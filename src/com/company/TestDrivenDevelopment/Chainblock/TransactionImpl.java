package com.company.TestDrivenDevelopment.Chainblock;

public class TransactionImpl implements Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public TransactionStatus getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(TransactionStatus newStatus) {
        this.status=newStatus;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public String getSender() {
        return this.from;
    }

    @Override
    public String getReceiver() {
        return this.to;
    }
}

