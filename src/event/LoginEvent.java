package event;
import System.LoginStart;
import mysql.Mysql;
import System.*;
import System.ChangeOwnPassword;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import System.Manage;
import System.HospitalSystem;

public class LoginEvent implements ActionListener    {
    JButton button;//定义一个按钮
    JButton jButton;
    static String accountA;
    static ChangeOwnPassword aa;
    static Manage manage;
    static Doctor doctor;
    public LoginEvent() {
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.button = (JButton)e.getSource();

            if (this.button.getName() == "ok") {
                String account = LoginStart.accounttext.getText();
                String password = new String(LoginStart.passwordtext.getPassword());
                if (Mysql.loginAccount(account, password)) {
                    accountA = account;
                    HospitalSystem.loginstartA.close();
                    manage = new Manage();
                    aa = new ChangeOwnPassword();
                    aa.dispose();
                } else {
                    JOptionPane.showMessageDialog((Component)null, "密码错误", "登录消息", 2);
                }
            }
            if(button.getName().equals("change")){
                Mysql.changeOtherAccountMessage();
            }
            if (button.getName().equals("changeown")){
                String password = new String(ChangeOwnPassword.passwordtext.getPassword());
                System.out.println(password);
                System.out.println(accountA);
                Mysql.changePassword(accountA, password);
                JOptionPane.showMessageDialog((Component)null, "修改密码成功", "修改密码消息",  2);
                aa.dispose();
                doctor.dispose();
                HospitalSystem.show();
            }
            if (button.getName().equals("delete")){
                String numberA=DeleteAccount.accounttext.getText();
                if (numberA.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "医生账户不能为空", "删除消息",  2);
                }
                else {
                    Mysql.delAccount1(numberA);
                }
            }




