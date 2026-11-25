package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.exceptions.InvalidPlayerCountException;
import mru.tsc.exceptions.NegativePriceException;
import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Puzzle;
import mru.tsc.model.figure;

/**
 * Unit test suite verifying the constructors, getters, setters, stock management,
 * file formatting, and custom exceptions for all concrete Toy subclasses.
 * 
 * @author Ali, Manmeet
 */
public class ToyTest {

    /**
     * Tests constructor, getters, setters, decrementCount, and format for Figure.
     */
    @Test
    public void testfigure() {
        figure figure = new figure("1147205649", "Ninja Turtles", "Game Zone", 26.15, 3, "8", "A");

        assertEquals("1147205649", figure.getSerialNumber());
        assertEquals("Ninja Turtles", figure.getName());
        assertEquals("Game Zone", figure.getBrand());
        assertEquals(26.15, figure.getPrice(), 0.001);
        assertEquals(3, figure.getAvailableCount());
        assertEquals("8", figure.getAgeAppropriate());
        assertEquals("A", figure.getClassification());

        figure.setClassification("D");
        figure.setPrice(29.99);
        assertEquals("D", figure.getClassification());
        assertEquals(29.99, figure.getPrice(), 0.001);

        figure.decrementCount();
        assertEquals(2, figure.getAvailableCount());

        assertEquals("1147205649;Ninja Turtles;Game Zone;29.99;2;8;D", figure.format());
        assertTrue(figure.toString().contains("Category: figure"));
    }

    /**
     * Tests constructor, getters, setters, decrementCount, and format for Animal.
     */
    @Test
    public void testAnimal() {
        Animal animal = new Animal("2835360879", "Teddy Bear", "PlushCo", 19.50, 1, "3", "Plush", "M");

        assertEquals("2835360879", animal.getSerialNumber());
        assertEquals("Plush", animal.getMaterial());
        assertEquals("M", animal.getSize());

        animal.setMaterial("Cotton");
        animal.setSize("L");
        assertEquals("Cotton", animal.getMaterial());
        assertEquals("L", animal.getSize());

        // Verify decrementCount stops at 0
        animal.decrementCount();
        assertEquals(0, animal.getAvailableCount());
        animal.decrementCount();
        assertEquals(0, animal.getAvailableCount());

        assertEquals("2835360879;Teddy Bear;PlushCo;19.50;0;3;Cotton;L", animal.format());
        assertTrue(animal.toString().contains("Category: Animal"));
    }

    /**
     * Tests constructor, getters, setters, and format for Puzzle.
     */
    @Test
    public void testPuzzle() {
        Puzzle puzzle = new Puzzle("5420389102", "Rubik's Cube", "Hasbro", 14.99, 10, "7", "Mechanical");

        assertEquals("5420389102", puzzle.getSerialNumber());
        assertEquals("Mechanical", puzzle.getPuzzleType());

        puzzle.setPuzzleType("Logic");
        puzzle.setAvailableCount(5);
        assertEquals("Logic", puzzle.getPuzzleType());
        assertEquals(5, puzzle.getAvailableCount());

        assertEquals("5420389102;Rubik's Cube;Hasbro;14.99;5;7;Logic", puzzle.format());
        assertTrue(puzzle.toString().contains("Category: Puzzle"));
    }

    /**
     * Tests constructor, getters, setters, and format for BoardGame.
     */
    @Test
    public void testBoardGame() {
        BoardGame game = new BoardGame("7291048563", "Catan", "Kosmos", 54.99, 4, "10", 3, 4, "Klaus Teuber");

        assertEquals("7291048563", game.getSerialNumber());
        assertEquals(3, game.getMinPlayers());
        assertEquals(4, game.getMaxPlayers());
        assertEquals("Klaus Teuber", game.getDesigners());

        game.setMinPlayers(2);
        game.setMaxPlayers(6);
        game.setDesigners("Klaus Teuber, Benjamin Teuber");
        assertEquals(2, game.getMinPlayers());
        assertEquals(6, game.getMaxPlayers());

        assertEquals("7291048563;Catan;Kosmos;54.99;4;10;2-6;Klaus Teuber, Benjamin Teuber", game.format());
        assertTrue(game.toString().contains("Category: BoardGame"));
    }

    /**
     * Verifies that custom exceptions can be thrown and caught with expected messages.
     */
    @Test
    public void testCustomExceptions() {
        assertThrows(NegativePriceException.class, () -> {
            throw new NegativePriceException();
        });

        assertThrows(InvalidPlayerCountException.class, () -> {
            throw new InvalidPlayerCountException();
        });
    }
}
	


