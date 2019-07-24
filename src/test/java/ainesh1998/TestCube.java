package ainesh1998;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static ainesh1998.Move.*;
import static ainesh1998.Colour.*;

/**
 * Unit test for simple App.
 */
public class TestCube
{
    /**
     * Tests the Cube class.
     */

    @Test
    public void tPermShouldReturnCorrectCube() {
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
    public void randomScrambleShouldReturnCorrectCube() {
        Cube cube = new Cube();
        ArrayList<Move> scramble = new ArrayList<>(Arrays.asList(R, F2, Dp, F2, U, B2, F2, L2, D, U2, L2, Rp, F, L, Dp, Bp, U2, L2, U, F2));

        cube.applyMoves(scramble);
    }
}
