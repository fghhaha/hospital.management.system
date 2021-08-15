package mysql;
import System.Manage;
import System.Doctor;
import System.*;
import event.LoginEvent;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    public static Connection con = null;

    public Mysql(String account, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (Exception var6) {
            System.out.println("加载驱失败");
        }
        String uri = "jdbc:mysql://localhost:3306/hospital?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai ";

        try {
            con = DriverManager.getConnection(uri, account, password);
            System.out.println("连接数据库成功");

        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
            System.out.println("连接数据库失败");
        }

    }
    public static boolean loginAccount(String account, String password) {
        String uri = "select account,password from user";

        try {
            Statement sql = con.createStatement();
            ResultSet rs = sql.executeQuery(uri);

            String acc;
            String pass;
            do {
                if (!rs.next()) {
                    return false;
                }

                acc = rs.getString(1);
                pass = rs.getString(2);
            } while(!acc.equals(account) || !pass.equals(password));

            return true;
        } catch (SQLException var7) {
            return false;
        }
    }

    public static void onlineAccount() {
        String uri = "select * from user";

        try {
            Statement sql = con.createStatement();
            ResultSet rs = sql.executeQuery(uri);

            Doctor.resultText.setText("姓名\t账号\t密码\t");
            while(rs.next()) {
                String name = rs.getString(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String uri1 = Doctor.resultText.getText() + name + "\t" + account + "\t" + password+"\n";
                    Doctor.resultText.setText(uri1);

            }
        } catch (SQLException var8) {
        }

    }
    public static void showownMessage(String account){
       // System.out.println("showownMessage:" + account);
        String uri = "select * from user  where account like ?";
        try {
            //你刚刚使用的是Statement对吧，这里你用到到where的条件查询，这个时候你就要把uri中的？替换成account的值
            PreparedStatement preparedStatement = con.prepareStatement(uri); // 你百度搜索一下PreparedStatement，你就知道了
            preparedStatement.setString(1,account);
            ResultSet rs = preparedStatement.executeQuery();
            Doctor.resultText.setText("当前账号姓名\t当前账号\t当前账号密码\n");
            while(rs.next()) {
                String name = rs.getString(1);
                String accountA = rs.getString(2);
                String password = rs.getString(3);
                String uri1 = Doctor.resultText.getText() + name + "\t" + account + "\t" + password +"\n";
                Doctor.resultText.setText(uri1);

            }
        } catch (SQLException var8) {
        }
    }
    public static void changeOtherAccountMessage() {
        String sqlStr = "update user set name=?,password=? where account=?";

        try {
            String account = ChangeAccountMessage.accounttext.getText();
            String name = ChangeAccountMessage.nametext.getText();
            String password = new String(ChangeAccountMessage.passwordtext.getPassword());
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            int ok ;
            if (account.equals("")) {
                JOptionPane.showMessageDialog((Component)null, "账号不能为空", "更改消息", 2);
            } else if (name.equals("")) {
                JOptionPane.showMessageDialog((Component)null, "姓名不能为空", "更改消息", 2);
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog((Component)null, "密码不能为空", "更改消息", 2);
            } else {
                preSql.setString(1, name);
                preSql.setString(2, password);
                preSql.setString(3, account);
                 ok = preSql.executeUpdate();
                if (ok == 0) {
                    JOptionPane.showMessageDialog((Component)null, "请输入正确账号", "更改消息", 2);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "更改成功", "更改消息", 2);
                }
            }
        } catch (SQLException var7) {
        }

    }

    public static void changePassword(String account, String password) {
        String sqlStr = "update user set password=? where account=?";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, password);
            preSql.setString(2, account);
            preSql.executeLargeUpdate();
        } catch (SQLException var5) {
        }

    }
    public static void addmedicine(String name,String number,String way,String remain){
        PreparedStatement preSql;
        String sqlStr ="insert into medicine(name,number,way,remain)  values (?,?,?,?)  ";

        try {
            PreparedStatement preSql1 = con.prepareStatement(sqlStr);
            preSql1.setString(1, name);
            preSql1.setString(2, number);
            preSql1.setString(3, way);
            preSql1.setString(4, remain);
            int ok = preSql1.executeUpdate();
            JOptionPane.showMessageDialog((Component)null, "添加成功", "添加数据", 2);
        } catch (SQLException var5) {
            JOptionPane.showMessageDialog((Component)null, "添加失败请检查编号是否重复或信息格式是否正确或购买药品是否正确", "添加数据", 2);
        }

    }

    public static void delmedicine(String number){
        PreparedStatement preSql;
        String sqlStr ="delete from medicine where number=?  ";
        try{
            preSql=con.prepareStatement(sqlStr);
            preSql.setString(1,number);
            int ok = preSql.executeUpdate();
            if(ok==0){
                JOptionPane.showMessageDialog((Component)null, "未找到相关编号", "删除消息", 2);
            }else {
                JOptionPane.showMessageDialog((Component)null, "删除成功", "删除消息", 2);

            }

        }catch( SQLException var5){

        }
    }
    public static void delAccount1(String number){
        PreparedStatement preSql;
        String sqlStr ="delete from user where account=?  ";
        try{
            preSql=con.prepareStatement(sqlStr);
            preSql.setString(1,number);
            int ok = preSql.executeUpdate();
            if(ok==0){
                JOptionPane.showMessageDialog((Component)null, "未找到相关账号", "删除消息", 2);
            }else {
                JOptionPane.showMessageDialog((Component)null, "删除成功", "删除消息", 2);

            }

        }catch( SQLException var5){

        }
    }


    public static void changemedicine(String name,String number,String way,String remain,String numberT){
        PreparedStatement preSql;
        String sqlStr ="update medicine set number=?,name=?,way=?, remain=? where number=?  ";
        try{
            PreparedStatement preSql1 = con.prepareStatement(sqlStr);
            preSql1.setString(1, name);
            preSql1.setString(2, number);
            preSql1.setString(3, way);
            preSql1.setString(4, remain);
            preSql1.setString(5, numberT);
            int ok = preSql1.executeUpdate();
            if(ok==0){
                JOptionPane.showMessageDialog((Component)null, "编号重复或者输入编号不存在", "消息", 2);
            }else{
                JOptionPane.showMessageDialog((Component)null, "更改成功", "消息", 2);
            }

        }catch (SQLException e) {
            System.out.println(e);

        }

    }
    public static void findAllmedicine(){
        PreparedStatement preSql;
        Medical.model.setNumRows(0);//将表格数据为0
        String sqlStr ="select * from medicine";
        try{
            PreparedStatement preSql1 = con.prepareStatement(sqlStr);
            ResultSet rs =preSql1.executeQuery();
            LoginEvent.addAble(rs);

        }catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void addPatient(String name, String number, String sex, String age, String buy) {
        String sqlStr = "insert into  patient(name,number,sex,age,buy) values(?,?,?,?,?)";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, name);
            preSql.setString(2, number);
            preSql.setString(3, sex);
            preSql.setString(4, age);
            preSql.setString(5, buy);
            int ok = preSql.executeUpdate();
            JOptionPane.showMessageDialog((Component)null, "添加成功", "添加数据", 2);
        } catch (SQLException var8) {
            JOptionPane.showMessageDialog((Component)null, "添加失败请检查编号是否重复或信息格式是否正确", "添加数据", 2);
        }
    }


    public static void delPatient(String number) {
        String sqlStr = "delete from patient where number=?";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, number);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog((Component)null, "未找到相关编号", "消息", 2);
            } else {
                JOptionPane.showMessageDialog((Component)null, "删除成功", "消息", 2);
            }
        } catch (SQLException var4) {
            JOptionPane.showMessageDialog((Component)null, "当前编号已经存字", "添加数据", 2);
        }
    }

    public static void changePatient(String name, String number, String sex, String age, String buy, String numberT) {
        String sqlStr = "update patient  set name=?,number=?,sex=?,age=?,buy=? where number=?";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, name);
            preSql.setString(2, number);
            preSql.setString(3, sex);
            preSql.setString(4, age);
            preSql.setString(5, buy);
            preSql.setString(6, numberT);
            int ok = preSql.executeUpdate();
            if (ok == 0) {
                JOptionPane.showMessageDialog((Component)null, "编号重复或者输入编号不存在", "消息", 2);
            } else {
                JOptionPane.showMessageDialog((Component)null, "更改成功", "消息", 2);
            }
        } catch (SQLException var9) {
            System.out.println(var9);
        }

    }

    public static void findAllPatient() {
        Patient.model.setNumRows(0);
        String sqlStr = "select * from patient";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            ResultSet rs = preSql.executeQuery();
            LoginEvent.addAble1(rs);
        } catch (SQLException var3) {
            System.out.println(var3);
        }

    }

    public static ResultSet getRs1() {
        ResultSet rs = null;
        Patient.model.setNumRows(0);
        String sqlStr = "select * from patient";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            rs = preSql.executeQuery();
        } catch (SQLException var4) {
            System.out.println(var4);
        }

        return rs;
    }

    public static void findConPatient(String name, String number, String sex, String age, String buy) {
        ResultSet rs = null;
        Patient.model.setNumRows(0);
        String sqlStr = "select * from patient where name REGEXP? and number REGEXP? and sex REGEXP? and age REGEXP? and buy REGEXP?";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, name);
            preSql.setString(2, number);
            preSql.setString(3, sex);
            preSql.setString(4, age);
            preSql.setString(5, buy);
            rs = preSql.executeQuery();
            LoginEvent.addAble1(rs);
        } catch (SQLException var9) {
            System.out.println(var9);
        }

    }

    public static void findOnePatient(String number) {
        ResultSet rs = null;
        Patient.model.setNumRows(0);
        String sqlStr = "select * from patient where number=?";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, number);
            rs = preSql.executeQuery();
            LoginEvent.addOneAble1(rs);
        } catch (SQLException var5) {
            System.out.println(var5);
        }

    }

    public static ResultSet getRS(){
    PreparedStatement preSql;
    ResultSet rs =null;
    Medical.model.setNumRows(0);
    String sqlStr ="select * from medicine";
        try{
             preSql = con.prepareStatement(sqlStr);
            rs =preSql.executeQuery();
        }catch (SQLException e) {
            System.out.println(e);
        }
        return rs;
    }
    public static void findConMedicine(String number, String name, String way, String remain) {
        ResultSet rs = null;
        Medical.model.setNumRows(0);
        String sqlStr = "select * from medicine where name REGEXP? and number REGEXP? and  way REGEXP? and remain REGEXP? ";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, number);
            preSql.setString(2, name);
            preSql.setString(3, way);
            preSql.setString(4, remain);
            rs = preSql.executeQuery();
            LoginEvent.addAble(rs);
        } catch (SQLException var9) {
            System.out.println(var9);
        }

    }

    public static void findOnemedicine(String number){
        ResultSet rs = null;
        Medical.model.setNumRows(0);
        String sqlStr = "select * from medicine where number=?";

        try {
            PreparedStatement preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, number);
            rs = preSql.executeQuery();
            LoginEvent.addOneAble(rs);
        } catch (SQLException var5) {
            System.out.println(var5);
        }

    }
}