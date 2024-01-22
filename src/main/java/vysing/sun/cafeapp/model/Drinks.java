package vysing.sun.cafeapp.model;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Drinks implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String category_code;
    private String category_name;
    private String category;
    @Lob
    @Column(nullable = true,length = 2147483647)
    private String image;
    private float price;
    private String note;

    public Drinks(){}

    public Drinks(Long id, String category_code, String category_name, String category, String image, float price,
            String note) {
        this.id = id;
        this.category_code = category_code;
        this.category_name = category_name;
        this.category = category;
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

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        return "Drinks [id=" + id + ", category_code=" + category_code + ", category_name=" + category_name
                + ", category=" + category + ", image=" + image + ", price=" + price + ", note=" + note + "]";
    }

    
 
}
