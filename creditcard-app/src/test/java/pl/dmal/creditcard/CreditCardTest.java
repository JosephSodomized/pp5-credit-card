package pl.dmal.creditcard;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void allowAssignLimitToCard() {
        CreditCard card = new CreditCard();

        card.assignLimit(2000);

        Assert.assertTrue(card.getLimit() == 2000);
    }

    @Test
    public void cantWithdrawWhenCantAfford() {
    
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
        card.assignLimit(200);
        card.withdraw(300);
    }

}