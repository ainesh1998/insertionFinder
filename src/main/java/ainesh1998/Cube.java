package ainesh1998;

import java.util.ArrayList;
import java.util.Arrays;

public class Cube {

    ArrayList<Piece> pieces;
    ArrayList<Corner> corners;
    ArrayList<Edge> edges;

    public Cube() {
        //Initialise Edges
        Edge WB = new Edge(0, Colour.WHITE, Colour.BLUE);
        Edge WR = new Edge(1, Colour.WHITE, Colour.RED);
        Edge WG = new Edge(2, Colour.WHITE, Colour.GREEN);
        Edge WO = new Edge(3, Colour.WHITE, Colour.ORANGE);
        Edge BO = new Edge(4, Colour.BLUE, Colour.ORANGE);
        Edge BR = new Edge(5, Colour.BLUE, Colour.RED);
        Edge GR = new Edge(6, Colour.GREEN, Colour.RED);
        Edge GO = new Edge(7, Colour.GREEN, Colour.ORANGE);
        Edge YB = new Edge(8, Colour.YELLOW, Colour.BLUE);
        Edge YR = new Edge(9, Colour.YELLOW, Colour.RED);
        Edge YG = new Edge(10, Colour.YELLOW, Colour.GREEN);
        Edge YO = new Edge(11, Colour.YELLOW, Colour.ORANGE);

        // Initialise corners
        Corner WOB = new Corner(0, Colour.WHITE, Colour.ORANGE, Colour.BLUE);
        Corner WBR = new Corner(1, Colour.WHITE, Colour.BLUE, Colour.RED);
        Corner WRG = new Corner(2, Colour.WHITE, Colour.RED, Colour.GREEN);
        Corner WGO = new Corner(3, Colour.WHITE, Colour.GREEN, Colour.ORANGE);
        Corner YBO = new Corner(4, Colour.YELLOW, Colour.BLUE, Colour.ORANGE);
        Corner YRB = new Corner(5, Colour.YELLOW, Colour.RED, Colour.BLUE);
        Corner YGR = new Corner(6, Colour.YELLOW, Colour.GREEN, Colour.RED);
        Corner YOG = new Corner(7, Colour.YELLOW, Colour.ORANGE, Colour.GREEN);

        pieces = new ArrayList<>(Arrays.asList(WOB, WB, WBR, WR, WRG, WG, WGO, WO, BO, BR, GR, GO, YBO, YB, YRB, YR, YGR, YG, YOG, YO));

        corners = new ArrayList<>(Arrays.asList(WOB, WBR, WRG, WGO, YBO, YRB, YGR, YOG));
        edges = new ArrayList<>(Arrays.asList(WB, WR, WG, WO, BO, BR, GR, GO, YB, YR, YG, YO));
    }

    public void applyMoves(ArrayList<Move> moves) {

    }

    /** Methods that handle each move **/

    private void up(int degree) {

        // U
        if (degree == 1) {
            // Handle corners
            Corner newUBL = corners.remove(3);
            corners.add(0, newUBL);

            // Handle edges
            Edge newUB = edges.remove(3);
            edges.add(0, newUB);
        }

        // U'
        else if (degree == 3) {
            // Handle corners
            Corner newUFL = corners.remove(0);
            corners.add(3, newUFL);

            // Handle edges
            Edge newUL = edges.remove(0);
            edges.add(3, newUL);
        }

        // U2
        else if (degree == 2) {
            // Handle corners
            swapCorners(0, 2);
            swapCorners(1, 3);

            // Handle edges
            swapEdges(0, 2);
            swapEdges(1, 3);
        }
    }

    private void down(int degree) {

        // D
        if (degree == 1) {
            // Handle corners
            Corner newDFL = corners.remove(4);
            corners.add(7, newDFL);

            // Handle edges
            Edge newDL = edges.remove(8);
            edges.add(11, newDL);
        }

        // D'
        else if (degree == 3) {
            // Handle corners
            Corner newDBL = corners.remove(7);
            corners.add(4, newDBL);

            // Handle edges
            Edge newDB = edges.remove(11);
            edges.add(8, newDB);
        }

        // D2
        else if (degree == 2) {
            // Handle corners
            swapCorners(4, 6);
            swapCorners(5, 7);

            // Handle edges
            swapEdges(8, 10);
            swapEdges(9, 11);
        }
    }

