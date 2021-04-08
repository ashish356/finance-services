package com.org.ashish.financeservices.model;

import javax.persistence.*;

@Entity
@Table(name="loan")
public class Loan {


    private long id;
    private String bankName;
    private long Amount;

    public Loan() {
    }

    public Loan(long id, String bankName, long amount) {
        this.id = id;
        this.bankName = bankName;
        Amount = amount;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "bankName", nullable = false)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "amount", nullable = false)
    public long getAmount() {
        return Amount;
    }

    public void setAmount(long amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Loans{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", Amount=" + Amount +
                '}';
    }
}
