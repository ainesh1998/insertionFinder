package ainesh1998.CubeSimulator;

import static org.junit.Assert.assertTrue;

import ainesh1998.CubeSimulator.Corner;
import ainesh1998.CubeSimulator.Cube;
import ainesh1998.CubeSimulator.Edge;
import ainesh1998.CubeSimulator.Move;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static ainesh1998.CubeSimulator.Move.*;
import static ainesh1998.CubeSimulator.Colour.*;

/**
 * Unit test for simple App.
 */

/*
    TODO: add test for each move
 */

public class TestCube
{
    /**
     * Tests the Cube class.
     */

    private ArrayList<Move> scramble = new ArrayList<>(Arrays.asList(R, F2, Dp, F2, U, B2, F2, L2, D, U2, L2, Rp, F, L, Dp, Bp, U2, L2, U, F2));
    private ArrayList<Move> scramble2 = new ArrayList<>(Arrays.asList(D2, Rp, Fp, D2, Fp, D2, B2, L2, D2, Fp, L2, D2, Rp, B, U, B, R, Fp, D, U));

    @Test
    public void testResetCubeReturnsSolvedCube() {
        Cube cube = new Cube();
        cube.applyMoves(scramble);
        cube.resetCube();

        // Check entire cube
        assertTrue(checkSolvedPieces(cube, new ArrayList<>(), new ArrayList<>()));
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

        assertTrue(checkSolvedPieces(cube, cube.getUnsolvedCorners(), cube.getUnsolvedEdges()));
    }

    @Test
    public void testTPermReturnsCorrectUnsolvedPieces() {
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
        assertTrue(checkSolvedPieces(cube, unsolvedCorners, unsolvedEdges));
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

    @Test
    public void testAnotherRandomScrambleShouldReturnCorrectCube() {
        Cube cube = new Cube();
        cube.applyMoves(scramble2);

        // Check entire cube
        assertTrue(cube.getCornerAtIndex(0).equals(new Corner(2, GREEN, WHITE, RED)));
        assertTrue(cube.getCornerAtIndex(1).equals(new Corner(3, ORANGE, WHITE, GREEN)));
        assertTrue(cube.getCornerAtIndex(2).equals(new Corner(6, GREEN, RED, YELLOW)));
        assertTrue(cube.getCornerAtIndex(3).equals(new Corner(7, GREEN, YELLOW, ORANGE)));
        assertTrue(cube.getCornerAtIndex(4).equals(new Corner(0, BLUE, WHITE, ORANGE)));
        assertTrue(cube.getCornerAtIndex(5).equals(new Corner(1, RED, WHITE, BLUE)));
        assertTrue(cube.getCornerAtIndex(6).equals(new Corner(4, ORANGE, YELLOW, BLUE)));
        assertTrue(cube.getCornerAtIndex(7).equals(new Corner(5, BLUE, YELLOW, RED)));

        assertTrue(cube.getEdgeAtIndex(0).equals(new Edge(10, YELLOW, GREEN)));
        assertTrue(cube.getEdgeAtIndex(1).equals(new Edge(11, ORANGE, YELLOW)));
        assertTrue(cube.getEdgeAtIndex(2).equals(new Edge(5, BLUE, RED)));
        assertTrue(cube.getEdgeAtIndex(3).equals(new Edge(0, WHITE, BLUE)));
        assertTrue(cube.getEdgeAtIndex(4).equals(new Edge(6, RED, GREEN)));
        assertTrue(cube.getEdgeAtIndex(5).equals(new Edge(9, RED, YELLOW)));
        assertTrue(cube.getEdgeAtIndex(6).equals(new Edge(7, GREEN, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(7).equals(new Edge(4, ORANGE, BLUE)));
        assertTrue(cube.getEdgeAtIndex(8).equals(new Edge(8, BLUE, YELLOW)));
        assertTrue(cube.getEdgeAtIndex(9).equals(new Edge(1, RED, WHITE)));
        assertTrue(cube.getEdgeAtIndex(10).equals(new Edge(3, WHITE, ORANGE)));
        assertTrue(cube.getEdgeAtIndex(11).equals(new Edge(2, WHITE, GREEN)));
    }

    /**
     *  Helper methods
     */

    private boolean checkSolvedPieces(Cube cube, ArrayList<Corner> unsolvedCorners, ArrayList<Edge> unsolvedEdges) {
        ArrayList<Corner> corners = cube.getCorners();
        ArrayList<Edge> edges = cube.getEdges();
        Cube solvedCube = new Cube();
        ArrayList<Corner> solvedCorners = solvedCube.getCorners();
        ArrayList<Edge> solvedEdges = solvedCube.getEdges();

        boolean result = true;

        for (int i = 0; i < 8; i++) {
            Corner temp = corners.get(i);
            if (!unsolvedCorners.contains(temp)) result = result && temp.equals(solvedCorners.get(i));
        }

        for (int i = 0; i < 12; i ++) {
            Edge temp = edges.get(i);
            if (!unsolvedEdges.contains(temp)) result = result && temp.equals(solvedEdges.get(i));
        }

        return result;
    }
}
