package ainesh1998;

public class Edge extends Piece {

    Colour firstColour;
    Colour secondColour;

    public Edge(int position, Colour firstColour, Colour secondColour) {
        if (firstColour == secondColour) throw new IllegalArgumentException();

        this.firstColour = firstColour;
        this.secondColour = secondColour;
//        this.currentPosition = position;
        this.originalPosition = position;
    }

    public Edge flip() {
        Colour temp = firstColour;
        firstColour = secondColour;
        secondColour = temp;
        return this;
    }
}
