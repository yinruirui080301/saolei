/**��ע���û�����Ϣ��User���Ӧ����**/
public class User{
     private String name;
     private String password;
     public User(String name,String password){
       this.name=name;
       this.password=password;
     }
    //setter and getter methods
     public User(){ }
     public void setName(String name){
       this.name=name;
     }
     public void setPassword(String password){
        this.password=password;
     }
     public String getName(){
          return name;
     }
     public String getPassword(){
        return password;
     }
}