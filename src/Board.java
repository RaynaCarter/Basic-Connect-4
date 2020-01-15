public class Board {

    int size = 8;
    String empty = " - ";
    String[][] grid = new String[size][size];

    //makes the empty board the first time
    public Board() {

        for(int row = 0; row<size; row++) {
            for(int col = 0; col<size; col++) {
                grid[row][col] = empty;
            }
        }

    }

    //prints out the current board
    public void printBoard() {

        for(int row = 0; row<size; row++) {
            for(int col = 0; col<size; col++) {
                System.out.print(grid[row][col]);
            }
            System.out.print("\n");
        }

    }

    //adds a move to the board and prints it
    public boolean makeMove(int col, String token) {

        boolean legal = false;
        for(int row = size-1; row>=0; row--) {

            if(grid[row][col] == empty) {
                grid[row][col] = token;
                legal = true;
                break;
            }
        }

        printBoard();

        return legal;
    }

    //returns true if there are 4-in-a-row vertically
    public boolean checkVerticalWin() {
        String[] tokens = new String[4];
        int count = 0;
        for(int col = 0; col<size; col++) {
            for(int start = 3; start>=0; start--) {
                 tokens[start] = grid[start+4][col];
            }
            if(tokens[0] == tokens[1] && tokens[0] == tokens[2] && tokens[0] == tokens[3]) {
                if(tokens[0] == " X " || tokens[0] == " O "){
                    return true;
                }
            }
        }
        return false;
    }


}
