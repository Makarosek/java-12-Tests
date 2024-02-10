import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

public class JavaTest {

    @Test
    public void testNull(){
        String nullStr = null;
        assertThrows(
                NullPointerException.class,
                () -> Integer.decode(nullStr)
        );
    }

    @Test
    public void testZeroLength(){
        String emptyString = "";
        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(emptyString)
        );
    }

    @Test
    public void testOnlyNegativeSign(){
        String negative = "-";
        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(negative)
        );
    }

    @Test
    public void testNotANumber()
    {
        String nan = "asd";
        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(nan)
        );
    }

    @Test
    public void testChar()
    {
        String nan = "1234c123";
        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(nan)
        );
    }

    @Test
    public void testOverflow()
    {
        String lMax = String.valueOf((long)Integer.MAX_VALUE + 1);
        String lMin = String.valueOf((long)Integer.MIN_VALUE - 1);

        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(lMax)
        );

        assertThrows(
                NumberFormatException.class,
                () -> Integer.decode(lMin)
        );
    }

    @Test
    public void testPositiveNumber()
    {
        String number = "123";
        int res = Integer.decode(number);

        assertEquals(123, res);
    }

    @Test
    public void testNegativeNumber()
    {
        String number = "-123";
        int res = Integer.decode(number);

        assertEquals(-123, res);
    }
}
