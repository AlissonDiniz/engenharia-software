package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import model.EnumBoard;
import model.EnumColumn;
import model.EnumElement;
import model.EnumLine;

import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void createJogo() {
		assertFalse(this.gameInstance.finish());
	}

	@Test
	public void positioningPortaAvioes() throws InvalidPositionException,
			GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.PORTAAVIOES);

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
	public void positioningCruzador() throws InvalidPositionException,
			GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.CRUZADOR);

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
	public void positioningSubmarino() throws InvalidPositionException,
			GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.SUBMARINO);

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
	public void positioningFragata() throws InvalidPositionException,
			GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.FRAGATA);

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

	public void positioningDestroyer() throws InvalidPositionException,
			GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.DESTROYER);

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
	public void positioningVesselAgain() throws InvalidPositionException,
			GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.FRAGATA);
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.FRAGATA);
	}

	@Test(expected = InvalidPositionException.class)
	public void positionnigVesselInLocationAlreadyOccupied()
			throws InvalidPositionException, GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.FRAGATA);
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.PORTAAVIOES);
	}

	@Test(expected = InvalidPositionException.class)
	public void positionnigVesselInOtherLocationAlreadyOccupied()
			throws InvalidPositionException, GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.FRAGATA);
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L2,
				EnumColumn.C3, this.VERTICAL, EnumElement.PORTAAVIOES);
	}

	@Test(expected = InvalidPositionException.class)
	public void positionnigVesselInOtherLocationAlreadyOccupiedIntersection()
			throws InvalidPositionException, GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C3, this.VERTICAL, EnumElement.CRUZADOR);
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L2,
				EnumColumn.C1, this.HORIZONTAL, EnumElement.PORTAAVIOES);
	}

	@Test(expected = InvalidPositionException.class)
	public void posicioningVesselInCInvalidLocationVerticalLimit()
			throws InvalidPositionException, GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L10,
				EnumColumn.C1, this.VERTICAL, EnumElement.PORTAAVIOES);
	}

	@Test(expected = InvalidPositionException.class)
	public void posicioningVesselInCInvalidLocationHorizontalLimit()
			throws InvalidPositionException, GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C10, this.HORIZONTAL, EnumElement.PORTAAVIOES);
	}

	@Test(expected = InvalidPositionException.class)
	public void posicioningVesselInCInvalidLocationVertical()
			throws InvalidPositionException, GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L8,
				EnumColumn.C1, this.VERTICAL, EnumElement.PORTAAVIOES);
	}

	@Test(expected = InvalidPositionException.class)
	public void posicioningVesselInCInvalidLocationHorizontal()
			throws InvalidPositionException, GameInitializedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L1,
				EnumColumn.C8, this.HORIZONTAL, EnumElement.PORTAAVIOES);
	}

	@Test(expected = GameInitializedException.class)
	public void positioningVesselAfterGameInitialized()
			throws GameInitializedException, InvalidPositionException {
		this.gameInstance.initGame();

		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C4, this.HORIZONTAL, EnumElement.PORTAAVIOES);
	}

	@Test
	public void shootThePortaAvioes() throws InvalidPositionException,
			GameInitializedException, PositionAlreadyUsedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C4, this.HORIZONTAL, EnumElement.PORTAAVIOES);

		assertFalse(!this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C4));

		assertFalse(!this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C5));

		assertFalse(!this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C6));

		assertFalse(!this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C7));

		assertFalse(!this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C8));

		assertFalse(!this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C9));

	}

	@Test
	public void checkIfShotHitWater() throws InvalidPositionException,
			GameInitializedException, PositionAlreadyUsedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C4, this.HORIZONTAL, EnumElement.PORTAAVIOES);

		assertFalse(this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C10));

	}

	@Test(expected = PositionAlreadyUsedException.class)
	public void shootThePositionAlready() throws InvalidPositionException,
			GameInitializedException, PositionAlreadyUsedException {
		this.gameInstance.positionVessel(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C4, this.HORIZONTAL, EnumElement.PORTAAVIOES);

		assertFalse(!this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C4));

		assertFalse(this.gameInstance.shot(EnumBoard.PLAYER1, EnumLine.L4,
				EnumColumn.C4));
	}
}
