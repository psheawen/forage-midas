package com.jpmc.midascore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TransactionRecord {
    @Id
    @GeneratedValue
    private long  id;

    @ManyToOne
    private UserRecord user;

    @ManyToOne
    private UserRecord recipient;

    private float amount;
    private float incentive;

//    Hibernate requires a no-args constructor to recreate objects when reading from the database
//    protected instead of public means you can't accidentally call it in your own code
//    It's just a convention to signal "this is for Hibernate, not for you"
    protected TransactionRecord() {};

    public TransactionRecord(UserRecord user, UserRecord recipient, float amount, float incentive) {
        this.user = user;
        this.recipient = recipient;
        this.amount = amount;
        this.incentive = incentive;
    }
}
