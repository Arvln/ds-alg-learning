package stack;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestExpressionCalculation {
    @Test
    public void testBackCalculation() {
        assertEquals(9, ExpressionCalculation.backCalculation(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, ExpressionCalculation.backCalculation(new String[]{"4", "13", "5", "/", "+"}));
    }
}
