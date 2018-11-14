package pl.jkan.creditcard;

class CreditCard {
    
     
     public boolean blockade = false;
     private double balance = 0;
     
     public void assignLimit(double limit){
         
     }
    
    
    public double getBalance() {
        return balance;
    }
    
    public double getLimit() {
        return 2000;
    }
    
    public void block(){
        this.blockade=true;
    }
    
    public boolean isBlocked(){
        return this.blockade;
    }
    
    public void repay(double money) {
        
        if(money < 0){
            
        }
        
        balance = balance + money;
    }
}