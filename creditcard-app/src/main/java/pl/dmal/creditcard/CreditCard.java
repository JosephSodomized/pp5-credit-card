package pl.dmal.creditcard;
import java.math.BigDecimal;

class CreditCard {

    private BigDecimal limit;
     
     public boolean blockade = false;
     private BigDecimal balance = BigDecimal.ZERO;

     public void assignLimit(BigDecimal money){
        this.limit = money;
        this.balance = money;
     }
    
    public BigDecimal getLimit() {
        return limit;
    }
    
    
    public void block(){
        this.blockade=true;
    }
    
    public boolean isBlocked(){
        return this.blockade;
    }

    public void withdraw(BigDecimal money) {

        if (isNotEnoughMoney(money))
        throw new WithdrawWhenOverTheLimit();

        balance = balance.subtract(money);
    }

    private boolean isNotEnoughMoney(BigDecimal money) {
        return money.compareTo(balance) > 0;
    }

    public void repay(BigDecimal money){
        if (money.compareTo(BigDecimal.ZERO) < 0) {
            throw new CantRepayMinusAmountException();
        }
        balance = balance.add(money);
    }

    public BigDecimal getBalance() {
        return balance;
    }

}