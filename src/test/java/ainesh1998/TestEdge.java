package ainesh1998;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestEdge {
    /**
     * Tests the Edge class.
     */

    @Test
    public void testFlip() {
        Edge temp = new Edge(1, Colour.WHITE, Colour.RED);
        temp.flip();
        assertTrue(temp.firstColour == Colour.RED);
        assertTrue(temp.secondColour == Colour.WHITE);
    }
}
