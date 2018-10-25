import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NewGameFrame extends JFrame implements ActionListener{
    private JButton jixu;
    private JButton newgame;
    private JButton oldgame;
    private ThunderWindow tw;
    public NewGameFrame(ThunderWindow frame){
        tw=frame;
        setTitle("����Ϸ");
        JLabel l=new JLabel("��Ϸ���ڽ��У���ϣ����ʲô��");
        Font font=new Font("����",Font.BOLD,20);
        l.setFont(font);
        l.setForeground(Color.red);
        newgame=new JButton("�˳�����ʼ����Ϸ(���ּ�Ϊʧ��)");
        oldgame=new JButton("���¿�ʼ�����Ϸ(���ּ�Ϊʧ��)");
        jixu=new JButton("         ��  ��  ��  Ϸ       ");
        font=new Font("����",Font.BOLD,20);
        newgame.setFont(font);
        newgame.setForeground(Color.blue);
        oldgame.setFont(font);
        oldgame.setForeground(Color.blue);
        jixu.setFont(font);
        jixu.setForeground(Color.blue);
        Container con=this.getContentPane();
        con.setLayout(null);
        l.setBounds(20,20,350,30);
        newgame.setBounds(20,80,350,40);
        oldgame.setBounds(20,130,350,40);
        jixu.setBounds(20,180,350,40);
        con.add(l);
        con.add(newgame);
        con.add(oldgame);
        con.add(jixu);
        setSize(400,270);
        jixu.addActionListener(this);
        newgame.addActionListener(this);
        oldgame.addActionListener(this);
        setVisible(true);
        setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ee){
             if (ee.getSource()==newgame){
                        String name=tw.getUsername();
                        int dengji=tw.getDengji();
                        tw.setVisible(false);
                        tw.gameOver(3);
                        int style=tw.getStyle();
                        tw=new ThunderWindow("ɨ����Ϸ",name,dengji,style);
                        tw.startGame(0);
                        setVisible(false);
             }
             if (ee.getSource()==oldgame){
                        int a[]=tw.getThunderOfxy();
                        String name=tw.getUsername();
                        int dengji=tw.getDengji();
                        tw.setVisible(false);
                        tw.gameOver(3);
                        int style=tw.getStyle();
                        tw=new ThunderWindow("ɨ����Ϸ",name,dengji,style);
                        tw.setThunderOfxy(a);
                        tw.startGame(1);
                         setVisible(false);
             }
             if (ee.getSource()==jixu){
                  setVisible(false);
             }
    }
    public static void main(String ar[]){
       //new NewGameFrame();
    }
}