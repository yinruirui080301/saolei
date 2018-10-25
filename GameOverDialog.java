import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
public class GameOverDialog extends JDialog{
     private JButton exit;
     private JButton newb;
     private JButton old;
     private JTextArea tishi;
     private ThunderWindow tw;
    /**构造游戏失败的对话框，一种是因为时间到了，一种是因为点到雷了**/ 
     public GameOverDialog(ThunderWindow jframe,String title,String tishistring){
            super(jframe,title);
            tw=jframe;
            String name=tw.getUsername();
            int dengji=tw.getDengji();
            String jibie;
            if (dengji==3) jibie="高级";
            else if (dengji==2) jibie="中级";
            else jibie="初级";
            /** 统计当前用户以前的成绩 **/
            LogDao logDao=new LogDao();
            Log log=logDao.maxScore(name,dengji);
            List<Log> list=logDao.findByName(name,dengji);
            int num=list.size();
            int a[]=logDao.numOf(name,dengji);
            double rate=logDao.rateOf(name,dengji);
            /** 将结果显示给用户 **/
            tishi=new JTextArea(tishistring+"\n\n");
            tishi.setEditable(false);
            tishi.append("你共玩了"+num+"次"+jibie+"游戏\n");
            if (log==null){
              tishi.append("一次都没有成功!\n");
            }else{
                tishi.append("成功了"+a[0]+"次,失败了"+a[1]+"次,成功率是"+(int)(rate*100)+"%\n");
                int good=log.getScore();
                Date date=log.getDate();
                Time ti=log.getTime();
               tishi.append("你最好的成绩是于"+date+" "+ti+"玩的，用时"+good+"秒"); 
            }
            /**设置文本域的字体 **/
            Font font=new Font("楷体_GB2312",Font.BOLD,15);
            tishi.setFont(font);
            tishi.setBackground(Color.cyan);
            tishi.setForeground(Color.red);
            exit=new JButton("不玩了");
            newb=new JButton("重新开始新的游戏");
            old=new JButton("继续当前游戏");
            Container con=this.getContentPane();
            con.setLayout(null);
            con.setLayout(null);
            tishi.setBounds(20,20,400,150);
            exit.setBounds(20,200,80,30);
            newb.setBounds(120,200,150,30);
            old.setBounds(290,200,130,30);
            con.add(tishi);
            con.add(exit);
            con.add(newb);
            con.add(old);
            setSize(450,290);
            setVisible(false);
             setResizable(false);
            exit.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                        System.exit(0);
                   }
            });
            newb.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                        String name=tw.getUsername();
                        int dengji=tw.getDengji();
                        System.out.println(dengji);
                        int style=tw.getStyle();
                        tw.setVisible(false);
                        tw=new ThunderWindow("扫雷游戏",name,dengji,style);
                        tw.startGame(0);
                   }
            });
            old.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                        int a[]=tw.getThunderOfxy();
                        tw.setVisible(false);
                        String name=tw.getUsername();
                        int dengji=tw.getDengji();
                        int style=tw.getStyle();
                        tw=new ThunderWindow("扫雷游戏",name,dengji,style);
                        tw.setThunderOfxy(a);
                        tw.startGame(1);
                   }
            });
     }
     /**要人为结束游戏**/
     public GameOverDialog(ThunderWindow frame){
         super(frame,"退出游戏");
         this.tw=frame;
         tishi=new JTextArea("你真的要退出游戏了吗\n");
         tishi.setEditable(false);
         exit=new JButton("是的");
         old=new JButton("算了，继续吧");
         Font font=new Font("楷体_GB2312",Font.BOLD,23);
            tishi.setFont(font);
            tishi.setBackground(Color.cyan);
            tishi.setForeground(Color.red);
          Container con=this.getContentPane();
            con.setLayout(null);
            tishi.setBounds(20,20,400,50);
            exit.setBounds(20,90,80,30);
            old.setBounds(120,90,150,30);
            con.add(tishi);
            con.add(exit);
            con.add(old);
            setSize(450,290);
            setVisible(false);
           setResizable(false);
            exit.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                        System.exit(0);
                   }
            });
            old.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                       setVisible(false);
                   }
            });
     }
    /**构造游戏成功的对话框**/
     public GameOverDialog(ThunderWindow jframe,String title,int time){
            super(jframe,title); 
            tw=jframe;
            String name=tw.getUsername();
            int dengji=tw.getDengji();
            String jibie;
            if (dengji==3) jibie="高级";
            else if (dengji==2) jibie="中级";
            else jibie="初级";
            /** 统计当前用户以前的成绩 **/
            LogDao logDao=new LogDao();
            Log log=logDao.maxScore(name,dengji);
            List<Log> list=logDao.findByName(name,dengji);
            int num=list.size();
            int a[]=logDao.numOf(name,dengji);
            double rate=logDao.rateOf(name,dengji);
            /** 将结果显示给用户 **/
            tishi=new JTextArea(name+"，恭喜，你成功了，"+"你用了"+time+"秒\n");
           tishi.setEditable(false);
            tishi.append("你共玩了"+num+"次"+jibie+"游戏\n");
            if (log==null){
              tishi.append("一次都没有成功!\n");
            }else{
                tishi.append("成功了"+a[0]+"次,失败了"+a[1]+"次,成功率是"+(int)(rate*100)+"%\n");
                int good=log.getScore();
                Date date=log.getDate();
                Time ti=log.getTime();
               tishi.append("你最好的成绩是于"+date+" "+ti+"玩的，用时"+good+"秒"); 
            }
            Font font=new Font("楷体_GB2312",Font.BOLD,15);
            tishi.setFont(font);
            tishi.setBackground(Color.cyan);
            tishi.setForeground(Color.red);
            exit=new JButton("休息了");
            newb=new JButton("再玩一局");
            Container con=this.getContentPane();
            con.setLayout(null);
            tishi.setBounds(20,20,400,150);
            exit.setBounds(40,200,100,30);
            newb.setBounds(180,200,100,30);
            con.add(tishi);
            con.add(exit);
            con.add(newb);
            setSize(450,290);
            setVisible(false);
            setResizable(false);
             exit.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){               
                        System.exit(0);
                   }
            });
            newb.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                        tw.setVisible(false);
                        String name=tw.getUsername();
                        int dengji=tw.getDengji();
                        int style=tw.getStyle();
                        tw=new ThunderWindow("扫雷游戏",name,dengji,style);
                        tw.startGame(0);
                   }
            });
     }
}