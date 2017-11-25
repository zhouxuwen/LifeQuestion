package P1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		People p1 = new People(12,65,24,2,9);
//		People p2 = new People(1,16,45,80,5);
//		People p3 = new People(4,38,14,1,99);
//		People p4 = new People(3,68,68,2,99);
//		Life life = new Life(1,true,2,false);
//		life.List_OnLife.add(p1);
//		life.List_OnLife.add(p2);
//		life.List_OnLife.add(p3);
//		life.List_OnLife.add(p4);
//		life.sort();
//		System.out.println(life.List_OnLife.remove());
//		System.out.println(life.List_OnLife.remove());
//		System.out.println(life.List_OnLife.remove());
//		System.out.println(life.List_OnLife.remove());
		Work work = new Work();
		work.write();
		work.read();
		work.sort_ComingTime();
		work.start();
//		work.writeOnText();
	}

}
