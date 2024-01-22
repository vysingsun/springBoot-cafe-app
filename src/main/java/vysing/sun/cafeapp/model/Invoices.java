package vysing.sun.cafeapp.model;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoices implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private int table_number;
    private float total_price;
    @CreationTimestamp //LocalDateTime
    private Date order_date;

    public Invoices(){}

    public Invoices(Long id, int table_number, float total_price, Date order_date) {
        this.id = id;
        this.table_number = table_number;
        this.total_price = total_price;
        this.order_date = order_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "Invoices [id=" + id + ", table_number=" + table_number + ", total_price=" + total_price
                + ", order_date=" + order_date + "]";
    }

    

}
