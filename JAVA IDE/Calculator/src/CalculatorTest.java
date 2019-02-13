
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c=new Calculator();
		c.setOperandOne(10.5);
		c.setOperation("+");
		c.setOperandTwo(5.2);
		c.setOperation("*");
		c.setOperandOne(10);
		c.performOperation();
		System.out.println(c.getResults());
		
	}

	public CalculatorTest() {
		// TODO Auto-generated constructor stub
	}

}
