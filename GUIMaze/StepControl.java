import javafx.scene.layout.*;
import javafx.scene.control.*;
public class StepControl extends BorderPane{
	//Intreface 
	private ShowStep ss;

	//Layout
	private VBox main;

	private Button stepButton;
	private Button allStepButton;
	
	private Button solveButton;

	private int count = 0;



	private final double width = 60;

	

	public StepControl(ShowStep ss){
		this.ss = ss;
		setSize();
		createMainLayout();
		



	}
	private void createStepButton(){
		stepButton = new Button("Steps");

		stepButton.setPrefWidth(width);
		stepButton.setMinWidth(width);
		stepButton.setMaxWidth(width);

		stepButton.setOnAction(e->{
			if(count == 0){
				ss.stepButtonPressed(true);

			}else{
				ss.stepButtonPressed(false);

			}
			count++;
			
			
		});

		//setTop(stepButton);



	}
	private void createAllStepButton(){
		allStepButton = new Button("All Steps");
		allStepButton.setPrefWidth(width);
		allStepButton.setMinWidth(width);
		allStepButton.setMaxWidth(width);

		allStepButton.setOnAction(e->{
			if(count == 0){
				ss.allstepButtonPressed(true);

			}else{
				ss.allstepButtonPressed(false);

			}
			count++;

		});
	}
	
	private void createMainLayout(){
		main = new VBox(10);
		createStepButton();
		createSolveButton();
		createAllStepButton();

		main.getChildren().addAll(stepButton,solveButton,allStepButton);

		setCenter(main);


	}
	private void createSolveButton(){
		solveButton = new Button("Solve");


		solveButton.setPrefWidth(width);
		solveButton.setMinWidth(width);
		solveButton.setMaxWidth(width);

		solveButton.setOnAction(e->{
			ss.solveButtonPressed();
			System.out.println("Pressed solve Button");
			count = 0;
		});

		//setBottom(solveButton);

	}
	private void setSize(){
		//setWidth(width);
		setPrefWidth(width);
		setMinWidth(width);
	}
}