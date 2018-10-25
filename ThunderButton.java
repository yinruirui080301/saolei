/**
  ��ThunderButton��ʾ��Ϸ�еİ�ť����Ҫ������굥��������ң�
  �������ʱ��Ҫ����ť�����ס��հ׻������֣����������ͬ
**/
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
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener; 
import javax.swing.ImageIcon;
public class ThunderButton extends JLabel{
     private final int x,y;
     public static int num=0;
     public static int tishinum=0;
     private final ThunderWindow thunderWindow;
     private int playStatus;/*��ʾ��ʱ��״̬ -1(�㿪�ˣ������ٵ��ˣ�  
      0(һ��״̬ ��  1���к��죩  2�����ʺţ�*/
     private int realStatus;/*��ʾʵ�ʵ�״̬ 0����Χһ���׶�û�� ��
              1 2 3 4 5 6 7 8 -1(���ף� */

    
     public static final ImageIcon NullImage=new ImageIcon("wu.png"); 
     public static final ImageIcon Number_1=new ImageIcon("1.png");
     public static final ImageIcon Number_2=new ImageIcon("2.png");
     public static final ImageIcon Number_3=new ImageIcon("3.png");
     public static final ImageIcon Number_4=new ImageIcon("4.png");
     public static final ImageIcon Number_5=new ImageIcon("5.png");
     public static final ImageIcon Number_6=new ImageIcon("6.png");
     public static final ImageIcon Number_7=new ImageIcon("7.png");
     public static final ImageIcon Number_8=new ImageIcon("8.png");
     public  ImageIcon FlagImage=new ImageIcon("image/ActionBFlag.png");
     public  ImageIcon UnsureImage=new ImageIcon("image/ActionBUnsure.png");
     public  ImageIcon ThunderImage=new ImageIcon("image/Mine.png");
     public  ImageIcon ThunderTiShiImage=new ImageIcon("image/ResultFlag.png");
     public  ImageIcon MainImage=new ImageIcon("image/ActionBlue.png");

