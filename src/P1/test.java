package P1;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class test extends Application{
	
	 static LifePane pane = new LifePane();
	 
	 @Override
	public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
		
			 Scene scene = new Scene(pane,800,900);
			 primaryStage.setTitle("Life");
			 primaryStage.setScene(scene);
			 primaryStage.show();
//			
			 Work work = new Work(pane);
			 
			 work.write();
			 work.read();
			 work.readOnText();
			 work.sort_ComingTime();
			 work.start();
			 work.writeToText();
			 
//			 Thread.sleep(1000);
//			 Thread t1 = new  Thread(new LifePaneThread());
//			 Thread t2 = new  Thread(new LifeCloseTheDoorThread());
//			 t1.start();
//			 t1.join();
//			 pane.closeTheDoor();
//			 System.out.println("open");
		 	
//			 
//			 System.out.println("close");
//			 t2.start();
//			 t2.join();
//			 
//			 System.out.println("Ok");
			 pane.play();
	}
	
	public static void main(String[] args) throws Exception {
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
		 
//		Work work = new Work(pane);
//		work.readOnText();
		 
		Application.launch(args);
		
		
	}



	
}
