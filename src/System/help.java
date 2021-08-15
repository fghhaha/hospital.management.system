package System;

import event.LoginEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class help extends JFrame {
    FlowLayout flowlayout;
    final int WIDTH = 915;
    final int HEIGHT = 250;

    JTextArea jTextArea;
    public static JTextField accounttext;
    JLabel jLabel;
    JPanel jPanel1;
    JPanel jPanel2;
    ActionListener lintener_1;


    public help() {
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
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.flowlayout = new FlowLayout(1);
        this.setLayout(null);
        jTextArea = new JTextArea("此医院管理系统拥有三个模块-药品信息管理模块、患者信息管理模块、医生账户信息管理模块。\n药品信息管理模块中可以对药品信息进行处理，有着增加、删除、修改、查找、重置、数据" +
                "的功能。可以根据药品的编号来快速找到药品的所有信息。\n患者信息管理模块中可以对所有的患者数据进行处理，同样有着增加、删除、修改、查找、重置、数据的功能,同样可以依据患者的编号查看患者的所有信息\n"
 +              "还有着医生账户管理信息模块，此功能可以显示，注销，更改，所有医生的账户（需要管理员权限及登录账号为管理员账号），普通账号可以显示当前账号的信息，更改\n当前账号的密码");
        jLabel = new JLabel("功能简介");
        jLabel.setForeground(Color.red);
        jLabel.setFont(Fronts.jlabel);
        jPanel1=new JPanel();
        jPanel2=new JPanel();
        jPanel1.setBounds(0,20,WIDTH,40);
        jPanel2.setBounds(0,70,WIDTH,410);
       // jPanel1.setBorder(BorderFactory.createTitledBorder("账号注册界面"));
        //jPanel2.setBorder(BorderFactory.createTitledBorder("账号注册界面"));
        jTextArea.setEditable(false);
        jPanel1.add(jLabel);
        jPanel2.add(jTextArea);
        this.setTitle("使用说明");
        this.add(jPanel1);
        this.add(jPanel2);

    }
}