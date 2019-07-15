package ainesh1998;

public class Corner extends Piece {

    Colour firstColour;
    Colour secondColour;
    Colour thirdColour;

    public Corner(int position, Colour firstColour, Colour secondColour, Colour thirdColour) {
        if (firstColour == secondColour && secondColour == thirdColour) throw new IllegalArgumentException();

        this.firstColour = firstColour;
        this.secondColour = secondColour;
        this.thirdColour = thirdColour;
//        this.currentPosition = position;
        this.originalPosition = position;
    }

    public void twistClockwise() {
        Colour temp = firstColour;
        firstColour = thirdColour;
        thirdColour = secondColour;
        secondColour = temp;
    }

    public void twistAntiClockwise() {
        Colour temp = firstColour;
        firstColour = secondColour;
        secondColour = thirdColour;
        thirdColour = temp;
    }
}
