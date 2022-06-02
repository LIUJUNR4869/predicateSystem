package com.frame;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.EventQueue;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author YLPJFR
 * @date 2022��05��31�� 17:42
 */

public class LoginMain extends JFrame {
    // ��½����һ����Ϊ������
    // ����ͼ��
    // �������
    // �����м�İ�ť
    private JPanel contenPane; //�������

    public static void main(String[] args) {
        try {
            //���õ�½�����ʽ
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //ʵ������½����
                    LoginMain frame = new LoginMain();
                    //ʹ����ɼ�
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginMain() {                          //��½����Ĺ��췽��
        setTitle("���ղ�ƱԤ��ϵͳ");               //��½����ı���
        setIconImage(
                //getImage ����һ��ͼ�񣬸�ͼ���ָ���ļ��л�ȡ�������ݣ�ͼ���ʽ������ GIF��JPEG �� PNG���ײ㹤�߰���ͼ�Ծ�����ͬ�ļ����Ķ�����󷵻���ͬ�� Image��
                Toolkit.getDefaultToolkit().getImage(LoginMain.class.getResource("/imgs/log.png"))
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�Ե�½���巢��CLOSE��ʱ���˳�Ӧ�ó���
        setBounds(200, 100, 1100, 260);//���ô����λ�û����
        contenPane = new JPanel();//�������
        setContentPane(contenPane);//�����������½������
        contenPane.setLayout(new BorderLayout(0, 0));//�����������Ĳ���Ϊ�߽粼��
        JButton btNewButton = new JButton("");//ʵ�������ı����ݵİ�ť
//���ð�ť��ͼƬ
        btNewButton.setIcon(
                new ImageIcon(LoginMain.class.getResource("/imgs/login1.jpg"))
        );
        contenPane.add(btNewButton,BorderLayout.CENTER);//����ť�����м�
    }
}
