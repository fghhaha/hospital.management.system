package System;

import mysql.Mysql;

public class HospitalSystem {
    public static LoginStart loginstartA;

    public static void main(String[] args) {
        show();
       // Mysql a = new Mysql("root","123");
       // LoginStart loginstart = new LoginStart();
        //Register register = new Register();
       //Manage manage =new Manage();
       //Medical medical = new Medical();
        //Patient patient = new Patient();
       // Doctor doctor = new Doctor();
        //ChangeAccountMessage changeAccountMessage = new ChangeAccountMessage();
        //ChangeOwnPassword changeOwnPassword = new ChangeOwnPassword();


    }
    public static void show() {
        LoginStart loginstart = new LoginStart();
        loginstartA = loginstart;
        new Mysql("root", "123");
        //Medical medical = new Medical();
        // Doctor doctor = new Doctor();
       /// Patient patient = new Patient();
       // DeleteAccount deleteAccount = new DeleteAccount();
      //  Manage manage = new Manage();
        //help help = new help();
    }
}
