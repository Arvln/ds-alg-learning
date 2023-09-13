package single_linked_list.list_manipulation;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestListManipulation {
    @Test
    public void testReverseList() {
        Node o5 = new Node(5, null);
        Node o4 = new Node(4, o5);
        Node o3 = new Node(3, o4);
        Node o2 = new Node(2, o3);
        Node o1 = new Node(1, o2);

        assertEquals("[1, 2, 3, 4, 5]", Node.toString(o1));
        Node r1 = LinkedList.reverse1(o1);
        assertEquals("[5, 4, 3, 2, 1]", Node.toString(r1));
        assertEquals("[]", Node.toString(LinkedList.reverse1(null)));
        Node r2 = LinkedList.reverse2(o1);
        assertEquals("[5, 4, 3, 2, 1]", Node.toString(r2));
        assertEquals("[]", Node.toString(LinkedList.reverse2(null)));
    }

    @Test
    public void testDelete() {
        Node o5 = new Node(6, null);
        Node o4 = new Node(3, o5);
        Node o3 = new Node(6, o4);
        Node o2 = new Node(2, o3);
        Node o1 = new Node(1, o2);

        assertEquals("[1, 2, 6, 3, 6]", Node.toString(o1));
        assertEquals("[1, 2, 3]", Node.toString(LinkedList.delete1(o1, 6)));
        assertEquals("[]", Node.toString(LinkedList.delete1(null, 1)));
        assertEquals("[1, 2, 3]", Node.toString(LinkedList.delete2(o1, 6)));
        assertEquals("[]", Node.toString(LinkedList.delete2(null, 1)));

        Node n4 = new Node(7, null);
        Node n3 = new Node(7, n4);
        Node n2 = new Node(7, n3);
        Node n1 = new Node(7, n2);

        assertEquals("[]", Node.toString(LinkedList.delete1(n1, 7)));
        assertEquals("[]", Node.toString(LinkedList.delete2(n1, 7)));
    }

    @Test
    public void testDeleteLast() {
        Node o5 = new Node(5, null);
        Node o4 = new Node(4, o5);
        Node o3 = new Node(3, o4);
        Node o2 = new Node(2, o3);
        Node o1 = new Node(1, o2);

        assertEquals("[1, 2, 3, 5]", Node.toString(LinkedList.deleteLast1(o1, 2)));
        assertEquals("[]", Node.toString(LinkedList.deleteLast1(new Node(1, null), 1)));
        assertEquals("[1]", Node.toString(LinkedList.deleteLast1(new Node(1, new Node(2, null)), 1)));

        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        assertEquals("[1, 2, 3, 5]", Node.toString(LinkedList.deleteLast2(n1, 2)));
        assertEquals("[]", Node.toString(LinkedList.deleteLast2(new Node(1, null), 1)));
        assertEquals("[1]", Node.toString(LinkedList.deleteLast2(new Node(1, new Node(2, null)), 1)));
    }

    @Test
    public void testDeleteDuplicate() {
        Node o3 = new Node(2, null);
        Node o2 = new Node(1, o3);
        Node o1 = new Node(1, o2);

        assertEquals("[1, 2]", Node.toString(LinkedList.deleteDuplicate1(o1)));

        Node r3 = new Node(2, null);
        Node r2 = new Node(1, r3);
        Node r1 = new Node(1, r2);

        assertEquals("[1, 2]", Node.toString(LinkedList.deleteDuplicate2(r1)));

        Node n5 = new Node(3, null);
        Node n4 = new Node(3, n5);
        Node n3 = new Node(2, n4);
        Node n2 = new Node(1, n3);
        Node n1 = new Node(1, n2);

        assertEquals("[1, 2, 3]", Node.toString(LinkedList.deleteDuplicate1(n1)));

        Node nr5 = new Node(3, null);
        Node nr4 = new Node(3, nr5);
        Node nr3 = new Node(2, nr4);
        Node nr2 = new Node(1, nr3);
        Node nr1 = new Node(1, nr2);

        assertEquals("[1, 2, 3]", Node.toString(LinkedList.deleteDuplicate2(nr1)));
    }

    @Test
    public void testDeleteAllDuplicate() {
        Node o7 = new Node(5, null);
        Node o6 = new Node(4, o7);
        Node o5 = new Node(4, o6);
        Node o4 = new Node(3, o5);
        Node o3 = new Node(3, o4);
        Node o2 = new Node(2, o3);
        Node o1 = new Node(1, o2);

        assertEquals("[1, 2, 5]", Node.toString(LinkedList.deleteAllDuplicate1(o1)));

        Node r7 = new Node(5, null);
        Node r6 = new Node(4, r7);
        Node r5 = new Node(4, r6);
        Node r4 = new Node(3, r5);
        Node r3 = new Node(3, r4);
        Node r2 = new Node(2, r3);
        Node r1 = new Node(1, r2);

        assertEquals("[1, 2, 5]", Node.toString(LinkedList.deleteAllDuplicate2(r1)));

        Node n5 = new Node(3, null);
        Node n4 = new Node(2, n5);
        Node n3 = new Node(1, n4);
        Node n2 = new Node(1, n3);
        Node n1 = new Node(1, n2);

        assertEquals("[2, 3]", Node.toString(LinkedList.deleteAllDuplicate1(n1)));

        Node nr5 = new Node(3, null);
        Node nr4 = new Node(2, nr5);
        Node nr3 = new Node(1, nr4);
        Node nr2 = new Node(1, nr3);
        Node nr1 = new Node(1, nr2);

        assertEquals("[2, 3]", Node.toString(LinkedList.deleteAllDuplicate2(nr1)));
    }

    @Test
    public void testMerge() {
        Node o14 = new Node(3, null);
        Node o13 = new Node(2, o14);
        Node o12 = new Node(2, o13);
        Node o11 = new Node(1, o12);

        Node o25 = new Node(8, null);
        Node o24 = new Node(7, o25);
        Node o23 = new Node(3, o24);
        Node o22 = new Node(2, o23);
        Node o21 = new Node(2, o22);

        assertEquals("[]", Node.toString(LinkedList.merge1(null, null)));
        assertEquals("[1, 2, 2, 3]", Node.toString(LinkedList.merge1(o11, null)));
        assertEquals("[1, 2, 2, 2, 2, 3, 3, 7, 8]", Node.toString(LinkedList.merge1(o11, o21)));

        Node r14 = new Node(3, null);
        Node r13 = new Node(2, r14);
        Node r12 = new Node(2, r13);
        Node r11 = new Node(1, r12);

        Node r25 = new Node(8, null);
        Node r24 = new Node(7, r25);
        Node r23 = new Node(3, r24);
        Node r22 = new Node(2, r23);
        Node r21 = new Node(2, r22);

        assertEquals("[]", Node.toString(LinkedList.merge2(null, null)));
        assertEquals("[1, 2, 2, 3]", Node.toString(LinkedList.merge2(null, r11)));
        assertEquals("[1, 2, 2, 2, 2, 3, 3, 7, 8]", Node.toString(LinkedList.merge2(r11, r21)));
    }

    @Test
    public void testMergeAll1() {
        Node o13 = new Node(5, null);
        Node o12 = new Node(4, o13);
        Node o11 = new Node(1, o12);

        Node o23 = new Node(4, null);
        Node o22 = new Node(3, o23);
        Node o21 = new Node(1, o22);

        Node o32 = new Node(6, null);
        Node o31 = new Node(2, o32);

        Node o3 = new Node(o31, null);
        Node o2 = new Node(o21, o3);
        Node o1 = new Node(o11, o2);

        assertEquals("[1, 1, 2, 3, 4, 4, 5, 6]", Node.toString(LinkedList.mergeAll1(o1)));
    }

    @Test
    public void testMergeAll2() {
        Node o13 = new Node(5, null);
        Node o12 = new Node(4, o13);
        Node o11 = new Node(1, o12);

        Node o23 = new Node(4, null);
        Node o22 = new Node(3, o23);
        Node o21 = new Node(1, o22);

        Node o32 = new Node(6, null);
        Node o31 = new Node(2, o32);

        Node o3 = new Node(o31, null);
        Node o2 = new Node(o21, o3);
        Node o1 = new Node(o11, o2);

        assertEquals("[1, 1, 2, 3, 4, 4, 5, 6]", Node.toString(LinkedList.mergeAll2(o1)));
    }
}
