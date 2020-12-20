public class BankAccount{
    // private static int num = 0;
    // private int accountNum;
    private double m;
    public BankAccount(){
        m = 0;
        // accountNum = num++;
    }
    public BankAccount(int s){
        if (s > 0){
            m = s;
        }
        else{
            m = 0;
        }
    }
    public double getBalance(){
        return m;
        // accountNum = num++;
    }
    public boolean withdraw(double amount){
        if (amount > 0 && m >= amount){
            m -= amount;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deposit(double amount){
        if (amount > 0){
            m += amount;
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return "Saldo: "+m;
    }
}
