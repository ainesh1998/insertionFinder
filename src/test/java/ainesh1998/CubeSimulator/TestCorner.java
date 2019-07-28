package ainesh1998.CubeSimulator;

import static org.junit.Assert.assertTrue;

import ainesh1998.CubeSimulator.Colour;
import ainesh1998.CubeSimulator.Corner;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestCorner {
    /**
     * Tests the Corner class.
     */

    @Test
    public void testTwistClockwise() {
        Corner corner = new Corner(2, Colour.WHITE, Colour.BLUE, Colour.RED);
        corner.twistClockwise();
        assertTrue(corner.firstColour == Colour.RED && corner.secondColour == Colour.WHITE && corner.thirdColour == Colour.BLUE);
    }

    @Test
    public void testTwistAntiClockwise() {
        Corner corner = new Corner(7, Colour.GREEN, Colour.YELLOW, Colour.ORANGE);
        corner.twistAntiClockwise();
        assertTrue(corner.firstColour == Colour.YELLOW && corner.secondColour == Colour.ORANGE && corner.thirdColour == Colour.GREEN);
    }
}
