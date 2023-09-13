package binary_tree;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPractice {
    @Test
    public void testIsSymmetryTree() {
        TreeNode tree1 = new TreeNode(
                new TreeNode(new TreeNode(
                        new TreeNode(5),
                        3,
                        new TreeNode(6)
                ), 2, new TreeNode(
                        new TreeNode(7),
                        4,
                        new TreeNode(8)
                )),
                1,
                new TreeNode(new TreeNode(
                        new TreeNode(8),
                        4,
                        new TreeNode(7)
                ), 2, new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(5)
                ))
        );
        TreeNode tree2 = new TreeNode(
                new TreeNode(new TreeNode(
                        new TreeNode(5),
                        3,
                        new TreeNode(6)
                ), 2, new TreeNode(
                        new TreeNode(7),
                        4,
                        new TreeNode(9)
                )),
                1,
                new TreeNode(new TreeNode(
                        new TreeNode(8),
                        4,
                        new TreeNode(7)
                ), 2, new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(5)
                ))
        );

        assertTrue(Practice.isSymmetryTree(tree1));
        assertFalse(Practice.isSymmetryTree(tree2));
    }

    @Test
    public void testMaxDepth() {
        TreeNode tree1 = new TreeNode(
                new TreeNode(new TreeNode(
                        new TreeNode(5),
                        3,
                        new TreeNode(6)
                ), 2, new TreeNode(
                        new TreeNode(7),
                        4,
                        new TreeNode(8)
                )),
                1,
                new TreeNode(new TreeNode(
                        new TreeNode(8),
                        4,
                        new TreeNode(7)
                ), 2, new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(5)
                ))
        );
        TreeNode tree2 = new TreeNode(
                new TreeNode(new TreeNode(
                        new TreeNode(5),
                        3,
                        new TreeNode(
                                new TreeNode(7),
                                6,
                                new TreeNode(8)
                        )
                ),
                        2,
                        new TreeNode(4)),
                1,
                new TreeNode(2)
        );
        TreeNode tree3 = new TreeNode(1);

        assertEquals(4, Practice.maxDepth1(tree1));
        assertEquals(5, Practice.maxDepth1(tree2));
        assertEquals(1, Practice.maxDepth1(tree3));
        assertEquals(0, Practice.maxDepth1(null));
        assertEquals(4, Practice.maxDepth2(tree1));
        assertEquals(5, Practice.maxDepth2(tree2));
        assertEquals(1, Practice.maxDepth2(tree3));
        assertEquals(0, Practice.maxDepth2(null));
        assertEquals(4, Practice.maxDepth3(tree1));
        assertEquals(5, Practice.maxDepth3(tree2));
        assertEquals(1, Practice.maxDepth3(tree3));
        assertEquals(0, Practice.maxDepth3(null));
    }

    @Test
    public void testMinDepth() {
        TreeNode tree1 = new TreeNode(
                new TreeNode(new TreeNode(
                        new TreeNode(5),
                        3,
                        new TreeNode(6)
                ), 2, new TreeNode(
                        new TreeNode(7),
                        4,
                        new TreeNode(8)
                )),
                1,
                null
        );
        TreeNode tree2 = new TreeNode(
                new TreeNode(new TreeNode(
                        new TreeNode(5),
                        3,
                        new TreeNode(
                                new TreeNode(7),
                                6,
                                new TreeNode(8)
                        )
                ),
                        2,
                        new TreeNode(4)),
                1,
                new TreeNode(2)
        );
        TreeNode tree3 = new TreeNode(1);

        assertEquals(4, Practice.minDepth(tree1));
        assertEquals(2, Practice.minDepth(tree2));
        assertEquals(1, Practice.minDepth(tree3));
        assertEquals(0, Practice.minDepth(null));
    }
}
