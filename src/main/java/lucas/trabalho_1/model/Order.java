package lucas.trabalho_1.model;

import lucas.trabalho_1.data_structures.ItemList;
import lucas.trabalho_1.util.Db;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Order {
    
    private Table table;
    private Item item;
    private int quantity;
    private Customer customer;
    private String notes;

    public Order(Table table, Item item, int quantity, Customer customer) {
        this.table = table;
        this.item = item;
        this.quantity = quantity;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void addToWaitingOrders() {
        Db.getInstance().getWaitingOrders().push(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table: ").append(this.getTable().getNumber()).append("\n");
        sb.append("Item: \n code: ").append(this.getItem().getCode()).append("\n description: ").append(this.getItem().getDescription()).append("\n");
        sb.append("Quantity: ").append(this.getQuantity());
        sb.append("Customer: ").append(this.getCustomer().toString());
        return sb.toString();
    }    
    
    
}
