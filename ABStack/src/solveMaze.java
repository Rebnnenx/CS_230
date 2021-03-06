import java.util.*;


public class solveMaze {
	
	static Random rand = new Random();
	public static void main(String[] args) {
		
		int row, col;
		
		row = rand.nextInt(10)+2;
		col = rand.nextInt(10)+2;
		int srow = rand.nextInt(row);
		int scol = 0;
		char[][] maze = new char[row][col];
		int erow= rand.nextInt(row);
		int ecol= maze[erow].length-1;
		
		maze[srow][scol]='*';
		System.out.println(row+"  "+col);
		maze=mazeGenerator(maze, row, col);
		
		navigateMaze(maze,srow,scol,erow,ecol);
		
		clearFails(maze);
		
		
		
		maze[srow][scol]='&';
		maze[erow][ecol]='$';
		System.out.println("Start = &\nExit = $");
		for (int i=0;i<maze.length;i++) {
			for (int j=0; j<maze[i].length;j++) {
				System.out.print(maze[i][j]+" ");
				}
			System.out.print("\n");
			}
		java.awt.Toolkit.getDefaultToolkit().beep();
	}
	
	public static char[][] mazeGenerator(char[][] m,int r,int c) {
		
		for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = '#';
            }
        }		
		
		int row, col;
		for( int i=1; i<=r*c*1.25; i++) {
			row =rand.nextInt(r);
			col =rand.nextInt(c);
			
			if(m[row][col]=='#') {
				m[row][col]= '.';
			}

		}
		return m;
	}
	public static void navigateMaze(char[][] maze, int rs, int cs, int re, int ce) {

		LinkedStack<Integer> Col = new LinkedStack<>();
		LinkedStack<Integer> Row = new LinkedStack<>();
		
		Col.push(cs);
		Row.push(rs);

		maze[rs][cs] = '&';
		maze[re][ce] = '$';
		
		String dir = "";
		maze[Row.peek()][Col.peek()] = '#';
		boolean found = false;
		while (!found) {
			blankScreen();
			//System.out.println("Exit is at '*'\nPosition : " + Col.peek() + " " + Row.peek());
			if( (Row.peek() + 1) < maze.length)
				if( (maze[Row.peek()+1][Col.peek()] != '#') && (maze[Row.peek()+1][Col.peek()] != '-') && (maze[Row.peek()+1][Col.peek()] != '@') && (maze[Row.peek()+1][Col.peek()] != '-')) {
					dir = dir + "S";
				}
			if( (Row.peek() - 1) >= 0)
				if( (maze[Row.peek()-1][Col.peek()] != '#') && (maze[Row.peek()-1][Col.peek()] != '-') && (maze[Row.peek()-1][Col.peek()] != '@') && (maze[Row.peek()-1][Col.peek()] != '-')) {
					dir = dir + "N";
				}
			if( (Col.peek() + 1) < maze[0].length) 
				if( (maze[Row.peek()][Col.peek()+1] != '#') && (maze[Row.peek()][Col.peek()+1] != '-') && (maze[Row.peek()][Col.peek()+1] != '@') && (maze[Row.peek()][Col.peek()+1] != '-')) {
					dir = dir + "E";
				}
			if( (Col.peek() - 1) >= 0)
				if( (maze[Row.peek()][Col.peek()-1] != '#') && (maze[Row.peek()][Col.peek()-1] != '-') && (maze[Row.peek()][Col.peek()-1] != '@') && (maze[Row.peek()][Col.peek()-1] != '-')) {
					dir = dir + "W";
				}


			//System.out.println(dir);
			if( dir.equals("")) {
				try {
				maze[Row.peek()][Col.peek()] = '@';
				Col.pop();
				Row.pop();
				maze[Row.peek()][Col.peek()] = '-';
				}catch(Exception e) {
					blankScreen();
					System.out.println("This maze has no valid path");
					java.awt.Toolkit.getDefaultToolkit().beep();
					break;
				}
			} else {
				if( dir.contains("E")) {
					maze[Row.peek()][Col.peek()] = '-';
					Row.push(Row.peek());
					Col.push(Col.peek()+1);
					dir = "";
				}
				if( dir.contains("N")) {
					maze[Row.peek()][Col.peek()] = '-';
					Row.push(Row.peek()-1);
					Col.push(Col.peek());
					dir = "";
				}
				if( dir.contains("S")) {
					maze[Row.peek()][Col.peek()] = '-';
					Row.push(Row.peek()+1);
					Col.push(Col.peek());
					dir = "";
				}
				if( dir.contains("W")) {
					maze[Row.peek()][Col.peek()] = '-';
					Row.push(Row.peek());
					Col.push(Col.peek()-1);
					dir = "";
				}
			}
			int i = 0;
			int j = 0;

			while (i<maze.length) {
				j = 0;
				while (j<maze[0].length) {
					System.out.print(maze[i][j] + " ");
					j++;
				}
				System.out.println("");
				i++;
			}

			if(((maze[Row.peek()][Col.peek()])==('$'))) {
				found = true;
				blankScreen();
				System.out.println("I found the exit");
				
				while (!Col.isEmpty() && !Row.isEmpty()) {
					maze[Row.pop()][Col.pop()] = '-';
				}
				clearFails(maze);
						}

			dir = "";
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void blankScreen() {
		for(int i=1; i<10; i++){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
	}
	
	public static void clearFails(char[][] maze) {
		for(int q=0;q<maze.length;q++) {
			for(int p=0; p<maze[q].length;p++) {
				if(maze[q][p]=='@') {
					maze[q][p]='.';
			}
		}
	}
}}
