package annotationTest.Test2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Package: annotationTest.Test2
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/11 0:07
 * <p>
 * Version: 0.0.1
 */
public class AnnotationTest {
    private JFrame mainWin = new JFrame("使用注解绑定事件监听器");
    // 使用ActionListenerFor注解为ok按钮绑定事件监听器
    @ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("确定");
       // 使用ActionListenerFor注解为cancle按钮绑定事件监听器
    @ActionListenerFor(listener = CancleListener.class)
    private JButton cancle = new JButton("取消");

    public void init(){
        // 初始化界面的方法
        JPanel jp = new JPanel();
        jp.add(ok);
        jp.add(cancle);
        mainWin.add(jp);
        ActionListenerInstaller.processAnnotations(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new AnnotationTest().init();
    }

}
class OkListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"单击了确认按钮");
    }
}
class CancleListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"单击了取消按钮");
    }
}