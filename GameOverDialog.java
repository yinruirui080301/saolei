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
    /**������Ϸʧ�ܵĶԻ���һ������Ϊʱ�䵽�ˣ�һ������Ϊ�㵽����**/ 
     public GameOverDialog(ThunderWindow jframe,String title,String tishistring){
            super(jframe,title);
            tw=jframe;
            String name=tw.getUsername();
            int dengji=tw.getDengji();
            String jibie;
            if (dengji==3) jibie="�߼�";
            else if (dengji==2) jibie="�м�";
            else jibie="����";
            /** ͳ�Ƶ�ǰ�û���ǰ�ĳɼ� **/
            LogDao logDao=new LogDao();
            Log log=logDao.maxScore(name,dengji);
            List<Log> list=logDao.findByName(name,dengji);
            int num=list.size();
            int a[]=logDao.numOf(name,dengji);
            double rate=logDao.rateOf(name,dengji);
            /** �������ʾ���û� **/
            tishi=new JTextArea(tishistring+"\n\n");
            tishi.setEditable(false);
            tishi.append("�㹲����"+num+"��"+jibie+"��Ϸ\n");
            if (log==null){
              tishi.append("һ�ζ�û�гɹ�!\n");
            }else{
                tishi.append("�ɹ���"+a[0]+"��,ʧ����"+a[1]+"��,�ɹ�����"+(int)(rate*100)+"%\n");
                int good=log.getScore();
                Date date=log.getDate();
                Time ti=log.getTime();
               tishi.append("����õĳɼ�����"+date+" "+ti+"��ģ���ʱ"+good+"��"); 
            }
            /**�����ı�������� **/
            Font font=new Font("����_GB2312",Font.BOLD,15);
            tishi.setFont(font);
            tishi.setBackground(Color.cyan);
            tishi.setForeground(Color.red);
            exit=new JButton("������");
            newb=new JButton("���¿�ʼ�µ���Ϸ");
            old=new JButton("������ǰ��Ϸ");
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
                        tw=new ThunderWindow("ɨ����Ϸ",name,dengji,style);
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
                        tw=new ThunderWindow("ɨ����Ϸ",name,dengji,style);
                        tw.setThunderOfxy(a);
                        tw.startGame(1);
                   }
            });
     }
     /**Ҫ��Ϊ������Ϸ**/
     public GameOverDialog(ThunderWindow frame){
         super(frame,"�˳���Ϸ");
         this.tw=frame;
         tishi=new JTextArea("�����Ҫ�˳���Ϸ����\n");
         tishi.setEditable(false);
         exit=new JButton("�ǵ�");
         old=new JButton("���ˣ�������");
         Font font=new Font("����_GB2312",Font.BOLD,23);
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
    /**������Ϸ�ɹ��ĶԻ���**/
     public GameOverDialog(ThunderWindow jframe,String title,int time){
            super(jframe,title); 
            tw=jframe;
            String name=tw.getUsername();
            int dengji=tw.getDengji();
            String jibie;
            if (dengji==3) jibie="�߼�";
            else if (dengji==2) jibie="�м�";
            else jibie="����";
            /** ͳ�Ƶ�ǰ�û���ǰ�ĳɼ� **/
            LogDao logDao=new LogDao();
            Log log=logDao.maxScore(name,dengji);
            List<Log> list=logDao.findByName(name,dengji);
            int num=list.size();
            int a[]=logDao.numOf(name,dengji);
            double rate=logDao.rateOf(name,dengji);
            /** �������ʾ���û� **/
            tishi=new JTextArea(name+"����ϲ����ɹ��ˣ�"+"������"+time+"��\n");
           tishi.setEditable(false);
            tishi.append("�㹲����"+num+"��"+jibie+"��Ϸ\n");
            if (log==null){
              tishi.append("һ�ζ�û�гɹ�!\n");
            }else{
                tishi.append("�ɹ���"+a[0]+"��,ʧ����"+a[1]+"��,�ɹ�����"+(int)(rate*100)+"%\n");
                int good=log.getScore();
                Date date=log.getDate();
                Time ti=log.getTime();
               tishi.append("����õĳɼ�����"+date+" "+ti+"��ģ���ʱ"+good+"��"); 
            }
            Font font=new Font("����_GB2312",Font.BOLD,15);
            tishi.setFont(font);
            tishi.setBackground(Color.cyan);
            tishi.setForeground(Color.red);
            exit=new JButton("��Ϣ��");
            newb=new JButton("����һ��");
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
                        tw=new ThunderWindow("ɨ����Ϸ",name,dengji,style);
                        tw.startGame(0);
                   }
            });
     }
}