package lucas.trabalho_1.data_structures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class SinglyLinkedListTest {
    
    public SinglyLinkedListTest() {
    }

    /**
     * Test of insertAtBeginning method, of class SinglyLinkedList.
     */
    @Test
    public void testInsertAtBeginning() {
    
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        lk.insertAtBeginning(1);
        assertEquals(lk.head(), 1);
        lk.insertAtBeginning(2);
        assertEquals(lk.head(), 2);
    
    }

    /**
     * Test of getTailNode method, of class SinglyLinkedList.
     */
    @Test
    public void testGetTailNode() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        assertEquals(null, lk.getTailNode());
        lk.insertAtEnd(1);
        assertEquals(1, lk.getTailNode().data());
        lk.insertAtEnd(2);
        assertEquals(2, lk.getTailNode().data());
    } 
    
    /**
     * Test of insertAtEnd method, of class SinglyLinkedList.
     */
    @Test
    public void testInsertAtEnd() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        assertEquals(null, lk.getTailNode());
        lk.insertAtEnd(1);
        assertEquals(1, lk.getTailNode().data());
        lk.insertAtEnd(2);
        assertEquals(2, lk.getTailNode().data());
    }

    /**
     * Test of insertAtIndex method, of class SinglyLinkedList.
     */
    @Test
    public void testInsertAtIndex() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        lk.insertAtEnd(0);
        lk.insertAtEnd(1);
        lk.insertAtEnd(2);
        lk.insertAtEnd(3);
        lk.insertAtEnd(4);
        lk.insertAtIndex(5, 3);
        lk.insertAtIndex(6, 5);
        assertEquals(3, lk.indexOf(5));
        assertEquals(6, lk.indexOf(6));
    }

    /**
     * Test of deleteAtBeginning method, of class SinglyLinkedList.
     */
    @Test
    public void testDeleteAtBeginning() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        lk.insertAtEnd(0);
        lk.insertAtEnd(1);
        lk.insertAtEnd(2);
        lk.insertAtEnd(3);
        lk.insertAtEnd(4);
        lk.deleteAtBeginning();
        assertEquals(4, lk.size());
        assertEquals(1, lk.head.data());
    }

    /**
     * Test of deleteAtEnd method, of class SinglyLinkedList.
     */
    @Test
    public void testDeleteAtEnd() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        lk.insertAtEnd(0);
        lk.insertAtEnd(1);
        lk.insertAtEnd(2);
        lk.insertAtEnd(3);
        lk.insertAtEnd(4);
        lk.deleteAtEnd();
        assertEquals(4, lk.size());
        assertEquals(3, lk.getTailNode().data());
        lk.deleteAtEnd();
        assertEquals(3, lk.size());
        assertEquals(2, lk.getTailNode().data());
    }

    /**
     * Test of deleteAtIndex method, of class SinglyLinkedList.
     */
    @Test
    public void testDeleteAtIndex() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        lk.insertAtEnd(0);
        lk.insertAtEnd(1);
        lk.insertAtEnd(2);
        lk.insertAtEnd(3);
        lk.insertAtEnd(4);
        lk.insertAtEnd(5);
        lk.deleteAtIndex(2);
        assertEquals(5, lk.size());
        assertEquals(3, lk.getAt(2));
    }

    /**
     * Test of deleteByValue method, of class SinglyLinkedList.
     */
    @Test
    public void testDeleteByValue() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        lk.insertAtEnd(0);
        lk.insertAtEnd(1);
        lk.insertAtEnd(2);
        lk.insertAtEnd(3);
        lk.insertAtEnd(4);
        lk.insertAtEnd(5);
        assertEquals(true, lk.contains(2));
        assertEquals(true, lk.contains(0));
        assertEquals(true, lk.contains(5));
        lk.deleteByValue(2);
        lk.deleteByValue(0);
        lk.deleteByValue(5);
        assertEquals(3, lk.size());
        assertEquals(false, lk.contains(2));
        assertEquals(false, lk.contains(0));
        assertEquals(false, lk.contains(5));
    }

    /**
     * Test of toString method, of class SinglyLinkedList.
     */
    @Test
    public void testToString() {
    }

    /**
     * Test of empty method, of class SinglyLinkedList.
     */
    @Test
    public void testEmpty() {
    }

    /**
     * Test of size method, of class SinglyLinkedList.
     */
    @Test
    public void testSize() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        assertEquals(0, lk.size());
        lk.insertAtEnd(1);
        assertEquals(1, lk.size());
        lk.insertAtEnd(2);
        assertEquals(2, lk.size());
    }

    /**
     * Test of getAt method, of class SinglyLinkedList.
     */
    @Test
    public void testGetAt() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        lk.insertAtEnd(0);
        lk.insertAtEnd(1);
        lk.insertAtEnd(2);
        lk.insertAtEnd(3);
        lk.insertAtEnd(4);
        lk.insertAtEnd(5);
        assertEquals(0, lk.getAt(0));
        assertEquals(1, lk.getAt(1));
        assertEquals(2, lk.getAt(2));
        assertEquals(3, lk.getAt(3));
        assertEquals(4, lk.getAt(4));
        assertEquals(5, lk.getAt(5));
    }

    /**
     * Test of contains method, of class SinglyLinkedList.
     */
    @Test
    public void testContains() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        lk.insertAtEnd(0);
        lk.insertAtEnd(1);
        lk.insertAtEnd(2);
        lk.insertAtEnd(3);
        lk.insertAtEnd(4);
        lk.insertAtEnd(5);
        assertEquals(true, lk.contains(0));
        assertEquals(true, lk.contains(3));
        assertEquals(true, lk.contains(5));
        assertEquals(false, lk.contains(6));
    }

    /**
     * Test of indexOf method, of class SinglyLinkedList.
     */
    @Test
    public void testIndexOf() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertEquals(null, list.indexOf(1));
        list.insertAtBeginning(1);
        assertEquals(0, list.indexOf(1));
        list.insertAtBeginning(2);
        assertEquals(1, list.indexOf(1));
        list.insertAtBeginning(3);
        assertEquals(2, list.indexOf(1));
        list.insertAtBeginning(4);
        assertEquals(3, list.indexOf(1));
    }

    public class LinkedListImpl extends SinglyLinkedList {
    }

    /**
     * Test of head method, of class SinglyLinkedList.
     */
    @Test
    public void testHead() {
    }

    
    
}
