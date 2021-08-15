package event;
import System.Doctor;
import System.Medical;
import System.Patient;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import System.*;

public class ManageEvent1 implements ActionListener {
    JButton Button;

    @Override
    public void actionPerformed(ActionEvent e) {
        //这里面只存在一个按钮实体，就是你绑定点击的那个
        Button = (JButton) e.getSource();
        //判断你点击传进来的按钮是哪一个
        if("ok1".equals(Button.getName())){ //以后字符串比对都用.equals(String)
            Medical medical = new Medical();
        }else if("ok2".equals(Button.getName()))
        {
            Patient patient = new Patient();
        }else if ("ok3".equals(Button.getName())){
            Doctor doctor = new Doctor();
        }else if ("ok4".equals(Button.getName())){
            help help = new help();
        }

        /*
        try {

            Button1 = (JButton) e.getSource();
            Button2 = (JButton) e.getSource();
            System.out.println(Button1 == Button2);
            if("ok1".equals(Button1.getName())){ //以后字符串比对都用.equals(String)

            }else if(Button2.getName() == ("ok2"))
            {
                Doctor doctor = new Doctor();
            }
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }*/

}
}