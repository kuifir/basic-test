package NetT.HttpTest.AIO.Chating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static javafx.scene.input.KeyCode.J;

/**
 * Package: NetT.HttpTest.AIO.Chating
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/1 12:23
 * <p>
 * Version: 0.0.1
 */
public class AIOClient {
    final static int PORT = 30000;
    // 与服务器通信异步的Channel
    AsynchronousSocketChannel clientChinel;
    JFrame mainWin = new JFrame("多人聊天");
    JTextArea jta = new JTextArea(16, 48);
    JTextField jtf = new JTextField(40);
    JButton sendBn = new JButton("发送");

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AIOClient aioClient = new AIOClient();
        aioClient.init();
        aioClient.connect();
    }

    public void init() {
        mainWin.setLayout(new BorderLayout());
        jta.setEditable(false);
        mainWin.add(new JScrollPane(jta), BorderLayout.CENTER);
        JPanel jp = new JPanel();
        jp.add(jtf);
        jp.add(sendBn);
        Action sendAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = jtf.getText();
                if (content.trim().length() > 0) {
                    try {
                        clientChinel.write(ByteBuffer.wrap(content.trim().getBytes("UTF-8"))).get();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                jtf.setText("");
            }
        };
        sendBn.addActionListener(sendAction);
        jtf.getInputMap().put(KeyStroke.getKeyStroke('\n', InputEvent.CTRL_MASK), "send");
        jtf.getActionMap().put("send", sendAction);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.add(jp, BorderLayout.SOUTH);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public void connect() throws IOException, ExecutionException, InterruptedException {
        // 定义一个ByteBuffer准备读取数据
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(80);
        // 以指定线程池创建一个AsynchronousChannelGroup
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        // 以channelGroup作为组管理器来创建AsynchronousSocketChannel
        clientChinel = AsynchronousSocketChannel.open(channelGroup);
        // 让AsynchronousSocketChannel连接带指定IP地址、指定端口
        clientChinel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
        jta.append("连接服务器成功\n");
        buffer.clear();
        clientChinel.read(buffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buffer.flip();
                String content = StandardCharsets.UTF_8.decode(buffer).toString();
                // 显示从服务器读取的数据
                jta.append("某人说：" + content + "\n");
                buffer.clear();
                clientChinel.read(buffer, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("读取数据失败" + exc);
            }
        });

    }
}
