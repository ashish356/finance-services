package com.org.ashish.financeservices.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="fixed_deposit")
public class FixedDeposit {

    private long id;
    private String bankName;
    private long depositAmount;
    private long maturityAmount;
    private Date depositDate;
    private Date maturityDate;

    public FixedDeposit() {
    }

    public FixedDeposit(long id, String bankName, long depositAmount, long maturityAmount, Date depositDate, Date maturityDate) {
        this.id = id;
        this.bankName = bankName;
        this.depositAmount = depositAmount;
        this.maturityAmount = maturityAmount;
        this.depositDate = depositDate;
        this.maturityDate = maturityDate;
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

    @Column(name = "depositAmount", nullable = false)
    public long getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(long depositAmount) {
        this.depositAmount = depositAmount;
    }

    @Column(name = "maturityAmount", nullable = false)
    public long getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(long maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    @Column(name = "depositDate", nullable = false)
    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    @Column(name = "maturityDate", nullable = false)
    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    @Override
    public String toString() {
        return "FixedDeposit{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", depositAmount=" + depositAmount +
                ", maturityAmount=" + maturityAmount +
                ", depositDate=" + depositDate +
                ", maturityDate=" + maturityDate +
                '}';
    }
}
