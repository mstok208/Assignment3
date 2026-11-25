package mru.tsc.exceptions;

/** Thrown when a toy is assigned a negative price. */
public class InvalidPriceException extends IllegalArgumentException {
	public InvalidPriceException(String message) {
		super(message);
	}
}
