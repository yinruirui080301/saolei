import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Event;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
public class StyleJFrame extends JFrame{
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;
    private ButtonGroup bg1=new ButtonGroup();
    private ButtonGroup bg2=new ButtonGroup();
    private JButton ok;
    private JButton cancel;
    private ThunderWindow tw;
    public StyleJFrame(){
         setTitle("更改外观");
         JLabel l1=new JLabel("选择游戏样式");
         rb1=new JRadioButton("红雷");
        rb2=new JRadioButton("灰雷");
         rb1.setIcon(new ImageIcon("TargetMine.png"));
         rb2.setIcon(new ImageIcon("Mine.png"));
         rb1.setBackground(Color.white);
         rb2.setBackground(Color.white);
        
          bg1.add(rb1);
          bg1.add(rb2);
         JPanel jp1=new JPanel();
         jp1.setLayout(new GridLayout(2,1,20,20));
         jp1.setBackground(Color.white);
         jp1.add(rb1);
         jp1.add(rb2);

         JLabel l2=new JLabel("选择按钮样式");
         rb3=new JRadioButton("灰按钮");
         rb4=new JRadioButton("绿按钮");
         rb3.setIcon(new ImageIcon("Action.png"));
         rb4.setIcon(new ImageIcon("Action1.png"));
         rb3.setBackground(Color.white);
         rb4.setBackground(Color.white);
       
         bg2.add(rb3);
         bg2.add(rb4); 
         JPanel jp2=new JPanel();
         jp2.setLayout(new GridLayout(2,1,20,20));
         jp2.setBackground(Color.white);
         jp2.add(rb3);
         jp2.add(rb4);
         ok=new JButton("确定");
         cancel=new JButton("取消");
         Container con=getContentPane();
         con.setLayout(null);
         l1.setBounds(50,20,90,30);
         jp1.setBounds(50,70,110,120);
         l2.setBounds(220,20,90,30);
         jp2.setBounds(220,70,110,120);
         ok.setBounds(100,210,60,30);
         cancel.setBounds(190,210,60,30);
         con.add(l1);
         con.add(l2);
         con.add(jp1);
         con.add(jp2);
         con.add(ok);
         con.add(cancel);
        
         
         setSize(360,300);
         setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
    }
    public static void main(String ar[]){
       new StyleJFrame();
    }
}