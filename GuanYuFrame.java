import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GuanYuFrame extends JFrame {
    private JButton close;
    public GuanYuFrame(){
        setTitle("关于扫雷");
        JLabel l1=new JLabel();
        JLabel l2=new JLabel();
        JLabel l3=new JLabel();
        JLabel l4=new JLabel();
        JLabel l5=new JLabel();
        close=new JButton("关闭");
        l1.setForeground(Color.green);
        l2.setForeground(Color.blue);
        l3.setForeground(Color.blue);
        l4.setForeground(Color.blue);
        l5.setForeground(Color.red);
        Font font=new Font("华文新魏",Font.BOLD,18);
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l1.setText("      此扫雷游戏有6种外观，4个等级。\n");
        l2.setText("玩家注册后方可玩。可以统计每个玩家\n");
        l3.setText("的成功率，还可以显示出每个等级的前\n");
        l4.setText("5名的玩家。游戏还有提示功能。\n");
        l5.setText("     希望大家玩得开心！");
        Container con=this.getContentPane();
        con.setLayout(null);
        l1.setBounds(20,20,330,30);
        l2.setBounds(20,70,330,30);
        l3.setBounds(20,120,330,30);
        l4.setBounds(20,170,330,30);
        l5.setBounds(20,220,330,30);
        close.setBounds(120,270,80,30);
        con.add(l1);
        con.add(l2);
        con.add(l3);
        con.add(l4);
        con.add(l5);
        con.add(close);
        setSize(380,360);
        setVisible(true);
        setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               setVisible(false);
            }
        });
    }
    public static void main(String ar[]){
       new GuanYuFrame();
    }
}