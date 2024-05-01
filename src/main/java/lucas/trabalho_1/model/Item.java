package lucas.trabalho_1.model;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Item {
    
    private Integer code;
    private String description;
    private double price;

    public Item(int code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }
    
    public Item(int code) {
        this.code = code;
    }

    public boolean equals(Item i) {
        return i.getCode().equals(this.getCode());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
