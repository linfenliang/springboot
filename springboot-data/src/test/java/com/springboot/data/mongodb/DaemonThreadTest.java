/*
 * 版权信息：北京宇卫科技有限公司</br>
 * Copyright ©2016-2017. All rights reserved. 京ICP备120422号
 */
package com.springboot.data.mongodb;

/**
 *
 * @Author linfenliang
 * @Version 1.0
 * @Date 2017年7月21日
 */
public class DaemonThreadTest {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new MyThread();
		t.setDaemon(true);
		t.start();
		Thread.sleep(5*1100);
		
	}
	
	
	

}
class MyThread extends Thread{
	@Override
	public void run() {
		while(true){
			
		}
	}
}