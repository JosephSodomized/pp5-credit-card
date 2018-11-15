package pl.dmal.creditcard;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardApiTest{

    private static final double initialCredit = 200;
    private static final String id = "666";
    private CreditCardRepository repository;
    private CreditCardApi api;

    @Test
    public void withdrawFromCard(){
        thereIsCardWithRepository();
        thereIsCardWithApi();
        thereIsCardWithId(id);
        
        api.withdraw(id, 20);
        
        ballanceOfcardWithIdEquals(id, 180);
    }

    private void thereIsCardWithId(String id){
        CreditCard c = new CreditCard(id);
        c.assignLimit(BigDecimal.valueOf(initialCredit));

        repository.add(c);
    }

    private void thereIsCardWithApi(){
        this.api = new CreditCardApi(this.repository);
    }

    private void thereIsCardWithRepository(){
        this.repository = new CreditCardRepository();
    }

    private void ballanceOfcardWithIdEquals(String id, double money){
        CreditCard c = repository.find(id);

        Assert.assertEquals(
            BigDecimal.valueOf(money), 
            c.getBalance());
    }
}