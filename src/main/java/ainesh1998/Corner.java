package ainesh1998;

public class Corner extends Piece {

    Colour firstColour;
    Colour secondColour;
    Colour thirdColour;

    public Corner(int originalPosition, Colour firstColour, Colour secondColour, Colour thirdColour) {
        if (firstColour == secondColour && secondColour == thirdColour) throw new IllegalArgumentException();

        this.firstColour = firstColour;
        this.secondColour = secondColour;
        this.thirdColour = thirdColour;
//        this.currentPosition = position;
        this.originalPosition = originalPosition;
    }

    public Corner twistClockwise() {
        Colour temp = firstColour;
        firstColour = thirdColour;
        thirdColour = secondColour;
        secondColour = temp;
        return this;
    }

    public Corner twistAntiClockwise() {
        Colour temp = firstColour;
        firstColour = secondColour;
        secondColour = thirdColour;
        thirdColour = temp;
        return this;
    }

    public boolean equals(Corner corner) {
        return corner.originalPosition == this.originalPosition && corner.firstColour == this.firstColour && corner.secondColour == this.secondColour && corner.thirdColour == this.thirdColour;
    }
}
