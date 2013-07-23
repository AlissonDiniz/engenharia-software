package entity;

import java.util.HashMap;
import java.util.Map;

import model.EnumBoard;
import model.EnumColumn;
import model.EnumElement;
import model.EnumLine;
import exception.GameInitializedException;
import exception.InvalidPositionException;
import exception.PositionAlreadyUsedException;

public class Game {

	private final int LENGHTMAP = 10;
	private Map<String, EnumElement> boardPlayer1;
	private Map<String, EnumElement> boardPlayer2;
	private boolean init;
	private boolean status;

	private boolean statusCommand;

	public Game() {
		this.boardPlayer1 = new HashMap<String, EnumElement>();
		this.boardPlayer2 = new HashMap<String, EnumElement>();
		this.status = false;
	}

	public void finish() {
		this.statusCommand = this.status;
	}

	public String createPosition(EnumLine line, EnumColumn column) {
		return line.toString().concat(column.toString());
	}

	public void positionVessel(EnumBoard player, EnumLine line,
			EnumColumn column, boolean vertical, EnumElement vessel)
			throws InvalidPositionException, GameInitializedException {
		if (this.init) {
			throw new GameInitializedException();
		} else {
			Map<String, EnumElement> board = (player.equals(EnumBoard.PLAYER1)) ? this.boardPlayer1
					: this.boardPlayer2;
			if (this.isEmpty(board, line, column)) {
				if (this.fitsVessel(line, column, vertical, vessel)) {
					this.addVessel(board, line, column, vertical, vessel);
				} else {
					throw new InvalidPositionException();
				}
			} else {
				throw new InvalidPositionException();
			}
		}

	}

	private void addVessel(Map<String, EnumElement> board, EnumLine line,
			EnumColumn column, boolean vertical, EnumElement vessel)
			throws InvalidPositionException {

		if (this.validatePosition(line, column, vertical, vessel)) {
			if (this.notOverrideVessel(board, line, column, vertical, vessel)) {
				final int initLinePosition = line.getPosition();
				final int initColumnPosition = column.getPosition();
				for (int i = 1; i < (vessel.getLength() + 1); i++) {
					if (vertical) {
						board.put(this.createPosition(line, column), vessel);
						line = EnumLine.getEnumLine(initLinePosition + i);
					} else {
						board.put(this.createPosition(line, column), vessel);
						column = EnumColumn.getEnumColumn(initColumnPosition
								+ i);
					}
				}
			} else {
				throw new InvalidPositionException();
			}
		} else {
			throw new InvalidPositionException();
		}
	}

	private boolean notOverrideVessel(Map<String, EnumElement> board,
			EnumLine line, EnumColumn column, boolean vertical,
			EnumElement vessel) {

		boolean empty = true;

		for (int i = 1; i < (vessel.getLength() + 1); i++) {
			if (vertical) {
				line = EnumLine.getEnumLine(i);
				empty = this.isEmpty(board, line, column);
			} else {
				column = EnumColumn.getEnumColumn(i);
				empty = this.isEmpty(board, line, column);
			}

			if (!empty) {
				return false;
			}
		}
		return empty;
	}

	public boolean validatePosition(EnumLine line, EnumColumn column,
			boolean vertical, EnumElement vessel) {

		final int initLinePosition = line.getPosition();
		final int initColumnPosition = column.getPosition();

		for (int i = 1; i < (vessel.getLength() + 1); i++) {
			if (vertical) {
				line = EnumLine.getEnumLine(initLinePosition + i);
			} else {
				column = EnumColumn.getEnumColumn(initColumnPosition + i);
			}
		}

		return line == null || column == null ? false : true;
	}

	private boolean isEmpty(Map<String, EnumElement> board, EnumLine line,
			EnumColumn column) {
		return board.get(this.createPosition(line, column)) == null ? true
				: false;
	}

	private boolean fitsVessel(EnumLine line, EnumColumn column,
			boolean vertical, EnumElement vessel) {

		final int lengthVessel = vessel.getLength();

		if (vertical) {
			return (column.getPosition() + lengthVessel) > this.LENGHTMAP ? false
					: true;
		} else {
			return (line.getPosition() + lengthVessel) > this.LENGHTMAP ? false
					: true;
		}

	}

	public EnumElement checkVesselPosition(EnumBoard player, EnumLine line,
			EnumColumn column) {
		Map<String, EnumElement> board = (player.equals(EnumBoard.PLAYER1)) ? this.boardPlayer1
				: this.boardPlayer2;
		return board.get(this.createPosition(line, column));
	}

	public void initGame() {
		this.init = true;
	}

	public void shoot(EnumBoard player, EnumLine line, EnumColumn column)
			throws PositionAlreadyUsedException, InvalidPositionException {

		Map<String, EnumElement> board = (player.equals(EnumBoard.PLAYER1)) ? this.boardPlayer1
				: this.boardPlayer2;

		if (this.checkPositionUsed(board, line, column)) {
			if (this.isEmpty(board, line, column)) {
				board.put(this.createPosition(line, column), EnumElement.WATER);
				this.statusCommand = false;
			} else {
				board.put(this.createPosition(line, column), EnumElement.HIT);
				this.statusCommand = true;
			}
		} else {
			this.statusCommand = false;
		}

	}

	public boolean checkPositionUsed(Map<String, EnumElement> board,
			EnumLine line, EnumColumn column)
			throws PositionAlreadyUsedException {

		if (board.get(this.createPosition(line, column)) == EnumElement.HIT) {
			throw new PositionAlreadyUsedException();
		} else {
			return true;
		}
	}

	public boolean isStatusCommand() {
		return statusCommand;
	}

}
