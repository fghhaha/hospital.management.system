package System;

import java.awt.Font;

public class Fronts {
    public static Font title;
    public static Font account;
    public static Font accounttext;
    public static Font ok;
    public static Font register;
    public static Font registerAcountText;
    public static Font jlabel;

    public Fronts() {
        title = new Font("宋体", 1, 28);
        account = new Font("华文bai行楷", 1, 18);
        accounttext = new Font("宋体", 0, 18);
        ok = new Font("宋体", 1, 18);
        register = new Font("宋体", 1, 15);
        registerAcountText = new Font("宋体", 0, 10);
        jlabel = new Font("宋体", 1, 28);
    }
}
