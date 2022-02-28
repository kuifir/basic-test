package NetT.UDPT.LanTalk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFrame extends JDialog {
    JTextArea msgArea = new JTextArea(12, 45);
    JTextField chatField = new JTextField(30);
    JButton sendBn = new JButton("发送");
    UserInfo user;

    public ChatFrame(LanTalk var1, UserInfo var2) {
        super(var1, "和" + var2.getName() + "聊天中", false);
        this.user = var2;
        this.msgArea.setEditable(false);
        this.add(new JScrollPane(this.msgArea));
        JPanel var3 = new JPanel();
        var3.add(new JLabel("输入信息："));
        var3.add(this.chatField);
        var3.add(this.sendBn);
        this.add(var3, "South");
        ChatFrame.MyActionListener var4 = new ChatFrame.MyActionListener();
        this.chatField.addActionListener(var4);
        this.sendBn.addActionListener(var4);
        this.pack();
    }

    public void addString(String var1) {
        this.msgArea.setText(var1 + "\n" + this.msgArea.getText());
    }

    class MyActionListener implements ActionListener {
        MyActionListener() {
        }

        public void actionPerformed(ActionEvent var1) {
            InetSocketAddress var2 = (InetSocketAddress)ChatFrame.this.user.getSocketAddress();
            if (var2 == null) {
                LoginFrame.comUtil.broadCast(ChatFrame.this.chatField.getText());
                ChatFrame.this.msgArea.setText("您对大家说：" + ChatFrame.this.chatField.getText() + "\n" + ChatFrame.this.msgArea.getText());
            } else {
                var2 = new InetSocketAddress(var2.getHostName(), var2.getPort() + 1);
                LoginFrame.comUtil.sendSingle(ChatFrame.this.chatField.getText(), var2);
                ChatFrame.this.msgArea.setText("您对" + ChatFrame.this.user.getName() + "说：" + ChatFrame.this.chatField.getText() + "\n" + ChatFrame.this.msgArea.getText());
            }

            ChatFrame.this.chatField.setText("");
        }
    }
}

