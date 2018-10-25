package pl.jkan.creditcard;

class CreditCard {
    
     
     public boolean blockade = false;
     
     public void assignLimi(double limit){
         
     }
    
    
    public double getLimit() {
        return 2000;
    }
    
    public void block(){
        this.blockade=true;
    }
    
    public boolean isBloked{
        return this.blockade;
    }
}