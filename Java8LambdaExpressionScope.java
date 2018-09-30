
public class Java8LambdaExpressionScope {
	final static String salutation = "Hello! ";
	
	public static void main(String []args) {
		GreetingService greetService = message -> {
			System.out.println(salutation + message);
		};
		
		greetService.sayMessage("Mahesh");
			
	}
	
	interface GreetingService{
		void sayMessage(String message);
	}
}
