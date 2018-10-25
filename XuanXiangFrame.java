import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import java.awt.event.ItemEvent;
public class XuanXiangFrame extends JFrame implements ActionListener{
     private ThunderWindow tw;
     private int dengji;
     private JRadioButton chuji;
     private JRadioButton zhongji;
     private JRadioButton gaoji;
     private JRadioButton zidingyi;
     private JTextField x;
     private JTextField y;
     private JTextField size;
     private JLabel lx;
     private JLabel ly;
     private JLabel lsize;
     private JButton ok;
     private JButton cancel;
     private int[] whs;
     private JLabel tishi;
     public void setDengji(int dengji){
        this.dengji=dengji;
     }
     public int getDengji(){
         return dengji;
     }
    public ThunderWindow getTw(){
         return tw;
    }
     public XuanXiangFrame(ThunderWindow frame,int dengji){
         tw=frame;
         this.dengji=dengji;
         setTitle("选项");
         chuji=new JRadioButton("初级（10个雷;10*10个网格)");
         zhongji=new JRadioButton("中级（40个雷;15*15个网格)");
         gaoji=new JRadioButton("高级（90个雷;18*20个网格)");
         zidingyi=new JRadioButton("自定义");
         if (dengji==1)
            chuji.setSelected(true);
         else if (dengji==2)
            zhongji.setSelected(true);
         else if (dengji==3)
              gaoji.setSelected(true);
         else zidingyi.setSelected(true);
         chuji.setForeground(Color.blue);
         zhongji.setForeground(Color.blue);
         gaoji.setForeground(Color.blue);
         zidingyi.setForeground(Color.blue);
         lx=new JLabel("宽度(9-24):");
         ly=new JLabel("高度(9-30):");
         lsize=new JLabel("雷数(10-360):");
         x=new JTextField(5);
         y=new JTextField(5);
         size=new JTextField(5);
         ok=new JButton("确定");
         cancel=new JButton("取消");
         tishi=new JLabel();
         tishi.setForeground(Color.red);
         Container con=this.getContentPane();
         con.setLayout(null);
         chuji.setBounds(20,20,200,40);
         zhongji.setBounds(20,80,200,40);
         gaoji.setBounds(20,140,200,40);
         zidingyi.setBounds(250,20,200,30);
         lx.setBounds(260,60,80,30);
         x.setBounds(340,65,50,20);
         ly.setBounds(260,100,80,30);
         y.setBounds(340,105,50,20);
         lsize.setBounds(260,140,80,30);
         size.setBounds(340,145,50,20);
         ok.setBounds(100,230,100,30);
         cancel.setBounds(250,230,100,30);
         tishi.setBounds(260,190,150,30);
         con.add(chuji);
         con.add(zhongji);
         con.add(gaoji);
         con.add(zidingyi);
         con.add(lx);
         con.add(x);
         con.add(ly);
         con.add(y);
         con.add(lsize);
         con.add(size);
         con.add(ok);
         con.add(cancel);
         con.add(tishi);
         ButtonGroup bg=new ButtonGroup();
         bg.add(chuji);
         bg.add(zhongji);
         bg.add(gaoji);
         bg.add(zidingyi);
         setSize(450,300);
         setVisible(true);
         setResizable(false); 
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         if (dengji!=4){
                x.setEnabled(false);
                y.setEnabled(false);
                size.setEnabled(false);
                x.setBackground(new Color(238,238,238));
                y.setBackground(new Color(238,238,238));
                size.setBackground(new Color(238,238,238));
         }
         chuji.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ee){
              if (!zidingyi.isSelected()){
                x.setEnabled(false);
                y.setEnabled(false);
                size.setEnabled(false);
                x.setBackground(new Color(238,238,238));
                y.setBackground(new Color(238,238,238));
                size.setBackground(new Color(238,238,238));
              }
            }
         });
         zhongji.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ee){
              if (!zidingyi.isSelected()){
                x.setEnabled(false);
                y.setEnabled(false);
                size.setEnabled(false);
                x.setBackground(new Color(238,238,238));
                y.setBackground(new Color(238,238,238));
                size.setBackground(new Color(238,238,238));
              }
            }
         });
         gaoji.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ee){
              if (!zidingyi.isSelected()){
                x.setEnabled(false);
                y.setEnabled(false);
                size.setEnabled(false);
                x.setBackground(new Color(238,238,238));
                y.setBackground(new Color(238,238,238));
                size.setBackground(new Color(238,238,238));
              }
            }
         });
         ok.addActionListener(this);
          cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
         });
         zidingyi.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ee){
              if (zidingyi.isSelected()){
                x.setEnabled(true);
                y.setEnabled(true);
                size.setEnabled(true);
                x.setBackground(Color.white);
                y.setBackground(Color.white);
                size.setBackground(Color.white);
              }
            }
         });
     }
     public void actionPerformed(ActionEvent e){
                 if (chuji.isSelected()){ 
                    setDengji(1);
                    setVisible(false);
                 }
                 if (zhongji.isSelected()){
                      setDengji(2);
                     setVisible(false);
                 }
                 if (gaoji.isSelected()){
                     setDengji(3);
                     setVisible(false);
                 }
                 if (zidingyi.isSelected()){
                    
                     int a[]=new int[3];
                    try{
                       a[0]=Integer.parseInt(x.getText());
                       a[1]=Integer.parseInt(y.getText());
                       a[2]=Integer.parseInt(size.getText());
                       if (a[2]>(a[0]*a[1])/2){
                          tishi.setText("雷数必须是10-"+(a[0]*a[1])/2+"之间的数");
                        }else{
                           setDengji(4);
                           SetFrameSize.sumOfThunder[3]=a[2];
                           SetFrameSize.sumOfButton[3][0]=a[0];
                           SetFrameSize.sumOfButton[3][1]=a[1];
                           SetFrameSize.sizeOfFrame[3][0]=380+(a[1]-10)*40;
                           SetFrameSize.sizeOfFrame[3][1]=450+(a[0]-10)*50;
                           setVisible(false);
                        }
                     }catch(NumberFormatException ee){
                         tishi.setText("文本框必须填数值");
                     }   
                 }
                 if (tw.getStart().isEnabled()){
                       String name=tw.getUsername();
                       tw.setVisible(false);
                        int dengji=getDengji();
                        int style=tw.getStyle();
                       tw=new ThunderWindow("扫雷游戏",name,dengji,style);
                 }else{
                      new XuanXiangFrameOk(this);
                 }
            }
     public static void main(String ar[]){
         
          
      }
}