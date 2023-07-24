package com.company.TestDrivenDevelopment.Chainblock;

public interface Transaction {

    int getId();
    TransactionStatus getStatus();
    void setStatus(TransactionStatus newStatus);
    double getAmount();
    String getSender();
    String getReceiver();

}

