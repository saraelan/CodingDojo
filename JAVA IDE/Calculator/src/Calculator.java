
public class Calculator {
	
	private double operandOne;
	private double operandTwo;
	private double results;
	private String operations;
	
	Calculator() {
		// TODO Auto-generated constructor stub
	}

	
	public double getOperandOne() {
		return operandOne;
	}
	
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	
	public double getOperandTwo() {
		return operandTwo;
	}
	
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	public double getResult() {
		return results;
	}
	
	public void setResult(double results) {
		this.results = results;
	}
	
	public String getOperation() {
		return operations;
	}
	
	public void setOperation(String operations) {
		this.operations = operations;
	}
	
	public void performOperation() {
		if(operations.equals("+")){
			results = operandOne + operandTwo;
		} else if(operations.equals("-")){
			results = operandOne - operandTwo;
		} else if(operations.equals("*")){
			results = operandOne*operandTwo;
		} else if(operations.equals("/")){
			results = operandOne/operandTwo;
		} else {
			System.out.println("Invalid Operation");
			results = 0;
		}
	}
	
	public double getResults() {
		return results;
	}
}
