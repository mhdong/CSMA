public class Bus {
	static int busIFS=10;       //信道帧间间隔 interframe space（竞争者等待时间=信道帧间间隔+回退时间），单位为ms

	static int busState=0;       //信道状态：0为信道空闲，1为信道忙
	static double utilRate;      //信道利用率
	static double totalTime=0;   //总时间，单位为s.  totalTime=busNowTime-busStartTime
	static double usedTime=0;    //信道处于繁忙（被占用的时间）,单位为s
  	static double busStartTime=0.0;  //单位为s
    static double busNowTime;    //单位为s

	
    public static double getRate()  //获得信道利用率
    {
		getTotalTime();
		utilRate = usedTime/totalTime;
    	return utilRate;
    }
    
    public static void getTotalTime()
	 {   
	      Bus.busNowTime=new Double((System.nanoTime())/Math.pow(10, 9)).doubleValue();
	    
	      Bus.totalTime=Bus.busNowTime-Bus.busStartTime;
	      System.out.println("Total time:"+Bus.totalTime);
	      System.out.println("Used time:"+Bus.usedTime);
	 }
}
