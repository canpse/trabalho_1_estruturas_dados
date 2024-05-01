
package lucas.trabalho_1;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import lucas.trabalho_1.data_structures.SinglyLinkedList;
import lucas.trabalho_1.model.Checkout;
import lucas.trabalho_1.model.Customer;
import lucas.trabalho_1.model.Employee;
import lucas.trabalho_1.model.Item;
import lucas.trabalho_1.model.Order;
import lucas.trabalho_1.model.Table;
import lucas.trabalho_1.util.Db;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Trabalho_1 {
    
    public static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean quit = false;
        Db.getInstance();
        while (!quit) {
            System.out.println("Manage your restaurant:");
            System.out.println("1 - Manage Customers");
            System.out.println("2 - Manage Orders");
            System.out.println("3 - Manage Tables");
            System.out.println("4 - Manage Employees");
            System.out.println("5 - Manage Checkouts");
            System.out.println("6 - View and manage Statistics");
            
            System.out.println("0 - Close program");
            int option = stdin.nextInt();
            switch (option) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    manageCustomers();
                    break;
                case 2:
                    manageOrders();
                    break;
                case 3:
                    manageTables();
                    break;
                case 4:
                    manageEmployees();
                    break;
                case 5:
                    manageCheckouts();
                    break;
                case 6:
                    manageStatistics();
                    break;
                default:
                    System.out.println("Choose a valid option");
            }
        }
    }

    private static void manageCustomers() {
        System.out.println("Managing Customers");
        System.out.println("1 - Add Customer");
        System.out.println("2 - Remove Customer");
        System.out.println("3 - Change Customer");
        System.out.println("4 - List all Customers");
        int option = stdin.nextInt();
        stdin.nextLine();
        switch (option) {
            case 1:
                addCustomer();
                break;
            case 2:
                removeCustomer();
                break;
            case 3:
                updateCustomer();
                break;
            case 4:
                listAllCustomers();
                break;
            default:
        }
    }

    private static void manageOrders() {
        System.out.println("Managing Orders: ");
        System.out.println("1 - Add Order to waiting");
        System.out.println("2 - Take next order to production");
        System.out.println("3 - Deliver Order to table");
        System.out.println("4 - List waiting Orders");
        System.out.println("5 - List Orders in production");
        System.out.println("6 - Cancel waiting order");
        System.out.println("7 - Update waiting order");
        System.out.println("-----------------------");
        int option = stdin.nextInt();
        stdin.nextLine();
        switch (option) {
            case 1:
                addWaitingOrder();
                break;
            case 2:
                takeNextOrderToProduction();
                break;
            case 3:
                deliverOrder();
                break;
            case 4:
                listWaitingOrders();
                break;
            case 5:
                listOrdersInProduction();
                break;
            case 6:
                cancelOrder();
                break;
            default:
        }
        
    }

    private static void manageTables() {
        System.out.println("Managing Tables");
        System.out.println("1 - List Tables");
        System.out.println("2 - list Vacant Table");
        System.out.println("3 - Assign table to customer");
        System.out.println("4 - Vacant Table");
        
        int option = stdin.nextInt();
        stdin.nextLine();
        switch (option) {
            case 1:
                listTables();
                break;
            case 2:
                listVacantTables();
                break;
            case 3:
                assignTable();
                break;
            case 4:
                vacantTable();
                break;
            default:
        }
    }

    private static void manageEmployees() {
        System.out.println("Managing Employees: ");
        System.out.println("1 - add employee");
        System.out.println("2 - remove employee");
        System.out.println("3 - update employee");
        System.out.println("4 - list all employee");
        int option = stdin.nextInt();
        stdin.nextLine();
        switch (option) {
            case 1:
                addEmployee();
                break;
            case 2:
                removeEmployee();
                break;
            case 3:
                updateEmployee();
                break;
            case 4:
                listAllEmployee();
                break;
            default:
        }
    }

    private static void addEmployee() {
        System.out.println("Enter name:");
        String name = stdin.nextLine();
        System.out.println("Enter cpf:");
        String cpf = stdin.nextLine();
        System.out.println("Enter position:");
        String position = stdin.nextLine();
        System.out.println("Enter work schedule:");
        String workSchedule = stdin.nextLine();
        Employee employee = new Employee(cpf, name, position, workSchedule);
        Db.getInstance().getEmployees().insertAtEnd(employee);
        System.out.println("Employee saved");
    }

    private static void addCustomer() {
        System.out.println("Adding a Customer");
        System.out.println("Enter the customer cpf");
        String cpf = stdin.nextLine();
        System.out.println("Enter the customer name");
        String name = stdin.nextLine();
        System.out.println("Enter the customer contact number");
        String contact = stdin.nextLine();
        Customer newCustomer = new Customer(cpf, name, contact);
        try {
            Db.getInstance().saveCustomer(newCustomer, false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void removeCustomer() {
        System.out.println("Remove Customer: ");
        System.out.println("Enter the cpf of the desired customer to be removed: ");
        String cpf = stdin.nextLine();
        Db.getInstance().getCustomerList().deleteByValue(new Customer(cpf));
    }

    private static void updateCustomer() {
        System.out.println("Updating a customer:");
        System.out.println("Enter the cpf of the desired customer to be updated: ");
        String cpf = stdin.nextLine();
        System.out.println("Enter the new name: ");
        String name = stdin.nextLine();
        System.out.println("Enter new contact number: ");
        String contact = stdin.nextLine();
        try {
            Db.getInstance().saveCustomer(new Customer(cpf, name, contact), true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listAllCustomers() {
        System.out.println("All customers");
        System.out.println(Db.getInstance().getCustomerList().toString());
    }

    private static void addWaitingOrder() {
        System.out.println("Adding Order: ");
        System.out.println("for wich table is the order: ");
        int tableNumber = stdin.nextInt();
        stdin.nextLine();
        Table table = Db.getInstance().getTableList().getTableByNumber(tableNumber);
        if (table == null) {
            System.out.println("No such table number");
            return;
        }
        System.out.println("Table " + table.getNumber() + " choosen with " + table.getSeats() + " seats");
        
        System.out.println("Enter customer CPF: ");
        String cpf = stdin.nextLine();
        
        Customer customer = Db.getInstance().getCustomerList().getByCpf(cpf);
        
        if (customer == null) {
            System.out.println("no such customer");
            return;
        }
        
        System.out.println(customer.toString());
        
        System.out.println("Item code: ");
        int itemCode = stdin.nextInt();
        Item item = Db.getInstance().getItemList().getItemByCode(itemCode);
        if (item != null) {
            System.out.println("Quantity: ");
            int quantity = stdin.nextInt();
            stdin.nextLine();
            System.out.println("Item: " + item.getDescription() + "; " + quantity + " unities" + "; R$" + item.getPrice());
            Order o = new Order(table, item, quantity, customer);
            o.addToWaitingOrders();
            System.out.println("Done!");
        } else {
            System.out.println("that item is not on the menu");
        }
    }

    private static void takeNextOrderToProduction() {
        Order nextOrder = Db.getInstance().getWaitingOrders().pop();
        if (nextOrder != null) {
            Db.getInstance().getProductionOrders().insertAtEnd(nextOrder);
            System.out.println("Order:\n " + nextOrder.toString() + "\nwent to production!");
        } else {
            System.out.println("No orders in waiting");
        }
    }

    private static void deliverOrder() {
        Db.getInstance().getProductionOrders().toString();
        System.out.println("Wich order to deliver: ");
        int orderNumber = stdin.nextInt();
        stdin.nextLine();
        Order toDeliver = Db.getInstance().getProductionOrders().getAt(orderNumber);
        Db.getInstance().getProductionOrders().deleteAtIndex(orderNumber);
        
        Checkout ck = Db.getInstance().getCheckouts().getCheckoutByCpf(toDeliver.getCustomer().getCpf());
        if (ck == null) {
            ck = new Checkout(Db.getInstance().getCustomerList().getByCpf(toDeliver.getCustomer().getCpf()));
            Db.getInstance().getCheckouts().insertAtEnd(ck);
        }
        ck.addOrder(toDeliver);
    }

    private static void listWaitingOrders() {
        System.out.println("Waiting Orders:");
        String waitingOrders = Db.getInstance().getWaitingOrders().toString();
        System.out.println(waitingOrders);
    }

    private static void listOrdersInProduction() {
        System.out.println("Orders in production");
        System.out.println(Db.getInstance().getProductionOrders().toString());
    }

    private static void cancelOrder() {
        System.out.println("Wich order to cancel: ");
        listWaitingOrders();
        int orderNUmber = stdin.nextInt();
        stdin.nextLine();
        Db.getInstance().getWaitingOrders().cancelOrder(orderNUmber);
    }

    private static void listTables() {
        System.out.println("List of tables");
        System.out.println(Db.getInstance().getTableList().toString(false));
    }

    private static void listVacantTables() {
        System.out.println("List of vacant tables");
        System.out.println(Db.getInstance().getTableList().toString(true));
    }

    private static void assignTable() {
        System.out.println("Assigning customers to tables");
        System.out.println("Wich table are you assigning?");
        int tableNumber = stdin.nextInt();
        stdin.nextLine();
        System.out.println("CPF of customer: ");
        String cpf = stdin.nextLine();
        Table table = Db.getInstance().getTableList().getTableByNumber(tableNumber);
        if (table == null) {
            System.out.println("no such table number");
            return;
        }
        Customer c = Db.getInstance().getCustomerList().getByCpf(cpf);
        if (c != null) {
            table.getCustomers().insertAtEnd(c);
            table.setVacant(false);
        } else {
            System.out.println("no such customer");
        }
    }

    private static void vacantTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void removeEmployee() {
        System.out.println("Removing Employees: ");
        System.out.println("Enter the cpf of the desired employee to be removed: ");
        String cpf = stdin.nextLine();
        Db.getInstance().getEmployees().deleteByValue(Db.getInstance().getEmployees().getByCpf(cpf));
        System.out.println("Employee removed!");
    }

    private static void updateEmployee() {
        System.out.println("Updating a Employee");
        System.out.println("Wich is the employee CPF:");
        String cpf = stdin.nextLine();
        addEmployee();
        Db.getInstance().getEmployees().deleteByValue(new Employee(cpf));
    }

    private static void listAllEmployee() {
        System.out.println("List of all employess");
        System.out.println(Db.getInstance().getEmployees().toString());
    }

    private static void manageCheckouts() {
        System.out.println("MAnaging checkouts");
        System.out.println("1 - checkout a customer");
        System.out.println("2 - list all checkouts");
        System.out.println("3 - payment history");
        int option = stdin.nextInt();
        stdin.nextLine();
        switch (option) {
            case 1:
                checkoutCustomer();
                break;
            case 2:
                listAllCheckouts();
                break;
            case 3:
                paymentHistory();
                break;
            default:
        }
    }

    private static void checkoutCustomer() {
        System.out.println("ChekingOut customer: ");
        System.out.println("Wich is the customer cpf: ");
        String cpf = stdin.nextLine();
        Customer cus = Db.getInstance().getCustomerList().getByCpf(cpf);
        if (cus == null) {
            System.out.println("no such customer");
            return;
        }
        Checkout ck = Db.getInstance().getCheckouts().getCheckoutByCpf(cpf);
        if (ck == null) {
            System.out.println("No checkouts for the customer");
            return;
        }
        System.out.println("This customer has the folowing orders: ");
        System.out.println(ck.getOrders().toString());
        System.out.println("Having to pay: ");
        Double total = ck.getTotal();
        System.out.println(total);
        
        System.out.println("insert payment: ");
        double payment = stdin.nextDouble();
        stdin.nextLine();
        if (payment > total) {
            Double change = payment - total;
            System.out.println("change: " + change);
            ck.setAmountPaid(payment);
            Db.getInstance().getReceipts().insertAtEnd(ck);
            Db.getInstance().getCheckouts().deleteByValue(ck);
        } else if (payment < total) {
            System.out.println("that is not enought sir");
        } else {
            ck.setAmountPaid(payment);
            Db.getInstance().getReceipts().insertAtEnd(ck);
            Db.getInstance().getCheckouts().deleteByValue(ck);
            System.out.println("paid.");
        }
        ck.getOrders().getAt(0).getTable().setVacant(true);
        
        System.out.println("Recibo: ");
        
        System.out.println(ck.toString());
        
    }

    private static void listAllCheckouts() {
        System.out.println("Listing all checkouts");
        System.out.println(Db.getInstance().getCheckouts().toString());
    }

    private static void paymentHistory() {
        System.out.println("payment history: ");
        System.out.println(Db.getInstance().getReceipts().toString());
    }

    private static void manageStatistics() {
        System.out.println("Manage Statistics");
        System.out.println("1 - Add customer to lunch queue");
        System.out.println("2 - add customer do checkout queue");
        System.out.println("3 - List customers in restarant");
        System.out.println("4 - Total customers count");
        System.out.println("5 - number of vacant tables");
        System.out.println("6 - view lunch queue");
        System.out.println("7 - view Checkout queue");
        System.out.println("8 - pop lunch queue");
        System.out.println("9 - pop checkout queue");
        
        int option = stdin.nextInt();
        stdin.nextLine();
        switch (option) {
            case 1:
                addCustomerToLunchQueue();
                break;
            case 2:
                addCustomerToCheckoutQueue();
                break;
            case 6:
                viewLunchQueue();
                break;
            case 7:
                viewCheckoutQueue();
                break;
            case 8:
                popLuchQueue();
                break;
            case 9:
                popCheckoutQueue();
                break;
            default:
        }
    }

    private static void addCustomerToLunchQueue() {
        System.out.println("Adding to lunch queue: ");
        System.out.println("type the cpf of the customer: ");
        String cpf = stdin.nextLine();
        Customer customer = Db.getInstance().getCustomerList().getByCpf(cpf);
        Db.getInstance().getLunchQueue().push(customer);
        System.out.println("Customer added.");
    }

    private static void addCustomerToCheckoutQueue() {
        System.out.println("Adding to checkout queue: ");
        System.out.println("type the cpf of the customer: ");
        String cpf = stdin.nextLine();
        Customer customer = Db.getInstance().getCustomerList().getByCpf(cpf);
        Db.getInstance().getCheckoutQueue().push(customer);
        System.out.println("Customer added.");
        
    }

    private static void viewLunchQueue() {
        System.out.println("View Customer queue");
        Db.getInstance().getLunchQueue().toString();
    }

    private static void viewCheckoutQueue() {
        System.out.println("View Checkout Queue");
        Db.getInstance().getCheckoutQueue().toString();
    }

    private static void popLuchQueue() {
        System.out.println("Next Customer!");
        Db.getInstance().getLunchQueue().pop();
    }

    private static void popCheckoutQueue() {
        Db.getInstance().getCheckoutQueue().pop();
    }
    
}
