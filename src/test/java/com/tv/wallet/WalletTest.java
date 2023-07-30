package com.tv.wallet;

import com.tv.wallet.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {


    @Test
    public void oneINR_balanceEqualsOneINR() {

        Wallet wallet = new Wallet(CurrencyType.INR);

        wallet.depositAmount(new Money(CurrencyType.INR, 1));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 1), balance);

    }

    @Test
    public void oneUSDandOneUSD_balanceEqualsTwoUSD() {
        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 1));
        wallet.depositAmount(new Money(CurrencyType.USD, 1));
        Money actual = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 2), actual);
    }

    @Test
    public void twoINRandOneINR_balanceEqualsThreeINR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 1));

        wallet.depositAmount(new Money(CurrencyType.INR, 2));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 3), balance);


    }

    @Test
    public void oneUSDandThreeUSD_balanceEqualsFourUSD() {

        Wallet wallet = new Wallet(CurrencyType.USD);

        wallet.depositAmount(new Money(CurrencyType.USD, 1));
        wallet.depositAmount(new Money(CurrencyType.USD, 3));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 4), balance);

    }

    @Test
    public void INR_80_and_1_USD_balanceEquals_160_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);

        wallet.depositAmount(new Money(CurrencyType.INR, 80));
        wallet.depositAmount(new Money(CurrencyType.USD, 1));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 160), balance);

    }

    @Test

    public void USD_1_and_80_INR_balanceEquals_2_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);

        wallet.depositAmount(new Money(CurrencyType.USD, 1));
        wallet.depositAmount(new Money(CurrencyType.INR, 80));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 2), balance);

    }

    @Test
    public void inwardOneGBP_balanceEqualsOneGBP() {

        Wallet wallet = new Wallet(CurrencyType.GBP);

        wallet.depositAmount(new Money(CurrencyType.GBP, 1));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.GBP, 1), balance);

    }

    @Test
    public void GBP_1_and_80_INR_balanceEquals_240_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.GBP, 1));
        wallet.depositAmount(new Money(CurrencyType.INR, 80));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 240), balance);

    }

    @Test
    public void GBP_1_and_2_USD_balanceEquals_3_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.GBP, 1));
        wallet.depositAmount(new Money(CurrencyType.USD, 2));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 4), balance);

    }


    @Test
    public void GBP_1_and_1_USD_balanceEquals_3_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.GBP, 1));
        wallet.depositAmount(new Money(CurrencyType.USD, 1));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 3), balance);

    }

    @Test
    public void GBP_1_and_2_USD_balanceEquals_2_GBP() {

        Wallet wallet = new Wallet(CurrencyType.GBP);
        wallet.depositAmount(new Money(CurrencyType.GBP, 1));
        wallet.depositAmount(new Money(CurrencyType.USD, 2));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.GBP, 2), balance);

    }

    @Test
    public void GBP_1_and_160_INR_balanceEquals_2_GBP() {

        Wallet wallet = new Wallet(CurrencyType.GBP);
        wallet.depositAmount(new Money(CurrencyType.GBP, 1));
        wallet.depositAmount(new Money(CurrencyType.INR, 160));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.GBP, 2), balance);

    }

    @Test
    public void balanceShouldBe_1_INRAfterWithdrawing_1_INRFromBalance_2_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 2));
        wallet.withdrawAmount(new Money(CurrencyType.INR, 1));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 1), balance);

    }

    @Test
    public void balanceShouldBe_5_INRAfterWithdrawing_5_INRFromBalance_10_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 10));
        wallet.withdrawAmount(new Money(CurrencyType.INR, 5));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 5), balance);

    }

    @Test
    public void balanceShouldBe_5_USDAfterWithdrawing_5_USDFromBalance_10_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 10));
        wallet.withdrawAmount(new Money(CurrencyType.USD, 5));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 5), balance);

    }

    @Test
    public void balanceShouldBe_2_USDAfterWithdrawing_3_USDFromBalance_5_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 5));
        wallet.withdrawAmount(new Money(CurrencyType.USD, 3));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 2), balance);

    }

    @Test
    public void balanceShouldBe_2_GBPAfterWithdrawing_3_GBPFromBalance_5_GBP() {

        Wallet wallet = new Wallet(CurrencyType.GBP);
        wallet.depositAmount(new Money(CurrencyType.GBP, 5));
        wallet.withdrawAmount(new Money(CurrencyType.GBP, 3));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.GBP, 2), balance);

    }

    @Test
    public void balanceShouldBe_10_GBPAfterWithdrawing_10_GBPFromBalance_20_GBP() {

        Wallet wallet = new Wallet(CurrencyType.GBP);
        wallet.depositAmount(new Money(CurrencyType.GBP, 20));
        wallet.withdrawAmount(new Money(CurrencyType.GBP, 10));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.GBP, 10), balance);

    }

    @Test
    public void balanceShouldBe_10_BTHAfterWithdrawing_10_BTHFromBalance_20_BTH() {

        Wallet wallet = new Wallet(CurrencyType.BTH);
        wallet.depositAmount(new Money(CurrencyType.BTH, 20));
        wallet.withdrawAmount(new Money(CurrencyType.BTH, 10));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.BTH, 10), balance);

    }

    @Test
    public void balanceShouldBe_5_BTHAfterWithdrawing_10_BTHFromBalance_15_BTH() {

        Wallet wallet = new Wallet(CurrencyType.BTH);
        wallet.depositAmount(new Money(CurrencyType.BTH, 15));
        wallet.withdrawAmount(new Money(CurrencyType.BTH, 10));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.BTH, 5), balance);

    }

    @Test
    public void balanceShouldBe_5_INRAfterWithdrawing_10_BTHFromBalance_10_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 10));
        wallet.withdrawAmount(new Money(CurrencyType.BTH, 10));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 5), balance);

    }

    @Test
    public void balanceShouldBe_10_INRAfterWithdrawing_20_BTHFromBalance_20_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 20));
        wallet.withdrawAmount(new Money(CurrencyType.BTH, 20));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 10), balance);

    }

    @Test
    public void balanceShouldBe_10_INRAfterWithdrawing_1_USDFromBalance_90_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 90));
        wallet.withdrawAmount(new Money(CurrencyType.USD, 1));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 10), balance);

    }

    @Test
    public void balanceShouldBe_0_INRAfterWithdrawing_2_USDFromBalance_160_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 160));
        wallet.withdrawAmount(new Money(CurrencyType.USD, 2));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 0), balance);

    }

    @Test
    public void balanceShouldBe_0_INRAfterWithdrawing_1_GBPFromBalance_160_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 160));
        wallet.withdrawAmount(new Money(CurrencyType.GBP, 1));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 0), balance);

    }

    @Test
    public void balanceShouldBe_10_INRAfterWithdrawing_2_GBPFromBalance_330_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 330));
        wallet.withdrawAmount(new Money(CurrencyType.GBP, 2));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.INR, 10), balance);

    }

    @Test
    public void balanceShouldBe_1_USDAfterWithdrawing_2_GBPFromBalance_5_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 5));
        wallet.withdrawAmount(new Money(CurrencyType.GBP, 2));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 1), balance);

    }

    @Test
    public void balanceShouldBe_4_USDAfterWithdrawing_3_GBPFromBalance_10_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 10));
        wallet.withdrawAmount(new Money(CurrencyType.GBP, 3));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 4), balance);

    }

    @Test
    public void balanceShouldBe_1_USDAfterWithdrawing_160_BTHFromBalance_2_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 2));
        wallet.withdrawAmount(new Money(CurrencyType.BTH, 160));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 1), balance);

    }

    @Test
    public void balanceShouldBe_2_USDAfterWithdrawing_80_INRFromBalance_3_USD() {

        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 3));
        wallet.withdrawAmount(new Money(CurrencyType.INR, 80));
        Money balance = wallet.balance();
        assertEquals(new Money(CurrencyType.USD, 2), balance);

    }

    @Test()
    public void shouldGiveInsufficientBalanceErrorMessageIfTryToWithdraw_5_INRFromBalance_2_INR() {
        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 2));
        Exception exception = assertThrows(RuntimeException.class, () -> wallet.withdrawAmount(new Money(CurrencyType.INR, 5)));
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test()
    public void shouldGiveInsufficientBalanceErrorMessageIfTryToWithdrawFromEmptyWallet() {
        Wallet wallet = new Wallet(CurrencyType.INR);
        Exception exception = assertThrows(RuntimeException.class, () -> wallet.withdrawAmount(new Money(CurrencyType.INR, 2)));
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    @DisplayName("History should display 2 INR credited with balance 2 INR")
    public void transactionHistoryAfterCrediting_2_INR() {

        Wallet wallet = new Wallet(CurrencyType.INR);

        Money amountToBDeposited = new Money(CurrencyType.INR, 2);
        Transaction recordedTransaction = wallet.depositAmount(amountToBDeposited);

        List<Transaction> transactions = wallet.transactions();

        assertTrue(transactions.contains(recordedTransaction));
    }

    @Test
    @DisplayName("History should display 4 USD credited with balance 4 USD")
    public void transactionHistoryAfterCrediting_4_USD() {
        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 4));
        Transaction actual = wallet.getHistory();
        assertEquals(new Transaction(new Money(CurrencyType.USD, 4), TransactionType.CREDIT, new Money(CurrencyType.USD, 4)), actual);
    }

    @Test
    @DisplayName("History should display 4 USD credited with balance 320 INR")
    public void transactionHistoryAfterCrediting_4_USD_To_INR_Wallet() {
        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.USD, 4));
        Transaction actual = wallet.getHistory();
        assertEquals(new Transaction(new Money(CurrencyType.USD, 4), TransactionType.CREDIT, new Money(CurrencyType.INR, 320)), actual);
    }

    @Test
    @DisplayName("History should display 2 GBP credited with balance 4 USD")
    public void transactionHistoryAfterCrediting_2_GBP_To_USD_Wallet() {
        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.GBP, 2));
        Transaction actual = wallet.getHistory();
        assertEquals(new Transaction(new Money(CurrencyType.GBP, 2), TransactionType.CREDIT, new Money(CurrencyType.USD, 4)), actual);
    }

    @Test
    @DisplayName("History should display 10 INR debited with balance 5 INR")
    public void transactionHistoryAfterDebiting_10_INR_From_15_INR() {
        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 15));
        wallet.withdrawAmount(new Money(CurrencyType.INR, 10));
        Transaction actual = wallet.getHistory();
        assertEquals(new Transaction(new Money(CurrencyType.INR, 10), TransactionType.DEBIT, new Money(CurrencyType.INR, 5)), actual);
    }

    @Test
    @DisplayName("History should display 1 USD debited with balance 3 USD")
    public void transactionHistoryAfterDebiting_1_USD_From_3_USD() {
        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 3));
        wallet.withdrawAmount(new Money(CurrencyType.USD, 1));
        Transaction actual = wallet.getHistory();
        assertEquals(new Transaction(new Money(CurrencyType.USD, 1), TransactionType.DEBIT, new Money(CurrencyType.USD, 2)), actual);
    }

    @Test
    @DisplayName("History should display 4 GBP debited with balance 8 GBP")
    public void transactionHistoryAfterDebiting_4_GBP_From_8_GBP() {
        Wallet wallet = new Wallet(CurrencyType.GBP);
        wallet.depositAmount(new Money(CurrencyType.GBP, 8));
        wallet.withdrawAmount(new Money(CurrencyType.GBP, 4));
        Transaction actual = wallet.getHistory();
        assertEquals(new Transaction(new Money(CurrencyType.GBP, 4), TransactionType.DEBIT, new Money(CurrencyType.GBP, 4)), actual);
    }

    @Test
    @DisplayName("History should display 80 INR debited with balance 1 USD")
    public void transactionHistoryAfterDebiting_80_INR_From_2_USD() {
        Wallet wallet = new Wallet(CurrencyType.USD);
        wallet.depositAmount(new Money(CurrencyType.USD, 2));
        wallet.withdrawAmount(new Money(CurrencyType.INR, 80));
        Transaction actual = wallet.getHistory();
        assertEquals(new Transaction(new Money(CurrencyType.INR, 80), TransactionType.DEBIT, new Money(CurrencyType.USD, 1)), actual);
    }

    @Test
    @DisplayName("History should display 2 USD debited with balance 3 GBP")
    public void transactionHistoryAfterDebiting_2_USD_From_4_GBP() {
        Wallet wallet = new Wallet(CurrencyType.GBP);
        wallet.depositAmount(new Money(CurrencyType.GBP, 4));
        wallet.withdrawAmount(new Money(CurrencyType.USD, 2));
        Transaction actual = wallet.getHistory();
        assertEquals(new Transaction(new Money(CurrencyType.USD, 2), TransactionType.DEBIT, new Money(CurrencyType.GBP, 3)), actual);
    }

    @Test
    public void walletWithBalance_2_INR_ShouldBeDisplayedBeforeWalletWithBalance_1_INR_AfterSorting() {
        Wallet walletINROne = new Wallet(CurrencyType.INR);
        Wallet walletINRTwo = new Wallet(CurrencyType.INR);

        walletINROne.depositAmount(new Money(CurrencyType.INR, 1));
        walletINRTwo.depositAmount(new Money(CurrencyType.INR, 2));

        List<Wallet> walletCollection = new ArrayList<>();
        walletCollection.add(walletINROne);
        walletCollection.add(walletINRTwo);

        List<Wallet> walletCollectionExpected = new ArrayList<>();
        walletCollectionExpected.add(walletINRTwo);
        walletCollectionExpected.add(walletINROne);

        walletCollection = Wallet.sort(walletCollection, Wallet.MAX_BALANCE);

        assertEquals(walletCollectionExpected, walletCollection);
    }

    @Test
    public void walletWithBalance_4_INR_ShouldBeDisplayedBeforeWalletWithBalance_3_INR_AfterSorting() {
        Wallet walletINROne = new Wallet(CurrencyType.INR);
        Wallet walletINRTwo = new Wallet(CurrencyType.INR);

        walletINROne.depositAmount(new Money(CurrencyType.INR, 4));
        walletINRTwo.depositAmount(new Money(CurrencyType.INR, 3));

        List<Wallet> walletCollection = new ArrayList<>();
        walletCollection.add(walletINROne);
        walletCollection.add(walletINRTwo);

        List<Wallet> walletCollectionExpected = new ArrayList<>();
        walletCollectionExpected.add(walletINROne);
        walletCollectionExpected.add(walletINRTwo);

        walletCollection = Wallet.sort(walletCollection, Wallet.MAX_BALANCE);

        assertEquals(walletCollectionExpected, walletCollection);
    }

    @Test
    public void walletWithBalance_1_USD_ShouldBeDisplayedBeforeWalletWithBalance_60_INR_AfterSorting() {
        Wallet walletINROne = new Wallet(CurrencyType.INR);
        Wallet walletINRTwo = new Wallet(CurrencyType.USD);

        walletINROne.depositAmount(new Money(CurrencyType.INR, 60));
        walletINRTwo.depositAmount(new Money(CurrencyType.USD, 1));

        List<Wallet> walletCollection = new ArrayList<>();
        walletCollection.add(walletINROne);
        walletCollection.add(walletINRTwo);

        List<Wallet> walletCollectionExpected = new ArrayList<>();
        walletCollectionExpected.add(walletINRTwo);
        walletCollectionExpected.add(walletINROne);

        walletCollection = Wallet.sort(walletCollection, Wallet.MAX_BALANCE);

        assertEquals(walletCollectionExpected, walletCollection);
    }

    @Test
    public void walletWithBalance_160_INR_ShouldBeDisplayedBeforeWalletWithBalance_2_USD_AfterSorting() {
        Wallet walletINROne = new Wallet(CurrencyType.INR);
        Wallet walletINRTwo = new Wallet(CurrencyType.USD);

        walletINROne.depositAmount(new Money(CurrencyType.INR, 80));
        walletINROne.depositAmount(new Money(CurrencyType.INR, 80));
        walletINRTwo.depositAmount(new Money(CurrencyType.USD, 2));

        List<Wallet> walletCollection = new ArrayList<>();
        walletCollection.add(walletINRTwo);
        walletCollection.add(walletINROne);

        List<Wallet> walletCollectionExpected = new ArrayList<>();
        walletCollectionExpected.add(walletINROne);
        walletCollectionExpected.add(walletINRTwo);

        walletCollection = Wallet.sort(walletCollection, Wallet.MAX_BALANCE);

        assertEquals(walletCollectionExpected, walletCollection);
    }

    @Test
    public void walletWithBalance_4_USD_ShouldBeDisplayedBeforeWalletWithBalance_2_GBP_AfterSorting() {
        Wallet walletINROne = new Wallet(CurrencyType.GBP);
        Wallet walletINRTwo = new Wallet(CurrencyType.USD);

        walletINROne.depositAmount(new Money(CurrencyType.USD, 2));
        walletINROne.depositAmount(new Money(CurrencyType.USD, 2));
        walletINRTwo.depositAmount(new Money(CurrencyType.GBP, 2));

        List<Wallet> walletCollection = new ArrayList<>();
        walletCollection.add(walletINRTwo);
        walletCollection.add(walletINROne);

        List<Wallet> walletCollectionExpected = new ArrayList<>();
        walletCollectionExpected.add(walletINROne);
        walletCollectionExpected.add(walletINRTwo);

        walletCollection = Wallet.sort(walletCollection, Wallet.MAX_BALANCE);

        assertEquals(walletCollectionExpected, walletCollection);
    }

    @Test
    public void walletWithBalance_4_USD_ShouldBeDisplayedBeforeWalletWithBalance_5_USD_AfterSorting() {
        Wallet walletINROne = new Wallet(CurrencyType.USD);
        Wallet walletINRTwo = new Wallet(CurrencyType.USD);

        walletINROne.depositAmount(new Money(CurrencyType.USD, 4));
        walletINRTwo.depositAmount(new Money(CurrencyType.USD, 5));

        List<Wallet> walletCollection = new ArrayList<>();
        walletCollection.add(walletINRTwo);
        walletCollection.add(walletINROne);

        List<Wallet> walletCollectionExpected = new ArrayList<>();
        walletCollectionExpected.add(walletINROne);
        walletCollectionExpected.add(walletINRTwo);

        walletCollection = Wallet.sort(walletCollection, Wallet.LEAST_BALANCE);

        assertEquals(walletCollectionExpected, walletCollection);
    }

    @Test
    public void walletWithBalance_3_INR_ShouldBeDisplayedBeforeWalletWithBalance_4_INR_BeforeWalletWithBalance_5_INR_AfterSorting() {
        Wallet walletINROne = new Wallet(CurrencyType.INR);
        Wallet walletINRTwo = new Wallet(CurrencyType.INR);
        Wallet walletINRThree = new Wallet(CurrencyType.INR);

        walletINROne.depositAmount(new Money(CurrencyType.INR, 3));
        walletINRTwo.depositAmount(new Money(CurrencyType.INR, 4));
        walletINRThree.depositAmount(new Money(CurrencyType.INR, 5));

        List<Wallet> walletCollection = new ArrayList<>();
        walletCollection.add(walletINRThree);
        walletCollection.add(walletINRTwo);
        walletCollection.add(walletINROne);

        List<Wallet> walletCollectionExpected = new ArrayList<>();
        walletCollectionExpected.add(walletINROne);
        walletCollectionExpected.add(walletINRTwo);
        walletCollectionExpected.add(walletINRThree);

        walletCollection = Wallet.sort(walletCollection, Wallet.LEAST_BALANCE);

        assertEquals(walletCollectionExpected, walletCollection);
    }

}
