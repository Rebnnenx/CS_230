
public class AdditionProblem {
	
	private int leftOperand;
	private int rightOperand;
	private int answer;
	
	public AdditionProblem()
	{
		leftOperand = 0;
		rightOperand = 0;
		answer = 0;
	}
	
	public AdditionProblem( int operand)
	{
		leftOperand = operand;
		rightOperand = 0;
		answer = leftOperand + rightOperand;
	}
	
	public AdditionProblem( int operand1, int operand2)
	{
		leftOperand = operand1;
		rightOperand = operand2;
		answer = leftOperand + rightOperand;
	}
	
	public int getLeftOperand()
	{
		return leftOperand;
	}
	
	public int getRightOperand()
	{
		return rightOperand;
	}
	
	public int getAnswer()
	{
		return answer;
	}
	
	public void setLeftOperand(int operand) {
		leftOperand = operand;
		answer = leftOperand+rightOperand;
	}
	
	public void setRightOperand(int operand) {
		rightOperand = operand;
		answer = leftOperand+rightOperand;
	}
	
	public void setOperands(int operandL, int operandR) {
		leftOperand = operandL;
		rightOperand = operandR;
		answer = leftOperand+rightOperand;
	}
	
	public AdditionProblem getAdditionProblem()
	{
		AdditionProblem problem = new AdditionProblem( leftOperand, rightOperand);
		
		return problem;
	}
	
	public String toString()
	{
		String str = "";
		
		str = str + leftOperand + " + " + rightOperand + " = ";
		return str;
	}

	public String displayAnswer()
	{
		String str = "";
		
		str = str + leftOperand + " + " + rightOperand + " = " + answer;
		return str;
	}
}
