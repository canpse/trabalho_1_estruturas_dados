package lucas.trabalho_1.data_structures;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 * @param <T>
 */
public class QueueFifo<T> {
    
    protected Node<T> head;
    protected Integer size = 0;
    
    public void push(T data) {
        size++;
        if (head != null) {
            Node<T> current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.next(new Node<>(data));
        } else {
            head = new Node<>(data);
        }
    }
    
    public T pop() {
        Node<T> popped = head;
        if (head != null) {
            head = head.next();
            size--;
            return popped.data();
        }
        return null;
    }
    
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data();
    }
    
    public Integer size() {
        return size;
    }
    
}
