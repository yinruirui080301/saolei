import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
//插入日志
public class LogDao{
     public void saveLog(Log log){
         String name=log.getName();
         Date date=log.getDate();
         Time time=log.getTime();
         int score=log.getScore();
         int leixing=log.getLeiXing();
         String sql="insert into log(name,youxidate,youxitime,score,leixing) values(?,?,?,?,?)";
         try{
             Connection con=UserDao.getConnection();
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1,name);
             ps.setDate(2,date);
             ps.setTime(3,time);
             ps.setInt(4,score);
             ps.setInt(5,leixing);
             ps.executeUpdate();
             ps.close();
             con.close();
         }catch(Exception e){
            System.out.println(e);
         }
     }
     public List<Log> findByName(String name,int leixing){
         String sql="select * from log where name=? and leixing=?";
         List<Log> list=new ArrayList<Log>();
         try{
             Connection con=UserDao.getConnection();
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1,name);
             ps.setInt(2,leixing);
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                 String n=rs.getString("name");
                 Date d=rs.getDate("youxidate");
                 Time t=rs.getTime("youxitime");
                 int s=rs.getInt("score");
                 int l=rs.getInt("leixing");
                 Log log=new Log();
                 log.setName(n);
                 log.setDate(d);
                 log.setTime(t);
                 log.setScore(s);
                 log.setLeiXing(l);
                 list.add(log);
             }
             ps.close();
             con.close();
         }catch(Exception e){
            System.out.println(e);
            return null;
         }
         return list;
     }
     private List<Log> sort(List<Log> list){
          Log log;
          int k;
          if (list==null) return list;
          for(int i=0;i<list.size()-1;i++){
              log=list.get(i);
              k=i;
              for(int j=i+1;j<list.size();j++){
                  if (list.get(j).getScore()<log.getScore()){
                       k=j;
                       log=list.get(j);
                   }
              }
              log=list.get(i);
              list.set(i,list.get(k));
              list.set(k,log);
          }
          return list;
     }
     public List<Log> findFiveGood(String name,int leixing){
         List<Log> list=findByName(name,leixing);
         list=sort(list);
         List<Log> fiveoflist=new ArrayList<Log>();
         int num=0;
         for(int i=0;i<list.size();i++){
              if (list.get(i).getScore()!=-1&&num<5){
                  fiveoflist.add(list.get(i));
                  num++;
              }
              if (num>=5) break;
         }
         return fiveoflist;
     }
     public Log maxScore(String name,int leixing){
          List<Log> list=findByName(name,leixing);
          list=sort(list);
          Log log=null;
          for(int i=0;i<list.size();i++){
              if (list.get(i).getScore()!=-1){
                 log=list.get(i);
                 break;
              } 
          }
          return log;
     }
     /** 光荣榜（前5名） **/
     private List<Log> findByScore(int leixing){
         String sql="select * from log where leixing=? and score>0";
         List<Log> list=new ArrayList<Log>();
         try{
             Connection con=UserDao.getConnection();
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1,leixing);
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                 String n=rs.getString("name");
                 Date d=rs.getDate("youxidate");
                 Time t=rs.getTime("youxitime");
                 int s=rs.getInt("score");
                 int l=rs.getInt("leixing");
                 Log log=new Log();
                 log.setName(n);
                 log.setDate(d);
                 log.setTime(t);
                 log.setScore(s);
                 log.setLeiXing(l);
                 list.add(log);
             }
             ps.close();
             con.close();
         }catch(Exception e){
            System.out.println(e);
            return null;
         }
         return list;
     }
     public List<Log> findFiveGood(int leixing){
           List<Log> list=findByScore(leixing);
           if (list==null) return null;
           list=sort(list);
           if (list.size()<=5) 
             return list;
           else{
              List<Log> list0_4=new ArrayList<Log>();
              for(int i=0;i<5;i++)
                 list0_4.add(list.get(i));
              return list0_4;
           }
     }
     /**计算获胜率**/
     public double rateOf(String name,int leixing){
          int num[]=numOf(name,leixing);
          double rate=0.0;
          rate=num[0]/(num[0]+num[1]+0.0);
          return rate;
     }
     /** 计算成功和失败的次数 **/
     public int[] numOf(String name,int leixing){
         List<Log> list=findByName(name,leixing);
         int num[]=new int[2];
         for(Log log:list){
             if (log.getScore()!=-1)
                num[0]++;
             else num[1]++;
         }
         return num;
     }
     public boolean set0(){
         String sql="delete from log";
         try{
             Connection con=UserDao.getConnection();
             PreparedStatement ps=con.prepareStatement(sql);
             ps.executeUpdate();
         }catch(Exception e){
              System.out.println(e);
              return false;
         }
         return true;
     }
     /**以下是测试代码 **/
     public static void main(String r[]){     
         LogDao logDao=new LogDao();
       System.out.println(logDao.set0());
         
     }
}