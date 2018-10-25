import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class XuanXiangFrameOk extends JFrame implements ActionListener{
    private JButton l1;
    private JButton l2;
    private XuanXiangFrame frame;
    public XuanXiangFrame getFrame(){
       return frame;
    }
    public XuanXiangFrameOk(XuanXiangFrame frame){
        setTitle("已更改游戏设置");
        this.frame=frame;
        l1=new JButton("-〉退出并以新设置开始新游戏           ");
        l2=new JButton("-> 继续现在游戏;新设置应用于下一个游戏");
        JLabel l3=new JLabel("这些设置不会应用到已开始的游戏中。");
        JLabel l4=new JLabel("您希望做什么？");
        Container con=this.getContentPane();
        con.setLayout(null);
        l3.setBounds(20,20,450,30);
        l4.setBounds(20,60,450,30);
        l1.setBounds(20,130,450,50);
        l2.setBounds(20,200,450,50);
        l2.setForeground(Color.blue);
        l1.setForeground(Color.blue);
        Font font=new Font("隶书",Font.BOLD,20);
        l1.setFont(font);
        l2.setFont(font);
        l1.addActionListener(this);
        l2.addActionListener(this);
        con.add(l3);
        con.add(l4);
        con.add(l1);
        con.add(l2);
        setSize(480,300);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
   }
     public void actionPerformed(ActionEvent e){
         if (e.getSource()==l1){
             int dengji=frame.getDengji();
             
             ThunderWindow tw=frame.getTw();
             String name=tw.getUsername();
             int style=tw.getStyle();
             tw.gameOver(3);
             tw.setVisible(false);
             tw=new ThunderWindow("扫雷游戏",name,dengji,style);
         }
         if (e.getSource()==l2){
            int dengji=frame.getDengji();
            
             ThunderWindow tw=frame.getTw();
            int style=tw.getStyle();
            tw.setDengji(dengji);
            tw.getStyle();
         }
         setVisible(false);
     }
     public static void main(String ar[]){
        
    }
}