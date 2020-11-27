public class BankAccountTester{
    public static void main(String[] args){
        BankAccount account = new BankAccount();

        System.out.println("Saldo iniziale "+account.getBalance());
        account.deposit(100);
        System.out.println("Saldo dopo il deposito di 100 euro "+
                           account.getBalance());
        account.withdraw(20);
        System.out.println("Saldo dopo il ritiro di 20 euro "+
                           account.getBalance());
    }
}
