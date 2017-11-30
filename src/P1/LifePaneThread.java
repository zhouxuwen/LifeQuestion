package P1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class LifePaneThread extends LifePane implements Runnable {

	public LifePaneThread() {
		super();
		
	}
	
	public void run() {
		super.openTheDoor();
	}


	
	
		
}