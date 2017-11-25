package P1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Life {
	final int peopleMAX = 13;
	int floor;
	boolean UpOrDown;
	int peopleNum;
	boolean isFloor; //ÊÇ·ñµ½´ïÂ¥²ã
	LinkedList<People> List_OnLife;
	
	
	public Life(int floor, boolean upOrDown, int peopleNum, boolean isFloor) {
		super();
		this.floor = floor;
		UpOrDown = upOrDown;
		this.peopleNum = peopleNum;
		this.isFloor = isFloor;
		List_OnLife = new LinkedList<People>();
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public boolean isUpOrDown() {
		return UpOrDown;
	}
	public void setUpOrDown(boolean upOrDown) {
		UpOrDown = upOrDown;
	}
	
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	
	public boolean isFloor() {
		return isFloor;
	}
	public void setFloor(boolean isFloor) {
		this.isFloor = isFloor;
	}
	
	public void sort() {
		Collections.sort(List_OnLife,new Comparator<People>(){

			@Override
			public int compare(People o1, People o2) {
				
				if(UpOrDown) {
					if(o1.DestinationFloor > o2.DestinationFloor) {
						return 1;
					}
					else if(o1.DestinationFloor < o2.DestinationFloor) {
						return -1;
					}
				}
				else {
					if(o1.DestinationFloor < o2.DestinationFloor) {
						return 1;
					}
					else if(o1.DestinationFloor > o2.DestinationFloor) {
						return -1;
					}
				}
				if(o1.Age < o2.Age) {
					return 1;
				}
				else if(o1.Age > o2.Age) {
					return -1;
				}
				return 0;
			}});
				
	}	
			
}