     public void setStyle(int style){
        switch(style){
            default:
            case 1:  /**����ť�ͻ���**/
               FlagImage=new ImageIcon("image/ActionBFlag.png");
               UnsureImage=new ImageIcon("image/ActionBUnsure.png");
               ThunderImage=new ImageIcon("image/Mine.png");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag.png");
               MainImage=new ImageIcon("image/ActionBlue.png");
               break;
            case 2: /**�̰�ť�ͻ���**/
               FlagImage=new ImageIcon("image/ActionGFlag.png");
               UnsureImage=new ImageIcon("image/ActionGUnsure.png");
               ThunderImage=new ImageIcon("image/Mine.png");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag.png");
               MainImage=new ImageIcon("image/ActionGreen.png");
               break;
            case 3: /**�ư�ť�ͻ���**/
                FlagImage=new ImageIcon("image/ActionYFlag.png");
               UnsureImage=new ImageIcon("image/ActionYUnsure.png");
               ThunderImage=new ImageIcon("image/Mine.png");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag.png");
               MainImage=new ImageIcon("image/ActionYellow.png");
               break; 
            case 4: /**����ť��Ц��**/
               FlagImage=new ImageIcon("image/ActionGFlag.png");
               UnsureImage=new ImageIcon("image/ActionGUnsure.png");
               ThunderImage=new ImageIcon("image/Mine1.gif");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag1.gif");
               MainImage=new ImageIcon("image/ActionBlue.png");
               break;
            case 5: /**�̰�ť��Ц��**/
               FlagImage=new ImageIcon("image/ActionGFlag.png");
               UnsureImage=new ImageIcon("image/ActionGUnsure.png");
               ThunderImage=new ImageIcon("image/Mine1.gif");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag1.gif");
               MainImage=new ImageIcon("image/ActionGreen.png");
               break;
            case 6: /**�ư�ť��Ц��**/
               FlagImage=new ImageIcon("image/ActionYFlag.png");
               UnsureImage=new ImageIcon("image/ActionYUnsure.png");
               ThunderImage=new ImageIcon("image/Mine1.gif");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag1.gif");
               MainImage=new ImageIcon("image/ActionYellow.png");
        }
        if (playStatus==0)
             setIcon(MainImage);
        else if (playStatus==1)
             setIcon(FlagImage);
        else if (playStatus==2)
          setIcon(UnsureImage);
        else if (playStatus==3)
           setIcon(ThunderTiShiImage);
     }
     public int getRealStatus(){return realStatus;}
     public int getPlayStatus(){return playStatus;}
     public void setRealStatus(int realStatus){ this.realStatus=realStatus;}
     public void setPlayStatus(int playStatus){this.playStatus=playStatus;}
     /** �ж����׷��һЩ���� **/
     public boolean isThunder(){
          return  realStatus==-1;
      }
     public boolean isNumber(){
           if (realStatus>=1&&realStatus<=8)
              return true;
           return false;
     }
     public boolean isEmpty(){
         return realStatus==0;
     }
     public boolean isRedFlag(){
          return playStatus==1;
     }
     public boolean isUnsure(){
           return playStatus==2;
     }
     public boolean isNoAction(){
         return playStatus==0;
     }
     public void setPlayEmpty(){
           playStatus=-1;
     }
     public ThunderButton(int _x,int _y,ThunderWindow _thunderWindow){
       this.x=_x;this.y=_y;
       this.thunderWindow=_thunderWindow;
        realStatus=0;
        playStatus=0;
       this.setIcon(MainImage);
 
       /* �������һЩ���룬������  */
      
      }
      public int begin(){
        /*���嵥������¼� */
       this.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
              /**ʵ����ʾ����**/
               if (e.getClickCount()==2){
                  if (playStatus==-1&&realStatus>=1&&realStatus<=8){
                    if (tishinum<thunderWindow.getTishisum()){
                        tishinum++;
                        ThunderLocation tl=new ThunderLocation(x,y);
                        for(int i=0;i<8;i++){
                           ThunderLocation tll=tl.extend(i,thunderWindow.getX(),thunderWindow.getY());
                           if (tll!=null){
                               if (thunderWindow.getThunder(tll.getX(),tll.getY()).isThunder()){
                                  if (thunderWindow.getThunder(tll.getX(),tll.getY()).getIcon()!=ThunderTiShiImage){
                                      thunderWindow.getThunder(tll.getX(),tll.getY()).setIcon(ThunderTiShiImage);
                                       
                                      if (thunderWindow.getThunder(tll.getX(),tll.getY()).getPlayStatus()!=1)
                                           num++;
                                      thunderWindow.getThunder(tll.getX(),tll.getY()).setPlayStatus(3); 
                                  }
                                }
                            }
                        }
                        thunderWindow.setTishixinxi(thunderWindow.getTishisum()-tishinum);
                      }
                  }
               }
                 /* �����������������  */
               if (e.getButton()==1){
                  
                    if (playStatus!=-1&&playStatus!=1){
                        //˵����ť��ʱ���Ա�����(��û���㿪Ҳû��ʾ���죩
                       
                        if (realStatus==-1){
                          /**��ʾ�����е��� **/
                          for(int i=0;i<thunderWindow.getX();i++){
                             for(int j=0;j<thunderWindow.getY();j++){
                               ThunderButton tb=thunderWindow.getThunder(i,j);
                                if (tb.getRealStatus()==-1) {
                                    tb.setIcon(ThunderImage);
                                }
                             }
                           }
                          thunderWindow.gameOver(2); /**�㵽���ˣ� ��Ϸ����**/
                        }
                        if (realStatus>=1&&realStatus<=8){
                           setIcon(getNumberImageIcon(realStatus));
                           playStatus=-1;
                        }
                        if (realStatus==0){/** ����Χһ���׶�û�У�����ܸ���**/
                            ArrayList<ThunderLocation>  list=search(x,y,thunderWindow.getX(),thunderWindow.getY());
                            for(ThunderLocation th:list){
                                 if (thunderWindow.getThunder(th.getX(),th.getY()).isNumber()){
                                           int number=thunderWindow.getThunder(th.getX(),th.getY()).getRealStatus();
                                           thunderWindow.getThunder(th.getX(),th.getY()).setIcon(getNumberImageIcon(number));
                                           thunderWindow.getThunder(th.getX(),th.getY()).setPlayEmpty();
                                 }
                                 if (thunderWindow.getThunder(th.getX(),th.getY()).isEmpty()){
                                  thunderWindow.getThunder(th.getX(),th.getY()).setIcon(NullImage);
                                  thunderWindow.getThunder(th.getX(),th.getY()).setPlayEmpty();
                                }
                             }
                        }
                         /**���װ�ť���㿪�ˣ���Ϸ�ɹ�**/
                       int s=0;
                       for(int i=0;i<thunderWindow.getX();i++){
                          for(int j=0;j<thunderWindow.getY();j++){
                              ThunderButton tb=thunderWindow.getThunder(i,j);
                              if (tb.getPlayStatus()==-1) s++;
                          }
                       }
                       if (s>=thunderWindow.getX()*thunderWindow.getY()-thunderWindow.getSizenew()){
                           thunderWindow.gameOver(4);
                       }
                    }
               }
               /*  ����������������Ҽ�  */
               if (e.getButton()==3){
                  
                   if (playStatus!=-1){
                       if (playStatus==0){
                             playStatus=1;
                             setIcon(FlagImage);
                             /*����ζ���ҵ���һ����*/
                             num++;
                             
                        }else if (playStatus==1){
                             playStatus=2;
                             setIcon(UnsureImage);
                             num--;
                        }else if (playStatus==2){
                              playStatus=0;
                              setIcon(MainImage);
                        }
                   }
               }
           }
        }); 
        return num;
     }
    /** ��λ�ã�x,y)��ʼչ�����װ�ť size��ʾ��ť�Ķ��� **/
     private ArrayList<ThunderLocation> search(int x,int y,int sizex,int sizey){
            /**ʹ�ö��д����Ҫ�������ܱ߰�ť�İ�ť **/
            Queue<ThunderLocation> queue=new LinkedList<ThunderLocation>();
            queue.add(new ThunderLocation(x,y));
            /** ʹ����������Ҫ��չ���İ�ť **/
            ArrayList<ThunderLocation> list=new ArrayList<ThunderLocation>();
            /**ʹ������������ʾ��ť���������û **/
            boolean is_in_queue[][]=new boolean[sizex][sizey];
            for(int i=0;i<sizex;i++) 
               for(int j=0;j<sizey;j++)
                     is_in_queue[i][j]=false;
            is_in_queue[x][y]=true;/**ֻ�е�ǰ��ť���������  **/
            while(queue.size()>0){
                 ThunderLocation head=queue.poll();
                 /**����˰�ť����  **/
                 if (thunderWindow.getThunder(head.getX(),head.getY()).isThunder()){
                    continue;
                 }
                list.add(head);
                if (thunderWindow.getThunder(head.getX(),head.getY()).isNumber()){
                   continue;
                }
                for(int i=0;i<8;i++){
                    ThunderLocation tmp=head.extend(i,sizex,sizey);
                    if (tmp==null){
                        continue;
                    }
                    if (is_in_queue[tmp.getX()][tmp.getY()]==false && !thunderWindow.getThunder(tmp.getX(),tmp.getY()).isThunder()){
                         is_in_queue[tmp.getX()][tmp.getY()]=true;
                         queue.add(tmp);
                    }
                }
            }
            return list;
     }
     private ImageIcon getNumberImageIcon(int number){
        switch(number){
           default:
           case 1:return Number_1;
           case 2:return Number_2;
           case 3:return Number_3;
           case 4:return Number_4;
           case 5:return Number_5;
           case 6:return Number_6;
           case 7:return Number_7;
           case 8:return Number_8;
        }
     }
}