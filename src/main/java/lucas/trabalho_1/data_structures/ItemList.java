package lucas.trabalho_1.data_structures;

import lucas.trabalho_1.model.Item;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class ItemList extends SinglyLinkedList<Item> {

    public ItemList() {
    }
    
    
    public Item getItemByCode(int code) {
        Node<Item> current = head;
        while (current != null) {
            if (current.data().getCode().equals(code)) {
                return current.data(); 
            } else {
                current = current.next();
            }
        }
        return null;
    }

}
