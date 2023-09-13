package stack;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestParenthesesValidator {
    @Test
    public void testIsValid() {
        assertTrue(ParenthesesValidator.isValid("([{}])"));
        assertTrue(ParenthesesValidator.isValid("()[]{}"));
        assertTrue(ParenthesesValidator.isValid("()"));

        assertFalse(ParenthesesValidator.isValid("[)"));
        assertFalse(ParenthesesValidator.isValid(")("));
        assertFalse(ParenthesesValidator.isValid("([)]"));
        assertFalse(ParenthesesValidator.isValid("([]"));
        assertFalse(ParenthesesValidator.isValid("("));
        assertFalse(ParenthesesValidator.isValid("]"));
    }
}