            if (button.getName().equals("add")){
                Medical.model.setNumRows(0);
                String name=Medical.nametext.getText();
                String number=Medical.numbertext.getText();
                String way=Medical.waytext.getText();
                String remain=Medical.remaintext.getText();
                if(name.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "药品名称不能为空", "编辑消息",  2);
                }
                if(number.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "药品编号不能为空", "编辑消息",  2);
                }
                if(way.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "进货方式不能为空", "编辑消息",  2);
                }
                if(remain.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "剩余数量不能为空", "编辑消息",  2);
                }else{
                Mysql.addmedicine(name,number,way,remain);
                String data[] =new String[5];
                    data[0]=name;
                    data[1]=number;
                    data[2]=way;
                    data[3]=remain;
                    Medical.model.addRow(data);

                }
            }

            if (button.getName().equals("del")){
                String numberA=Medical.numcontext.getText();
                if (numberA.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "输入的药品编号不能为空", "删除消息",  2);
                }
                else {
                    Mysql.delmedicine(numberA);
                }
            }
            if (button.getName().equals("change1")){
                String number=Medical.numbertext.getText();
                String name=Medical.nametext.getText();
                String way=Medical.waytext.getText();
                String remain=Medical.remaintext.getText();
                String numberA=Medical.numcontext.getText();
                if(numberA.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "输入的药品编号不能为空", "编辑消息",  2);
                }
                if(name.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "药品名称不能为空", "编辑消息",  2);
                }
                if(number.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "药品编号不能为空", "编辑消息",  2);
                }
                if(way.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "进货方式不能为空", "编辑消息",  2);
                }
                if(remain.equals("")){
                    JOptionPane.showMessageDialog((Component)null, "库存数量不能为空", "编辑消息",  2);
                }else{
                    Mysql.changemedicine(number,name,way,remain,numberA);
                    String data[] =new String[5];
                    data[0]=name;
                    data[1]=number;
                    data[2]=way;
                    data[3]=remain;
                    Medical.model.addRow(data);
                }
            }

            if (button.getName().equals("find")){
               String numberA=Medical.numcontext.getText();
                String number=Medical.numbertext.getText();
                String name=Medical.nametext.getText();
                String way=Medical.waytext.getText();
                String remain=Medical.remaintext.getText();
                if (numberA.equals("")){
                    if (name.equals("")&&number.equals("")&&way.equals("")&&remain.equals("")){
                        Mysql.findAllmedicine();
                        System.out.println("正在查看所有信息");
                    }else {
                        if (name.equals("")) {
                            name = ".*?";
                        }

                        if (number.equals("")) {
                            number = ".*?";
                        }

                        if (way.equals("")) {
                            way = ".*?";
                        }

                        if (remain.equals("")) {
                            remain = ".*?";
                        }
                        Mysql.findConMedicine(name,number,way,remain);
                    }
                } else if (!numberA.equals("")) {
                    Mysql.findOnemedicine(numberA);
                }
            }

            if (this.button.getName().equals("reset")){
                Medical.nametext.setText("");
                Medical.numbertext.setText("");
                Medical.waytext.setText("");
                Medical.remaintext.setText("");
            }

            if (this.button.getName() == "add1") {
                String sex;
                Patient.model.setNumRows(0);
                String name = Patient.nametext.getText();
                String number =Patient.numbertext.getText();
                boolean man = Patient.Men.isSelected();
                boolean woman = Patient.Women.isSelected();
                boolean allsex = Patient.allsex.isSelected();
                String age = Patient.agetext.getText();
                String buy = Patient.buytext.getText();
                if (name.equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "患者姓名不能为空", "编辑消息", 2);
                } else if (!man && !woman && allsex) {
                    Patient.Men.setSelected(true);
                    JOptionPane.showMessageDialog((Component)null, "”全部“在增加信息不能被选中", "编辑消息", 2);
                } else if (!man && !woman && !allsex) {
                    JOptionPane.showMessageDialog((Component)null, "请选则性别", "编辑消息", 2);
                } else if (age.equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "年纪不能为空", "编辑消息", 2);
                } else if (buy.equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "编号不能为空", "编辑消息", 2);
                } else {
                    if (Patient.Men.isSelected()) {
                        sex = Patient.Men.getText();
                    } else {
                        sex = Patient.Women.getText();
                    }

                    Mysql.addPatient(name, number, sex, age, buy);
                    String[] data = new String[]{name, number, sex, age, buy};
                    Patient.model.addRow(data);
                }
            }
            if (this.button.getName() == "del1") {
               String number = Patient.numcontext.getText();
                if (number.equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "输入的患者编号不能为空", "删除消息", 2);
                } else {
                    Mysql.delPatient(number);
                }
            }

            if (this.button.getName() == "change2") {
                String sex;
               String name = Patient.nametext.getText();
               boolean man = Patient.Men.isSelected();
               boolean woman = Patient.Women.isSelected();
               boolean allsex = Patient.allsex.isSelected();
                String buy = Patient.buytext.getText();
                String age =Patient.agetext.getText();
                String number = Patient.numbertext.getText();
                String numberA=Patient.numcontext.getText();
                if (numberA.equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "输入的患者编号不能为空", "删除消息", 2);
                } else if (name.equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "患者姓名不能为空", "编辑消息", 2);
                } else if (!man && !woman && allsex) {
                    Patient.Men.setSelected(true);
                    JOptionPane.showMessageDialog((Component)null, "”全部“在增加信息不能被选中", "编辑消息", 2);
                } else if (!man && !woman && !allsex) {
                    JOptionPane.showMessageDialog((Component)null, "请选则性别", "编辑消息", 2);
                } else if (buy.equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "患者购买的药品不能为空", "编辑消息", 2);
                } else if (number.equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "患者编号不能为空", "编辑消息", 2);
                } else {
                    if (Patient.Men.isSelected()) {
                        sex = Patient.Men.getText();
                    } else {
                        sex = Patient.Women.getText();
                    }

                    Mysql.changePatient(name, number, sex, age, buy, numberA);
                    String[] data = new String[]{name, number, sex, age, buy};
                    Patient.model.addRow(data);
                }
            }

            if (this.button.getName() == "find1") {
               String numberA = Patient.numcontext.getText();
               String sex = "";
                String name = Patient.nametext.getText();
                boolean men = Patient.Men.isSelected();
                boolean woman = Patient.Women.isSelected();
                boolean allsex = Patient.allsex.isSelected();
                if (!men && !woman && !allsex) {
                    Patient.allsex.setSelected(true);
                }

                String  age = Patient.agetext.getText();
                String  buy = Patient.buytext.getText();
                String number = Patient.numbertext.getText();
                if (Patient.Men.isSelected()) {
                    sex = Patient.Men.getText();
                } else if (Patient.Women.isSelected()) {
                    sex = Patient.Women.getText();
                }

                if (numberA.equals("")) {
                    if (name.equals("") && allsex && age.equals("") && buy.equals("") && number.equals("")) {
                        Mysql.findAllPatient();
                    } else {
                        if (name.equals("")) {
                            name = ".*?";
                        }

                        if (sex.equals("")) {
                            sex = ".*?";
                        }

                        if (age.equals("")) {
                            age = ".*?";
                        }

                        if (buy.equals("")) {
                            buy = ".*?";
                        }

                        if (number.equals("")) {
                            number = ".*?";
                        }

                        Mysql.findConPatient(name, number, sex, age, buy);
                    }
                } else if (!numberA.equals("")) {
                    Mysql.findOnePatient(numberA);
                }
            }

            if (this.button.getName() == "reset1") {
                Patient.nametext.setText("");
                Patient.allsex.setSelected(true);
                Patient.agetext.setText("");
                Patient.buytext.setText("");
                Patient.numbertext.setText("");
            }







            if(this.button.getName().equals("jButton1")){
               if (accountA.equals("admin"))
               {Mysql.onlineAccount();}
                else{
                   JOptionPane.showMessageDialog((Component)null, "你不是管理员账号无法查看", "消息", 2);
               }
            }
            else if (this.button.getName().equals("jButton2")){
                if (accountA.equals("admin"))
                { ChangeAccountMessage changeAccountMessage = new ChangeAccountMessage();}
            else{
                JOptionPane.showMessageDialog((Component)null, "你不是管理员账号无法查看", "消息", 2);
               }
            }
            else if (this.button.getName().equals("jButton5")){
                ChangeOwnPassword changeOwnPassword =new ChangeOwnPassword();
            }else if (this.button.getName().equals("jButton4")){
                Mysql.showownMessage(accountA);
            }else if (this.button.getName().equals("jButton3")){
                if (accountA.equals("admin")){  DeleteAccount deleteAccount =new DeleteAccount();}
                else{
                    JOptionPane.showMessageDialog((Component)null, "你不是管理员账号无法查看", "消息", 2);
                }


            }







        } catch (ClassCastException var6) {
            try {
                jButton = (JButton) e.getSource();
                if(jButton.getName()=="jbutton1"){
                    Mysql.onlineAccount();
                }
            } catch (Exception var5) {
                System.out.println("报错");
            }
        }

    }
   public static void addAble(ResultSet rs){
        String data[]=new String[4];
        try{
            while(rs.next()){
            data[0]=rs.getString(1);
            data[1]=rs.getString(2);
            data[2]=rs.getString(3);
            data[3]=rs.getString(4);
            Medical.model.addRow(data);}
    }
        catch (Exception e){}
}
    public static void addAble1(ResultSet rs){
        String data[]=new String[5];
        try{
            while(rs.next()){
                data[0]=rs.getString(1);
                data[1]=rs.getString(2);
                data[2]=rs.getString(3);
                data[3]=rs.getString(4);
                data[4]=rs.getString(5);

                Patient.model.addRow(data);}
        }
        catch (Exception e){}
    }
    public static void addOneAble(ResultSet rs){
        String data[]=new String[4];
        try{
                rs.next();
                data[0]=rs.getString(1);
                data[1]=rs.getString(2);
                data[2]=rs.getString(3);
                data[3]=rs.getString(4);
                Medical.nametext.setText(data[0]);
                Medical.numbertext.setText(data[1]);
                Medical.waytext.setText(data[2]);
                Medical.remaintext.setText(data[3]);
                Medical.model.addRow(data);}
        catch (Exception e){

        }

    }
    public static void addOneAble1(ResultSet rs) {
        String[] data = new String[5];

        try {
            rs.next();
            data[0] = rs.getString(1);
            data[1] = rs.getString(2);
            data[2] = rs.getString(3);
            data[3] = rs.getString(4);
            data[4] = rs.getString(5);
            Patient.nametext.setText(data[0]);
            Patient.numbertext.setText(data[1]);
            if (data[2].equals("男")) {
                Patient.Men.setSelected(true);
            } else if (data[2].equals("女")) {
                Patient.Women.setSelected(true);
            }
            Patient.agetext.setText(data[3]);
            Patient.buytext.setText(data[4]);
            Patient.model.addRow(data);
        } catch (SQLException var3) {
        }

    }








}