    private void left(int degree) {

        // L
        if (degree == 1) {
            // Handle corners
            singleMovesCorners(0, 3, 7, 4);

            // Handle edges
            singleMovesEdges(3, 7, 11, 4, false);
        }

        // L'
        else if (degree == 3) {
            // Handle corners
            singleMovesCorners(0, 4, 7, 3);

            // Handle edges
            singleMovesEdges(3, 4, 11, 7, false);
        }

        // L2
        else if (degree == 2) {
            // Handle corners
            swapCorners(0, 7);
            swapCorners(3, 4);

            // Handle edges
            swapEdges(3, 11);
            swapEdges(4, 7);
        }
    }

    private void right(int degree) {

        // R
        if (degree == 1) {
            // Handle corners
            singleMovesCorners(2, 1, 5, 6);

            // Handle edges
            singleMovesEdges(1, 5, 9, 6, false);
        }

        // R'
        else if (degree == 3) {
            // Handle corners
            singleMovesCorners(2, 6, 5, 1);

            // Handle edges
            singleMovesEdges(1, 6, 9, 5, false);
        }

        // R2
        else if (degree == 2) {
            // Handle corners
            swapCorners(1, 6);
            swapCorners(2, 5);

            // Handle edges
            swapEdges(1, 9);
            swapEdges(5, 6);
        }
    }

    private void front(int degree) {

        // F
        if (degree == 1) {
            // Handle corners
            singleMovesCorners(3, 2, 6, 7);

            // Handle edges
            singleMovesEdges(2, 6, 10,7, true);
        }

        // F'
        else if (degree == 3) {
            // Handle corners
            singleMovesCorners(3, 7, 6, 2);

            // Handle edges
            singleMovesEdges(2, 7, 10, 6, true);
        }

        // F2
        else if (degree == 2) {
            // Handle corners
            swapCorners(2, 7);
            swapCorners(3, 6);

            // Handle edges
            swapEdges(2, 10);
            swapEdges(6, 7);
        }
    }

    private void back(int degree) {

        // B
        if (degree == 1) {
            // Handle corners
            singleMovesCorners(1, 0, 4, 5);

            // Handle edges
            singleMovesEdges(0, 4, 8, 5, true);
        }

        // B'
        else if (degree == 3) {
            // Handle corners
            singleMovesCorners(1, 5, 4, 0);

            // Handle edges
            singleMovesEdges(0, 5, 8, 4, true);
        }

        // B2
        else if (degree == 2) {
            // Handle corners
            swapCorners(0, 5);
            swapCorners(1, 4);

            // Handle edges
            swapEdges(0, 8);
            swapEdges(4, 5);
        }
    }

    /** Helper methods **/

    private void swapCorners(int firstIndex, int secondIndex) {
        Corner temp = corners.get(firstIndex);
        corners.set(firstIndex, corners.get(secondIndex));
        corners.set(secondIndex, temp);
    }

    private void swapEdges(int firstIndex, int secondIndex) {
        Edge temp = edges.get(firstIndex);
        edges.set(firstIndex, edges.get(secondIndex));
        edges.set(secondIndex, temp);
    }

    private void singleMovesCorners(int firstIndex, int secondIndex, int thirdIndex, int fourthIndex) {
        // firstIndex is the top left on that face. cycle is as such: first -> second -> third -> fourth

        Corner first = corners.get(firstIndex).twistAntiClockwise();
        Corner second = corners.get(secondIndex).twistClockwise();
        Corner third = corners.get(thirdIndex).twistAntiClockwise();
        Corner fourth = corners.get(fourthIndex).twistClockwise();

        corners.set(secondIndex, first);
        corners.set(thirdIndex, second);
        corners.set(fourthIndex, third);
        corners.set(firstIndex, fourth);
    }

    private void singleMovesEdges(int firstIndex, int secondIndex, int thirdIndex, int fourthIndex, boolean twist) {
        Edge temp = edges.get(firstIndex);

        if (twist) {
            edges.set(firstIndex, edges.get(fourthIndex).flip());
            edges.set(fourthIndex, edges.get(thirdIndex).flip());
            edges.set(thirdIndex, edges.get(secondIndex)).flip();
            edges.set(secondIndex, temp.flip());
        }
        else {
            edges.set(firstIndex, edges.get(fourthIndex));
            edges.set(fourthIndex, edges.get(thirdIndex));
            edges.set(thirdIndex, edges.get(secondIndex));
            edges.set(secondIndex, temp);
        }
    }
}
