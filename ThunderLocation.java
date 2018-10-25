public class ThunderLocation{
      private int x,y;
      private int dir[][]={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
      public int getX(){return x;}
      public int getY(){return y;}
      public ThunderLocation(int x,int y){
            this.x=x;this.y=y;
      }
      public ThunderLocation extend(int i,int sizex,int sizey){
           if (x+dir[i][0]>=0&&x+dir[i][0]<sizex&&y+dir[i][1]>=0&&y+dir[i][1]<sizey){
              return new ThunderLocation(x+dir[i][0],y+dir[i][1]);
           }
           return null;
      }
}