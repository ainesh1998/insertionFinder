package ainesh1998;

import java.util.ArrayList;
import java.util.Arrays;

public class Cube {

    ArrayList<Piece> pieces;
    ArrayList<Corner> corners;
    ArrayList<Edge> edges;

    public Cube() {
        // Initialise edges
//        Edge WB = new Edge(1, Colour.WHITE, Colour.BLUE);
//        Edge WR = new Edge(3, Colour.WHITE, Colour.RED);
//        Edge WG = new Edge(5, Colour.WHITE, Colour.GREEN);
//        Edge WO = new Edge(7, Colour.WHITE, Colour.ORANGE);
//        Edge BO = new Edge(8, Colour.BLUE, Colour.ORANGE);
//        Edge BR = new Edge(9, Colour.BLUE, Colour.RED);
//        Edge GR = new Edge(10, Colour.GREEN, Colour.RED);
//        Edge GO = new Edge(11, Colour.GREEN, Colour.ORANGE);
//        Edge YB = new Edge(13, Colour.YELLOW, Colour.BLUE);
//        Edge YR = new Edge(15, Colour.YELLOW, Colour.RED);
//        Edge YG = new Edge(17, Colour.YELLOW, Colour.GREEN);
//        Edge YO = new Edge(19, Colour.YELLOW, Colour.ORANGE);
//
//        // Initialise corners
//        Corner WOB = new Corner(0, Colour.WHITE, Colour.ORANGE, Colour.BLUE);
//        Corner WBR = new Corner(2, Colour.WHITE, Colour.BLUE, Colour.RED);
//        Corner WRG = new Corner(4, Colour.WHITE, Colour.RED, Colour.GREEN);
//        Corner WGO = new Corner(6, Colour.WHITE, Colour.GREEN, Colour.ORANGE);
//        Corner YBO = new Corner(12, Colour.YELLOW, Colour.BLUE, Colour.ORANGE);
//        Corner YRB = new Corner(14, Colour.YELLOW, Colour.RED, Colour.BLUE);
//        Corner YGR = new Corner(16, Colour.YELLOW, Colour.GREEN, Colour.RED);
//        Corner YOG = new Corner(18, Colour.YELLOW, Colour.ORANGE, Colour.GREEN);

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
        if (degree == 1) {
            // Handle corners
            Corner newFirstCorner = corners.remove(3);
            corners.add(0, newFirstCorner);

            // Handle edges
            Edge newFirstEdge = edges.remove(3);
            edges.add(0, newFirstEdge);
        }

        else if (degree == 3) {
            // Handle corners
            Corner newLastCorner = corners.remove(0);
            corners.add(3, newLastCorner);

            // Handle edges
            Edge newLastEdge = edges.remove(0);
            edges.add(3, newLastEdge);
        }

        else {
            // Handle corners


            // Handle edges

        }
    }

    private void down(int degree) {

    }

    private void left(int degree) {

    }

    private void right(int degree) {

    }

    private void front(int degree) {

    }

    private void back(int degree) {

    }
}
