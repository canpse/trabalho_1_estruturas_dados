package lucas.trabalho_1.data_structures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class LinkedListTest {
    
    public LinkedListTest() {
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
     * Test of insertAtEnd method, of class SinglyLinkedList.
     */
    @Test
    public void testInsertAtEnd() {
        SinglyLinkedList<Integer> lk = new SinglyLinkedList<>();
        
    }

    /**
     * Test of insertAtIndex method, of class SinglyLinkedList.
     */
    @Test
    public void testInsertAtIndex() {
    }

    /**
     * Test of deleteAtBeginning method, of class SinglyLinkedList.
     */
    @Test
    public void testDeleteAtBeginning() {
    }

    /**
     * Test of deleteAtEnd method, of class SinglyLinkedList.
     */
    @Test
    public void testDeleteAtEnd() {
    }

    /**
     * Test of deleteAtIndex method, of class SinglyLinkedList.
     */
    @Test
    public void testDeleteAtIndex() {
    }

    /**
     * Test of deleteByValue method, of class SinglyLinkedList.
     */
    @Test
    public void testDeleteByValue() {
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
    }

    /**
     * Test of getAt method, of class SinglyLinkedList.
     */
    @Test
    public void testGetAt() {
    }

    /**
     * Test of contains method, of class SinglyLinkedList.
     */
    @Test
    public void testContains() {
    }

    /**
     * Test of indexOf method, of class SinglyLinkedList.
     */
    @Test
    public void testIndexOf() {
    }

    public class LinkedListImpl extends SinglyLinkedList {
    }
    
}
