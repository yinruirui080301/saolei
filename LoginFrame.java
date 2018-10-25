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
        super("登录/注册窗口");
        //setIconImage(new ImageIcon("TargetMine.png"));
        /** 初始化组件 **/
        login=new JButton("登录");
        regin=new JButton("注册");
        JLabel l1=new JLabel("用户名");
        JLabel l2=new JLabel("密    码");
        name=new JTextField(10);
        password=new JPasswordField(10);
        tishi=new JLabel("若没注册，请先注册");
        tishi.setForeground(Color.red);
        /**将组件加入窗口中**/
        Container con=this.getContentPane();
        con.setLayout(new FlowLayout());
        con.add(l1);
        con.add(name);
        con.add(l2);
        con.add(password);
        con.add(login);
        con.add(regin);
        con.add(tishi);
       /** 事件处理 **/
       regin.addActionListener(new MyActionListener());
       login.addActionListener(new MyActionListener());
       /**设置窗口 **/
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
                       tishi.setText("用户名不能为空");
                   else if (!"".equals(n)&&"".equals(p))
                        tishi.setText("密码不能为空");
                   else  tishi.setText("用户名密码都不能为空");
                }else{
                   int x=ud.find(n,p);
                   if (x==1){
                     new ThunderWindow("扫雷游戏",n,1,1);
                     setVisible(false);  
                   }else if (x==2){
                     //name.setText("");
                     password.setText("");
                     tishi.setText("密码错误    ");
                   }else if (x==3){
                     name.setText("");
                     password.setText("");
                     tishi.setText("用户还没有注册");
                   }
               }
            }
             if (e.getSource()==regin){
                String n=name.getText();
                String p=password.getText();
                if ("".equals(n)||"".equals(p)){
                   if ("".equals(n)&&!"".equals(p))
                       tishi.setText("用户名不能为空");
                   else if (!"".equals(n)&&"".equals(p))
                        tishi.setText("密码不能为空");
                   else  tishi.setText("用户名密码都不能为空");
                }else{ 
                    User user=new User();
                    user.setName(n);
                    user.setPassword(p);
                    UserDao ud=new UserDao();
                    boolean flag=ud.save(user);
                    if (flag){
                       new ThunderWindow("扫雷游戏",n,1,1);
                       setVisible(false);
                    }else{
                       name.setText("");
                       password.setText("");
                        tishi.setText("已存在同名的用户");
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