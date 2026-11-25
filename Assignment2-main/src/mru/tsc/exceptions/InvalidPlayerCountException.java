package mru.tsc.exceptions;

/** Thrown when minimum players exceeds maximum players. */
public class InvalidPlayerCountException extends IllegalArgumentException {
	public InvalidPlayerCountException(String message) {
		super(message);
	}
}
