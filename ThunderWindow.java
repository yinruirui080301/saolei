import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.sql.Date;
import java.sql.Time;
public class ThunderWindow extends JFrame implements ActionListener{
    
    private int x,y;
    private int width,height;
    private int size;
    private JMenuBar mb;
    private JMenu jm1;
    private JMenu jm2;
    private JMenuItem xinyouxi;
    private JMenuItem xuanxiang;
    private JMenuItem tongji;
    private JMenuItem waiguan;
    private JMenuItem tuichu;
    private JMenuItem guanyu;
    private JMenuItem youxitishi;
    private String username;
    private int dengji;
    private int thunderOfxy[];
    private TimeThread tt;
    private Thread thread;
    private JProgressBar progressBar;
    private Timer timeMonitor;
    private JPanel panel;
    private JLabel show_time;
    private JLabel show_thunder_num;
    private JLabel show_tishi_num;
    private JButton start,end;
    private ThunderButton thunder[][];
    private int find_num=0;
    private int tishisum=0;
    private  GameOverDialog gameOver1;
    private  GameOverDialog gameOver2;
    private  GameOverDialog gameOver3;
    private  GameOverDialog gameOver4;
    private int style=1;
    
    /**������Ϸ��ѡ��ȼ���**/
    public void setTishisum(int tishisum){
       this.tishisum=tishisum;
    }
    public int getTishisum(){
      return tishisum;
    }
    public void setX(int x){
       this.x=x;
    }
    public void setY(int y){
      this.y=y;
    }
    public int getX(){
      return x;
    }
    public int getY(){
      return y;
    }
    public void setSize(int size){
         this.size=size;
    }
    public int getSizenew(){
       return size;
    }
    public void setWidth(int width){
        this.width=width;
    }
     public int getWidth(){
        return width;
    }
    public void setHeight(int height){
       this.height=height;
    }
    public int getHeight(){
       return height;
    }
    public void setDengji(int dengji){
        this.dengji=dengji;
    }
    public int getDengji(){
       return dengji;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
         return username;
    }
    public JButton getStart(){
         return start;
    }
    public void setStyle(int style){
      this.style=style;
      for(int i=0;i<x;i++)
        for(int j=0;j<y;j++)
             thunder[i][j].setStyle(style);
    }
    public int getStyle(){
      return style;
    }
    /**Ϊ��������ղ�ʧ�ܵ���Ϸ**/
    public void setThunderOfxy(int thunderOfxy[]){
        this.thunderOfxy=thunderOfxy;
    }
    public int [] getThunderOfxy(){
       return thunderOfxy;
    }
    public void setTishixinxi(int x){
         show_tishi_num.setText("��ʾ:"+x);
    }
    /**���췽��**/
    public ThunderWindow(String title,String username,int dengji,int style){
        this.username=username;
        this.style=style;
        this.dengji=dengji;
        if (dengji>=1&&dengji<=4){
          this.size=SetFrameSize.sumOfThunder[dengji-1];
          this.x=SetFrameSize.sumOfButton[dengji-1][0];
          this.y=SetFrameSize.sumOfButton[dengji-1][1];
          this.width=SetFrameSize.sizeOfFrame[dengji-1][0];
          this.height=SetFrameSize.sizeOfFrame[dengji-1][1];
           
        }  else{
          this.size=SetFrameSize.sumOfThunder[0];
          this.x=SetFrameSize.sumOfButton[0][0];
          this.y=SetFrameSize.sumOfButton[0][1];
          this.width=SetFrameSize.sizeOfFrame[0][0];
          this.height=SetFrameSize.sizeOfFrame[0][1];
        }
        if (size<20) tishisum=1;
        else if (size<50) tishisum=2;
        else tishisum=3;
        tt=new TimeThread(size*10);
        thread=new Thread(tt);
        progressBar=new JProgressBar();
        progressBar.setStringPainted(true);
        setTitle(title);
       /**���ò˵�**/
        mb=new JMenuBar();
        jm1=new JMenu("��Ϸ");
        jm2=new JMenu("����");
        xinyouxi=new JMenuItem("����Ϸ");
        xuanxiang=new JMenuItem("ѡ��");
        waiguan=new JMenuItem("���");
        tongji=new JMenuItem("ͳ����Ϣ");
        tuichu=new JMenuItem("�˳�");
        guanyu=new JMenuItem("����ɨ��");
        youxitishi=new JMenuItem("�й���ʾ");
        jm1.add(xinyouxi);
        jm1.addSeparator();
        jm1.add(xuanxiang);
        jm1.add(tongji);
        jm1.add(waiguan);
        jm1.addSeparator();
        jm1.add(tuichu);
        jm2.add(guanyu);
        jm2.add(youxitishi);
        mb.add(jm1);
        mb.add(jm2);
        this.setJMenuBar(mb);
      /** ���ô��ڵĲ��� **/
      Container con=getContentPane();
      con.setLayout(new FlowLayout());
       panel=new JPanel();
      panel.setLayout(new GridLayout(x,y));
       thunder=new ThunderButton[x][y];
       /** ��ʼ����ť **/
       for(int i=0;i<x;i++)
           for(int j=0;j<y;j++){
               thunder[i][j]=new ThunderButton(i,j,this);
               panel.add(thunder[i][j]);
            }
       ThunderButton.num=0;
       ThunderButton.tishinum=0;
       show_time=new JLabel("ʱ�䣺");
       show_thunder_num=new JLabel("���ҵ�"+find_num+"����"+size+"��");
       start=new JButton("��ʼ");
       end=new JButton("����");
       show_tishi_num=new JLabel("��ʾ:"+tishisum);
       JPanel temp=new JPanel();
       temp.setLayout(new GridLayout(1,3));
       temp.add(show_tishi_num);
       temp.add(start);
       temp.add(end);
       con.add(show_time);
       con.add(progressBar);
       con.add(show_thunder_num);
       con.add(panel);
       con.add(temp);
       start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               startGame(0);
               
            }
       });
       end.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                /*��Ϸ����*/
                gameOver(3);
            }
       });
       /*����ʱ��*/
       timeMonitor=new Timer(size*10,new ActionListener(){
           public void actionPerformed(ActionEvent e){
               int current=tt.getTime();
               progressBar.setValue(current);
               find_num=ThunderButton.num;
               String text="���ҵ�"+find_num+"����"+size+"��";
               show_thunder_num.setText(text);
               
               if (current==tt.getTarget()){
                   timeMonitor.stop();
                   /*��Ϸ����*/
                  gameOver(1);
               }
           }
        });
       this.setSize(width,height);//���Ǵ��ڵĸ߿��
       this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*������ϴ��ڴ�С���ɵ��� */
       this.setResizable(false);
       /** ����˵��¼� **/
       xinyouxi.addActionListener(this);
       xuanxiang.addActionListener(this);
       waiguan.addActionListener(this);
       tuichu.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            System.exit(0);
          }
       });
       tongji.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
                 new TongJiFrame(getUsername());
          }
       });
       guanyu.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
               new GuanYuFrame();
          }
       });
       youxitishi.addActionListener(this);
    } 
 
   public void actionPerformed(ActionEvent e){
       if (e.getSource()==xuanxiang){
                 new XuanXiangFrame(this,dengji);
        }
       if (e.getSource()==xinyouxi){
            if (!start.isEnabled()){
                  new NewGameFrame(this);
            }
       }  
       if (e.getSource()==youxitishi){
            new HelpFrame();
       } 
       if (e.getSource()==waiguan){
              new StyleFrame(this);
        }
     }
    
    public void startGame(int flag){
                gameInit(flag);
                progressBar.setMaximum(size*10);
                progressBar.setMinimum(0);
                timeMonitor.start();
                thread.start();
                start.setEnabled(false);
    }
    private int[] randomNumber(){
      /** �������size����ͬ��0-x*y֮����� **/
        int a[]=new int[size];
        int sum=0;
        Random ran=new Random();
        while(sum<size){
           int r=ran.nextInt(this.x*this.y);
           boolean flag=true;
           for(int i=0;i<sum;i++)
             if (a[i]==r){
                  flag=false;
                  break;
             }
          if (flag) a[sum++]=r;
        }
        setThunderOfxy(a);
        return a;
    }
    public void gameInit(int flag){
        /** ��ʼ����Ϸ����Ҫ��������� **/
        int a[];
        if (flag==0)
           a=randomNumber(); 
        else a=getThunderOfxy(); 
        for(int i=0;i<a.length;i++){
              int k=a[i]/y;
              int l=a[i]%y;
              thunder[k][l].setRealStatus(-1); 
        }
       /** �������������װ�ť��Χ������  **/
       for(int i=0;i<thunder.length;i++){
            for(int j=0;j<thunder[i].length;j++){
                  if (!thunder[i][j].isThunder()){
                       int sum=0;
                       ThunderLocation tl=new ThunderLocation(i,j);
                       for(int k=0;k<8;k++){
                           ThunderLocation tmp=tl.extend(k,x,y);
                           if (tmp!=null){
                               if (thunder[tmp.getX()][tmp.getY()].isThunder()) sum++;
                           }
                       }
                       thunder[i][j].setRealStatus(sum);
                  }
            }
       }
       for(int i=0;i<thunder.length;i++){
         for(int j=0;j<thunder[i].length;j++){
             thunder[i][j].begin();
         }
       }
    }
    public ThunderButton getThunder(int k,int l){
            return thunder[k][l];
    }
    /** �����ǲ��Դ��� **/
    public static void main(String ar[]){
       // new ThunderWindow("ɨ����Ϸ");
    }
    /**��Ϸ����**/
    public void gameOver(int status){
        /**status��ʾ��Ϸ�����Ķ��ֿ���**/
       LogDao logDao=new LogDao();
       if (status==4){
           int time=tt.getTime();  
           thread.stop();
           timeMonitor.stop();
           Log log=new Log();
           log.setScore(time);
           log.setName(username);
           log.setLeiXing(dengji);
           log.setDate(new Date(System.currentTimeMillis()));
           log.setTime(new Time(System.currentTimeMillis()));
           logDao.saveLog(log);
           gameOver4=new  GameOverDialog(this,"��Ϸ�ɹ�",time); 
           gameOver4.show();
           
       }
      if (status==1){
           thread.stop();
           timeMonitor.stop();
           Log log=new Log();
           log.setScore(-1);
           log.setName(username);
           log.setLeiXing(dengji);
           log.setDate(new Date(System.currentTimeMillis()));
           log.setTime(new Time(System.currentTimeMillis()));
           logDao.saveLog(log);
           gameOver1=new GameOverDialog(this,"��Ϸʧ��",username+"��ʱ�䵽�ˣ������ˣ��´����ˣ�");
           gameOver1.show();
       }
      if (status==2){
         thread.stop();
         timeMonitor.stop();
         Log log=new Log();
           log.setScore(-1);
           log.setName(username);
           log.setLeiXing(dengji);
           log.setDate(new Date(System.currentTimeMillis()));
           log.setTime(new Time(System.currentTimeMillis()));
           logDao.saveLog(log);
         gameOver2=new GameOverDialog(this,"��Ϸʧ��",username+",��ȵ����ˣ����ˣ��´����ˣ�");
         gameOver2.show();
      }
      if (status==3){
         thread.stop();
           timeMonitor.stop();
         Log log=new Log();
           log.setScore(-1);
           log.setName(username);
           log.setLeiXing(dengji);
           log.setDate(new Date(System.currentTimeMillis()));
           log.setTime(new Time(System.currentTimeMillis()));
           logDao.saveLog(log);
         gameOver3=new GameOverDialog(this);
         gameOver3.show();
      }
    } 
}