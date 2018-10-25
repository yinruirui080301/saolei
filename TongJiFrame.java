import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
public class TongJiFrame extends JFrame{
      private JLabel l1,l2;
      private JList list;
      private  JTextArea ta1;
      private JTextArea  ta2;
      private JButton close;
      private JButton  set0;
      private ThunderWindow tw;
      public TongJiFrame(final String name){
         setTitle("��Ϣͳ��");
         l1=new JLabel("�����óɼ�:");
         l2=new JLabel("���ٰ�(ǰ5��):");
         l1.setForeground(Color.blue);
         l2.setForeground(Color.blue);
         close=new JButton("�ر�");
         set0=new JButton("����");
         ta1=new JTextArea(10,10);
         ta2=new JTextArea(10,10);
         ta1.setEditable(false);
         ta1.setBackground(new Color(238,238,238));
         ta1.setForeground(Color.red);
          ta2.setEditable(false);
         ta2.setBackground(new Color(238,238,238));
         ta2.setForeground(Color.red);
         String [] jibie={"����","�м�","�߼�"};
         list=new JList(jibie);
         Container con=getContentPane();
         con.setLayout(null);
         list.setBounds(20,50,50,100);
         l1.setBounds(90,20,100,30);
         ta1.setBounds(90,50,200,100);
         l2.setBounds(310,20,100,30);
         ta2.setBounds(310,50,200,100);
         close.setBounds(180,170,80,30);
         set0.setBounds(280,170,80,30);
         con.add(list);
         con.add(l1);
         con.add(l2);
         con.add(ta1);
         con.add(ta2);
         con.add(close);
         con.add(set0);
         setSize(530,240);
         setVisible(true);
         setResizable(false); 
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         close.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 setVisible(false);
             }
         });
         set0.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                  int x=JOptionPane.showConfirmDialog(null,"���뽫���е�ͳ����Ϣ����Ϊ����?","����",JOptionPane.YES_NO_OPTION);
                  if (x==0){
                       LogDao logDao=new LogDao();
                       boolean flag=logDao.set0();
                       if (!flag)  
                            JOptionPane.showMessageDialog(null,"����ʧ�ܣ�������");
                  }
             }
         });
         list.addListSelectionListener(new ListSelectionListener(){
             public void valueChanged(ListSelectionEvent e){
                 Object obj=list.getSelectedValue();
                 LogDao logDao=new LogDao();
                 List<Log> list=new ArrayList<Log>();
                 if ("����".equals(obj)){
                     ta1.setText("");
                     ta2.setText("");
                     list=logDao.findFiveGood(name,1);
                     for(int i=0;i<list.size();i++){
                        int x=list.get(i).getScore();
                        Date d=list.get(i).getDate();
                        Time t=list.get(i).getTime();
                        ta1.append("��ʱ:"+x+" ʱ��:"+d+" "+t+"\n");
                     }
                    list=logDao.findFiveGood(1);
                    for(int i=0;i<list.size();i++){
                        int x=list.get(i).getScore();
                        String n=list.get(i).getName();
                        System.out.println(n);
                        ta2.append("��ʱ:"+x+" ���:"+n+"\n");
                     }
                 }
                 if ("�м�".equals(obj)){
                     ta1.setText("");
                     ta2.setText("");
                     list=logDao.findFiveGood(name,2);
                     for(int i=0;i<list.size();i++){
                        int x=list.get(i).getScore();
                        Date d=list.get(i).getDate();
                        Time t=list.get(i).getTime();
                        ta1.append("��ʱ:"+x+" ʱ��:"+d+" "+t+"\n");
                     }
                    list=logDao.findFiveGood(2);
                    for(int i=0;i<list.size();i++){
                        int x=list.get(i).getScore();
                        String n=list.get(i).getName();
                        ta2.append("��ʱ:"+x+" ���:"+n+"\n");
                     }
                 }
                 if ("�߼�".equals(obj)){
                   ta1.setText("");
                     ta2.setText("");
                   list=logDao.findFiveGood(name,3);
                     for(int i=0;i<list.size();i++){
                        int x=list.get(i).getScore();
                        Date d=list.get(i).getDate();
                        Time t=list.get(i).getTime();
                        ta1.append("��ʱ:"+x+" ʱ��:"+d+" "+t+"\n");
                     }
                    list=logDao.findFiveGood(3);
                    for(int i=0;i<list.size();i++){
                        int x=list.get(i).getScore();
                        String n=list.get(i).getName();
                        ta2.append("��ʱ:"+x+" ���:"+n+"\n");
                     }
                 }
             }
         });
      }
      public static void main(String ar[]){
        
      }
}