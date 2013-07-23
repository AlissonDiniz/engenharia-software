package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import model.EnumBoard;
import model.EnumColumn;
import model.EnumElement;
import model.EnumLine;

import org.junit.Before;
import org.junit.Test;

import command.Command;
import command.FinishCommand;
import command.InitCommand;
import command.PositionCommand;
import command.ShootCommand;

import entity.Game;
import exception.GameInitializedException;
import exception.InvalidPositionException;
import exception.PositionAlreadyUsedException;

public class BatalhaTest {

	private Game gameInstance;

	private final boolean VERTICAL = true;
	private final boolean HORIZONTAL = false;

	@Before
	public void initJogo() {
		this.gameInstance = new Game();
	}

	private void runCommand(Command commandInstance) throws Exception,
			InvalidPositionException, GameInitializedException {
		commandInstance.run();
	}

	@Test
	public void createJogo() throws Exception, InvalidPositionException,
			GameInitializedException {
		this.runCommand(new FinishCommand(this.gameInstance));
		assertFalse(this.gameInstance.isStatusCommand());
	}

	@Test
	public void positioningPortaAvioes() throws Exception,
			InvalidPositionException, GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.PORTAAVIOES));

		assertEquals(EnumElement.PORTAAVIOES,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L1, EnumColumn.C3));

		assertEquals(EnumElement.PORTAAVIOES,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L2, EnumColumn.C3));

		assertEquals(EnumElement.PORTAAVIOES,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L3, EnumColumn.C3));

		assertEquals(EnumElement.PORTAAVIOES,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L4, EnumColumn.C3));

		assertEquals(EnumElement.PORTAAVIOES,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L5, EnumColumn.C3));

		assertEquals(EnumElement.PORTAAVIOES,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L6, EnumColumn.C3));

		assertFalse((EnumElement.PORTAAVIOES.equals(this.gameInstance
				.checkVesselPosition(EnumBoard.PLAYER1, EnumLine.L7,
						EnumColumn.C3))));

	}

	@Test
	public void positioningCruzador() throws Exception,
			InvalidPositionException, GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.CRUZADOR));

		assertEquals(EnumElement.CRUZADOR,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L1, EnumColumn.C3));

		assertEquals(EnumElement.CRUZADOR,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L2, EnumColumn.C3));

		assertEquals(EnumElement.CRUZADOR,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L3, EnumColumn.C3));

		assertEquals(EnumElement.CRUZADOR,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L4, EnumColumn.C3));

		assertEquals(EnumElement.CRUZADOR,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L5, EnumColumn.C3));

		assertFalse((EnumElement.CRUZADOR.equals(this.gameInstance
				.checkVesselPosition(EnumBoard.PLAYER1, EnumLine.L6,
						EnumColumn.C3))));

	}

	@Test
	public void positioningSubmarino() throws Exception,
			InvalidPositionException, GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.SUBMARINO));

		assertEquals(EnumElement.SUBMARINO,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L1, EnumColumn.C3));

		assertEquals(EnumElement.SUBMARINO,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L2, EnumColumn.C3));

		assertEquals(EnumElement.SUBMARINO,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L3, EnumColumn.C3));

		assertEquals(EnumElement.SUBMARINO,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L4, EnumColumn.C3));

		assertFalse((EnumElement.SUBMARINO.equals(this.gameInstance
				.checkVesselPosition(EnumBoard.PLAYER1, EnumLine.L5,
						EnumColumn.C3))));

	}

	@Test
	public void positioningFragata() throws Exception,
			InvalidPositionException, GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.FRAGATA));

		assertEquals(EnumElement.FRAGATA,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L1, EnumColumn.C3));

		assertEquals(EnumElement.FRAGATA,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L2, EnumColumn.C3));

		assertEquals(EnumElement.FRAGATA,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L3, EnumColumn.C3));

		assertFalse((EnumElement.FRAGATA.equals(this.gameInstance
				.checkVesselPosition(EnumBoard.PLAYER1, EnumLine.L4,
						EnumColumn.C3))));

	}

	public void positioningDestroyer() throws Exception,
			InvalidPositionException, GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.DESTROYER));

		assertEquals(EnumElement.DESTROYER,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L1, EnumColumn.C3));

		assertEquals(EnumElement.DESTROYER,
				this.gameInstance.checkVesselPosition(EnumBoard.PLAYER1,
						EnumLine.L2, EnumColumn.C3));

		assertFalse((EnumElement.DESTROYER.equals(this.gameInstance
				.checkVesselPosition(EnumBoard.PLAYER1, EnumLine.L3,
						EnumColumn.C3))));

	}

	@Test(expected = InvalidPositionException.class)
	public void positioningVesselAgain() throws Exception,
			InvalidPositionException, GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.FRAGATA));

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.FRAGATA));
	}

	@Test(expected = InvalidPositionException.class)
	public void positionnigVesselInLocationAlreadyOccupied() throws Exception,
			InvalidPositionException, GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.FRAGATA));

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.PORTAAVIOES));
	}

	@Test(expected = InvalidPositionException.class)
	public void positionnigVesselInOtherLocationAlreadyOccupied()
			throws Exception, InvalidPositionException,
			GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.FRAGATA));

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L2, EnumColumn.C3, this.VERTICAL,
				EnumElement.PORTAAVIOES));
	}

	@Test(expected = InvalidPositionException.class)
	public void positionnigVesselInOtherLocationAlreadyOccupiedIntersection()
			throws Exception, InvalidPositionException,
			GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C3, this.VERTICAL,
				EnumElement.CRUZADOR));

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L2, EnumColumn.C1, this.HORIZONTAL,
				EnumElement.PORTAAVIOES));
	}

	@Test(expected = InvalidPositionException.class)
	public void posicioningVesselInCInvalidLocationVerticalLimit()
			throws Exception, InvalidPositionException,
			GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L10, EnumColumn.C1, this.VERTICAL,
				EnumElement.PORTAAVIOES));
	}

	@Test(expected = InvalidPositionException.class)
	public void posicioningVesselInCInvalidLocationHorizontalLimit()
			throws Exception, InvalidPositionException,
			GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C10,
				this.HORIZONTAL, EnumElement.PORTAAVIOES));
	}

	@Test(expected = InvalidPositionException.class)
	public void posicioningVesselInCInvalidLocationVertical() throws Exception,
			InvalidPositionException, GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L8, EnumColumn.C1, this.VERTICAL,
				EnumElement.PORTAAVIOES));
	}

	@Test(expected = InvalidPositionException.class)
	public void posicioningVesselInCInvalidLocationHorizontal()
			throws Exception, InvalidPositionException,
			GameInitializedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L1, EnumColumn.C8, this.HORIZONTAL,
				EnumElement.PORTAAVIOES));
	}

	@Test(expected = GameInitializedException.class)
	public void positioningVesselAfterGameInitialized() throws Exception,
			GameInitializedException, InvalidPositionException {

		this.runCommand(new InitCommand(this.gameInstance));

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L4, EnumColumn.C4, this.HORIZONTAL,
				EnumElement.PORTAAVIOES));
	}

	@Test
	public void shootThePortaAvioes() throws Exception,
			InvalidPositionException, GameInitializedException,
			PositionAlreadyUsedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L4, EnumColumn.C4, this.HORIZONTAL,
				EnumElement.PORTAAVIOES));

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C4));

		assertFalse(!this.gameInstance.isStatusCommand());

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C5));

		assertFalse(!this.gameInstance.isStatusCommand());

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C6));

		assertFalse(!this.gameInstance.isStatusCommand());

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C7));

		assertFalse(!this.gameInstance.isStatusCommand());

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C8));

		assertFalse(!this.gameInstance.isStatusCommand());

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C9));

		assertFalse(!this.gameInstance.isStatusCommand());

	}

	@Test
	public void checkIfShotHitWater() throws Exception,
			InvalidPositionException, GameInitializedException,
			PositionAlreadyUsedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L4, EnumColumn.C4, this.HORIZONTAL,
				EnumElement.PORTAAVIOES));

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C10));

		assertFalse(this.gameInstance.isStatusCommand());
	}

	@Test(expected = PositionAlreadyUsedException.class)
	public void shootThePositionAlready() throws Exception,
			InvalidPositionException, GameInitializedException,
			PositionAlreadyUsedException {

		this.runCommand(new PositionCommand(this.gameInstance,
				EnumBoard.PLAYER1, EnumLine.L4, EnumColumn.C4, this.HORIZONTAL,
				EnumElement.PORTAAVIOES));

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C4));

		assertFalse(!this.gameInstance.isStatusCommand());

		this.runCommand(new ShootCommand(this.gameInstance, EnumBoard.PLAYER1,
				EnumLine.L4, EnumColumn.C4));

		assertFalse(!this.gameInstance.isStatusCommand());

	}
}
