package System;

import event.LoginEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Medical extends JFrame {
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
    JLabel name;
    public static JTextField nametext;
    JLabel number;
    public static JTextField numbertext;
    JLabel way;
    public static JTextField waytext;
    JLabel remain;
    public static JTextField remaintext;
    JButton add,del,change,find,reset;
    Object[] columns = new Object[]{"药品名称", "药品编号", "进货渠道", "库存情况"};
    static JTable tableL = null;
    JScrollPane jscrollpane;
    static Vector rwo;
    static Object[][] a;
    static int row;
     public static DefaultTableModel model;
    static TableColumnModel columnModel;
    public Medical() {
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
        jPanel1.setBorder(BorderFactory.createTitledBorder("药品基本信息处理"));
        this.table();
        numcon= new JLabel("输入药品编号");
        numcontext = new JTextField(17);
        number = new JLabel("药品编号");
        numbertext = new JTextField(10);
        name= new JLabel("药品名称");
        nametext = new JTextField(10);
        way= new JLabel("进货渠道");
        waytext = new JTextField(10);
        remain = new JLabel("库存情况(kg)");
        remaintext = new JTextField(10);
        add =new JButton("增加数据");
        del =new JButton("删除数据");
        change =new JButton("更改数据");
        find =new JButton("查找数据");
        reset=new JButton("重置数据 ");
        jPanel2.setLayout(flowLayout);
        jPanel2.setBounds(0,250,WIDTH,300);
        jPanel2.setBorder(BorderFactory.createTitledBorder("药品基本信息显示"));
        jPanel1.add(name);
        jPanel1.add(nametext);
        jPanel1.add(number);
        jPanel1.add(numbertext);
        jPanel1.add(way);
        jPanel1.add(waytext);
        jPanel1.add(remain);
        jPanel1.add(remaintext);
        jPanel1.add(numcon);
        jPanel1.add(numcontext);
        jPanel1.add(add);
        jPanel1.add(del);
        jPanel1.add(change);
        jPanel1.add(find);
        jPanel1.add(reset);
        jPanel2.add(jscrollpane);
        allEvent();

        add.setName("add");
        del.setName("del");
        change.setName("change1");
        find.setName("find");
        reset.setName("reset");

        this.setLayout(null);
        this.setTitle("药品信息管理界面");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - 800) / 2;
        int y = (height - 725) / 2;
        this.setBounds(x, y, 800, 725);
   ImageIcon img = new ImageIcon("src/img/3.jpg");
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
            int[] columnWidth = new int[]{187, 187, 187, 187,};
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

            rwo = new Vector(4);
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
