package lucas.trabalho_1.model;

import lucas.trabalho_1.util.Db;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Customer implements Comparable<Customer>{
    
    private String cpf;
    private String name;
    private String contact;

    public Customer(String cpf, String name, String contact) {
        this.cpf = cpf;
        this.name = name;
        this.contact = contact;
    }
    
    public Customer(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * Verifica se é o mesmo cliente vendo se é o mesmo cpf
     * 
     * @param c
     * @return 
     */
    public boolean equals(Customer c) {
        return this.getCpf().equals(c.getCpf());
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    @Override
    public int compareTo(Customer c) {
        if (c.name.equals(name)) {
            return 0;
        }
        return 1;
    }
    
    public void save(boolean change) throws Exception {
        Db.getInstance().saveCustomer(this, change);
    }

    @Override
    public String toString() {
        StringBuilder customer = new StringBuilder();
        customer.append("CPF: ").append(cpf).append("\n");
        customer.append("Name: ").append(name).append("\n");
        customer.append("Contact: ").append(contact).append("\n");
        return customer.toString();
    }
    
    
    
    
}
