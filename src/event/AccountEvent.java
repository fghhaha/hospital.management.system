package event;

import System.Register;
import mysql.Mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AccountEvent implements ActionListener {
    JTextField alluse;
    JButton allJbutton;
    String name;
    Statement sql;
    ResultSet rs;
    Connection con = Mysql.con;

    public AccountEvent() {
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.alluse = (JTextField)e.getSource();
            if (this.alluse != null) {
                this.allUee();
            }
        } catch (Exception var3) {
            this.allJbutton = (JButton)e.getSource();
            if (this.allJbutton.getName() == "reg") {
                this.Jbtton();
            }
        }

    }

    void allUee() {
        if (this.alluse.getName() == "nametext") {
            Register.accounttext.requestFocus();
        }

        if (this.alluse.getName() == "accounttext") {
            Register.passwordtext.requestFocus();
        }

        if (this.alluse.getName() == "passwordtext") {
            Register.okpasswordtext.requestFocus();
        }

        if (this.alluse.getName() == "okpasswordtext") {
            Register.reg.requestFocus();
        }

    }

    void Jbtton() {
        boolean nameT = Register.nametext.getText().equals("");
        boolean accountT = Register.accounttext.getText().equals("");
        char[] str = Register.passwordtext.getPassword();
        String passwordtext = new String(str);
        boolean passwordT = passwordtext.equals("");
        str = Register.okpasswordtext.getPassword();
        String okpasswordtext = new String(str);
        boolean okpasswordT = okpasswordtext.equals("");
        if (nameT) {
            JOptionPane.showMessageDialog((Component)null, "姓名不能为空", "注册消息", 2);
        } else if (accountT) {
            JOptionPane.showMessageDialog((Component)null, "账号不能为空", "注册消息", 2);
        } else if (passwordT) {
            JOptionPane.showMessageDialog((Component)null, "密码不能为空", "注册消息", 2);
        } else if (okpasswordT) {
            JOptionPane.showMessageDialog((Component)null, "确认密码不能为空", "注册消息", 2);
        } else if (!passwordtext.equals(okpasswordtext)) {
            JOptionPane.showMessageDialog((Component)null, "密码输入不一致", "注册消息", 2);
        } else {
             name = Register.nametext.getText();
            String account = Register.accounttext.getText();
            String password = passwordtext;


            String Uri = "insert into user values(?,?,?)";


            try {
                PreparedStatement preSql = con.prepareStatement(Uri);
                preSql.setString(1, name);
                preSql.setString(2, account);
                preSql.setString(3, password);
                int ok = preSql.executeUpdate();
                JOptionPane.showMessageDialog((Component)null, "注册成功", "注册消息", 2);
            } catch (SQLException var15) {
                JOptionPane.showMessageDialog((Component)null, "当前账号已经存字", "注册消息", 2);
            }
        }

    }
}
