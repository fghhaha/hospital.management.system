package System;

import event.LoginEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChangeOwnPassword extends JFrame {
    FlowLayout flowlayout;
    final int WIDTH = 300;
    final int HEIGHT = 80;
    JLabel password;
    public static JPasswordField passwordtext;
    JButton changeown;
    ActionListener lintener_1;

    public ChangeOwnPassword() {
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
        int x = (width - 300) / 2;
        int y = (height - 80) / 2;
        this.setBounds(x, y, 300, 100);
        this.flowlayout = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(this.flowlayout);
        this.password = new JLabel("密码");
        passwordtext = new JPasswordField(15);
        this.changeown = new JButton("修改密码");
        this.lintener_1 = new LoginEvent();
        this.changeown.addActionListener(this.lintener_1);
        this.changeown.setName("changeown");
        this.setTitle("更改密码");
        this.add(this.password);
        this.add(passwordtext);
        this.add(this.changeown);
    }
}