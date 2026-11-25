package mru.tsc.application;

import java.nio.file.Path;
import mru.tsc.controller.ToyStoreController;
import mru.tsc.view.ConsoleView;

/** Application entry point. */
public class Main {
	public static void main(String[] args) {
		Path dataFile = Path.of("res", "toys.txt");
		ToyStoreController controller = new ToyStoreController(dataFile);
		ConsoleView view = new ConsoleView();
		view.start(controller);
	}
}
