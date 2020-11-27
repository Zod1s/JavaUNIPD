public class BankAccount{
    private double balance; // le variabili di esemplare devono essere dichiarate fuori dai metodi

    public BankAccount(){
        balance = 0;
    }

    public BankAccount(double init){
        balance = init;
    }
    /**
       ritira una quantità di denaro
       @param double amount quanto ritirare
       @throws IllegalArgumentException se saldo < amount
     */
    public void withdraw(double amount){
        balance -= amount;
    }
    /**
       deposita denaro nel conto
       @param double amount quanto deposito
       @throws IllegalArgumentException se amount < 0
     */
    public void deposit(double amount){
        balance += amount;
    }
    /**
       ritorna il saldo
       @return double balance il saldo
     */
    public double getBalance(){
        return balance;
    }

    public String toString(){
        return "BankAccount, saldo: "+balance;
    }
}
