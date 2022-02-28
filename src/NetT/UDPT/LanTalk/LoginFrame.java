package NetT.UDPT.LanTalk;

/**
 * Package: NetT.UDPT.LanTalk
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/8/2 10:27
 * <p>
 * Version: 0.0.1
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class LoginFrame extends JDialog {
    public JLabel tip;
    public JTextField userField = new JTextField("李刚", 20);
    public JComboBox iconList = new JComboBox(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    private JButton loginBn = new JButton("登陆");
    private LanTalk chatFrame;
    public static ComUtil comUtil;

    public LoginFrame(LanTalk var1, String var2) {
        super(var1, "输入名字后登陆", true);
        this.chatFrame = var1;
        this.setLayout(new GridLayout(5, 1));
        JPanel var3 = new JPanel();
        this.tip = new JLabel(var2);
        this.tip.setFont(new Font("Serif", 1, 16));
        var3.add(this.tip);
        this.add(var3);
        this.add(this.getPanel("用户名", this.userField));
        this.iconList.setPreferredSize(new Dimension(224, 20));
        this.add(this.getPanel("图    标", this.iconList));
        JPanel var4 = new JPanel();
        this.loginBn.addActionListener(new LoginFrame.MyActionListener(this));
        var4.add(this.loginBn);
        this.add(var4);
        this.pack();
        this.setVisible(true);
    }

    private JPanel getPanel(String var1, JComponent var2) {
        JPanel var3 = new JPanel();
        var3.add(new JLabel(var1 + "："));
        var3.add(var2);
        return var3;
    }

    public void setTipMsg(String var1) {
        this.tip.setText(var1);
    }

    class MyActionListener implements ActionListener {
        private LoginFrame loginFrame;

        public MyActionListener(LoginFrame var2) {
            this.loginFrame = var2;
        }

        public void actionPerformed(ActionEvent var1) {
            try {
                LoginFrame.comUtil = new ComUtil(LoginFrame.this.chatFrame);
                final String var2 = YeekuProtocol.PRESENCE + LoginFrame.this.userField.getText() + YeekuProtocol.SPLITTER + LoginFrame.this.iconList.getSelectedObjects()[0] + YeekuProtocol.PRESENCE;
                LoginFrame.comUtil.broadCast(var2);
                Timer var3 = new Timer(10000, new ActionListener() {
                    public void actionPerformed(ActionEvent var1) {
                        LoginFrame.comUtil.broadCast(var2);
                    }
                });
                var3.start();
                this.loginFrame.setVisible(false);
                LoginFrame.this.chatFrame.setVisible(true);
            } catch (Exception var4) {
                this.loginFrame.setTipMsg("确认30001端口空闲，且网络正常！");
            }

        }
    }
}

