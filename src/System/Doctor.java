package System;

import event.LoginEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Doctor extends JFrame {
    ActionListener actionListener_1;
    final int WIDTH=825;
    final int HEIGHT=700;
    FlowLayout flowLayout;
    JLabel bgimg;
    public  static JTextArea resultText;
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    public Doctor() {
        init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(2);
        validate();
    }
    void init(){
        jButton1 =new JButton("显示所有医生账号信息");
        jButton1.setBounds(0,170,158,50);
        jButton2 =new JButton("更改其他医生账号信息");
        jButton2.setBounds(160,170,158,50);
        jButton3 =new JButton("注销其他医生账号密码");
        jButton3.setBounds(320,170,158,50);
        jButton4 = new JButton("显示当前医生账号信息");
        jButton4.setBounds(480,170,158,50);
        jButton5 = new JButton("更改当前医生账号信息");
        jButton5.setBounds(640,170,158,50);


        resultText= new JTextArea();
        this.setLayout(flowLayout);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH,HEIGHT);
        ImageIcon img = new ImageIcon("src/img/6.jpg");
        bgimg = new JLabel(img);
        bgimg.setBounds(0, 0, img.getIconWidth(),160);
        this.add(bgimg);
        resultText.setBounds(0,240,WIDTH-19,300);
        resultText.setBorder(BorderFactory.createTitledBorder("医生账号基本信息显示"));
        this.add(resultText);
        this.setTitle("医生账户信息管理及个人信息显示界面");
        allEvent();
        setAllName();
        this.add(jButton1);
        this.add(jButton2);
        this.add(jButton5);
        this.add(jButton3);
        this.add(jButton4);

    }
    void allEvent(){
     actionListener_1 = new LoginEvent();
     jButton1.addActionListener(actionListener_1);
     jButton2.addActionListener(actionListener_1);
     jButton3.addActionListener(actionListener_1);
     jButton4.addActionListener(actionListener_1);
     jButton5.addActionListener(actionListener_1);
    }
    void setAllName(){
        jButton1.setName("jButton1");
        jButton2.setName("jButton2");
        jButton3.setName("jButton3");
        jButton4.setName("jButton4");
        jButton5.setName("jButton5");
    }
}

