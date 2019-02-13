
public class BankAccountTest {

	public BankAccountTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BankAccount b=new BankAccount();
		BankAccount b1=new BankAccount();
		BankAccount b2=new BankAccount();
		BankAccount b3=new BankAccount();
		System.out.println(BankAccount.accountCount());
		System.out.println(BankAccount.totalMoneyAccount());
		b.depositMoney("savings",10000);
		b1.depositMoney("checking",200000);
		b1.withdarawMoney("checking", 1000);
		b.getBalances();
		
		

	}

}
