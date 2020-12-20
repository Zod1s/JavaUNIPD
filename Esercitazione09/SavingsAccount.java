public class SavingsAccount extends BankAccount{
    private double interestRate;
    public SavingsAccount(double rate){
        super();               // costruttore della superclasse
        interestRate = rate;
    }

    public SavingsAccount(double initialBalance, double rate){
        super(initialBalance); // costruttore della superclasse
        interestRate = rate;
    }

    //accredita gli interessi al termine del mese. Attenzione: usa il metodo
    //deposit della superclasse, altrimenti verrebbe addebitata la penale FEE
    public void addInterest(){
        super.deposit(getBalance() * interestRate / 100);
    }

    // ------- metodi di accesso --------

    public double getInterestRate(){   
        return interestRate;
    }

    // ------ metodi di Object sovrascritti ---------
    // ........... toString, equals .................
    public String toString(){
        return "SavingsAccount[rate = " + interestRate + "]" + super.toString();
    }

    public boolean equals(Object account){
        if (account instanceof SavingsAccount){
            SavingsAccount s = (SavingsAccount) account;
            // BankAccount b = (BankAccount) account;
            return (interestRate == s.interestRate && super.equals(account));
        }
        return false;
    }
}
