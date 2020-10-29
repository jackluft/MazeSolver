import javafx.scene.*;
import javafx.application.Application;
import javafx.stage.Stage;
public class Main extends Application{

	private Maze maze;
	private Board board;

	@Override
	public void start(Stage stage){
		
		
		maze = new Maze("maze3.txt");
		board = new Board(maze);
		//maze.setUpSolve();
		stage = board.getStage();

		stage.show();




	}

	public static void main(String[] args){
		
		launch();

	}
}