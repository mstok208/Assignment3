package mru.tsc.exceptions;

/** Thrown when a serial number is not a valid unique 10-digit identifier. */
public class InvalidSerialNumberException extends IllegalArgumentException {
	public InvalidSerialNumberException(String message) {
		super(message);
	}
}
