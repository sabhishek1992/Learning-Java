
public class _8ExceptionHandling {
	public static void main(String[] args) {
		int balance;
		balance = Integer.parseInt("3434.2232"); // raises NumberFormatException : Unchecked Exception
		//updateBalance(balance); //compile-time checked
	}

	private static void updateBalance(int balance) throws InvalidBalanceException {
		if(balance<0) {
			throw new InvalidBalanceException("Account balance can't be less then zero.");
		}
	}
}

class InvalidBalanceException extends Exception{
	public InvalidBalanceException(String message) {
		super(message);
	}
}