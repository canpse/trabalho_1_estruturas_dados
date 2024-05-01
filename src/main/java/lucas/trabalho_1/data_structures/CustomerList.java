package lucas.trabalho_1.data_structures;

import lucas.trabalho_1.model.Customer;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class CustomerList extends SinglyLinkedList<Customer> {
 
    public Customer getByCpf(String cpf) {
        if (head == null) {
            return null;
        }
        Node<Customer> current = head;
        while (current != null) {
            if (current.data().getCpf().equals(cpf)) {
                return current.data();
            }
            current = current.next();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        if (head == null) {
            list.append("No customers");
        } else {
            list.append("-------------\n");
            list.append("cpf: ").append(head.data().getCpf()).append("\n");
            list.append("name: ").append(head.data().getName()).append("\n");
            list.append("Contact Number: ").append(head.data().getContact()).append("\n");
            if (head.next() != null) {
                Node<Customer> current = head;
                while (current != null) {                    
                    list.append("cpf: ").append(current.data().getCpf()).append("\n");
                    list.append("name: ").append(current.data().getName()).append("\n");
                    list.append("Contact Number: ").append(current.data().getContact()).append("\n");
                    current = current.next();
                    list.append("-------------\n");
                }
            }
            list.append("-------------\n");
        }
        return list.toString();
    }
    
    
    
    
}
