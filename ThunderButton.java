/**
  类ThunderButton表示游戏中的按钮，需要处理鼠标单击（左或右）
  当击左键时，要看按钮上是雷、空白还是数字，处理情况不同
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
     private int playStatus;/*表示玩时的状态 -1(点开了，不能再点了）  
      0(一般状态 ）  1（有红旗）  2（有问号）*/
     private int realStatus;/*表示实际的状态 0（周围一颗雷都没有 ）
              1 2 3 4 5 6 7 8 -1(有雷） */

    
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
            case 1:  /**兰按钮和灰雷**/
               FlagImage=new ImageIcon("image/ActionBFlag.png");
               UnsureImage=new ImageIcon("image/ActionBUnsure.png");
               ThunderImage=new ImageIcon("image/Mine.png");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag.png");
               MainImage=new ImageIcon("image/ActionBlue.png");
               break;
            case 2: /**绿按钮和灰雷**/
               FlagImage=new ImageIcon("image/ActionGFlag.png");
               UnsureImage=new ImageIcon("image/ActionGUnsure.png");
               ThunderImage=new ImageIcon("image/Mine.png");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag.png");
               MainImage=new ImageIcon("image/ActionGreen.png");
               break;
            case 3: /**黄按钮和灰雷**/
                FlagImage=new ImageIcon("image/ActionYFlag.png");
               UnsureImage=new ImageIcon("image/ActionYUnsure.png");
               ThunderImage=new ImageIcon("image/Mine.png");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag.png");
               MainImage=new ImageIcon("image/ActionYellow.png");
               break; 
            case 4: /**兰按钮和笑脸**/
               FlagImage=new ImageIcon("image/ActionGFlag.png");
               UnsureImage=new ImageIcon("image/ActionGUnsure.png");
               ThunderImage=new ImageIcon("image/Mine1.gif");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag1.gif");
               MainImage=new ImageIcon("image/ActionBlue.png");
               break;
            case 5: /**绿按钮和笑脸**/
               FlagImage=new ImageIcon("image/ActionGFlag.png");
               UnsureImage=new ImageIcon("image/ActionGUnsure.png");
               ThunderImage=new ImageIcon("image/Mine1.gif");
               ThunderTiShiImage=new ImageIcon("image/ResultFlag1.gif");
               MainImage=new ImageIcon("image/ActionGreen.png");
               break;
            case 6: /**黄按钮和笑脸**/
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
     /** 判断有雷否的一些方法 **/
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
 
       /* 这里加入一些代码，修饰雷  */
      
      }
      public int begin(){
        /*定义单击鼠标事件 */
       this.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
              /**实现提示功能**/
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
                 /* 如果单击的是鼠标左键  */
               if (e.getButton()==1){
                  
                    if (playStatus!=-1&&playStatus!=1){
                        //说明按钮此时可以被单击(既没被点开也没标示红旗）
                       
                        if (realStatus==-1){
                          /**显示出所有的雷 **/
                          for(int i=0;i<thunderWindow.getX();i++){
                             for(int j=0;j<thunderWindow.getY();j++){
                               ThunderButton tb=thunderWindow.getThunder(i,j);
                                if (tb.getRealStatus()==-1) {
                                    tb.setIcon(ThunderImage);
                                }
                             }
                           }
                          thunderWindow.gameOver(2); /**点到雷了， 游戏结束**/
                        }
                        if (realStatus>=1&&realStatus<=8){
                           setIcon(getNumberImageIcon(realStatus));
                           playStatus=-1;
                        }
                        if (realStatus==0){/** 若周围一个雷都没有，处理很复杂**/
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
                         /**非雷按钮都点开了，游戏成功**/
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
               /*  如果单击的是鼠标的右键  */
               if (e.getButton()==3){
                  
                   if (playStatus!=-1){
                       if (playStatus==0){
                             playStatus=1;
                             setIcon(FlagImage);
                             /*这意味着找到了一颗雷*/
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
    /** 从位置（x,y)开始展开无雷按钮 size表示按钮的多少 **/
     private ArrayList<ThunderLocation> search(int x,int y,int sizex,int sizey){
            /**使用队列存放需要访问其周边按钮的按钮 **/
            Queue<ThunderLocation> queue=new LinkedList<ThunderLocation>();
            queue.add(new ThunderLocation(x,y));
            /** 使用数组存放需要被展开的按钮 **/
            ArrayList<ThunderLocation> list=new ArrayList<ThunderLocation>();
            /**使用下面的数组表示按钮被处理过了没 **/
            boolean is_in_queue[][]=new boolean[sizex][sizey];
            for(int i=0;i<sizex;i++) 
               for(int j=0;j<sizey;j++)
                     is_in_queue[i][j]=false;
            is_in_queue[x][y]=true;/**只有当前按钮被处理过了  **/
            while(queue.size()>0){
                 ThunderLocation head=queue.poll();
                 /**如果此按钮有雷  **/
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