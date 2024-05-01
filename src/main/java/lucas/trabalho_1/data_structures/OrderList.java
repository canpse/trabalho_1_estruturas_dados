package lucas.trabalho_1.data_structures;

import lucas.trabalho_1.model.Order;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class OrderList extends SinglyLinkedList<Order>{

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
             sb.append("No orders");
        } else {
            int orderNumber = 0;
            Node<Order> current = head;
            while (current != null) {
                sb.append("Order Number: " + orderNumber + "\n");
                sb.append(current.data().toString());
                current = current.next();
                orderNumber++;
            }
        }
        return sb.toString();
    }
    
    
    public double getTotalPrice() {
        Node<Order> current = head;
        Double total = 0.0;
        while (current != null) {
            total = current.data().getItem().getPrice() * current.data().getQuantity();
            current = current.next();
        }
        return total;
    }
    
    
    
}
