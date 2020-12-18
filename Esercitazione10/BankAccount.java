public class BankAccount implements Comparable{
    private double balance;
    public BankAccount(){
        balance = 0;
    }

    public BankAccount(double initialBalance){
        deposit(initialBalance);
    }

    public void deposit(double amount){
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance = balance + amount;
    }

    public void withdraw(double amount){
        if (amount > balance || amount <= 0)
            throw new IllegalArgumentException();
        balance = balance - amount;
    }

    public void transfer(double amount, BankAccount other){ 
        withdraw(amount);
        other.deposit(amount);
    }

    // ------- metodi di accesso --------

    public double getBalance(){   
        return balance;
    }

    public int compareTo(Object account){
        BankAccount b = (BankAccount) account;
        if (balance == b.balance) return 0;
        if (balance > b.balance) return 1;
        else return -1;
    }
    
    // ------ metodi di Object da sovrascrivere ---------
    // ......... toString e equals ......................
    public String toString(){
        return "BankAccount[balance = " + balance + "]" + super.toString();
    }

    public boolean equals(Object account){
        if (account instanceof BankAccount){
            BankAccount b = (BankAccount) account;
            return (balance == b.balance);
        }
        return false;
    }
}
