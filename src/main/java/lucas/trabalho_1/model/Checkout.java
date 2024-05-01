package lucas.trabalho_1.model;

import lucas.trabalho_1.data_structures.OrderList;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Checkout {
    
    private Customer customer;
    private OrderList orders;
    private Double amountPaid;

    public Checkout(Customer customer) {
        this.customer = customer;
        orders = new OrderList();
        amountPaid = 0.0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void addOrder(Order order) {
        orders.insertAtEnd(order);
    }

    public OrderList getOrders() {
        return orders;
    }
    
    public Double getTotal() {
        return orders.getTotalPrice();
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    @Override
    public String toString() {
        return "Checkout{" + "\ncustomer=" + customer.toString() + ",\n orders=" + orders.toString() + ",\n Total=" + getTotal() + ",\n amount paid=" + amountPaid + "\n}";
    }
    
    
    
    
}
