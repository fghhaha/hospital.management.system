package System;

import javax.swing.*;
import java.awt.*;

import event.LoginEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Patient extends JFrame {
    final int WIDTH=800;
    final int HEIGHT=725;
    ActionListener actionListener1;
    FlowLayout flowLayout;
    public static JLabel numcon;
    public static JTextField numcontext;
    JLabel bgimg;
    JPanel jPanel1;
    JPanel jPanel2;//放表格
    JTable table;
    ButtonGroup group = null;
    public static  JLabel name;
    public static JRadioButton Men;
    public static JRadioButton Women;
    public static   JRadioButton allsex;
    public static JTextField nametext;
    JLabel number;
    public static JTextField numbertext;
    JLabel age;
    public static JTextField agetext;
    JLabel buy;
    public static JTextField buytext;
    JButton add,del,change,find,reset;
    Object[] columns = new Object[]{"患者名称", "患者编号", "患者性别","患者年龄", "患者所购药品"};
    static JTable tableL = null;
    JScrollPane jscrollpane;
    static Vector rwo;
    static Object[][] a;
    static int row;
    public static DefaultTableModel model;
    static TableColumnModel columnModel;
    public Patient() {
        init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(2);
        validate();
    }
    void init(){
        flowLayout = new FlowLayout();
        jPanel1 =new JPanel();
        jPanel2 =new JPanel();
        jPanel1.setLayout(flowLayout);
        jPanel1.setBounds(0,150,WIDTH-19,100);
        this.group = new ButtonGroup();
        this.Men = new JRadioButton("男");
        this.Women = new JRadioButton("女");
        this.allsex = new JRadioButton("全部");
        this.group.add(this.Men);
        this.group.add(this.Women);
        this.group.add(this.allsex);
        jPanel1.setBorder(BorderFactory.createTitledBorder("患者基本信息处理"));
        this.setTitle("患者信息处理页面");
        this.table();
        name= new JLabel("患者名称");
        nametext = new JTextField(7);
        numcon= new JLabel("输入患者编号");
        numcontext = new JTextField(7);
        number = new JLabel("患者编号");
        numbertext = new JTextField(7);
        age= new JLabel("患者年龄");
        agetext = new JTextField(7);
        buy = new JLabel("患者所购药品");
        buytext = new JTextField(10);
        add =new JButton("增加数据");
        del =new JButton("删除数据");
        change =new JButton("更改数据");
        find =new JButton("查找数据");
        reset=new JButton("重置数据 ");
        jPanel2.setLayout(flowLayout);
        jPanel2.setBounds(0,250,WIDTH,300);
        jPanel2.setBorder(BorderFactory.createTitledBorder("患者基本信息显示"));
        jPanel1.add(name);
        jPanel1.add(nametext);
        jPanel1.add(number);
        jPanel1.add(numbertext);
        jPanel1.add(this.Men);
        jPanel1.add(this.Women);
        jPanel1.add(this.allsex);
        jPanel1.add(age);
        jPanel1.add(agetext);
        jPanel1.add(buy);
        jPanel1.add(buytext);
        jPanel1.add(numcon);
        jPanel1.add(numcontext);
        jPanel1.add(add);
        jPanel1.add(del);
        jPanel1.add(change);
        jPanel1.add(find);
        jPanel1.add(reset);
        jPanel2.add(jscrollpane);
        allEvent();

        add.setName("add1");
        del.setName("del1");
        change.setName("change2");
        find.setName("find1");
        reset.setName("reset1");

        this.setLayout(null);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 800) / 2;
        int y = (height - 725) / 2;
        this.setBounds(x, y, 800, 725);
        ImageIcon img = new ImageIcon("src/img/5.jpg");
        this.add(jPanel1);
        this.add(jPanel2);
        this.bgimg = new JLabel(img);
        this.bgimg.setBounds(0, 0, img.getIconWidth(), 150);
        this.add(bgimg);
    }
    void table() {
        this.tableL = this.getTable();
        this.jscrollpane = new JScrollPane(this.tableL);//添加一个浏览表格
        this.jscrollpane.setPreferredSize(new Dimension(770, 250));//给窗格设置大小
        this.tableL.setPreferredSize(new Dimension(770, 1000));//给表格设置大小
        this.jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//将滑动组件显示在视口中
    }
    JTable getTable() {
        if (this.tableL == null) {
            this.tableL = new JTable();
            int[] columnWidth = new int[]{150, 150, 150, 150,150};
            model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.setColumnIdentifiers(this.columns);
            this.tableL.setModel(model);
            columnModel = this.tableL.getColumnModel();
            this.tableL.getTableHeader().setReorderingAllowed(false);
            this.tableL.getTableHeader().setResizingAllowed(false);
            int count = columnModel.getColumnCount();

            for(int i = 0; i < count; ++i) {
                TableColumn column = columnModel.getColumn(i);
                column.setPreferredWidth(columnWidth[i]);
            }

            rwo = new Vector(5);
        }

        return this.tableL;
    }
    void allEvent(){
        actionListener1 = new LoginEvent();
        add.addActionListener(actionListener1);
        del.addActionListener(actionListener1);
        change.addActionListener(actionListener1);
        find.addActionListener(actionListener1);
        reset.addActionListener(actionListener1);


    }
}
