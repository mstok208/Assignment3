package mru.tsc.exceptions;

public class NegativePriceException extends Exception{
	
	

	/**
	 * Custom exception thrown when a user attempts to enter a negative price
	 * while adding a new toy to the inventory.
	 * 
	 * @author Manmeet, Ali
	 */

	/**
	 * Constructs a new NegativePriceException with a default error message.
	 */
	 public NegativePriceException() {
	        super("Error: Toy price cannot be negative.");
	 }

	 /**
	  * Constructs a new NegativePriceException with a custom detail message.
	  * 
	  * @param message the specific error message describing the exception
	  */
	 public NegativePriceException(String message) {
		 super(message);
	 }	
	

}
