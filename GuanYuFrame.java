import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GuanYuFrame extends JFrame {
    private JButton close;
    public GuanYuFrame(){
        setTitle("����ɨ��");
        JLabel l1=new JLabel();
        JLabel l2=new JLabel();
        JLabel l3=new JLabel();
        JLabel l4=new JLabel();
        JLabel l5=new JLabel();
        close=new JButton("�ر�");
        l1.setForeground(Color.green);
        l2.setForeground(Color.blue);
        l3.setForeground(Color.blue);
        l4.setForeground(Color.blue);
        l5.setForeground(Color.red);
        Font font=new Font("������κ",Font.BOLD,18);
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l1.setText("      ��ɨ����Ϸ��6����ۣ�4���ȼ���\n");
        l2.setText("���ע��󷽿��档����ͳ��ÿ�����\n");
        l3.setText("�ĳɹ��ʣ���������ʾ��ÿ���ȼ���ǰ\n");
        l4.setText("5������ҡ���Ϸ������ʾ���ܡ�\n");
        l5.setText("     ϣ�������ÿ��ģ�");
        Container con=this.getContentPane();
        con.setLayout(null);
        l1.setBounds(20,20,330,30);
        l2.setBounds(20,70,330,30);
        l3.setBounds(20,120,330,30);
        l4.setBounds(20,170,330,30);
        l5.setBounds(20,220,330,30);
        close.setBounds(120,270,80,30);
        con.add(l1);
        con.add(l2);
        con.add(l3);
        con.add(l4);
        con.add(l5);
        con.add(close);
        setSize(380,360);
        setVisible(true);
        setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               setVisible(false);
            }
        });
    }
    public static void main(String ar[]){
       new GuanYuFrame();
    }
}