package lucas.trabalho_1.util;

import lucas.trabalho_1.data_structures.CheckoutList;
import lucas.trabalho_1.data_structures.CustomerList;
import lucas.trabalho_1.data_structures.CustomerQueue;
import lucas.trabalho_1.data_structures.EmployeeList;
import lucas.trabalho_1.data_structures.ItemList;
import lucas.trabalho_1.data_structures.OrderList;
import lucas.trabalho_1.data_structures.OrderQueue;
import lucas.trabalho_1.data_structures.TableList;
import lucas.trabalho_1.model.Customer;
import lucas.trabalho_1.model.Employee;
import lucas.trabalho_1.model.Item;
import lucas.trabalho_1.model.Order;
import lucas.trabalho_1.model.Table;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Db {
    
    private static Db self;
    private CustomerList customers;
    private EmployeeList employees;
    private OrderQueue waitingOrders;
    private OrderList productionOrders;
    private OrderList doneOrders;
    private TableList tables;
    private ItemList items;
    private CheckoutList checkouts;
    private CheckoutList receipts;
    private CustomerQueue lunchQueue;
    private CustomerQueue checkoutQueue;

    private Db() {
        customers = new CustomerList();
        employees = new EmployeeList();
        waitingOrders = new OrderQueue();
        productionOrders = new OrderList();
        doneOrders = new OrderList();
        tables = new TableList();
        items = new ItemList();
        checkouts = new CheckoutList();
        receipts = new CheckoutList();
        lunchQueue = new CustomerQueue();
        checkoutQueue = new CustomerQueue();
        
        populateDb();
    }
    
    /**
     * metodo para popular antecipadamente para testes
     */
    private void populateDb() {
        populateCustomers();
        populateItems();
        populateTables();
        populateOrders();
        populateEmployees();
    }
    
    private void populateCustomers() {
        Customer a = new Customer("1", "lucas", "4799999");
        Customer b = new Customer("2", "cristian", "479555999");
        Customer c = new Customer("3", "felipe", "47933399");
        Customer d = new Customer("4", "pedro", "4799779");
        customers.insertAtEnd(a);
        customers.insertAtEnd(b);
        customers.insertAtEnd(c);
        customers.insertAtEnd(d);
        
    }
    
    public TableList getTableList() {
        return tables;
    }
    
    public ItemList getItemList() {
        return items;
    }
    
    public OrderList getProductionOrders() {
        return productionOrders;
    }
    
    public EmployeeList getEmployees() {
        return employees;
    }
    
    public CheckoutList getCheckouts() {
        return checkouts;
    }
    
    public CheckoutList getReceipts() {
        return receipts;
    }

    public CustomerQueue getLunchQueue() {
        return lunchQueue;
    }

    public CustomerQueue getCheckoutQueue() {
        return checkoutQueue;
    }
    
    public static Db getInstance() {
        if (self == null) {
            self = new Db();
        }
        return self;
    }
    
    /**
     * Salva o cliente. Caso ja exista um cliente com o mesmo cpf
     * o deleta e salva o novo.
     * 
     * @param c 
     * @param change - se deve alterar caso ja exista
     */
    public void saveCustomer(Customer c, boolean change) throws Exception {
        if (customers.contains(c) && change) {
            int index = customers.indexOf(c);
            customers.deleteAtIndex(index);
            customers.insertAtEnd(c);
        } else if(customers.contains(c) && !change) {
            throw new Exception("Customer is already registered");
        }
        else {
            customers.insertAtEnd(c);
        }
    }
    
    /**
     * retorna a lista de clientes
     * @return 
     */
    public CustomerList getCustomerList() {
        return customers;
    }
    
    public OrderQueue getWaitingOrders() {
        return waitingOrders;
    }

    private void populateItems() {
        Item a = new Item(1, "macarrao", 20.00);
        Item b = new Item(2, "feijao", 10.00);
        Item c = new Item(3, "arroz", 10.00);
        Item d = new Item(4, "cuzcuz", 25.00);
        items.insertAtEnd(a);
        items.insertAtEnd(b);
        items.insertAtEnd(c);
        items.insertAtEnd(d);
    }

    private void populateTables() {
        Table a = new Table(4, 1);
        Table b = new Table(3, 2);
        Table c = new Table(2, 3);
        Table d = new Table(5, 4);
        
        a.setVacant(false);
        a.addCustomers(customers.getAt(0));
        a.addCustomers(customers.getAt(2));
        
        b.setVacant(false);
        b.addCustomers(customers.getAt(1));
        b.addCustomers(customers.getAt(3));
        
        tables.insertAtEnd(a);
        tables.insertAtEnd(b);
        tables.insertAtEnd(c);
        tables.insertAtEnd(d);
    }
    
    public void persistTable(Table t) {
        if (tables.contains(t)) {
            Table onRecordTable = tables.getAt(tables.indexOf(t));
            t.setSeats(onRecordTable.getSeats());
        }
    }
    
    public void persistItem(Item i) {
        if (items.contains(i)) {
            Item onRecordItem = items.getAt(items.indexOf(i));
        }
    }

    private void populateOrders() {
        Order a = new Order(tables.getTableByNumber(1), items.getAt(0), 1, customers.getAt(0));
        Order b = new Order(tables.getTableByNumber(2), items.getAt(1), 2, customers.getAt(1));
        Order c = new Order(tables.getTableByNumber(1), items.getAt(2), 3, customers.getAt(2));
        Order d = new Order(tables.getTableByNumber(2), items.getAt(1), 1, customers.getAt(3));
        Order e = new Order(tables.getTableByNumber(1), items.getAt(3), 1, customers.getAt(0));
        waitingOrders.push(a);
        waitingOrders.push(b);
        waitingOrders.push(c);
        waitingOrders.push(d);
    }

    private void populateEmployees() {
        Employee a = new Employee("123", "tadeu", "garcom", "9-5");
        Employee b = new Employee("234", "romeu", "garcom", "9-5");
        Employee c = new Employee("345", "julieta", "chefe", "9-5");
        Employee d = new Employee("456", "bruna", "balconista", "9-5");
        
        getEmployees().insertAtEnd(a);
        getEmployees().insertAtEnd(b);
        getEmployees().insertAtEnd(c);
        getEmployees().insertAtEnd(d);
    }
    
    
    
    
}
