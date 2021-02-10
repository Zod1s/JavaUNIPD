public class TimeDepositAccount extends SavingsAccount{
    private int months;
    public TimeDepositAccount(double rate, int months){
        super(rate);
        this.months = months;
    }

    public TimeDepositAccount(double amount, double rate, int months){
        super(amount, rate);
        this.months = months;
    }

    public void addInterest(){
        super.addInterest();
        if (months > 0) months--;
    }

    public int getMonthsLeft(){
        return months;
    }

    public String toString(){
        return "TimeDepositAccount[months = " + months + "]" + super.toString();
    }

    public boolean equals(Object account){
        if (account instanceof TimeDepositAccount){
            TimeDepositAccount t = (TimeDepositAccount) account;
            // SavingsAccount s = (SavingsAccount)
            return (months == t.months && super.equals(account));
        }
        return false;
    }
}
