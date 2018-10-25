/**��ע���û�����Ϣ���浽�û���Ϣ�ļ���user.txt����**/
import java.sql.*;
public class UserDao{
    /**��������**/
    public static Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/saolei";
        String name="root";
        String password="1234";
        Connection con=null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection(url,name,password);
         }catch(Exception e){
            System.out.println("���ݿ������쳣"+e);
         }
        return con;
    }
    /**������ͬ�����û�**/
    public boolean save(User user){
       String name=user.getName();
       String password=user.getPassword();
       if (find(name)!=null) return false;
       String sql="insert into user(name,password) values(?,?)";
       try{
           Connection con=getConnection();
           PreparedStatement st=con.prepareStatement(sql);
           st.setString(1,name);
           st.setString(2,password);
           st.executeUpdate();
           st.close();
           con.close();
       }catch(Exception e){
           System.out.println(e);
       }
       return true;
    }
    private User find(String name){
         User user=null;
         String sql="select * from user where name=? ";
         try{
            Connection con=getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,name); 
            ResultSet rs=st.executeQuery();
            while(rs.next()){
             user=new User();
             user.setName(rs.getString("name"));
             user.setPassword(rs.getString("password"));
            }
            st.close();
            con.close();
         }catch(Exception e){
            System.out.println(e);
         }
         return user;
    }
    /** ����1��ʾ�ҵ���ָ�����û�������2��ʾ������󣬷���3��ʾû�ҵ��û�**/
    public int find(String name,String password){
        User user=find(name);
        if (user==null){
            return 3;
        }else{
            String p=user.getPassword();
            if (password.equals(p)) return 1;else return 2;
        }
   }
}