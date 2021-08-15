package System;

import event.AccountEvent;
import event.LoginEvent;
import event.RegEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginStart extends JFrame {
    FlowLayout flowlayout;
    JLabel bgimg;
    JLabel register;
    JLabel account;
    JLabel password;
    JLabel title;
    public static JTextField accounttext;
    public static JPasswordField passwordtext;
    JButton ok;
    final int WIDTH = 500;
    final int HEIGHT = 280;
    JPanel jpanel_1;
    JPanel jpanel_2;
    JPanel jpanel_3;
    RegEvent regevent;//定义注册标签的鼠标监听事件
    ActionListener listener_1;


    public LoginStart() {
        this.init();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(2);
        this.validate();
    }

    void init() {
        this.flowlayout = new FlowLayout(1);
        this.jpanel_1 = new JPanel();
        this.jpanel_1.setBounds(0, 0, 500, 280);
        this.jpanel_1.setLayout((LayoutManager)null);
        this.jpanel_2 = new JPanel();
        this.jpanel_2.setBounds(0, 50, 500, 50);
        this.jpanel_2.setLayout(this.flowlayout);
        this.jpanel_2.setOpaque(false);
        this.jpanel_3 = new JPanel();
        this.jpanel_3.setBounds(100, 105, 280, 130);
        this.jpanel_3.setLayout(this.flowlayout);
        this.jpanel_3.setOpaque(false);
        new Fronts();
        this.setTitle("医院信息管理系统");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 500) / 2;
        int y = (height - 280) / 2;
        this.setBounds(x, y, 500, 280);
        ImageIcon img = new ImageIcon("src/img/1.png");
        this.bgimg = new JLabel(img);
        this.bgimg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        this.title = new JLabel("医院信息管理系统");
        this.title.setFont(Fronts.title);
        this.title.setForeground(Color.CYAN);
        this.account = new JLabel("账号 ");
        this.account.setFont(Fronts.account);
        this.account.setForeground(new Color(226, 172, 83));
        accounttext = new JTextField(20);
        accounttext.setFont(Fronts.accounttext);
        accounttext.setForeground(new Color(226, 172, 83));
        this.password = new JLabel("密码 ");
        this.password.setFont(Fronts.account);
        this.password.setForeground(new Color(226, 172, 83));
        passwordtext = new JPasswordField(20);
        passwordtext.setFont(Fronts.accounttext);
        passwordtext.setForeground(new Color(224, 57, 151));
        this.ok = new JButton("安全登录");
        this.ok.setPreferredSize(new Dimension(254, 35));
        this.ok.setFont(Fronts.ok);
        this.ok.setBackground(new Color(8, 189, 252));
        this.ok.setForeground(new Color(255, 215, 0));
        this.ok.setName("ok");
        this.register = new JLabel("注册账号");
        this.register.setBounds(10, 200, 100, 40);
        this.register.setFont(Fronts.register);
        this.register.setForeground(new Color(227, 83, 83));
        this.jpanel_1.add(this.register);
        this.jpanel_1.add(this.register);
        this.jpanel_3.add(this.account);
        this.jpanel_3.add(accounttext);
        this.jpanel_3.add(this.password);
        this.jpanel_3.add(passwordtext);
        this.jpanel_3.add(this.ok);
        this.jpanel_2.add(this.title);
        this.jpanel_1.add(this.jpanel_2);
        this.jpanel_1.add(this.jpanel_3);
        this.jpanel_1.add(this.bgimg);
        this.add(this.jpanel_1);
        this.allEvent();
        ok.setName("ok");
    }

    void allEvent() {
        regevent = new RegEvent();
        listener_1=new LoginEvent() ;
        register.addMouseListener(regevent);
        ok.addActionListener(listener_1);
    }

    public void close() {
        this.dispose();
    }
}