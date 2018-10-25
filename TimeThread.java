public class TimeThread implements Runnable {
    private int time;
    private int target;
    public TimeThread(int target){
          this.time=0;
          this.target=target;
    }
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
        public void setTarget(int t){
              target=t;
        }
        public int getTarget(){
           return target;
        }
	public void run() {
		
		try{
			while(time<target){
				Thread.sleep(1000);
				time++;
			}
		}catch(InterruptedException e){
			System.out.println("发生线程异常");
		}
	}
}