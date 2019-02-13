
public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingBalance;
	private static int numberOfAccount=0;
	private static double totalMoney=0;
	

	public BankAccount() {
		numberOfAccount++;
		this.accountNumber=accountNo();
		
		
	}
	
	public static int accountCount()
	{
		return numberOfAccount;
	}
	
	public static double totalMoneyAccount()
	{
		return totalMoney;
	}

	private String accountNo()
	{	String accountNumber="";
		for(int i =0;i<10;i++)
		{
			int random=(int)(Math.random()*10);
			accountNumber+=random;
		}
		
		return accountNumber;
	}

	public double getCheckingBalance() 
	{
		
        return checkingBalance;
    }

    public double getSavingBalance() 
    {
        return savingBalance;
    }
    
    public void  getBalances()
    {
    	System.out.println("Checking:"+ getCheckingBalance());
		System.out.println("Saving:"+ getSavingBalance());
    }
    
    public void depositMoney(String acctType, double amount)
    {
    	if( acctType=="checking")
    	{	
    		this.checkingBalance+=amount;	
    	}
    	else if(acctType=="savings")
    	{
    		this.savingBalance+=amount;
    	}
    	else 
    	{
    		System.out.println("Wrong choice");
    	}
    	totalMoney+=amount;
    	System.out.println("Total amount" +totalMoney+ "Account type"+acctType+ "account");
    }
    
    public void withdarawMoney(String acctType,double amount)
    {
    	if (acctType=="checking")
    	{
    		if(this.checkingBalance>amount)
    		{
    			this.checkingBalance-=amount;
    			totalMoney-=amount;
    		}
    		else
    		{
    			System.out.println("Insufficent Balance");
    		}
    	}
    		
    	else if (acctType=="savings")
    	{
    		if(this.savingBalance>amount)
    		{
    			this.savingBalance-=amount;
    			totalMoney-=amount;
    		}
    		else
    		{
    			System.out.println("Insufficent Balance");
    		}
    	}
    	
    	else
    	{
    		System.out.println("Enter amt");
    	}
      
    }	
}