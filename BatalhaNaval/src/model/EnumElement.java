package model;

public enum EnumElement {

	PORTAAVIOES(6), CRUZADOR(5), SUBMARINO(4), FRAGATA(3), DESTROYER(2), HIT(1), WATER(0);

	private int length;

	EnumElement(int length) {
		this.length = length;
	}

	public int getLength() {
		return this.length;
	}

}
