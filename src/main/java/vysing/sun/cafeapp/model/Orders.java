package vysing.sun.cafeapp.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String category_name;
    private String size;
    private String cream;
    private int suger;
    private String zone;
    private int quantity;
    private float price;

    public Orders(){}

    public Orders(Long id, String category_name, String size, String cream, int suger, String zone, int quantity,
            float price) {
        this.id = id;
        this.category_name = category_name;
        this.size = size;
        this.cream = cream;
        this.suger = suger;
        this.zone = zone;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCream() {
        return cream;
    }

    public void setCream(String cream) {
        this.cream = cream;
    }

    public int getSuger() {
        return suger;
    }

    public void setSuger(int suger) {
        this.suger = suger;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", category_name=" + category_name + ", size=" + size + ", cream=" + cream
                + ", suger=" + suger + ", zone=" + zone + ", quantity=" + quantity + ", price=" + price + "]";
    }

    
}
