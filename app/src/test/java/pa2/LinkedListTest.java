package pa2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAdd() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.traverse());
    }

    @Test
    void testRemove() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals("1 3 ", list.traverse());
    }

    @Test
    void testTraverse(){
        LinkedList list = new LinkedList(); 
        assertEquals("", list.reverse());
        list.add(1);
        assertEquals("1 ", list.reverse());
        list.add(3);
        list.add(2);
        assertEquals("3 2 1 ", list.reverse());
    }

    @Test
    void testReverse() {
        LinkedList list = new LinkedList();

        assertEquals("", list.reverse());
        list.add(1);
        list.add(3);
        list.add(2);
        assertEquals("1 2 3 ", list.traverse());
    }

    @Test
    void testMerge() {
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        LinkedList list2 = new LinkedList();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        LinkedList mergedList = LinkedList.merge(list1, list2);
        assertEquals("1 2 3 4 5 6 ", mergedList.traverse());
    }
}