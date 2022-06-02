
package com.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import java.awt.Color;
import java.awt.Toolkit;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

/**
 * @author YLPJFR
 * @date 2022��06��01�� 21:13
 */

public class MainFrame extends JFrame {
    private JPanel jcontentPane;                        //�������
    private JButton firstPageButton;                    //��ҳ
    private JButton latePageButton;                     //βҳ
    private JButton nextPageButton;                     //��һҳ
    private JButton lastPageButton;                     //��һҳ
    private JTable table;                               //���ģ��

    private int maxPageNumber;                          //������ҳ��
    private int maxrows = 0;                            //��ʼ��������� 1
    private int currentPageNumber = 1;                  //��ʼ�����ĵ�ǰҳ��Ϊ1
    private double pageSize = 20;                       //ÿҳ����������20������
    private DefaultTableModel defaultTableModel;        //���ģ�͵�ʵ������

    public static void main(String[] args) {

        /*
         *�����屳������������ʹ�˻��������۴󷽣�����ϵͳ������ѹ����ΪBackgroundImage.jar������Ҫ����ʵ������contentPane��ʵ�������屳������Ч��
         * @author YPLFJR
         * @date 2022/6/1 22:55
         * @param args
         */

        try {
            //���ô�����
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLook And Feel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //ʵ����������
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);             //ʹ����ɼ�
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //������Ĺ��췽��
    public MainFrame() {
        setForeground(Color.BLACK);                     //����ǰ������Ϊ��ɫ
        setTitle("���ղ�ƱԤ��ϵͳ");                      //������ı���
        setResizable(false);                            //�����岻�ܸı��С

        //������ı���ͼ��
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/imgs/log.png"))
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //�Դ��巢��close��ʱ���˳�����

        setBounds(200, 100, 1100, 600);             //��ʼ�������λ�ü����
        jcontentPane = new JPanel();                                   //ʵ�����������
        jcontentPane.setLayout(new BorderLayout(0, 0));     //�����������Ϊ�߽粼��
        setContentPane(jcontentPane);                                  //������������������
        BackgroundPanel contentPane = new BackgroundPanel();           //�����Զ��屳�����
        //���ñ�������ͼƬ
        contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/main.png")));
        jcontentPane.add(contentPane, BorderLayout.CENTER);             //��ӱ�����嵽�������

        /*
         *������Ĺ��ܰ�ťһ����9��
         * �鿴���쿪��
         * ��ӿ�������
         * ������Ӻ���
         * �޸Ŀ�������
         * �鿴��������
         * ���ѡ��
         * �н���ѯ
         * ��ʷս��
         * �˳�ϵͳ
         */

        JButton btnNewButton = new JButton("");// ����ӿ������롱��ť
        btnNewButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/10.png")));// ���á���ӿ������롱��ť��ͼ��
        btnNewButton.setBounds(6, 114, 184, 40);// ����ӿ������롱��ť��λ�ü����
        contentPane.add(btnNewButton);// ������ӿ������롱��ť��ӵ��Զ��屳�������

        JButton button = new JButton("");// ���鿴���쿪������ť
        button.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/09.png")));// ���á��鿴���쿪������ť��ͼ��
        button.setBounds(6, 74, 184, 40);// ���鿴���쿪������ť��λ�ü����
        contentPane.add(button);// �����鿴���쿪������ť��ӵ��Զ��屳�������

        JButton button_1 = new JButton("");// ��������Ӻ��롱��ť
        button_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/11.png")));// ���á�������Ӻ��롱��ť��ͼ��
        button_1.setBounds(6, 154, 184, 40);// ��������Ӻ��롱��ť��λ�ü����
        contentPane.add(button_1);// ����������Ӻ��롱��ť��ӵ��Զ��屳�������

        JButton updatebutton = new JButton("");// ���޸Ŀ������롱��ť
        updatebutton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/12.png")));// ���á��޸Ŀ������롱��ť��ͼ��
        updatebutton.setBounds(6, 194, 184, 40);// ���޸Ŀ������롱��ť��λ�ü����
        contentPane.add(updatebutton);// �����޸Ŀ������롱��ť��ӵ��Զ��屳�������

        JButton button_3 = new JButton("");//���鿴�������ơ���ť
        button_3.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/14.png")));//����ͼ��
        button_3.setBounds(6,234,184,40);//λ�ü����
        contentPane.add(button_3);//��ӵ��Զ��屳�����

        JButton button_4 =new JButton("");//�����ѡ�š���ť
        button_4.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/15.png")));//����ͼ��
        button_4.setBounds(6,274,184,40);
        contentPane.add(button_4);

        JButton button_5 =new JButton("");//���н���ѯ����ť
        button_5.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/17.png")));//����ͼ��
        button_5.setBounds(6,314,184,40);
        contentPane.add(button_5);

        JButton button_6 =new JButton("");//����ʷս������ť
        button_6.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/18.png")));//����ͼ��
        button_6.setBounds(6,354,184,40);
        contentPane.add(button_6);

        JButton button_2 =new JButton("");//�����ѡ�š���ť
        button_2.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/08.png")));//����ͼ��
        button_2.setBounds(6,394,184,40);
        contentPane.add(button_2);

        //���ģ�����ҳ��ť
        JScrollPane scrollPane =new JScrollPane();//�������
        scrollPane.setBackground(new Color(0, 68,204));//������屳��ɫ
        scrollPane.setBounds(217,74,848,351);//λ������
        contentPane.add(scrollPane);//���

        table = new JTable();//�������
        scrollPane.setViewportView(table);//�����������ӱ��
        firstPageButton = new JButton("��ҳ");//��ҳ��ť
        firstPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_08.png")));
        firstPageButton.setBounds(416,439,84,27);
        contentPane.add(firstPageButton);

        latePageButton = new JButton("��һҳ");//��һҳ��ť
        latePageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_10.png")));
        latePageButton.setBounds(550,439,84,27);
        contentPane.add(latePageButton);

        nextPageButton = new JButton("��һҳ");//��һҳ��ť
        nextPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_09.png")));
        nextPageButton.setBounds(686,439,84,27);
        contentPane.add(nextPageButton);


        lastPageButton = new JButton("βҳ");//βҳ��ť
        lastPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_11.png")));
        lastPageButton.setBounds(819,439,84,27);
        contentPane.add(lastPageButton);

    }
}
