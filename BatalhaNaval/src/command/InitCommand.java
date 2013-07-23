package command;

import entity.Game;

public class InitCommand implements Command{

	private Game gameInstance;
	
	@Override
	public void run() throws Exception {
		this.gameInstance.initGame();
	}
	
	public InitCommand(final Game game){
		this.gameInstance = game;
	}

}
