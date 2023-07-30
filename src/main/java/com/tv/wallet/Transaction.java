package com.tv.wallet;

import java.util.Objects;

public class Transaction{

    public final Money amount;
    private final TransactionType transactionType;
    private final Money balance;


    public Transaction(Money inward, TransactionType transactionType, Money balance) {
        this.amount = inward;
        this.transactionType = transactionType;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" + amount.value + " " + amount.currencyType + " " + transactionType + " to " + balance.currencyType + " wallet " + ", balance = " + balance.value + " " + balance.currencyType + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) && transactionType == that.transactionType && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, transactionType, balance);
    }


}
