package com.company.TestDrivenDevelopment.Chainblock;
import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.transactions.size();
    }

    @Override
    public void add(Transaction transaction) {
        if (!this.transactions.containsValue(transaction)) {
            this.transactions.put(transaction.getId(), transaction);
        }
    }

    @Override
    public boolean contains(Transaction transaction) {
        return this.transactions.containsValue(transaction);
    }

    @Override
    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (this.transactions.containsKey(id)) {
            this.transactions.get(id).setStatus(newStatus);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void removeTransactionById(int id) {
        if (this.transactions.containsKey(id)) {
            this.transactions.remove(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Transaction getById(int id) {
        if (!this.transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        if (!transactions.values().stream().anyMatch(e -> e.getStatus().equals(status))) {
            throw new IllegalArgumentException();
        }
        return transactions.values().stream()
                .filter(e -> e.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        if (!transactions.values().stream().anyMatch(e -> e.getStatus().equals(status))) {
            throw new IllegalArgumentException();
        }
        return transactions.values().stream()
                .filter(e -> e.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getSender)
                .collect(Collectors.toList());

    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        if (!transactions.values().stream().anyMatch(e -> e.getStatus().equals(status))) {
            throw new IllegalArgumentException();
        }
        return transactions.values().stream()
                .filter(e -> e.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getReceiver)
                .collect(Collectors.toList());

    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactions.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .toList();
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        if (!transactions.values().stream().anyMatch(e -> e.getSender().equals(sender))) {
            throw new IllegalArgumentException();
        }
        return transactions.values().stream()
                .filter(e -> e.getSender().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        if (!transactions.values().stream().anyMatch(e -> e.getReceiver().equals(receiver))) {
            throw new IllegalArgumentException();
        }
        return transactions.values().stream()
                .filter(e -> e.getReceiver().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        if (!transactions.values().stream().anyMatch(e -> e.getStatus().equals(status))) {
            return new ArrayList<>();
        } else if (!transactions.values().stream().anyMatch(e -> e.getAmount() <= amount)) {
            return new ArrayList<>();
        }
        return transactions.values().stream()
                .filter(e -> e.getStatus().equals(status))
                .filter(e -> e.getAmount() <= 130.00)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        if (!transactions.values().stream().anyMatch(e -> e.getSender().equals(sender))) {
            throw new IllegalArgumentException();
        } else if (!transactions.values().stream().anyMatch(e -> e.getAmount() > amount)) {
            throw new IllegalArgumentException();
        }
        return transactions.values().stream()
                .filter(e -> e.getSender().equals(sender))
                .filter(e -> e.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        if (!transactions.values().stream().anyMatch(e -> e.getReceiver().equals(receiver))) {
            throw new IllegalArgumentException();
        } else if (!transactions.values().stream().anyMatch(e -> e.getAmount() >= lo && e.getAmount() < hi)) {
            throw new IllegalArgumentException();
        }
        return transactions.values().stream()
                .filter(e -> e.getReceiver().equals(receiver))
                .filter((e -> e.getAmount() >= lo && e.getAmount() < hi))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        if (!transactions.values().stream().anyMatch(e -> e.getAmount() >= lo && e.getAmount() <= hi)) {
            return new ArrayList<>();
        }
        return transactions.values().stream()
                .filter(e -> e.getAmount() >= lo && e.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return transactions.values().iterator();
    }
}

