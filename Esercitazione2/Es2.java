public class Es2{
    public static void main(String[] args){
	// Es 3
	/*
	System.out.println(Byte.MIN_VALUE);
	System.out.println(Byte.MAX_VALUE);
	System.out.println(Short.MIN_VALUE);
	System.out.println(Short.MAX_VALUE);
	System.out.println(Character.MIN_VALUE);
 	System.out.println(Character.MAX_VALUE);
 	System.out.println(Integer.MIN_VALUE);
	System.out.println(Integer.MAX_VALUE);
	System.out.println(Long.MIN_VALUE);
	System.out.println(Long.MAX_VALUE);
	System.out.println(Float.MIN_VALUE);
	System.out.println(Float.MAX_VALUE);
	System.out.println(Double.MIN_VALUE);
	System.out.println(Double.MAX_VALUE); */
	// Es 4
	/*
	double r = 10.12;
	final double PI = 3.14159265358979;
	double circ = 2 * r * PI;
	System.out.println("La circonferenza di raggio "+r+"e' pari a "+circ);
	double area = r * r * PI;
	System.out.println("L'area di un cerchio di raggio "+r+" e' pari a "+area); */
	/* Es 5
	double r = 10.12;
	final double PI = 3.14159265358979;
	double h = 10.87;
	double area = r * r * PI;
	double vol = area * h;
	System.out.println("Il volume del cilindro di raggio "+r+" e altezza "+h+" e' pari a "+vol); */
	// Es 6
	/*
	final int A = 47;
	System.out.println(A/100+" "+(A%100)/10+" "+(A%10)); */
	// Es 7
	/*  
	final int BASE = 5;
	final int NUMBER = 124;
	System.out.println(((NUMBER/BASE)/BASE)%BASE+" "+(NUMBER/BASE)%BASE+" "+(NUMBER%BASE)); */
	// Es 8 
	/*
	final int Y = 2001;
	int a = Y % 19;
	int b = Y / 100;
	int c = Y % 100;
	int d = b / 4;
	int e = b % 4;
	int g = (8 * b + 13) / 25;
	int h = (19 * a + b - d - g + 15) % 30;
	int j = c / 4;
	int k = c % 4;
	int m = (a + 11 * h) / 319;
	int r = (2 * e + 2 * j - k - h + m + 32) % 7;
	int n = (h - m + r + 90) / 25;
	int p = (h - m + r + n + 19) % 32;
	System.out.println("anno "+Y+", mese "+n+", giorno "+p); */
	// Es 9
	/* 
	BankAccount account1 = new BankAccount();
	BankAccount account2 = new BankAccount();
	account1.deposit(1000);
	account2.deposit(100);
	System.out.println(account1.getBalance());
	System.out.println(account2.getBalance());
	account1.withdraw(400);
	account2.deposit(400);
	System.out.println(account1.getBalance());
	System.out.println(account2.getBalance()); */
	System.out.println("Esercitazione 2");
    }
}
