package lucas.trabalho_1.data_structures;

import lucas.trabalho_1.model.Customer;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class CustomerQueue extends QueueFifo<Customer>{

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("No customers in this queue");
        } else {
            Node<Customer> current = head;
            while (current != null) {
                sb.append("\n");
                sb.append(current.data().toString());
            }
        }
        return sb.toString();
    }
    
}
