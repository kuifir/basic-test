package NetT.HttpTest.ChatingRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Package: NetT.HttpTest.ChatingRoom
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/31 15:01
 * <p>
 * Version: 0.0.1
 */
public class ServerThread2 extends Thread{
    private Socket socket;
    BufferedReader br=null;
    PrintStream ps=null;

    @Override
    public void run() {
        try{
            // 获取该Socket对应的输入流
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 获取该Socket对应的输出流
            ps=new PrintStream(socket.getOutputStream());
            String line=null;
            while ((line=br.readLine())!=null){
                // 如果读到的行以MyProtocol.USER_ROUND开头并以其结束
                // 则可以确定读到的是用户登陆的用户名
                if(line.startsWith(MyProtocol.USER_ROUND)&&line.endsWith(MyProtocol.USER_ROUND)){
                    // 得到真实消息
                    String userName=getRealMsg(line);
                    // 如果用户名重复
                    if(Server.clients.map.containsKey(userName)){
                        System.out.println("重复");
                        ps.println(MyProtocol.NAME_REP);
                    }else {
                        System.out.println("成功");
                        ps.println(MyProtocol.LOGIN_SUCCESS);
                        Server.clients.put(userName,ps);
                    }
                }
                // 如果读到的是以MyProtocol.PRIVATE_ROUND，并以其结束
                // 则可以确定是私聊信息，私聊信息只向特定的输出流发送
                else if(line.startsWith(MyProtocol.PRIVATE_ROUND)&&line.endsWith(MyProtocol.PRIVATE_ROUND)) {
                    // 得到真实消息
                    String userAndmsg =getRealMsg(line);
                    // 以SPLIT_SIGN分割字符串，前半是私聊字符串，后半是聊天信息
                    String user=userAndmsg.split(MyProtocol.SPLIT_SIGN)[0];
                    String msg=userAndmsg.split(MyProtocol.SPLIT_SIGN)[1];
                    // 获取饲料用户对应的输出流，并发送私聊信息
                    Server.clients.map.get(user).println(Server.clients.getKeyByValue(ps)+"悄悄对你说"+msg);

                }
                // 公聊要向每个Socket发送
                else {
                    String msg=getRealMsg(line);
                    for (PrintStream clientPs:Server.clients.values()){
                        clientPs.println(Server.clients.getKeyByValue(ps)+"say:"+msg);
                    }
                }
            }
        } catch (IOException e) {
            Server.clients.removeByValue(ps);
            System.out.println(Server.clients.map.size());
            try {
                if (br!=null){
                    br.close();
                }if (ps!=null){
                    ps.close();
                }if (socket!=null){
                    socket.close();
                }
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }

    private String getRealMsg(String line) {
        return line.substring(MyProtocol.PROTOCOL_Len,line.length()-MyProtocol.PROTOCOL_Len);
    }

    public ServerThread2(Socket socket) {
        this.socket=socket;
    }

}
