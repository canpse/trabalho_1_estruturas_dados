package lucas.trabalho_1.data_structures;

import lucas.trabalho_1.model.Employee;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class EmployeeList extends SinglyLinkedList<Employee>{
    
    public Employee getByCpf(String cpf) {
        Employee searchedEmployee = new Employee(cpf);
        if (contains(searchedEmployee)) {
            int index = this.indexOf(searchedEmployee);
            return getAt(index);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("No employees");
        } else {
            Node<Employee> current = head;
            while (current != null) {
                sb.append("\n");
                sb.append(current.data().toString());
                sb.append("\n");
                current = current.next();
            }
        }
        return sb.toString();
    }
    
    
    
}
