package com.bid.dataMgr;

public class TimerMgr {
	
	/**
	 * 作用：挂了一个新的定时器
	 */
	public boolean registerDeadline(long itemId, long Time){
		return false;
	}

	/**
	 * 作用：在系统启动时，
	 * 1	将所有的目前活着的货品找出来
	 * 2	为所有的目前活着的货品挂上定时器
	 * 3	（某一个线程等待货品死掉）
	 */
	public void startUp(){
	}

	public void deadlineTrigger() {
	}
}
