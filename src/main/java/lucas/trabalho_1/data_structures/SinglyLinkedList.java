package lucas.trabalho_1.data_structures;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 * @param <T>
 */
public class SinglyLinkedList<T> {

    Node<T> head;
    
    public T head() {
        return head.data();
    }
    
    public void insertAtBeginning(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node aux = head;
            head = new Node<>(data);
            head.next(aux);
        }
    }
    
    public void insertAtEnd(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node tail = getTailNode();
            tail.next(newNode);
        }
    }
    
    public void insertAtIndex(T data, int index) {
        if (index == 0) {
            insertAtBeginning(data);
        } else if (index == size() - 1) { 
            insertAtEnd(data);
        } else if (index <= size() - 1) {
            int currentIndex = 0;
            Node current = head;
            Node previous = null;
            while (currentIndex != index) {
                previous = current;
                current = current.next();
                currentIndex++;
            }
            Node<T> newNode = new Node<>(data);
            previous.next(newNode);
            newNode.next(current);
        }
    }
    
    public void deleteAtBeginning() {
        if (head != null) {
            if (head.next() != null) {
                head = head.next();
            } else {
                head = null;
            }
        }
    }
    
    public void deleteAtEnd() {
        Node newLastNode = getNodeAt(size() - 2);
        newLastNode.next(null);
    }
    
    public void deleteAtIndex(int index) {
        if (index == 0) {
            deleteAtBeginning();
        } else if (index == size() - 1) {
            deleteAtEnd();
        } else if (index <= size() - 1) {
            Node nodeBefore = getNodeAt(index - 1);
            Node nodeAfter = getNodeAt(index + 1);
            nodeBefore.next(nodeAfter);
        }
    }
    
    public void deleteByValue(T value) {
        if (contains(value)) {
            if (head.data().equals(value)) {
                if (head.next() == null) {
                    head = null;
                } else {
                    head = head.next();
                }
            } else if (getTailNode().data().equals(value)) {
                getNodeAt(size() - 2).next(null);
            } else {
                Node<T> currentNode = head.next();
                while (currentNode != null) {
                    if (currentNode.next().data().equals(value)) {
                        currentNode.next(currentNode.next().next());
                        break;
                    } else {
                        currentNode = currentNode.next();
                    }
                }
            }
        }
    }
    
    public boolean empty() {
        return head == null;
    }
    
    public int size() {
        int size = 0;
        if (head != null) {
            size++;
            Node aux = head;
            while(aux.next() != null) {
                aux = aux.next();
                size++;
            }
        }
        return size;
    }
    
    public T getAt(int index) {
        Node<T> nodeAtIndex = getNodeAt(index);
        if (nodeAtIndex == null) {
            return null;
        } else {
            return nodeAtIndex.data();
        }
    }
    
    public Node<T> getNodeAt(int index) {
        if (index == 0) {
            return head;
        } else if (index == size() - 1) {
            return getTailNode();
        } else if(index <= size() - 1) {
            Node current = head;
            int currentIndex = 0;
            while (currentIndex != index) {
                current = current.next();
                currentIndex++;
            }
            return current;
        }
        return null;
    }
    
    public boolean contains(T data) {
        Node<T> current = head;
        if (current != null) {
            if (current.data().equals(data)) {
                return true;
            }
            if (current.next() != null) {
                while (current != null) {
                    if (current.data().equals(data)) {
                        return true;
                    }
                    current = current.next();
                }
            }
        }
        return false;
    }
    
    public Integer indexOf(T data) {
        Node<T> current = head;
        Integer indexOf = null;
        if (current != null) {
            if (current.data().equals(data)) {
                indexOf = 0;
            } else {
                Integer currentIndex = 0;
                if (current.next() != null) {
                    while (current != null) {
                        if (current.data().equals(data)) {
                            indexOf = currentIndex;
                            break;
                        }
                        currentIndex++;
                        current = current.next();
                    }
                }
            }
        }
        return indexOf;
    }
    
    public Node<T> getTailNode() {
        Node tail = head;
        if (tail == null) {
            return tail;
        }
        while (tail.next() != null) {
            tail = tail.next();
        }
        return tail;
    }
    
}
