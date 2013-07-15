package model;

public enum EnumBoard {

	PLAYER1("PLAYER1"), PLAYER2("PLAYER2");

	private String name;

	EnumBoard(String name) {
		this.name = name;
	}

	public String getPlayer() {
		return this.name;
	}

}
