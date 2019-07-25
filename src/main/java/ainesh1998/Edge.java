package ainesh1998;

public class Edge extends Piece {

    Colour firstColour;
    Colour secondColour;
    final int originalPosition;

    public Edge(int originalPosition, Colour firstColour, Colour secondColour) {
        if (firstColour == secondColour) throw new IllegalArgumentException();

        this.firstColour = firstColour;
        this.secondColour = secondColour;
        this.originalPosition = originalPosition;
    }

    public Edge flip() {
        Colour temp = firstColour;
        firstColour = secondColour;
        secondColour = temp;
        return this;
    }

    public boolean equals(Edge edge) {
        return edge.originalPosition == this.originalPosition && edge.firstColour == this.firstColour && edge.secondColour == this.secondColour;
    }
}
