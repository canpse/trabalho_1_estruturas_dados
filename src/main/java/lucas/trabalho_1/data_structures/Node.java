package lucas.trabalho_1.data_structures;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 * @param <T>
 */
public class Node<T> {
    
    private Node<T> next;
    private T data;
    
    public Node(T data) {
        this.data = data;
    }
    
    public Node<T> next() {
        return next;
    }
    
    public T data() {
        return data;
    }
    
    public void next(Node n) {
        next = n;
    } 
    
}
