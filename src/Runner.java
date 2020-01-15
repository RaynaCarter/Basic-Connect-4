import java.util.Scanner;

public class Runner {

    static int delay = 200;

    public static void main(String args[]) {

        //create instances of classes
        Scanner sc = new Scanner(System.in);
        Human h = new Human();
        Board b = new Board();
        Computer c = new Computer();

        //print the empty board
        b.printBoard();

        //repeating game play here
        boolean gameOn = true;
        while (gameOn) {

            //human move, checking for full cols and non-numerical input
            boolean legalMove = false;
            while (!legalMove) {
                System.out.println("\nHuman: make your move:");
                if (sc.hasNextInt()) {
                    legalMove = b.makeMove(sc.nextInt()-1, h.token);
                }
                if (!legalMove) {
                    System.out.println("Illegal Move - try again");
                    sc.next();
                }
            }

            System.out.print("\nComputer Moving");
            pause(delay);
            System.out.print(".");
            pause(delay);
            System.out.print(".");
            pause(delay);
            System.out.print(".\n\n");

            //Computer move here
            b.makeMove(c.determineMove(b),c.token);

            //check vertical win after every move
            if(b.checkVerticalWin()) {
                System.out.println("VERTICAL WIN");
                gameOn = false;
            }
        }



    }

    //helper method for pausing the game
    public static void pause(int ms) {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}