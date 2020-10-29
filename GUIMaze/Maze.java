import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
public class Maze{
	private Box[][] board;

	private MazeLocation start;
	private MazeLocation finish;
	private Stack<MazeLocation> stack;
	private Stack<MazeLocation> fullStack;
	//private Stack<MazeLocation> allLoc;

	private int rowSize;
	private int colSize;

	public Maze(String path){
		File f = new File(path);
		Scanner sc;
		try{
			sc = new Scanner(f);

			rowSize = sc.nextInt();
			colSize = sc.nextInt();
			int startRow = sc.nextInt();
			int startColumn = sc.nextInt();
			int finishRow = sc.nextInt();
			int finishColumn = sc.nextInt();

			start = new MazeLocation(startRow,startColumn);
			finish = new MazeLocation(finishRow,finishColumn);


			sc.nextLine();
			System.out.println("Row: "+rowSize+", Col: "+colSize);
			System.out.println("Start Point: "+startRow+", "+startColumn);
			
			setUpBoard(rowSize,colSize,sc);



		}catch(FileNotFoundException e){
			System.out.println("File not found");
			System.exit(1);

		}catch(NoSuchElementException e){
			System.out.println("Maze data file is not formatted correctly, should be:");
			System.out.println("<num rows> <num columns>");
			System.out.println("<start row> <start column>");
			System.out.println("<finish row> <finish column>");
			System.out.println("<Maze data>");
			System.out.println("Example:");
			System.out.println("7 8");
			System.out.println("0 1");
			System.out.println("6 6");
			System.out.println("H HHHHHH");
			System.out.println("H    H H");
			System.out.println("HHHH H H");
			System.out.println("H      H");
			System.out.println("H HHHHHH");
			System.out.println("H      H");
			System.out.println("HHHHHH H");
			System.exit(2);

		}
		System.out.println("File loaded");


		

	}
	private void setUpBoard(int rows, int columns,Scanner sc){
		board = new Box[rows][columns];
		for(int j = 0; j < rows; j++){
			String line = sc.nextLine();

			for(int i = 0; i < columns; i++){
				board[j][i] = new Box(line.charAt(i));
				//System.out.println("Addded: "+new MazeLocation(j,i));

			}

		}

	}

	public int getRow(){
		return board.length;
	}
	public Box[][] getBoxes(){
		return board;
	}

	public int getCol(){
		return board[0].length;
	}
	public void setUpSolve(){
		stack = new Stack<MazeLocation>();
		fullStack = new Stack<MazeLocation>();
		stack.push(start);
		boolean result = solve(start,finish);
		System.out.println("Solved: "+result);
	}

	public Stack<MazeLocation> getStack(){
		return this.stack;
	}
	public Stack<MazeLocation> getFullStack(){
		return this.fullStack;
	}


	public void clearBoard(){

		for(int j = 0; j < this.board.length; j++){
			for(int i = 0; i < this.board[j].length; i++){
				if(board[j][i].isWall() == false){
					board[j][i].clear();
				}
				

			}

		}
	}
	private boolean seeCorned(int row, int col, int up, int down, int left, int right){
		if((up >= 0 && up <= rowSize) && (down >= 0 && down <= rowSize) && (left >=0 && left <= colSize) && (right >=0 && right <= colSize)){
			int count = 0;
			if(board[down][col].isWall() == false && board[down][col].getMarked() == false){
				count++;
					
					

				}if(board[up][col].isWall() == true && board[up][col].getMarked() == true){
					count++;
					
					


				}if(board[row][left].isWall() == true && board[row][left].getMarked() == true){
					count++;

					
					//board[row][left].movePoint();
					

				}if(board[row][right].isWall() == true || board[row][right].getMarked() == true){
					count++;
					
					

				}
				if(count == 4){
					return true;

				}
		}
		
			return false;

	}
	


	public boolean solve(MazeLocation cur, MazeLocation finish){
		System.out.println("In solve Method");
		int row = cur.row;
		int col = cur.col;
		board[row][col].movePoint();
		fullStack.push(cur);
		

		
		//Break statement
		if(cur.equals(finish)){

			board[row][col].setEndPoint();
			return true;

		}
		
		if(stack.isEmpty()){
			return false;

		}

		//Check front
		int down = row+1;
		int up = row-1;
		int left = col+1;
		int right = col-1;
		
		
		 
		 if((up >= 0 && up <= rowSize) || (down >= 0 && down <= rowSize) || (left >=0 && left <= colSize) || (right >=0 && right <= colSize)){
				
				if(board[down][col].isWall() == false && board[down][col].getMarked() == false){
					
					//board[down][col].movePoint();
					stack.push(new MazeLocation(down,col));
					return solve(new MazeLocation(down,col),finish);

					}if(board[up][col].isWall() == false && board[up][col].getMarked() == false){
						
						stack.push(new MazeLocation(up,col));
						return solve(new MazeLocation(up,col),finish);


					}if(board[row][left].isWall() == false && board[row][left].getMarked() == false){
						
						//board[row][left].movePoint();
						stack.push(new MazeLocation(row,left));
						return solve(new MazeLocation(row,left),finish);

					}if(board[row][right].isWall() == false && board[row][right].getMarked() == false){
						
						//board[row][right].movePoint();
						stack.push(new MazeLocation(row,right));
						return solve(new MazeLocation(row,right),finish);

					}

				}
				if(stack.isEmpty() == false){
					System.out.println("Move back");
					MazeLocation loc = stack.pop();
					board[row][col].backPoint();


					return solve(stack.top(),finish);


				}



		 
		
				return false;
	
		


	}


}