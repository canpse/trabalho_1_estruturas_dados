package lucas.trabalho_1.data_structures;

import lucas.trabalho_1.model.Order;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class OrderQueue extends QueueFifo<Order>{

    @Override
    public String toString() {
        Node<Order> current = head;
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            return "Empty String";
        } else {
            int orderNumber = 0;
            while (current != null) {
                sb.append("\n-------------");
                sb.append("Order number: " + orderNumber + "\n");
                sb.append(current.data().toString());
                sb.append("\n-------------");
                current = current.next();
                orderNumber++;
            }
        }
        return sb.toString();
    }
    
    /**
     * Cacela o pedido recolocando a fila em um aux sem o pedido e então refazendo a fila
     * @param orderNumber 
     */
    public void cancelOrder(int orderNumber) {
        OrderQueue aux = new OrderQueue();
        int orderCounter = 0;
        while (this.peek() != null) {
            if (orderNumber != orderCounter) {
                aux.push(this.pop());
            } else {
                this.pop();
                System.out.println("Order " + orderCounter + " removed");
            }
            orderCounter++;
        }
        while (aux.peek() != null) {
            this.push(aux.pop());
        }
    }
    
    
}
