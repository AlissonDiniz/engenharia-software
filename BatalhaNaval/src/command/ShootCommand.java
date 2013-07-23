package command;

import model.EnumBoard;
import model.EnumColumn;
import model.EnumLine;
import entity.Game;

public class ShootCommand implements Command {

	private Game gameInstance;
	private EnumBoard enumBoard;
	private EnumLine enumLine;
	private EnumColumn enumColumn;

	@Override
	public void run() throws Exception {
		this.gameInstance.shoot(enumBoard, enumLine, enumColumn);
	}

	public ShootCommand(final Game game, final EnumBoard enumBoard,
			final EnumLine enumLine, final EnumColumn enumColumn) {
		this.gameInstance = game;
		this.enumBoard = enumBoard;
		this.enumLine = enumLine;
		this.enumColumn = enumColumn;
	}

}
