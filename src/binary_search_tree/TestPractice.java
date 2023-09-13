package binary_search_tree;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPractice {
    @Test
    public void testIsValidBST() {
        TreeNode validRoot = new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(6)
        );
        TreeNode inValidRoot1 = new TreeNode(
                5,
                new TreeNode(4),
                new TreeNode(
                        6,
                        new TreeNode(3),
                        new TreeNode(7)
                )
        );
        TreeNode inValidRoot2 = new TreeNode(
                1,
                new TreeNode(1),
                null
        );

        assertTrue(Practice.isValidBST1(validRoot));
        assertFalse(Practice.isValidBST1(inValidRoot1));
        assertFalse(Practice.isValidBST1(inValidRoot2));
        assertTrue(Practice.isValidBST2(validRoot));
        assertFalse(Practice.isValidBST2(inValidRoot1));
        assertFalse(Practice.isValidBST2(inValidRoot2));
        assertTrue(Practice.isValidBST3(validRoot));
        assertFalse(Practice.isValidBST3(inValidRoot1));
        assertFalse(Practice.isValidBST3(inValidRoot2));
    }
}
