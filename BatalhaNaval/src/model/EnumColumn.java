package model;

public enum EnumColumn {
	
	C1(1), C2(2), C3(3), C4(4), C5(5), C6(6), C7(7), C8(8), C9(9), C10(10);
	
	private int position;
	
	EnumColumn(int position){
		this.position = position;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public static EnumColumn getEnumColumn(int value) {
		for (EnumColumn column : EnumColumn.values()) {
			if (column.getPosition() == value) {
				return column;
			}
		}
		return null;
	}

}
