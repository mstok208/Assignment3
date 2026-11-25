package mru.tsc.exceptions;

public class InvalidPlayerCountException extends Exception {
	
	
	

	/**
	 * Custom exception thrown when the minimum number of players entered for a board game
	 * exceeds the maximum number of players.
	 * 
	 * @author Manmeet, Ali
	 */
	

	/**
	 * Constructs a new InvalidPlayerCountException with a default error message.
	 */
	public InvalidPlayerCountException() {
	        super("Error: Minimum number of players cannot be greater than maximum number of players.");
	}

	/**
	 * Constructs a new InvalidPlayerCountException with a custom detail message.
	 * 
	 * @param message the specific error message describing the exception
	 */
	public InvalidPlayerCountException(String message) {
		super(message);
	}
}

