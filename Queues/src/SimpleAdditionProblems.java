import java.util.Random;
import java.util.Scanner;

public class SimpleAdditionProblems {
	
	public static void main(String[] args) {
		
		int operand1;
		int operand2;
		int studentAnswer;
		int correctAnswers = 0;
		int incorrectAnswers = 0;
		Random rand = new Random();
		final int MAX_PROBLEMS = 5;
		Scanner keyboard = new Scanner( System.in);
		ABQueue<AdditionProblem> queue = new ABQueue<AdditionProblem>(MAX_PROBLEMS);
		
		System.out.println("I am going to give you " + MAX_PROBLEMS+ " Simple Addition Problems.");
		System.out.println("I will dispaly a problem. You need to type the answer");
		for( int count = 1 ; count <= MAX_PROBLEMS ; count++)
		{
			operand1 = rand.nextInt(10);
			operand2 = rand.nextInt(10);
			AdditionProblem problem= new AdditionProblem(operand1, operand2);
			System.out.print(problem);
			studentAnswer = keyboard.nextInt();
			if(studentAnswer == problem.getAnswer()) {
				System.out.println("Correct!!");
				correctAnswers++;
			}
			else {
				System.out.println("This is incorrect. You will see this problem again shortly.");
				incorrectAnswers++;
				queue.enqueue(problem);
			}
		}
		System.out.println("You got "+correctAnswers+ " problems correctly and "+incorrectAnswers+" incorrectly.");
		
		if(!queue.isEmpty()) {
			System.out.println("Next, you will have a second chance to solve the problems you missed.");
		}
		else
			System.out.println( "Done.");
		
		while(!queue.isEmpty()) {
			AdditionProblem problem = queue.dequeue();
			//AdditionProblem problem= new AdditionProblem(operand1, operand2);
			System.out.print(problem);
			studentAnswer = keyboard.nextInt();
			if(studentAnswer == problem.getAnswer()) {
				System.out.println("Correct!!");
				correctAnswers++;
			}
			else {
				System.out.println("This is incorrect. The correct Answer is:\n"+problem.displayAnswer());
			}
		}
		
		
		
		
		
		
		keyboard.close();
		return;
	}

}
