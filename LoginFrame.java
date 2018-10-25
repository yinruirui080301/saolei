import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Event;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
public class LoginFrame extends JFrame{
    private JButton login;
    private JButton regin;
    private JTextField name;
    private JPasswordField password;
    private JLabel tishi;
    public LoginFrame(){
        super("��¼/ע�ᴰ��");
        //setIconImage(new ImageIcon("TargetMine.png"));
        /** ��ʼ����� **/
        login=new JButton("��¼");
        regin=new JButton("ע��");
        JLabel l1=new JLabel("�û���");
        JLabel l2=new JLabel("��    ��");
        name=new JTextField(10);
        password=new JPasswordField(10);
        tishi=new JLabel("��ûע�ᣬ����ע��");
        tishi.setForeground(Color.red);
        /**��������봰����**/
        Container con=this.getContentPane();
        con.setLayout(new FlowLayout());
        con.add(l1);
        con.add(name);
        con.add(l2);
        con.add(password);
        con.add(login);
        con.add(regin);
        con.add(tishi);
       /** �¼����� **/
       regin.addActionListener(new MyActionListener());
       login.addActionListener(new MyActionListener());
       /**���ô��� **/
        this.setSize(200,170);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
             if (e.getSource()==login){
                String n=name.getText();
                String p=password.getText();
                UserDao ud=new UserDao();
                if ("".equals(n)||"".equals(p)){
                   if ("".equals(n)&&!"".equals(p))
                       tishi.setText("�û�������Ϊ��");
                   else if (!"".equals(n)&&"".equals(p))
                        tishi.setText("���벻��Ϊ��");
                   else  tishi.setText("�û������붼����Ϊ��");
                }else{
                   int x=ud.find(n,p);
                   if (x==1){
                     new ThunderWindow("ɨ����Ϸ",n,1,1);
                     setVisible(false);  
                   }else if (x==2){
                     //name.setText("");
                     password.setText("");
                     tishi.setText("�������    ");
                   }else if (x==3){
                     name.setText("");
                     password.setText("");
                     tishi.setText("�û���û��ע��");
                   }
               }
            }
             if (e.getSource()==regin){
                String n=name.getText();
                String p=password.getText();
                if ("".equals(n)||"".equals(p)){
                   if ("".equals(n)&&!"".equals(p))
                       tishi.setText("�û�������Ϊ��");
                   else if (!"".equals(n)&&"".equals(p))
                        tishi.setText("���벻��Ϊ��");
                   else  tishi.setText("�û������붼����Ϊ��");
                }else{ 
                    User user=new User();
                    user.setName(n);
                    user.setPassword(p);
                    UserDao ud=new UserDao();
                    boolean flag=ud.save(user);
                    if (flag){
                       new ThunderWindow("ɨ����Ϸ",n,1,1);
                       setVisible(false);
                    }else{
                       name.setText("");
                       password.setText("");
                        tishi.setText("�Ѵ���ͬ�����û�");
                    }
               }
            }
        }
    }
   /** **/
   public static void main(String ar[]){
      new LoginFrame();
   }  
}