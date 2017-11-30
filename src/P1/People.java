package P1;

import java.io.Serializable;

public class People implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int ID;
	protected int ComingTime;
	protected int Age;
	protected int SourceFloor;
	protected int DestinationFloor;
	protected int LeavingTime = 0;
	protected boolean isOldman;
	protected boolean UpOrDown;
	
	public People() {
		
	}
	public People(int iD, int comingTime, int age, int sourceFloor, int destinationFloor) {
		super();
		ID = iD;
		Age = age;
		ComingTime = comingTime;
		SourceFloor = sourceFloor;
		DestinationFloor = destinationFloor;
		this.setisOldman();
		this.setUpOrDown();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	public int getComingTime() {
		return ComingTime;
	}
	public void setComingTime(int comingTime) {
		ComingTime = comingTime;
	}
	
	public int getSourceFloor() {
		return SourceFloor;
	}
	public void setSourceFloor(int sourceFloor) {
		SourceFloor = sourceFloor;
	}
	
	public int getDestinationFloor() {
		return DestinationFloor;
	}
	public void setDestinationFloor(int destinationFloor) {
		DestinationFloor = destinationFloor;
	}
	
	public int getLeavingTime() {
		return LeavingTime;
	}
	public void setLeavingTime(int leavingTime) {
		LeavingTime = leavingTime;
	}
	
	public boolean isOldman() {
		return isOldman;
	}
	public void setisOldman() {
		if(Age > 60) {
			this.isOldman = true;
		}
		else {
			this.isOldman = false;
		}
	}
	
	public boolean isUpOrDown() {
		return UpOrDown;
	}
	public void setUpOrDown() {
		if(this.SourceFloor < this.DestinationFloor) {
			this.UpOrDown = true;
		}
		else {
			this.UpOrDown = false;
		}
	}
	@Override
	public String toString() {
		return "People [ID=" + ID + ", Age=" + Age + ", ComingTime=" + ComingTime + ", SourceFloor=" + SourceFloor
				+ ", DestinationFloor=" + DestinationFloor + ", LeavingTime=" + LeavingTime + ", isOldman=" + isOldman
				+ ", UpOrDown=" + UpOrDown + "]";
	}
	

}
