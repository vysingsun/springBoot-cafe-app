package vysing.sun.cafeapp.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Receipt implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private float cash_received;
    private float total_dollar;
    private float total_riel;
    private float rate;
    private float cash_back;
    private Long invoice_id;
    private Date order_date;
    private int table_number;

    public Receipt(){}

    public Receipt(Long id, float cash_received, float total_dollar, float total_riel, float rate, float cash_back,
            Long invoice_id, Date order_date, int table_number) {
        this.id = id;
        this.cash_received = cash_received;
        this.total_dollar = total_dollar;
        this.total_riel = total_riel;
        this.rate = rate;
        this.cash_back = cash_back;
        this.invoice_id = invoice_id;
        this.order_date = order_date;
        this.table_number = table_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCash_received() {
        return cash_received;
    }

    public void setCash_received(float cash_received) {
        this.cash_received = cash_received;
    }

    public float getTotal_dollar() {
        return total_dollar;
    }

    public void setTotal_dollar(float total_dollar) {
        this.total_dollar = total_dollar;
    }

    public float getTotal_riel() {
        return total_riel;
    }

    public void setTotal_riel(float total_riel) {
        this.total_riel = total_riel;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCash_back() {
        return cash_back;
    }

    public void setCash_back(float cash_back) {
        this.cash_back = cash_back;
    }

    public Long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    @Override
    public String toString() {
        return "Receipt [id=" + id + ", cash_received=" + cash_received + ", total_dollar=" + total_dollar
                + ", total_riel=" + total_riel + ", rate=" + rate + ", cash_back=" + cash_back + ", invoice_id="
                + invoice_id + ", order_date=" + order_date + ", table_number=" + table_number + "]";
    }

    
}
