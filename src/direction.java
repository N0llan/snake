
public enum direction {
	H�GER(1), 
	V�NSTER(2), 
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

