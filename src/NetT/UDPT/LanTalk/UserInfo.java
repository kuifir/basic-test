package NetT.UDPT.LanTalk;

import java.net.SocketAddress;
import java.util.Objects;

/**
 * Package: NetT.UDPT.LanTalk
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/2 9:34
 * <p>
 * Version: 0.0.1
 */
public class UserInfo {
    // 用户的图标
    private String icon;
    // 用户的名字
    private String name;
    // 该用户的MulitcastSocket所在的IP地址和端口
    private SocketAddress socketAddress;
    // 该用户失去联系的次数
    private int lost;
    // 该用户对应的交谈窗口
    private ChatFrame chatFrame;

    // 使用address作为该用户的标识，所以根据address重写hashCode()和equals()方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(socketAddress, userInfo.getSocketAddress());
    }

    @Override
    public int hashCode() {
        return socketAddress.hashCode();
    }

    public UserInfo() {
    }


    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setChatFrame(ChatFrame chatFrame) {
        this.chatFrame = chatFrame;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    public int getLost() {
        return lost;
    }

    public ChatFrame getChatFrame() {
        return chatFrame;
    }

    public UserInfo(String icon, String name, SocketAddress socketAddress, int lost) {
        this.icon = icon;
        this.name = name;
        this.socketAddress = socketAddress;
        this.lost = lost;
    }
}
