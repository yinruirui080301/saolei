import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HelpFrame extends JFrame {
    private JButton close;
    public HelpFrame(){
        setTitle("有关提示");
        JLabel l1=new JLabel();
        JLabel l2=new JLabel();
        JLabel l3=new JLabel();
        close=new JButton("关闭");
        l1.setForeground(Color.red);
        l2.setForeground(Color.blue);
        l3.setForeground(Color.blue);
        Font font=new Font("华文新魏",Font.BOLD,18);
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l1.setText("你可以通过双击某个数字来获得帮助。\n");
        l2.setText("初级可得1次提示；中级可得2次提示；\n");
        l3.setText("高级可得3次帮助。 ");
        Container con=this.getContentPane();
        con.setLayout(null);
        l1.setBounds(20,20,330,30);
        l2.setBounds(20,70,330,30);
        l3.setBounds(20,120,330,30);
        close.setBounds(120,170,80,30);
        con.add(l1);
        con.add(l2);
        con.add(l3);
        con.add(close);
        setSize(380,260);
        setVisible(true);
        setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //以下是关闭按钮的事件处理
        close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               setVisible(false);
            }
        });
    }
    public static void main(String ar[]){
        new HelpFrame();
    }
}