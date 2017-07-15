
public enum direction {
	HÖGER(1), 
	VÄNSTER(2), 
	UPP(3), 
	NER(4);
	private int value;
	private direction(int pvalue) {
		value = pvalue;
	}
	
	public int getValue() {
		return value;
	}
}

