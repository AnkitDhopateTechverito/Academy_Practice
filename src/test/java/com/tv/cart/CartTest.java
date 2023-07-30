package com.tv.cart;

import com.tv.wallet.CurrencyType;
import com.tv.wallet.Money;
import com.tv.wallet.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CartTest {
    @Test
    public void inventoryShouldContain_99_ApplesAfterAdding_1_AppleToCart() {
        Fruit apple = new Fruit(100, 10);

        Cart cart = new Cart();
        cart.add(apple, 1);

        Assertions.assertEquals(1, cart.items.get(apple));
    }

    @Test
    public void inventoryShouldContain_14_OrangesAfterAdding_1_OrangeToCart() {
        Fruit orange = new Fruit(15, 20);

        Cart cart = new Cart();
        cart.add(orange, 1);

        Assertions.assertEquals(1, cart.items.get(orange));
    }

    @Test
    public void inventoryShouldContain_13_OrangesAfterAdding_2_OrangesToCart() {
        Fruit orange = new Fruit(15, 20);

        Cart cart = new Cart();
        cart.add(orange, 1);
        cart.add(orange, 1);

        Assertions.assertEquals(2, cart.items.get(orange));
    }

    @Test
    public void totalShouldBe_10_AfterAdding_1_AppleToCart() {
        Fruit apple = new Fruit(10, 10);

        Cart cart = new Cart();
        cart.add(apple, 1);

        Assertions.assertEquals(10, cart.getTotal());
    }

    @Test
    public void totalShouldBe_20_AfterAdding_2_AppleToCart() {
        Fruit apple = new Fruit(10, 10);

        Cart cart = new Cart();
        cart.add(apple, 2);

        Assertions.assertEquals(20, cart.getTotal());
    }

    @Test
    public void totalShouldBe_10_AfterAdding_2_ApplesToCartWithOffer() {
        Fruit apple = new Fruit(10, 10);

        Cart cart = new Cart();
        cart.add(apple, 2);
        apple.applyOffer(new BuyAndGetMore(1, 1) {
            @Override
            public int offerPrice(Integer quantity, int price) {

                return (int) Math.ceil((double) quantity / 2) * price;

            }
        });

        Assertions.assertEquals(10, cart.getTotal());
    }

    @Test
    public void totalShouldBe_20_AfterAdding_1_OrangeToCart() {
        Fruit orange = new Fruit(10, 20);

        Cart cart = new Cart();
        cart.add(orange, 1);

        Assertions.assertEquals(20, cart.getTotal());
    }

    @Test
    public void totalShouldBe_40_AfterAdding_2_OrangesToCart() {
        Fruit orange = new Fruit(10, 20);


        Cart cart = new Cart();
        cart.add(orange, 2);

        Assertions.assertEquals(40, cart.getTotal());
    }

    @Test
    public void totalShouldBe_30_AfterAdding_1_OrangeAnd_1_AppleToCart() {
        Fruit orange = new Fruit(10, 20);
        Fruit apple = new Fruit(10, 10);

        apple.applyOffer(new BuyAndGetMore(1, 1) {
            @Override
            public int offerPrice(Integer quantity, int price) {

                return (int) Math.ceil((double) quantity / 2) * price;

            }
        });
        Cart cart = new Cart();
        cart.add(orange, 1);
        cart.add(apple, 1);

        Assertions.assertEquals(30, cart.getTotal());
    }

    @Test
    public void totalShouldBe_30_AfterAdding_5_AppleToCart() {
        Fruit apple = new Fruit(10, 10);
        apple.applyOffer(new BuyAndGetMore(1, 1) {
            @Override
            public int offerPrice(Integer quantity, int price) {

                return (int) Math.ceil((double) quantity / 2) * price;

            }
        });
        Cart cart = new Cart();
        cart.add(apple, 5);

        Assertions.assertEquals(30, cart.getTotal());
    }

    @Test
    public void totalShouldBe_40_AfterAdding_3_OrangeToCartWithBuy_2_Get_3() {
        Fruit orange = new Fruit(10, 20);
        orange.applyOffer(new BuyAndGetMore(2, 3) {
            @Override
            public int offerPrice(Integer quantity, int price) {
                if (quantity == 1)
                    return price;
                else
                    return 2 * price;
            }
        });
        Cart cart = new Cart();
        cart.add(orange, 3);

        Assertions.assertEquals(40, cart.getTotal());
    }

    @Test
    public void totalShouldBe_40_AfterAdding_2_OrangeToCartWithBuy_2_Get_3() {
        Fruit orange = new Fruit(10, 20);
        orange.applyOffer(new BuyAndGetMore(2, 3) {
            @Override
            public int offerPrice(Integer quantity, int price) {
                if (quantity == 1)
                    return price;
                else
                    return 2 * price;
            }
        });
        Cart cart = new Cart();
        cart.add(orange, 2);

        Assertions.assertEquals(40, cart.getTotal());
    }

    @Test
    public void totalShouldBe_20_AfterAdding_1_OrangeToCartWithBuy_2_Get_3() {
        Fruit orange = new Fruit(10, 20);
        orange.applyOffer(new BuyAndGetMore(2, 3) {
            @Override
            public int offerPrice(Integer quantity, int price) {
                if (quantity == 1)
                    return price;
                else
                    return 2 * price;
            }
        });
        Cart cart = new Cart();
        cart.add(orange, 1);

        Assertions.assertEquals(20, cart.getTotal());
    }

    @Test
    public void totalShouldBe_40_AfterAdding_4_OrangeToCartWithBuy_2_Get_3() {
        Fruit orange = new Fruit(10, 20);
        orange.applyOffer(new BuyAndGetMore(2, 3) {
            @Override
            public int offerPrice(Integer quantity, int price) {
                if (quantity == 1)
                    return price;
                else
                    return 2 * price;
            }
        });
        Cart cart = new Cart();
        cart.add(orange, 4);

        Assertions.assertEquals(40, cart.getTotal());
    }

    @Test
    public void totalShouldBe_40_AfterAdding_5_OrangeToCartWithBuy_2_Get_3() {
        Fruit orange = new Fruit(10, 20);
        orange.applyOffer(new BuyAndGetMore(2, 3) {
            @Override
            public int offerPrice(Integer quantity, int price) {
                if (quantity == 1)
                    return price;
                else
                    return 2 * price;
            }
        });
        Cart cart = new Cart();
        cart.add(orange, 5);

        Assertions.assertEquals(40, cart.getTotal());
    }

    @Test
    public void totalShouldBe_50_AfterAdding_5_OrangeAnd_2_AppleToCartWithBuy_2_Get_3_AndBuy_1_GET_1_Respectively() {
        Fruit orange = new Fruit(10, 20);
        Fruit apple = new Fruit(10, 10);
        orange.applyOffer(new BuyAndGetMore(2, 3) {
            @Override
            public int offerPrice(Integer quantity, int price) {
                if (quantity == 1)
                    return price;
                else
                    return 2 * price;
            }
        });
        apple.applyOffer(new BuyAndGetMore(1, 1) {
            @Override
            public int offerPrice(Integer quantity, int price) {

                return (int) Math.ceil((double) quantity / 2) * price;

            }
        });
        Cart cart = new Cart();
        cart.add(orange, 5);
        cart.add(apple, 2);

        Assertions.assertEquals(50, cart.getTotal());
    }

    @Test
    public void totalShouldBe_8_whenAdded_1_AppleToTheCartWith_20_percentDiscount() {
        Fruit apple = new Fruit(10, 10);
        apple.applyOffer(new Discount(20));
        Cart cart = new Cart();
        cart.add(apple, 1);

        Assertions.assertEquals(8, cart.getTotal());
    }

    @Test
    public void totalShouldBe_16_whenAdded_2_AppleToTheCartWith_20_percentDiscount() {
        Fruit apple = new Fruit(10, 10);
        apple.applyOffer(new Discount(20));
        Cart cart = new Cart();
        cart.add(apple, 2);

        Assertions.assertEquals(16, cart.getTotal());
    }

    @Test
    public void totalShouldBe_16_whenAdded_1_OrangeToTheCartWith_20_percentDiscount() {
        Fruit orange = new Fruit(10, 20);
        orange.applyOffer(new Discount(20));
        Cart cart = new Cart();
        cart.add(orange, 1);

        Assertions.assertEquals(16, cart.getTotal());
    }

    @Test
    public void whenCheckoutBalanceIs_0_ThenAmountWouldNotGetDeducted() {
        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 10));

        Cart cart = new Cart();

        cart.checkout(wallet);

        Assertions.assertEquals(new Money(CurrencyType.INR, 10), wallet.balance());
    }

    @Test
    public void whenCheckoutBalanceIs_10_Then_10_INRBalanceWalletShouldBecomeEmpty() {
        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 10));

        Fruit apple = new Fruit(10, 10);
        Cart cart = new Cart();
        cart.add(apple, 1);

        cart.checkout(wallet);

        Assertions.assertEquals(new Money(CurrencyType.INR, 0), wallet.balance());
    }

    @Test
    public void whenCheckoutBalanceIs_10_Then_0_INRBalanceWalletShouldThrowInsufficientBalanceException() {
        Wallet wallet = new Wallet(CurrencyType.INR);

        Fruit apple = new Fruit(10, 10);
        Cart cart = new Cart();
        cart.add(apple, 1);

        try {
            cart.checkout(wallet);
        } catch (RuntimeException re) {
            Assertions.assertEquals("Insufficient balance", re.getMessage());
        }
    }

    @Test
    public void whenCheckoutBalanceIs_10_moneyIsPaidThroughPayPal() {
        Wallet wallet = new Wallet(CurrencyType.INR);
        wallet.depositAmount(new Money(CurrencyType.INR, 10));

        Fruit apple = new Fruit(10, 10);
        Cart cart = new Cart();
        cart.add(apple, 1);

        Payment paymentMock = mock(Payment.class);

        Money paymentAmount = new Money(CurrencyType.INR, 10);
        doNothing().when(paymentMock).pay(paymentAmount);

        paymentMock.pay(paymentAmount);

        verify(paymentMock).pay(paymentAmount);
    }
}


