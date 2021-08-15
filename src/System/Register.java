package System;

import event.AccountEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    FlowLayout flowlayout;
    final int WIDTH = 410;
    final int HEIGHT = 345;
    JPanel jpanel_1;
    JPanel jpanel_2;
    JPanel jpanel_3;
    ActionListener lintener_1;
    JLabel bgimg;
    JLabel title;
    JLabel name;
    public static JTextField nametext;
    JLabel account;
    public static JTextField accounttext;
    JLabel password;
    public static JPasswordField passwordtext;
    JLabel okpassword;
    public static JPasswordField okpasswordtext;
    public static JButton reg;

    public Register() {
        this.init();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(2);
        this.validate();
    }

    void init() {
        this.flowlayout = new FlowLayout(1);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 410) / 2;
        int y = (height - 345) / 2;
        this.setBounds(x, y, 410, 345);
        this.jpanel_1 = new JPanel();
        this.jpanel_1.setPreferredSize(new Dimension(410, 345));
        this.jpanel_1.setLayout((LayoutManager)null);
        this.jpanel_1.setOpaque(false);
        ImageIcon img = new ImageIcon("src/img/2.jpg");
        this.bgimg = new JLabel(img);
        this.bgimg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        new Fronts();
        this.title = new JLabel("医院信息管理系统账号注册");
        this.title.setFont(Fronts.title);
        this.title.setForeground(Color.gray);
        this.jpanel_2 = new JPanel();
        this.jpanel_2.setBounds(0, 30, 400, 70);
        this.jpanel_2.setOpaque(false);
        this.jpanel_2.setLayout(this.flowlayout);
        this.jpanel_3 = new JPanel();
        this.jpanel_3.setBounds(25, 100, 350, 200);
        this.jpanel_3.setOpaque(false);
        this.jpanel_3.setLayout(this.flowlayout);
        this.name = new JLabel("姓        名:");
        this.name.setFont(Fronts.account);
        nametext = new JTextField(20);
        this.name.setForeground(new Color(102, 102, 102));
        nametext.setForeground(new Color(18, 120, 192));
        nametext.setPreferredSize(new Dimension(15, 28));
        nametext.setFont(Fronts.accounttext);
        this.account = new JLabel("账        号:");
        this.account.setFont(Fronts.account);
        accounttext = new JTextField(20);
        this.account.setForeground(new Color(102, 102, 102));
        accounttext.setForeground(new Color(18, 120, 192));
        accounttext.setPreferredSize(new Dimension(15, 28));
        accounttext.setFont(Fronts.accounttext);
        this.password = new JLabel("密        码:");
        this.password.setFont(Fronts.account);
        passwordtext = new JPasswordField(20);
        this.password.setForeground(new Color(102, 102, 102));
        passwordtext.setForeground(new Color(18, 120, 192));
        passwordtext.setPreferredSize(new Dimension(15, 28));
        passwordtext.setFont(Fronts.accounttext);
        this.okpassword = new JLabel("确认密码:");
        this.okpassword.setFont(Fronts.account);
        okpasswordtext = new JPasswordField(20);
        this.okpassword.setForeground(new Color(102, 102, 102));
        okpasswordtext.setForeground(new Color(18, 120, 192));
        okpasswordtext.setPreferredSize(new Dimension(15, 28));
        okpasswordtext.setFont(Fronts.accounttext);
        reg = new JButton("注          册");
        reg.setPreferredSize(new Dimension(290, 30));
        reg.setFont(Fronts.ok);
        reg.setForeground(new Color(244, 170, 128));
        this.jpanel_3.add(this.name);
        this.jpanel_3.add(nametext);
        this.jpanel_3.add(this.account);
        this.jpanel_3.add(accounttext);
        this.jpanel_3.add(this.password);
        this.jpanel_3.add(passwordtext);
        this.jpanel_3.add(this.okpassword);
        this.jpanel_3.add(okpasswordtext);
        this.jpanel_3.add(reg);
        this.jpanel_2.add(this.title);
        this.jpanel_3.setBorder(BorderFactory.createTitledBorder("账号注册界面"));
        this.jpanel_1.add(this.jpanel_3);
        this.jpanel_1.add(this.jpanel_2);
        this.jpanel_1.add(this.bgimg);
        this.add(this.jpanel_1);
        this.setAllTag();
        this.allEvent();
        this.setTitle("注册界面");
    }

    void allEvent() {
        this.lintener_1 = new AccountEvent();
        nametext.addActionListener(this.lintener_1);
        accounttext.addActionListener(this.lintener_1);
        passwordtext.addActionListener(this.lintener_1);
        okpasswordtext.addActionListener(this.lintener_1);
        reg.addActionListener(this.lintener_1);
    }

    void setAllTag() {
        nametext.setName("nametext");
        accounttext.setName("accounttext");
        passwordtext.setName("passwordtext");
        okpasswordtext.setName("okpasswordtext");
        reg.setName("reg");
    }
}
