package com.org.ashish.financeservices.model;


import javax.persistence.*;

@Entity
@Table(name="finance_components")
public class FinanceComponent {


    private long id;
    private String name;

    public FinanceComponent() {
    }

    public FinanceComponent(long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FinanceComponents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
