public class BankAccount{
    private double m;
    /**
       costruttore della classe BankAccount, imposta il saldo a 0.
       @param none
       @return none
    */
    public BankAccount(){
        this.m = 0;
    }
    /**
       saldo corrente.
       @param none
       @return balance
    */
    public double getBalance(){
        return this.m;
    }
    /**
       ritira soldi
       @param double amount
       @return none
    */
    public void withdraw(double amount){
        this.m -= amount;
    }
    /**
       deposita soldi
       @param double amount
       @return none
    */
    public void deposit(double amount){
        this.m += amount;
    }
}
