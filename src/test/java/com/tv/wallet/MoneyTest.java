package com.tv.wallet;

import com.tv.wallet.CurrencyType;
import com.tv.wallet.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    public void oneUSDShouldEqualToEightyINR(){

        Money oneUsd = new Money(CurrencyType.USD, 1);
        Money eightyInr = new Money(CurrencyType.INR, 80);

        Assertions.assertEquals(oneUsd,eightyInr);
    }

    @Test
    public void twoUSDShouldEqualToOneSixtyINR(){

        Money twoUSD = new Money(CurrencyType.USD, 2);
        Money oneSixtyINR = new Money(CurrencyType.INR, 160);

        Assertions.assertEquals(twoUSD,oneSixtyINR);
    }
    @Test
    public void twoGBPShouldEqualToThreeTwentyINR(){

        Money oneUsd = new Money(CurrencyType.GBP, 2);
        Money eightyInr = new Money(CurrencyType.INR, 320);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void oneGBPShouldEqualToOneSixtyINR(){

        Money oneUsd = new Money(CurrencyType.GBP, 1);
        Money eightyInr = new Money(CurrencyType.INR, 160);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void tenINRShouldEqualToTenINR(){

        Money oneUsd = new Money(CurrencyType.INR, 10);
        Money eightyInr = new Money(CurrencyType.INR, 10);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void oneGBPShouldEqualToTwoUSD(){

        Money oneUsd = new Money(CurrencyType.GBP, 1);
        Money eightyInr = new Money(CurrencyType.USD, 2);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void twoGBPShouldEqualToFourUSD(){

        Money oneUsd = new Money(CurrencyType.GBP, 2);
        Money eightyInr = new Money(CurrencyType.USD, 4);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void twoThirtyBTHShouldEqualToOneSixtyINR(){

        Money oneUsd = new Money(CurrencyType.BTH, 320);
        Money eightyInr = new Money(CurrencyType.INR, 160);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void twoBTHShouldEqualToOneINR(){

        Money oneUsd = new Money(CurrencyType.BTH, 2);
        Money eightyInr = new Money(CurrencyType.INR, 1);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void oneUSDShouldEqualToOneSixtyBTH(){

        Money oneUsd = new Money(CurrencyType.USD, 1);
        Money eightyInr = new Money(CurrencyType.BTH, 160);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void twoUSDShouldEqualToThreeTwentyBTH(){

        Money oneUsd = new Money(CurrencyType.USD, 2);
        Money eightyInr = new Money(CurrencyType.BTH, 320);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void twoGBPShouldEqualToSixFortyBTH(){

        Money oneUsd = new Money(CurrencyType.GBP, 2);
        Money eightyInr = new Money(CurrencyType.BTH, 640);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
    @Test
    public void oneGBPShouldEqualToThreeTwentyBTH(){

        Money oneUsd = new Money(CurrencyType.GBP, 1);
        Money eightyInr = new Money(CurrencyType.BTH, 320);

        Assertions.assertEquals(oneUsd,eightyInr);
    }
}