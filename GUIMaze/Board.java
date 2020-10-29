import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Board implements ShowStep{

	//Main Layout
	private BorderPane pane;
	private HBox[] board;

	private VBox main;

	private StepControl right;

	private Stage stage;
	private Scene scene;

	//Maze Object
	private Maze maze;

	private Stack<MazeLocation> copyStack;
	private Stack<MazeLocation> allCopyStack;


	public Board(Maze maze){
		this.maze = maze;

		setUpLayout(maze.getBoxes());
		setMainLayout();
		createStage();


	}
	private void setMainLayout(){
		main = new VBox();
		for(int i =0; i < board.length; i++){
			main.getChildren().add(board[i]);

		}
	}
	private void createStage(){

		pane = new BorderPane();
		pane.setCenter(main);
		right = new StepControl(this);
		pane.setRight(right);
		stage = new Stage();
		Scene s = new Scene(pane);
		stage.setScene(s);


	}
	public Stage getStage(){
		return stage;
	}
	private void setUpLayout(Box[][] boxs){
		board = new HBox[boxs.length];

		for(int j = 0; j < board.length; j++){
			board[j] = new HBox();
			//maybe set width & height
			for(int i = 0; i < boxs[j].length; i++){
				board[j].getChildren().add(boxs[j][i]);



			}

		}


	}
	//Interface method
	public void stepButtonPressed(boolean t){
		System.out.println("StepButton pressed");
		if(t == true){
			maze.clearBoard();
			copyStack = maze.getStack().copy();

		}else{
			if(copyStack.isEmpty()){
				System.out.println("Empty Stack");
				stepButtonPressed(true);


			}else{
				MazeLocation loc = copyStack.pop();

				maze.getBoxes()[loc.getRow()][loc.getCol()].movePoint();

			}
			
			
		}
		


	}
	//Interface method
	public void solveButtonPressed(){
		maze.clearBoard();
		maze.setUpSolve();
	}
	//Interface method
	public void allstepButtonPressed(boolean t){
		if(t == true){
			maze.clearBoard();
			allCopyStack = maze.getFullStack().copy();

		}else{
			if(allCopyStack.isEmpty()){
				System.out.println("Empty Stack");
				stepButtonPressed(true);


			}else{
				MazeLocation loc = allCopyStack.pop();

				maze.getBoxes()[loc.getRow()][loc.getCol()].movePoint();

			}
			
			
		}

	}
}