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
            Corner newUFR = corners.remove(0);
            Corner newUFL = corners.remove(1);
            corners.add(2, newUFR);
            corners.add(3, newUFL);

            // Handle edges
            Edge newUF = edges.remove(0);
            Edge newUL = edges.remove(1);
            edges.add(2, newUF);
            edges.add(3, newUL);
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
            Corner newDFR = corners.remove(4);
            Corner newDFL = corners.remove(5);
            corners.add(2, newDFR);
            corners.add(3, newDFL);

            // Handle edges
            Edge newDF = edges.remove(8);
            Edge newDL = edges.remove(9);
            edges.add(10, newDF);
            edges.add(11, newDL);
        }
    }

    private void left(int degree) {

        // L
        if (degree == 1) {
            // Handle corners
            Corner newFLU = corners.get(0);
            newFLU.twistClockwise();

            Corner newDLF = corners.get(3);
            newDLF.twistAntiClockwise();

            Corner newBLD = corners.get(7);
            newBLD.twistClockwise();

            Corner newUBL = corners.get(4);
            newUBL.twistAntiClockwise();

            corners.set(0, newUBL);
            corners.set(3, newFLU);
            corners.set(7, newDLF);
            corners.set(4, newBLD);

            // Handle edges
            Edge newFL = edges.get(3);

            edges.set(3, edges.get(4));
            edges.set(4, edges.get(11));
            edges.set(11, edges.get(7));
            edges.set(7, newFL);
        }

        // L'
        else if (degree == 3) {
            // Handle corners
            Corner newBLD = corners.get(0);
            newBLD.twistClockwise();

            Corner newDLF = corners.get(4);
            newDLF.twistAntiClockwise();

            Corner newFLU = corners.get(7);
            newFLU.twistClockwise();

            Corner newUBL = corners.get(3);
            newUBL.twistAntiClockwise();

            corners.set(0, newUBL);
            corners.set(3, newFLU);
            corners.set(7, newDLF);
            corners.set(4, newBLD);

            // Handle edges
            Edge newFL = edges.get(11);

            edges.set(11, edges.get(4));
            edges.set(4, edges.get(3));
            edges.set(3, edges.get(7));
            edges.set(7, newFL);
        }

        // L2
        else if (degree == 2) {
            // Handle corners
            Corner newDFL = corners.get(0);
            Corner newDBL = corners.get(3);

            corners.set(0, corners.get(7));
            corners.set(7, newDFL);
            corners.set(3, corners.get(4));
            corners.set(4, newDBL);

            // Handle edges
            Edge newDL = edges.get(3);
            Edge newFL = edges.get(4);

            edges.set(3, edges.get(11));
            edges.set(11, newDL);
            edges.set(4, edges.get(7));
            edges.set(7, newFL);
        }
    }

    private void right(int degree) {

        // R
        if (degree == 1) {
            // Handle corners
            Corner newBRD = corners.get(1);
            newBRD.twistAntiClockwise();

            Corner newDFR = corners.get(5);
            newDFR.twistClockwise();

            Corner newFRU = corners.get(6);
            newFRU.twistAntiClockwise();

            Corner newUBR = corners.get(2);
            newUBR.twistClockwise();

            corners.set(1, newUBR);
            corners.set(5, newBRD);
            corners.set(6, newDFR);
            corners.set(2, newFRU);

            // Handle edges
            Edge newFR = edges.get(9);

            edges.set(9, edges.get(5));
            edges.set(5, edges.get(1));
            edges.set(1, edges.get(6));
            edges.set(6, newFR);
        }

        // R'
        else if (degree == 3) {
            // Handle corners
            Corner newFRU = corners.get(1);
            newFRU.twistAntiClockwise();

            Corner newDRF = corners.get(2);
            newDRF.twistClockwise();

            Corner newBRD = corners.get(6);
            newBRD.twistAntiClockwise();

            Corner newUBR = corners.get(5);
            newUBR.twistClockwise();

            corners.set(1, newUBR);
            corners.set(2, newFRU);
            corners.set(6, newDRF);
            corners.set(5, newBRD);

            // Handle edges
            Edge newFR = edges.get(1);

            edges.set(1, edges.get(5));
            edges.set(5, edges.get(9));
            edges.set(9, edges.get(6));
            edges.set(6, newFR);
        }

        // R2
        else if (degree == 2) {
            // Handle corners
            Corner newDFR = corners.get(1);
            Corner newDBR = corners.get(2);

            corners.set(1, corners.get(6));
            corners.set(6, newDFR);
            corners.set(2, corners.get(5));
            corners.set(5, newDBR);

            // Handle edges
            Edge newDR = edges.get(1);
            Edge newFR = edges.get(5);

            edges.set(1, edges.get(9));
            edges.set(9, newDR);
            edges.set(5, edges.get(6));
            edges.set(6, newFR);
        }
    }

    private void front(int degree) {

        // F
        if (degree == 1) {
            // Handle corners
            Corner newRUF = corners.get(3);
            newRUF.twistClockwise();

            Corner newDRF = corners.get(2);
            newDRF.twistAntiClockwise();

            Corner newLFD = corners.get(6);
            newLFD.twistClockwise();

            Corner newUFL = corners.get(7);
            newUFL.twistAntiClockwise();

            corners.set(2, newRUF);
            corners.set(6, newDRF);
            corners.set(7, newLFD);
            corners.set(3, newUFL);

            // Handle edges
            Edge newRF = edges.get(2);
            newRF.flip();

            Edge newDF = edges.get(6);
            newDF.flip();

            Edge newLF = edges.get(10);
            newLF.flip();

            Edge newUF = edges.get(7);
            newUF.flip();

            edges.set(6, newRF);
            edges.set(10, newDF);
            edges.set(7, newLF);
            edges.set(2, newUF);
        }

        // F'
        else if (degree == 3) {
            // Handle corners
            Corner newLFD = corners.get(3);
            newLFD.twistClockwise();

            Corner newDRF = corners.get(7);
            newDRF.twistAntiClockwise();

            Corner newRUF = corners.get(6);
            newRUF.twistClockwise();

            Corner newUFL = corners.get(2);
            newUFL.twistAntiClockwise();

            corners.set(2, newRUF);
            corners.set(6, newDRF);
            corners.set(7, newLFD);
            corners.set(3, newUFL);

            // Handle edges
            Edge newLF = edges.get(2);
            newLF.flip();

            Edge newDF = edges.get(7);
            newDF.flip();

            Edge newRF = edges.get(10);
            newRF.flip();

            Edge newUF = edges.get(6);
            newUF.flip();

            edges.set(6, newRF);
            edges.set(10, newDF);
            edges.set(7, newLF);
            edges.set(2, newUF);
        }

        // F2
        else if (degree == 2) {
            // Handle corners
            Corner newDFL = corners.get(2);
            Corner newDFR = corners.get(3);

            corners.set(2, corners.get(7));
            corners.set(7, newDFL);
            corners.set(3, corners.get(6));
            corners.set(6, newDFR);

            // Handle edges
            Edge newDF = edges.get(2);
            Edge newFL = edges.get(6);

            edges.set(2, edges.get(10));
            edges.set(10, newDF);
            edges.set(6, edges.get(7));
            edges.set(7, newFL);
        }
    }

    private void back(int degree) {

        // B
        if (degree == 1) {
            // Handle corners
            Corner newLBD = corners.get(0);
            newLBD.twistAntiClockwise();

            Corner newDRB = corners.get(4);
            newDRB.twistClockwise();

            Corner newRUB = corners.get(5);
            newRUB.twistAntiClockwise();

            Corner newUBL = corners.get(1);
            newUBL.twistClockwise();

            corners.set(1, newRUB);
            corners.set(4, newDRB);
            corners.set(4, newLBD);
            corners.set(0, newUBL);

            // Handle edges
            Edge newLB = edges.get(0);
            newLB.flip();

            Edge newDB = edges.get(4);
            newDB.flip();

            Edge newRB = edges.get(8);
            newRB.flip();

            Edge newUB = edges.get(5);
            newUB.flip();

            edges.set(5, newRB);
            edges.set(8, newDB);
            edges.set(4, newLB);
            edges.set(0, newUB);
        }

        // B'
        else if (degree == 3) {
            Corner newRUB = corners.get(0);
            newRUB.twistAntiClockwise();

            Corner newDRB = corners.get(1);
            newDRB.twistClockwise();

            Corner newLBD = corners.get(5);
            newLBD.twistAntiClockwise();

            Corner newUBL = corners.get(4);
            newUBL.twistClockwise();

            corners.set(1, newRUB);
            corners.set(5, newDRB);
            corners.set(4, newLBD);
            corners.set(0, newUBL);

            // Handle edges
            Edge newRB = edges.get(0);
            newRB.flip();

            Edge newDB = edges.get(5);
            newDB.flip();

            Edge newLB = edges.get(8);
            newLB.flip();

            Edge newUB = edges.get(4);
            newUB.flip();

            edges.set(5, newRB);
            edges.set(8, newDB);
            edges.set(4, newLB);
            edges.set(0, newUB);
        }

        // B2
        else if (degree == 2) {
            // Handle corners
            Corner newDBR = corners.get(0);
            Corner newDBL = corners.get(1);

            corners.set(0, corners.get(5));
            corners.set(5, newDBR);
            corners.set(1, corners.get(4));
            corners.set(4, newDBL);

            // Handle edges
            Edge newDB = edges.get(0);
            Edge newBL = edges.get(5);

            edges.set(0, edges.get(8));
            edges.set(8, newDB);
            edges.set(5, edges.get(4));
            edges.set(4, newBL);
        }
    }
}
