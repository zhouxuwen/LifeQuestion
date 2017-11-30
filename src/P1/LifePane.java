package P1;


import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class LifePane extends Pane {
	protected double Width = 800;
	protected double Hight = 900;
	protected int floorNum = 10;
	
	Rectangle rectangle1;
	Rectangle rectangle2;
	protected Timeline timeline1;
	protected Timeline timeline2;
	protected Timeline timeline3;
	protected Timeline timeline4;
	protected SequentialTransition sequentialTransition;
	
	public LifePane() {
		// TODO Auto-generated constructor stub
		sequentialTransition = new SequentialTransition();
		for (int i = 0; i < floorNum; i++) {
			Line line = new Line(0,Hight/floorNum*(i+1),Width,Hight/floorNum*(i+1));
			
			getChildren().add(line);
			
		}
		rectangle1 = new Rectangle(60,900-Hight/floorNum + Hight/floorNum*0.4, Hight/floorNum*0.4,Hight/floorNum*0.6);
		rectangle1.setFill(Color.BLUE);
		rectangle2 = new Rectangle(61 + Hight/floorNum*0.4,900-Hight/floorNum + Hight/floorNum*0.4, Hight/floorNum*0.4,Hight/floorNum*0.6);
		rectangle2.setFill(Color.BLUE);
		
		getChildren().add(rectangle1);
		getChildren().add(rectangle2);	
	}
	
	public void openTheDoor() {
		timeline1 = new Timeline();
		timeline1.setCycleCount(10);
		KeyFrame keyFrame1 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				rectangle1.setWidth(rectangle1.getWidth() - (Hight/floorNum*0.4)/10 );
				rectangle2.setX(rectangle2.getX() + (Hight/floorNum*0.4)/10 );
				rectangle2.setWidth(rectangle2.getWidth() - (Hight/floorNum*0.4)/10 );
				System.out.println("open");
			}
		});
		timeline1.getKeyFrames().add(keyFrame1);
		sequentialTransition.getChildren().add(timeline1);
		
	}
	
	public void closeTheDoor() {
		timeline2 = new Timeline();
		timeline2.setCycleCount(10);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				rectangle1.setWidth(rectangle1.getWidth() + (Hight/floorNum*0.4)/10 );
				rectangle2.setX(rectangle2.getX() - (Hight/floorNum*0.4)/10 );
				rectangle2.setWidth(rectangle2.getWidth() + (Hight/floorNum*0.4)/10 );
				System.out.println("close");
			}
		});
		timeline2.getKeyFrames().add(keyFrame2);
		sequentialTransition.getChildren().add(timeline2);
		
	}
	public void up() {
		timeline3 = new Timeline();
		timeline3.setCycleCount(20);
		KeyFrame keyFrame3 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				rectangle1.setY(rectangle2.getY() - (Hight/floorNum)/20 );
				rectangle2.setY(rectangle2.getY() - (Hight/floorNum)/20 );
				System.out.println("up");
			}
		});
		timeline3.getKeyFrames().add(keyFrame3);
		sequentialTransition.getChildren().add(timeline3);
	}
	public void down() {
		timeline4 = new Timeline();
		timeline4.setCycleCount(20);
		KeyFrame keyFrame4 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				rectangle1.setY(rectangle2.getY() + (Hight/floorNum)/20 );
				rectangle2.setY(rectangle2.getY() + (Hight/floorNum)/20 );
				System.out.println("down");
			}
		});
		
		timeline4.getKeyFrames().add(keyFrame4);
		sequentialTransition.getChildren().add(timeline4);
	}
	public void play() {
		sequentialTransition.play();
	}

}
