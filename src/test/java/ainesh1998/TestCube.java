package ainesh1998;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static ainesh1998.Move.*;
import static ainesh1998.Colour.*;

/**
 * Unit test for simple App.
 */

/*
    TODO: implement a function to check that the rest of the cube is solved (minus some pieces) - makes testing
          much easier.

    TODO: remove T perm (useless lol), add test for each move, add another scramble.
 */

public class TestCube
{
    /**
     * Tests the Cube class.
     */

    private ArrayList<Move> scramble = new ArrayList<>(Arrays.asList(R, F2, Dp, F2, U, B2, F2, L2, D, U2, L2, Rp, F, L, Dp, Bp, U2, L2, U, F2));

    @Test
    public void testResetCubeReturnsSolvedCube() {
        Cube cube = new Cube();
        cube.applyMoves(scramble);
        cube.resetCube();

        // Check entire cube
        assertTrue(cube.getCornerAtIndex(0).equals(new Corner(0, WHITE, ORANGE, BLUE)));
        assertTrue(cube.getCornerAtIndex(1).equals(new Corner(1, WHITE, BLUE, RED)));
        assertTrue(cube.getCornerAtIndex(2).equals(new Corner(2, WHITE, RED, GREEN)));
        assertTrue(cube.getCornerAtIndex(3).equals(new Corner(3, WHITE, GREEN, ORANGE)));
        assertTrue(cube.getCornerAtIndex(4).equals(new Corner(4, YELLOW, BLUE, ORANGE)));
        assertTrue(cube.getCornerAtIndex(5).equals(new Corner(5, YELLOW, RED, BLUE)));
        assertTrue(cube.getCornerAtIndex(6).equals(new Corner(6, YELLOW, GREEN, RED)));
        assertTrue(cube.getCornerAtIndex(7).equals(new Corner(7, YELLOW, ORANGE, GREEN)));

        assertTrue(cube.getEdgeAtIndex(0).equals(new Edge(0, WHITE, BLUE)));
        assertTrue(cube.getEdgeAtIndex(1).equals(new Edge(1, WHITE, RED)));
        assertTrue(cube.getEdgeAtIndex(2).equals(new Edge(2, WHITE, GREEN)));
        assertTrue(cube.getEdgeAtIndex(3).equals(new Edge(3, WHITE, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(4).equals(new Edge(4, BLUE, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(5).equals(new Edge(5, BLUE, RED)));
        assertTrue(cube.getEdgeAtIndex(6).equals(new Edge(6, GREEN, RED)));
        assertTrue(cube.getEdgeAtIndex(7).equals(new Edge(7, GREEN, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(8).equals(new Edge(8, YELLOW, BLUE)));
        assertTrue(cube.getEdgeAtIndex(9).equals(new Edge(9, YELLOW, RED)));
        assertTrue(cube.getEdgeAtIndex(10).equals(new Edge(10, YELLOW, GREEN)));
        assertTrue(cube.getEdgeAtIndex(11).equals(new Edge(11, YELLOW, ORANGE)));
    }

    @Test
    public void testBMovesReturnCorrectCube() {
        Cube cube = new Cube();
        cube.applyMoves(new ArrayList<>(Arrays.asList(B)));

        Edge temp0 = cube.getEdgeAtIndex(0);
        Edge temp1 = cube.getEdgeAtIndex(4);
        Edge temp2 = cube.getEdgeAtIndex(8);
        Edge temp3 = cube.getEdgeAtIndex(5);

        assertTrue(cube.getCornerAtIndex(0).equals(new Corner(1, RED, WHITE, BLUE)));
        assertTrue(cube.getCornerAtIndex(1).equals(new Corner(5, RED, BLUE, YELLOW)));
        assertTrue(cube.getCornerAtIndex(5).equals(new Corner(4, ORANGE, YELLOW, BLUE)));
        assertTrue(cube.getCornerAtIndex(4).equals(new Corner(0, ORANGE, BLUE, WHITE)));
        assertTrue(cube.getEdgeAtIndex(0).equals(new Edge(5, RED, BLUE)));
        assertTrue(cube.getEdgeAtIndex(5).equals(new Edge(8, BLUE, YELLOW)));
        assertTrue(cube.getEdgeAtIndex(8).equals(new Edge(4, ORANGE, BLUE)));
        assertTrue(cube.getEdgeAtIndex(4).equals(new Edge(0, BLUE, WHITE)));
    }

    @Test
    public void testTPermShouldReturnCorrectCube() {
        Cube cube = new Cube();
        ArrayList<Move> tPerm = new ArrayList<>(Arrays.asList(R, U, Rp, Up, Rp, F, R2, Up, Rp, Up, R, U, Rp, Fp));

        cube.applyMoves(tPerm);

        ArrayList<Corner> unsolvedCorners = cube.getUnsolvedCorners();
        ArrayList<Edge> unsolvedEdges = cube.getUnsolvedEdges();

        // Check unsolved pieces
        Corner newUBR = new Corner(2, WHITE, RED, GREEN);
        Corner newUFR = new Corner(1, WHITE, BLUE, RED);
        Edge newUR = new Edge(3, WHITE, ORANGE);
        Edge newUL = new Edge(1, WHITE, RED);

        assertTrue(unsolvedCorners.size() == 2 && unsolvedEdges.size() == 2);
        assertTrue(unsolvedCorners.get(0).equals(newUBR));
        assertTrue(unsolvedCorners.get(1).equals(newUFR));
        assertTrue(unsolvedEdges.get(0).equals(newUR));
        assertTrue(unsolvedEdges.get(1).equals(newUL));

        // Check entire cube
        assertTrue(cube.getCornerAtIndex(0).equals(new Corner(0, WHITE, ORANGE, BLUE)));
        assertTrue(cube.getCornerAtIndex(1).equals(new Corner(2, WHITE, RED, GREEN)));
        assertTrue(cube.getCornerAtIndex(2).equals(new Corner(1, WHITE, BLUE, RED)));
        assertTrue(cube.getCornerAtIndex(3).equals(new Corner(3, WHITE, GREEN, ORANGE)));
        assertTrue(cube.getCornerAtIndex(4).equals(new Corner(4, YELLOW, BLUE, ORANGE)));
        assertTrue(cube.getCornerAtIndex(5).equals(new Corner(5, YELLOW, RED, BLUE)));
        assertTrue(cube.getCornerAtIndex(6).equals(new Corner(6, YELLOW, GREEN, RED)));
        assertTrue(cube.getCornerAtIndex(7).equals(new Corner(7, YELLOW, ORANGE, GREEN)));

        assertTrue(cube.getEdgeAtIndex(0).equals(new Edge(0, WHITE, BLUE)));
        assertTrue(cube.getEdgeAtIndex(1).equals(new Edge(3, WHITE, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(2).equals(new Edge(2, WHITE, GREEN)));
        assertTrue(cube.getEdgeAtIndex(3).equals(new Edge(1, WHITE, RED)));
        assertTrue(cube.getEdgeAtIndex(4).equals(new Edge(4, BLUE, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(5).equals(new Edge(5, BLUE, RED)));
        assertTrue(cube.getEdgeAtIndex(6).equals(new Edge(6, GREEN, RED)));
        assertTrue(cube.getEdgeAtIndex(7).equals(new Edge(7, GREEN, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(8).equals(new Edge(8, YELLOW, BLUE)));
        assertTrue(cube.getEdgeAtIndex(9).equals(new Edge(9, YELLOW, RED)));
        assertTrue(cube.getEdgeAtIndex(10).equals(new Edge(10, YELLOW, GREEN)));
        assertTrue(cube.getEdgeAtIndex(11).equals(new Edge(11, YELLOW, ORANGE)));
    }

    @Test
    public void testRandomScrambleShouldReturnCorrectCube() {
        Cube cube = new Cube();

        cube.applyMoves(scramble);

        // Check entire cube
        assertTrue(cube.getCornerAtIndex(0).equals(new Corner(2, WHITE, RED, GREEN)));
        assertTrue(cube.getCornerAtIndex(1).equals(new Corner(0, BLUE, WHITE, ORANGE)));
        assertTrue(cube.getCornerAtIndex(2).equals(new Corner(1, WHITE, BLUE, RED)));
        assertTrue(cube.getCornerAtIndex(3).equals(new Corner(4, BLUE, ORANGE, YELLOW)));
        assertTrue(cube.getCornerAtIndex(4).equals(new Corner(6, YELLOW, GREEN, RED)));
        assertTrue(cube.getCornerAtIndex(5).equals(new Corner(3, GREEN, ORANGE, WHITE)));
        assertTrue(cube.getCornerAtIndex(6).equals(new Corner(7, ORANGE, GREEN, YELLOW)));
        assertTrue(cube.getCornerAtIndex(7).equals(new Corner(5, RED, BLUE, YELLOW)));

        assertTrue(cube.getEdgeAtIndex(0).equals(new Edge(2, GREEN, WHITE)));
        assertTrue(cube.getEdgeAtIndex(1).equals(new Edge(9, RED, YELLOW)));
        assertTrue(cube.getEdgeAtIndex(2).equals(new Edge(7, GREEN, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(3).equals(new Edge(0, BLUE, WHITE)));
        assertTrue(cube.getEdgeAtIndex(4).equals(new Edge(3, WHITE, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(5).equals(new Edge(10, GREEN, YELLOW)));
        assertTrue(cube.getEdgeAtIndex(6).equals(new Edge(5, BLUE, RED)));
        assertTrue(cube.getEdgeAtIndex(7).equals(new Edge(11, ORANGE, YELLOW)));
        assertTrue(cube.getEdgeAtIndex(8).equals(new Edge(6, RED, GREEN)));
        assertTrue(cube.getEdgeAtIndex(9).equals(new Edge(8, YELLOW, BLUE)));
        assertTrue(cube.getEdgeAtIndex(10).equals(new Edge(1, WHITE, RED)));
        assertTrue(cube.getEdgeAtIndex(11).equals(new Edge(4, BLUE, ORANGE)));
    }
}
