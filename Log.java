import java.sql.*;
public class Log{
   private String name;
   private Date date;
   private Time time;
   private int score;
   /**leixing=1˵���ǳ�����Ϸ��leixing=2˵�����м���Ϸ��leixing=3˵���Ǹ߼���Ϸ**/
   private int leixing;
   public void setLeiXing(int leixing){
       this.leixing=leixing;
   }
   public int getLeiXing(){
      return leixing;
   }
   public void setName(String name){
     this.name=name;
   }
   public void setTime(Time time){
       this.time=time;
   }
   public void setScore(int score){
      this.score=score;
   }
   public void setDate(Date date){
        this.date=date;
   }
   public int getScore(){
     return score;
   }
   public Time getTime(){
     return time;
   }
   public String getName(){
     return name;
   }
   public Date getDate(){
      return date;
   }
   public Log(){ }
   public Log(String name,Date date,Time time,int score,int leixing){
        this.name=name;
        this.time=time;
        this.score=score;
        this.date=date;
        this.leixing=leixing;
   }
}