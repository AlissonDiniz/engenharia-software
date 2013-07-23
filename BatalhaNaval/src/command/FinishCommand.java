package command;

import entity.Game;

public class FinishCommand implements Command {

	private Game gameInstance;

	@Override
	public void run() throws Exception {
		this.gameInstance.finish();
	}

	public FinishCommand(final Game game) {
		this.gameInstance = game;
	}

}
