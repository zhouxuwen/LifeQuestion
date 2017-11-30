package P1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import com.sun.glass.ui.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
public class Work {
	
	LinkedList<People> list;
	LinkedList<People> list_Time;
	LinkedList<People> list_OnFloor;
	LinkedList<People> list_NotOnUpOrDownList;
	Life life;
	ListOnFloor [] floor = new ListOnFloor[105];
	LifePane pane;
	LifePaneThread lifePaneThread;
	
	public Work(LifePane pane) {
		list = new LinkedList<>();
		list_Time= new LinkedList<>();
		list_OnFloor = new LinkedList<>();
		list_NotOnUpOrDownList = new LinkedList<>();
		life = new Life(1,true,2,true);
		this.pane = pane;
		setListOnFloor();
	}
	public void setListOnFloor() {
		for(int i =1;i < 105;i++) {
			
			floor[i] = new ListOnFloor();
			
		}
	}
	public void write() throws FileNotFoundException, IOException {
		
		String file = "text.dat";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
		People p1 = new People(21,123,65,2,9);
		People p2 = new People(1,16,45,80,5);
		People p3 = new People(4,382,14,1,99);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(p3);
		oos.flush();	
		oos.close();
				
	}
	public void writeOnText() throws IOException, ClassNotFoundException {
		String file2 = "text.txt";
		FileOutputStream os2 = new FileOutputStream(file2);
		OutputStreamWriter oos2 = new OutputStreamWriter(os2,"GBK");
		String file = "text.dat";
		FileInputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		People p = new People();
		String s;	
		while(is.available() > 0) {
			p =(People)ois.readObject();
			System.out.println(p);
			s = p.toString() + '\n';
			oos2.write(s);
			oos2.flush();
		}
		ois.close();	
		oos2.close();
		
		
	}
	public void read() throws FileNotFoundException, IOException, ClassNotFoundException {
		String file = "text.dat";
		FileInputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		People p = new People();
		while(is.available() > 0) {
			p =(People)ois.readObject();
			list.add(p);
			list_Time.add(p);
			System.out.println(p);
		}
		ois.close();
//		System.out.println(list);
	}
	
	public void sort_ComingTime() {
		
		Collections.sort(list_Time,new Comparator<People>() {

			@Override
			public int compare(People o1, People o2) {
				
				if(o1.ComingTime > o2.ComingTime) {
						return 1;
				}
				else if(o1.ComingTime < o2.ComingTime) {
						return -1;
				}
				
				return 0;
			}});
//		System.out.println(list_Time);
	}
	
