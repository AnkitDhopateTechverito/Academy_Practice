package com.tv.wallet;

import com.tv.cart.Payment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Wallet implements Comparable<Wallet>, Payment {
    public static final Comparator<Wallet> LEAST_BALANCE = Comparator.comparing(Wallet::balance);
    public static final Comparator<Wallet> MAX_TRANSACTIONS = Comparator.comparing(Wallet::countTransactions).reversed();
    public static final Comparator<Wallet> MAX_BALANCE = Comparator.comparing(Wallet::balance).reversed().thenComparing(MAX_TRANSACTIONS);
    private Money balance;

    private Transaction history;
    private List<Transaction> transactions = new ArrayList<>();

    public Wallet(CurrencyType currencyType) {
        this.balance = new Money(currencyType, 0);
    }

    public static List<Wallet> sort(List<Wallet> walletCollection, Comparator<Wallet> comparator) {
        return walletCollection.stream().sorted(comparator).toList();
    }

    private int countTransactions() {
        return transactions.size();
    }


    public Money balance() {
        return balance;
    }

    public void withdrawAmount(Money outward) {

        this.balance = balance.deduct(outward);

        this.history = new Transaction(outward, TransactionType.DEBIT, balance);
    }

    public Transaction depositAmount(Money inward) {
        this.balance = balance.add(inward);
        Transaction transaction = new Transaction(inward, TransactionType.CREDIT, balance);
        this.history = transaction;
        this.transactions.add(transaction);
        return transaction;
    }

    public Transaction getHistory() {
        return history;
    }

    public List<Transaction> transactions() {
        return transactions;
    }


    @Override
    public int compareTo(Wallet o) {
        return Integer.compare(this.countTransactions(), o.countTransactions());
    }

    @Override
    public void pay(Money money) {
        withdrawAmount(money);
    }
}
