package ainesh1998;

import ainesh1998.CubeSimulator.Cube;
import ainesh1998.CubeSimulator.Move;

import java.util.ArrayList;

/**
 * Finally, the IF itself! Nothing much in here yet, as you can see.
 */

public class InsertionFinder {

    private ArrayList<Move> scramble;
    private ArrayList<Move> skeleton;
    private Cube cube;

    public InsertionFinder(ArrayList<Move> scramble, ArrayList<Move> skeleton) {
        this.scramble = scramble;
        this.skeleton = skeleton;
        this.cube = new Cube();

        insert();
    }

    private void insert() {
        cube.applyMoves(scramble);
        cube.applyMoves(skeleton);
    }

}
