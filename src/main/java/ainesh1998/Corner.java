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


}
