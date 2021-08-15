package System;

import event.LoginEvent;
import event.ManageEvent1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Manage extends JFrame {
    public static void main(String[] args) {

    }
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JPanel jPanel;
    final int WIDTH=500;
    final int HEIGHT=280;
    ActionListener listener_1;
    ActionListener listener_2;
    ActionListener listener_3;
    JLabel bgimg;
    public Manage() {
        init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(2);
        validate();
    }
    void init(){
        this.setLayout(null);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 500) / 2;
        int y = (height - 280) / 2;
        this.setBounds(x, y, 500, 237);
        this.setTitle("医院管理系统主界面");

        /*ImageIcon img = new ImageIcon("src/img/1.png");
        this.bgimg = new JLabel(img);
        this.bgimg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        this.add(bgimg);*/
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3,1));
        jPanel.setBounds(0, 0, 500, 280);
        jButton1=new JButton("药品信息管理页面");
        jButton1.setSize(1,1);
        jButton2=new JButton("患者信息管理页面");
        jButton2.setSize(20,20);

        jButton3=new JButton("医生信息管理模块及个人信息显示");
        jButton3.setSize(20,20);
        jButton4=new JButton("此系统的使用说明");
        jButton4.setSize(20,20);


        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        this.add(jPanel);
        this.allEvent1();

        jButton1.setName("ok1");
        jButton2.setName("ok2");
        jButton3.setName("ok3");
        jButton4.setName("ok4");


    }
    void allEvent1(){
        listener_1=new ManageEvent1() ;
        jButton1.addActionListener(listener_1); //你已经给按钮绑定了事件了，然后进入这个按钮的事件进行处理
        jButton2.addActionListener(listener_1);
        jButton3.addActionListener(listener_1);
        jButton4.addActionListener(listener_1);
    }
}

