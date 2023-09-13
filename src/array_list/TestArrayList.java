package array_list;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayList {
    @Test
    public void testArrayList() throws Exception {
        ArrayList arrayList = new ArrayList();

        arrayList.addLast(1);
        arrayList.addLast(2);
        arrayList.addLast(4);
        arrayList.addLast(5);
        arrayList.put(2, 3);
        arrayList.put(5, 6);

        assertEquals(1, arrayList.get(0));
        assertEquals(2, arrayList.get(1));
        assertEquals(3, arrayList.get(2));
        assertEquals(4, arrayList.get(3));
        assertEquals(5, arrayList.get(4));
        assertEquals(6, arrayList.get(5));

        arrayList.put(6, 7);
        arrayList.put(7, 8);
        arrayList.put(8, 9);
        assertEquals(9, arrayList.size());
    }
}
