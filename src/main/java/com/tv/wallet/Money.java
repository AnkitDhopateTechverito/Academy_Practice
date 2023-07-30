package com.tv.wallet;

import java.util.Objects;

public class Money implements Comparable<Money> {
    public final CurrencyType currencyType;
    public Double value;

    public Money(CurrencyType currencyType, double value) {
        this.currencyType = currencyType;
        this.value = value;
    }

    public Money add(Money other) {
        double amount = currencyType.convertFrom(other.value, other.currencyType);
        return new Money(this.currencyType, this.value + amount);
    }

    @Override
    public String toString() {
        return "Money{" + "currencyType=" + currencyType + ", balance=" + value + '}';
    }

    @Override
    public boolean equals(Object money) {
        if (this == money) return true;
        if (money == null || getClass() != money.getClass()) return false;
        Money other = (Money) money;
        double amount = currencyType.convertFrom(other.value, other.currencyType);
        return Double.compare(value, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyType, value);
    }

    public Money deduct(Money other) {
        double amount = currencyType.convertFrom(other.value, other.currencyType);
        if (this.value < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        return new Money(this.currencyType, this.value - amount);
    }


    public int compareTo(Money other) {
        Double amount = currencyType.convertFrom(other.value, other.currencyType);
        return Double.compare(value, amount);
    }
}
