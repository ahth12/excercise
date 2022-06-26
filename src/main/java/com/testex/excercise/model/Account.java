package com.testex.excercise.model;


import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="amount")
    private Long amount;

    public Account() {
    }

    public Account(Long value) {
        this.amount = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
