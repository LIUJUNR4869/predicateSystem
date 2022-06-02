
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
 * @date 2022年06月01日 21:13
 */

public class MainFrame extends JFrame {
    private JPanel jcontentPane;                        //内容面板
    private JButton firstPageButton;                    //首页
    private JButton latePageButton;                     //尾页
    private JButton nextPageButton;                     //下一页
    private JButton lastPageButton;                     //上一页
    private JTable table;                               //表格模型

    private int maxPageNumber;                          //表格的总页数
    private int maxrows = 0;                            //初始化最大行数 1
    private int currentPageNumber = 1;                  //初始化表格的当前页数为1
    private double pageSize = 20;                       //每页表格可以容纳20条数据
    private DefaultTableModel defaultTableModel;        //表格模型的实例对象

    public static void main(String[] args) {

        /*
         *主窗体背景面板的作用是使人机界面美观大方，由于系统背景板压缩成为BackgroundImage.jar包，需要创建实例对象contentPane，实现主窗体背景面板的效果
         * @author YPLFJR
         * @date 2022/6/1 22:55
         * @param args
         */

        try {
            //设置窗体风格
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLook And Feel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    //实例化主窗体
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);             //使窗体可见
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //主窗体的构造方法
    public MainFrame() {
        setForeground(Color.BLACK);                     //设置前背景板为黑色
        setTitle("明日彩票预测系统");                      //主窗体的标题
        setResizable(false);                            //主船体不能改变大小

        //主窗体的标题图标
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/imgs/log.png"))
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //对窗体发起“close”时，退出程序

        setBounds(200, 100, 1100, 600);             //初始化窗体的位置及宽高
        jcontentPane = new JPanel();                                   //实例化内容面板
        jcontentPane.setLayout(new BorderLayout(0, 0));     //设置内容面板为边界布局
        setContentPane(jcontentPane);                                  //内容面板放入主窗体中
        BackgroundPanel contentPane = new BackgroundPanel();           //创建自定义背景面板
        //设置背景面板的图片
        contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/main.png")));
        jcontentPane.add(contentPane, BorderLayout.CENTER);             //添加背景面板到内容面板

        /*
         *主窗体的功能按钮一共有9个
         * 查看历届开奖
         * 添加开奖号码
         * 批量添加号码
         * 修改开奖号码
         * 查看号码走势
         * 随机选号
         * 中奖查询
         * 历史战绩
         * 退出系统
         */

        JButton btnNewButton = new JButton("");// “添加开奖号码”按钮
        btnNewButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/10.png")));// 设置“添加开奖号码”按钮的图标
        btnNewButton.setBounds(6, 114, 184, 40);// “添加开奖号码”按钮的位置及宽高
        contentPane.add(btnNewButton);// 将“添加开奖号码”按钮添加到自定义背景面板中

        JButton button = new JButton("");// “查看历届开奖”按钮
        button.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/09.png")));// 设置“查看历届开奖”按钮的图标
        button.setBounds(6, 74, 184, 40);// “查看历届开奖”按钮的位置及宽高
        contentPane.add(button);// 将“查看历届开奖”按钮添加到自定义背景面板中

        JButton button_1 = new JButton("");// “批量添加号码”按钮
        button_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/11.png")));// 设置“批量添加号码”按钮的图标
        button_1.setBounds(6, 154, 184, 40);// “批量添加号码”按钮的位置及宽高
        contentPane.add(button_1);// 将“批量添加号码”按钮添加到自定义背景面板中

        JButton updatebutton = new JButton("");// “修改开奖号码”按钮
        updatebutton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/12.png")));// 设置“修改开奖号码”按钮的图标
        updatebutton.setBounds(6, 194, 184, 40);// “修改开奖号码”按钮的位置及宽高
        contentPane.add(updatebutton);// 将“修改开奖号码”按钮添加到自定义背景面板中

        JButton button_3 = new JButton("");//“查看号码走势”按钮
        button_3.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/14.png")));//设置图标
        button_3.setBounds(6,234,184,40);//位置及宽高
        contentPane.add(button_3);//添加到自定义背景面板

        JButton button_4 =new JButton("");//“随机选号”按钮
        button_4.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/15.png")));//设置图标
        button_4.setBounds(6,274,184,40);
        contentPane.add(button_4);

        JButton button_5 =new JButton("");//“中奖查询”按钮
        button_5.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/17.png")));//设置图标
        button_5.setBounds(6,314,184,40);
        contentPane.add(button_5);

        JButton button_6 =new JButton("");//“历史战绩”按钮
        button_6.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/18.png")));//设置图标
        button_6.setBounds(6,354,184,40);
        contentPane.add(button_6);

        JButton button_2 =new JButton("");//“随机选号”按钮
        button_2.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/08.png")));//设置图标
        button_2.setBounds(6,394,184,40);
        contentPane.add(button_2);

        //表格模型与分页按钮
        JScrollPane scrollPane =new JScrollPane();//滚动面板
        scrollPane.setBackground(new Color(0, 68,204));//滚动面板背景色
        scrollPane.setBounds(217,74,848,351);//位置与宽高
        contentPane.add(scrollPane);//添加

        table = new JTable();//表格类型
        scrollPane.setViewportView(table);//滚动面板中添加表格
        firstPageButton = new JButton("首页");//首页按钮
        firstPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_08.png")));
        firstPageButton.setBounds(416,439,84,27);
        contentPane.add(firstPageButton);

        latePageButton = new JButton("上一页");//上一页按钮
        latePageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_10.png")));
        latePageButton.setBounds(550,439,84,27);
        contentPane.add(latePageButton);

        nextPageButton = new JButton("下一页");//上一页按钮
        nextPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_09.png")));
        nextPageButton.setBounds(686,439,84,27);
        contentPane.add(nextPageButton);


        lastPageButton = new JButton("尾页");//尾页按钮
        lastPageButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img_btn/7_11.png")));
        lastPageButton.setBounds(819,439,84,27);
        contentPane.add(lastPageButton);

    }
}
