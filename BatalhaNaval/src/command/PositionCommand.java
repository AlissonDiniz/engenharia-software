package command;

import model.EnumBoard;
import model.EnumColumn;
import model.EnumElement;
import model.EnumLine;
import entity.Game;
import exception.GameInitializedException;
import exception.InvalidPositionException;

public class PositionCommand implements Command {

	private Game gameInstance;
	private EnumBoard enumBoard;
	private EnumLine enumLine;
	private EnumColumn enumColumn;
	private boolean isVertical;
	private EnumElement enumElement;

	@Override
	public void run() throws InvalidPositionException, GameInitializedException {
		this.gameInstance.positionVessel(enumBoard, enumLine, enumColumn, this.isVertical, enumElement);
	}

	public PositionCommand(final Game game, final EnumBoard enumBoard, final EnumLine enumLine,
			final EnumColumn enumColumn, final boolean isVertical, final EnumElement enumElement) {
		this.gameInstance = game;
		this.enumBoard = enumBoard;
		this.enumLine = enumLine;
		this.enumColumn = enumColumn;
		this.isVertical = isVertical;
		this.enumElement = enumElement;
	}

}
