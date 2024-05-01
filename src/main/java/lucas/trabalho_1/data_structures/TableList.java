package lucas.trabalho_1.data_structures;

import lucas.trabalho_1.model.Table;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class TableList extends SinglyLinkedList<Table>{

    @Override
    public boolean contains(Table data) {
        Node<Table> current = head;
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
    
    public Integer indexOf(Table data) {
        Node<Table> current = head;
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
    
    public Table getTableByNumber(int number) {
        Node<Table> current = head;
        while (current != null) {
            if (current.data().getNumber().equals(number)) {
                return current.data(); 
            } else {
                current = current.next();
            }
        }
        return null;
    }

    public String toString(boolean onlyVacant) {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("No tables");
        } else {
            Node<Table> current = head;
            while (current != null) {
                if (onlyVacant && current.data().isVacant()) {
                    sb.append("\n");
                    sb.append(current.data().toString());
                    current = current.next();
                } else if(!onlyVacant){
                    sb.append("\n");
                    sb.append(current.data().toString());
                    current = current.next();
                }
            }
        }
        return sb.toString();
    }
    
    
    
}
