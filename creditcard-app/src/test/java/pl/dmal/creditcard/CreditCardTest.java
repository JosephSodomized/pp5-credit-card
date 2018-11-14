package pl.dmal.creditcard;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {

    private static BigDecimal money(double x) {
        return BigDecimal.valueOf(x);
    }

    @Test
    public void allowAssignLimitToCard() {
        CreditCard card1 = new CreditCard();

        card1.assignLimit(money(2000));

        Assert.assertTrue(card1.getLimit().equals(money(2000)));
    }

    @Test(expected = WithdrawWhenOverTheLimit.class)
    public void cantWithdrawWhenCantAfford() {
        CreditCard card = new CreditCard();
        card.assignLimit(money(2000));
        card.withdraw(money(3000));
        Assert.assertTrue(card.getLimit().equals(money(2000)));
    }
    
    @Test
    public void cardBlockCard(){
        CreditCard card = new CreditCard();
        card.block();
    
        Assert.assertTrue(card.isBlocked());
    }

    @Test(expected = WithdrawWhenOverTheLimit.class)
    public void cantWithdrawWhenOverTheLimit() throws Exception{
        CreditCard card = new CreditCard();
        card.assignLimit(money(200));
        card.withdraw(money(300));
    }

    
    @Test
    public void repayCredit() {
        CreditCard card = new CreditCard();
        card.assignLimit(money(1000));
        card.withdraw(money(500));
        card.withdraw(money(200));
        card.repay(money(400));
        Assert.assertTrue(money(700).equals(card.getBalance()));
    }
}