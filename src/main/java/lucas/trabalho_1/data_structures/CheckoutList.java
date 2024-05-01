package lucas.trabalho_1.data_structures;

import lucas.trabalho_1.model.Checkout;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class CheckoutList extends SinglyLinkedList<Checkout>{
    
    /**
     * 
     * @param cpf
     * @return 
     */
    public Checkout getCheckoutByCpf(String cpf) {
        if (head == null) {
            return null;
        }
        Node<Checkout> current = head;
        while (current != null) {
            if (current.data().getCustomer().getCpf().equals(cpf)) {
                return current.data();
            }
            current = current.next();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("No checkouts");
        } else {
            Node<Checkout> current = head;
            while (current != null) {
                sb.append(current.data().toString());
                current = current.next();
            }
        }
        return sb.toString();
    }
    
    
    
    
}
