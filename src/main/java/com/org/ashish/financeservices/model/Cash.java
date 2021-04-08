package com.org.ashish.financeservices.model;


import javax.persistence.*;

@Entity
@Table(name="cash")
public class Cash {
    private long id;
    private String bank;
    private long amount;
    private String currencyCode;

    public Cash() {
    }

    public Cash(long id, String bank, long amount, String currencyCode) {
        this.id = id;
        this.bank = bank;
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "bank", nullable = false)
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Column(name = "amount", nullable = false)
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Column(name = "currencyCode", nullable = false)
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
