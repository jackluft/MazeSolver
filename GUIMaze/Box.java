import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
public class Box extends Pane{
	private char k;

	public static final double width = 30;
	public static final double height = 30;

	//point
	private Circle c = null;

	private boolean wall = false;

	private boolean marked = false;

	public Box(char k){
		this.k = k;
		setSize();
		setType();

	}
	private void setSize(){
		setWidth(width);
		setHeight(height);
	}
	private void setType(){
		if(this.k == 'H' || this.k == 'h'){
			Rectangle r = new Rectangle();
			r.setWidth(width);
			r.setHeight(height);
			r.setFill(Color.BLACK);
			getChildren().add(r);
			

			wall = true;


		}else{
			Rectangle r = new Rectangle();
			r.setWidth(width);
			r.setHeight(height);
			r.setFill(Color.WHITE);
			getChildren().add(r);
			wall = false;

		}

	}
	public boolean isWall(){
		return this.wall;
	}
	public boolean getMarked(){
		return marked;
	}
	/*
		purpose: add red point to show path


	*/
	public void movePoint(){
			c = new Circle(4);
			c.setLayoutX(width/2);
			c.setLayoutY(height/2);

			c.setFill(Color.RED);
			getChildren().add(c);
			marked = true;

	}
	/*
		purpose: add Black point to show deadend
		

	*/
	public void backPoint(){
		c = new Circle(5);
		c.setLayoutX(width/2);
		c.setLayoutY(height/2);

		c.setFill(Color.BLACK);
		getChildren().add(c);
		marked = true;

	}
	public void setEndPoint(){
		c = new Circle(10);
		c.setLayoutX(width/2);
		c.setLayoutY(height/2);

		c.setFill(Color.BLUE);
		getChildren().add(c);
		marked = true;
		

	}
	public void clear(){
		if(marked == true){
			getChildren().clear();
			if(isWall() == false){
				Rectangle r = new Rectangle();
				r.setWidth(width);
				r.setHeight(height);
				this.marked = false;
				r.setFill(Color.WHITE);
				getChildren().add(r);
				

			}

		}
	}

}