import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HelpFrame extends JFrame {
    private JButton close;
    public HelpFrame(){
        setTitle("�й���ʾ");
        JLabel l1=new JLabel();
        JLabel l2=new JLabel();
        JLabel l3=new JLabel();
        close=new JButton("�ر�");
        l1.setForeground(Color.red);
        l2.setForeground(Color.blue);
        l3.setForeground(Color.blue);
        Font font=new Font("������κ",Font.BOLD,18);
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l1.setText("�����ͨ��˫��ĳ����������ð�����\n");
        l2.setText("�����ɵ�1����ʾ���м��ɵ�2����ʾ��\n");
        l3.setText("�߼��ɵ�3�ΰ����� ");
        Container con=this.getContentPane();
        con.setLayout(null);
        l1.setBounds(20,20,330,30);
        l2.setBounds(20,70,330,30);
        l3.setBounds(20,120,330,30);
        close.setBounds(120,170,80,30);
        con.add(l1);
        con.add(l2);
        con.add(l3);
        con.add(close);
        setSize(380,260);
        setVisible(true);
        setResizable(false); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //�����ǹرհ�ť���¼�����
        close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               setVisible(false);
            }
        });
    }
    public static void main(String ar[]){
        new HelpFrame();
    }
}