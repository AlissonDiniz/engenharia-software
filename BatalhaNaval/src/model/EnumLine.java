package model;

public enum EnumLine {

	L1(1), L2(2), L3(3), L4(4), L5(5), L6(6), L7(7), L8(8), L9(9), L10(10);

	private int position;

	EnumLine(int position) {
		this.position = position;
	}

	public int getPosition() {
		return this.position;
	}

	public static EnumLine getEnumLine(int value) {
		for (EnumLine line : EnumLine.values()) {
			if (line.getPosition() == value) {
				return line;
			}
		}
		return null;
	}

}