	public void start() {
		
		pane.openTheDoor();
		
		
		pane.closeTheDoor();
		
		
		 
		 int nowTime = 0;
		 int MoveTime = 0;
		 while(!list_Time.isEmpty()||!life.List_OnLife.isEmpty()||!list_OnFloor.isEmpty()) {
			 if(!list_Time.isEmpty()) {
				 
			 	if(list_Time.get(0).ComingTime == nowTime) {
			 		list_OnFloor.add(list_Time.get(0));
			 		//setListOnFloor();
			 		list_NotOnUpOrDownList.add(list_Time.get(0));
			 		list_Time.poll();
			 	}
			 }
			 /**
			  * 电梯开始运动
			  */
//			 System.out.println(nowTime);
			 if(!list_OnFloor.isEmpty()||!life.List_OnLife.isEmpty()) {                        
				 if(life.List_OnLife.isEmpty()) {
					 life.UpOrDown = life.floor < list_OnFloor.getFirst().SourceFloor;
					 if(life.floor == list_OnFloor.getFirst().SourceFloor) {
						 life.UpOrDown = list_OnFloor.getFirst().UpOrDown;
					 }
				 }
				 else {
					 life.UpOrDown = life.List_OnLife.getFirst().UpOrDown;
				 }
				 
				 /**
				  * 加入到楼层中的四个队列
				  */
				 if(!list_NotOnUpOrDownList.isEmpty()) {
					 if(list_NotOnUpOrDownList.getFirst().UpOrDown) {
						 if(list_NotOnUpOrDownList.getFirst().isOldman) {
						 floor[list_NotOnUpOrDownList.getFirst().SourceFloor].List_Up_OldMan.add(list_NotOnUpOrDownList.get(0));
						 }
						 else {
						 floor[list_NotOnUpOrDownList.getFirst().SourceFloor].List_Up_Man.add(list_NotOnUpOrDownList.get(0));		 
						 }
					 }
					 else {
						 if(list_NotOnUpOrDownList.getFirst().isOldman) {
							 floor[list_NotOnUpOrDownList.getFirst().SourceFloor].List_Down_OldMan.add(list_NotOnUpOrDownList.get(0));
						 }
						 else {
							 floor[list_NotOnUpOrDownList.getFirst().SourceFloor].List_Down_Man.add(list_NotOnUpOrDownList.get(0));		 
						 }
					 }
					 list_NotOnUpOrDownList.poll();
				 }
				 
				 /**
				  * 是否到达楼层，到达楼层 是否加入电梯或下电梯
				  * 先下后上
				  */
				 if(life.isFloor) {
					 /**
					  * 是否有人下电梯
					  */
					 if(!life.List_OnLife.isEmpty()) {
						 People p = new People();
						 if(life.List_OnLife.getFirst().DestinationFloor == life.floor) {
							 p = life.List_OnLife.poll();
							 life.peopleNum--;
							 nowTime++;
							 p.LeavingTime = nowTime;
							 System.out.println(p);
							 continue;
						 }
					 }
					 /**是否电梯人满
					  * 是否有人加入电梯 
					  * UP 上升状态
					  * Down 下降状态
					  */
					 if(life.peopleNum < life.peopleMAX) {
						 if(life.UpOrDown) {
							 if(!floor[life.getFloor()].List_Up_OldMan.isEmpty()) {
								 life.List_OnLife.add(floor[life.getFloor()].List_Up_OldMan.getFirst());
								 list_OnFloor.remove(floor[life.getFloor()].List_Up_OldMan.getFirst());
								 floor[life.getFloor()].List_Up_OldMan.poll();
								 life.sort();
								 nowTime++;
								 continue;
							 }
							 else if(!floor[life.getFloor()].List_Up_Man.isEmpty()) {
								 life.List_OnLife.add(floor[life.getFloor()].List_Up_Man.getFirst());
								 list_OnFloor.remove(floor[life.getFloor()].List_Up_Man.getFirst());
								 floor[life.getFloor()].List_Up_Man.poll();
								 nowTime++;
								 life.sort();
								 continue;
							 }
							 else {
								 life.isFloor = false;
							 }
						 }
						 else {
							 if(!floor[life.getFloor()].List_Down_OldMan.isEmpty()) {
								 life.List_OnLife.add(floor[life.getFloor()].List_Down_OldMan.getFirst());
								 list_OnFloor.remove(floor[life.getFloor()].List_Down_OldMan.getFirst());
								 floor[life.getFloor()].List_Down_OldMan.poll();
								 nowTime++;
								 life.sort();
								 continue;
							 }
							 else if(!floor[life.getFloor()].List_Down_Man.isEmpty()) {
								 life.List_OnLife.add(floor[life.getFloor()].List_Down_Man.getFirst());
								 list_OnFloor.remove(floor[life.getFloor()].List_Down_Man.getFirst());
								 floor[life.getFloor()].List_Down_Man.poll();
								 nowTime++;
								 life.sort();
								 continue;
							 }
							 else {
								 life.isFloor = false;
							 } 
						 }
					 }
					 else {
						 life.isFloor = false;
					 }
				 }
				 
				 MoveTime ++;
				 if(MoveTime == 10) {
					 if(life.UpOrDown) {
						 life.floor ++; 
					 }
					 else {
						 life.floor --;  
					 }
					 life.isFloor = true;
					 MoveTime = 0;
				 }
				 
			 }
			 nowTime ++;
			
		 }
	}
	
	public void SortlistOnFloor() {
		Collections.sort(list_OnFloor,new Comparator<People>(){

			/**
			 * 上升就上升到顶部
			 * 下降就下降到底部
			 */
			@Override
			public int compare(People o1, People o2) {
				if(life.UpOrDown) {
					if(o1.SourceFloor > o2.SourceFloor) {
						return 1;
					}
					else if(o1.SourceFloor < o2.SourceFloor) {
						return -1;
					}
				}
				else {
					if(o1.SourceFloor > o2.SourceFloor) {
						return 1;
					}
					else if(o1.SourceFloor < o2.SourceFloor) {
						return -1;
					}
				}
				
				return 0;
			}});
	}

}
