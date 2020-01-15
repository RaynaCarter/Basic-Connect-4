import java.util.Random;

public class Computer {

    String token = " O ";

    public Computer() {}

    //computer always makes a ranom move - very sophisticated
    public int determineMove(Board b) {

        return 0 + (int)(Math.random() * ((7-0) + 1));

    }

}
