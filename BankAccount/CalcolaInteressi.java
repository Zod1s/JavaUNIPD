public class CalcolaInteressi{
    public static void main(String[] args){
        BankAccount account = new BankAccount();
        account.deposit(100);
        double interesse = account.getBalance() * 0.05;
        account.deposit(interesse);
        System.out.println(account.getBalance());
    }
}
