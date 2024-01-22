package vysing.sun.cafeapp.model;

import java.io.Serializable;


import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;

@Entity
public class Foods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String food_code;
    private String food_name;
    private String food_category;
    @Lob
    @Column(nullable = true, length = 2147483647)
    private String image;
    private float price;
    private String note;

    public Foods(){}

    public Foods(Long id, String food_code, String food_name, String food_category, String image, float price, String note) {
        this.id = id;
        this.food_code = food_code;
        this.food_name = food_name;
        this.food_category = food_category;
        this.image = image;
        this.price = price;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFood_code() {
        return food_code;
    }

    public void setFood_code(String food_code) {
        this.food_code = food_code;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_category() {
        return food_category;
    }

    public void setFood_category(String food_category) {
        this.food_category = food_category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Foods [id=" + id + ", food_code=" + food_code + ", food_name=" + food_name + ", food_category=" + food_category
                + ", image=" + image + ", price=" + price + ", note=" + note + "]";
    }

    
    
}
