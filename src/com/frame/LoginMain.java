package com.frame;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.EventQueue;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author YLPJFR
 * @date 2022年05月31日 17:42
 */

public class LoginMain extends JFrame {
    // 登陆窗体一共分为三部分
    // 窗体图标
    // 窗体标题
    // 窗体中间的按钮
    private JPanel contenPane; //内容面板

    public static void main(String[] args) {
        try {
            //设置登陆窗体格式
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //实例化登陆窗体
                    LoginMain frame = new LoginMain();
                    //使窗体可见
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginMain() {                          //登陆窗体的构造方法
        setTitle("明日彩票预测系统");               //登陆窗体的标题
        setIconImage(
                //getImage 返回一幅图像，该图像从指定文件中获取像素数据，图像格式可以是 GIF、JPEG 或 PNG。底层工具包试图对具有相同文件名的多个请求返回相同的 Image。
                Toolkit.getDefaultToolkit().getImage(LoginMain.class.getResource("/imgs/log.png"))
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//对登陆窗体发起“CLOSE”时，退出应用程序
        setBounds(200, 100, 1100, 260);//设置船体的位置机宽高
        contenPane = new JPanel();//内容面板
        setContentPane(contenPane);//内容面板放入登陆窗体中
        contenPane.setLayout(new BorderLayout(0, 0));//设置内容面板的布局为边界布局
        JButton btNewButton = new JButton("");//实例化五文本内容的按钮
//设置按钮的图片
        btNewButton.setIcon(
                new ImageIcon(LoginMain.class.getResource("/imgs/login1.jpg"))
        );
        contenPane.add(btNewButton,BorderLayout.CENTER);//将按钮放在中间
    }
}
