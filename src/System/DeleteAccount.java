package System;

import event.LoginEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteAccount extends JFrame {
    FlowLayout flowlayout;
    final int WIDTH = 230;
    final int HEIGHT = 160;
    JLabel account;
    public static JTextField accounttext;
    JLabel name;
    JLabel password;
    public static JTextField nametext;
    public static JPasswordField passwordtext;
    JButton delete;
    ActionListener lintener_1;

    public DeleteAccount() {
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
        this.setBounds(x, y, 240, 100);
        this.flowlayout = new FlowLayout(1);
        this.setLayout(this.flowlayout);


        this.account = new JLabel("账号");
        accounttext = new JTextField(15);

        this.delete = new JButton("注销账号信息");
        this.delete.setName("delete");
        this.setTitle("注销信息");
        this.add(this.account);
        this.add(accounttext);
        this.add(this.delete);
        this.lintener_1 = new LoginEvent();
        this.delete.addActionListener(this.lintener_1);
    }
}