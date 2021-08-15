package System;

import event.LoginEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

 public class ChangeAccountMessage extends JFrame {
    FlowLayout flowlayout;
    final int WIDTH = 230;
    final int HEIGHT = 160;
    JLabel account;
    public static JTextField accounttext;
    JLabel name;
    JLabel password;
    public static JTextField nametext;
    public static JPasswordField passwordtext;
    JButton change;
    ActionListener lintener_1;

    public ChangeAccountMessage() {
        this.init();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(2);
        this.validate();
    }

    void init() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 230) / 2;
        int y = (height - 160) / 2;
        this.setBounds(x, y, 240, 160);
        this.flowlayout = new FlowLayout(1);
        this.setLayout(this.flowlayout);
        this.name = new JLabel("姓名");
        this.password = new JLabel("密码");
        this.account = new JLabel("账号");
        nametext = new JTextField(15);
        passwordtext = new JPasswordField(15);
        accounttext = new JTextField(15);

        this.change = new JButton("更改账号信息");
        this.change.setName("change");
        this.setTitle("更改信息");
        this.add(this.account);
        this.add(accounttext);
        this.add(this.name);
        this.add(nametext);
        this.add(this.password);
        this.add(passwordtext);
        this.add(this.change);
        this.lintener_1 = new LoginEvent();
        this.change.addActionListener(this.lintener_1);
    }
}

