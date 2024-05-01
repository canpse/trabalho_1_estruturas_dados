package lucas.trabalho_1.data_structures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class QueueFifoTest {
    
    public QueueFifoTest() {
    }

    /**
     * Test of push method, of class QueueFifo.
     */
    @Test
    public void testPush() {
        QueueFifo<Integer> q = new QueueFifo<>();
        q.push(0);
        assertEquals(0, q.peek());
        q.push(1);
        assertEquals(0, q.peek());
        q.push(2);
        assertEquals(0, q.peek());
        assertEquals(3, q.size());
    }

    /**
     * Test of pop method, of class QueueFifo.
     */
    @Test
    public void testPop() {
        QueueFifo<Integer> q = new QueueFifo<>();
        q.push(0);
        q.push(1);
        q.push(2);
        q.push(3);
        assertEquals(0, q.peek());
        assertEquals(0, q.pop());
        assertEquals(1, q.peek());
        assertEquals(1, q.pop());
        assertEquals(2, q.peek());
        assertEquals(2, q.pop());
        assertEquals(1, q.size());
        assertEquals(3, q.peek());
        assertEquals(3, q.pop());
        assertEquals(null, q.peek());
        assertEquals(0, q.size());
    }

    /**
     * Test of peek method, of class QueueFifo.
     */
    @Test
    public void testPeek() {
    }
    
}
