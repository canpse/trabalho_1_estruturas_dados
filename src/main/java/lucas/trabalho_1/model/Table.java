package lucas.trabalho_1.model;

import lucas.trabalho_1.data_structures.CustomerList;
import lucas.trabalho_1.util.Db;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Table {
    
    private int seats;
    private Integer number;
    private boolean vacant;
    private CustomerList customers;

    public Table(int seats, int number) {
        this.seats = seats;
        this.number = number;
        vacant = true;
        customers = new CustomerList();
    }

    public CustomerList getCustomers() {
        return customers;
    }

    public void addCustomers(Customer customer) {
        if (customers.size() < seats) {
            customers.insertAtEnd(customer);
        } else {
            System.out.println("No more seats avaible");
        }
    }
    
    public boolean isVacant() {
        return vacant;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }
    
    public Table(int number) {
        this.number = number;
    }

    public boolean equals(Table t) {
        return t.getNumber().equals(this.number);
    }
    
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    

    @Override
    public String toString() {
        return "\nTable{" + "\nseats=" + seats + ", \nnumber=" + number + ", \nvacant=" + vacant + ", \ncustomers=" + customers.toString() + "\n}";
    }
    
    

}
