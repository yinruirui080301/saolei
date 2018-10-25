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
        setTitle("新游戏");
        JLabel l=new JLabel("游戏正在进行，您希望做什么？");
        Font font=new Font("楷体",Font.BOLD,20);
        l.setFont(font);
        l.setForeground(Color.red);
        newgame=new JButton("退出并开始新游戏(本局记为失败)");
        oldgame=new JButton("重新开始这个游戏(本局记为失败)");
        jixu=new JButton("         继  续  游  戏       ");
        font=new Font("隶书",Font.BOLD,20);
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
                        tw=new ThunderWindow("扫雷游戏",name,dengji,style);
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
                        tw=new ThunderWindow("扫雷游戏",name,dengji,style);
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