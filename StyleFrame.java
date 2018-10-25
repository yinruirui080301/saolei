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
import javax.swing.BorderFactory;
public class StyleFrame extends JFrame implements ActionListener{
    
    private ButtonGroup bg1=new ButtonGroup();
    private ButtonGroup bg2=new ButtonGroup();
    private JRadioButton rb1=new JRadioButton("����",true);
    private JRadioButton rb2=new JRadioButton("Ц��");
    private JRadioButton rb3=new JRadioButton("����ť",true);
    private JRadioButton rb4=new JRadioButton("�̰�ť");
    private JRadioButton rb5=new JRadioButton("�ư�ť");
    private JButton ok;
    private JButton cancel;
    private ThunderWindow tw;
    public StyleFrame(ThunderWindow jframe){
         tw=jframe;
        
         setTitle("�������");
 
         bg1.add(rb1);
         bg1.add(rb2);
         bg2.add(rb3);
         bg2.add(rb4);
         bg2.add(rb5);

         JPanel p1=new JPanel();
         JPanel p2=new JPanel();
         p1.setBorder(BorderFactory.createTitledBorder("�׵���ʽ"));
         p2.setBorder(BorderFactory.createTitledBorder("��ť����ʽ"));
         p1.setLayout(new GridLayout(2,2,0,10));
         p2.setLayout(new GridLayout(3,2,0,10));
         
         JLabel l1=new JLabel(new ImageIcon("image/Mine.png"));
         JLabel l2=new JLabel(new ImageIcon("image/Mine1.gif"));
         JLabel l3=new JLabel(new ImageIcon("image/ActionBlue.png"));
         JLabel l4=new JLabel(new ImageIcon("image/ActionGreen.png"));
         JLabel l5=new JLabel(new ImageIcon("image/ActionYellow.png"));

         p1.add(rb1);
         p1.add(l1);
         p1.add(rb2);
         p1.add(l2);
         p2.add(rb3);
         p2.add(l3);
         p2.add(rb4);
         p2.add(l4);
         p2.add(rb5);
         p2.add(l5);

         ok=new JButton("ȷ��");
         cancel=new JButton("ȡ��");
         Container con=getContentPane();

         con.setLayout(null);
        
         p1.setBounds(50,70,120,120);
         p2.setBounds(200,20,140,170);
         ok.setBounds(100,210,60,30);
         cancel.setBounds(190,210,60,30);
        
         con.add(p1);
         con.add(p2);
         con.add(ok);
         con.add(cancel);
        
         ok.addActionListener(this);
         cancel.addActionListener(this);
         setSize(360,300);
         setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==cancel){
              setVisible(false);
        }
        if (ae.getSource()==ok){
            /** ���ж�ѡ�����ʽ��ʲô **/
            if (rb1.isSelected()){
                 if (rb3.isSelected())
                   tw.setStyle(Style.STYLE_HB);
                 else if (rb4.isSelected())
                    tw.setStyle(Style.STYLE_HG);
                 else tw.setStyle(Style.STYLE_HY);
            }else{
                 if (rb3.isSelected())
                   tw.setStyle(Style.STYLE_XB);
                 else if (rb4.isSelected())
                    tw.setStyle(Style.STYLE_XG);
                 else tw.setStyle(Style.STYLE_XY);
            }
           setVisible(false);
        }
    }
   
}