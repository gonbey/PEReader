
public class ImageFileHeader {
	private int Machine;
	private int NumberOfSections;
	private int TimeDateStamp;
	private int PointerToSymbolTable;
	private int NumberOfSymbols;
	private int SizeOfOptionalHeader;
	private int Characteristics;
	public int getMachine() {
		return Machine;
	}
	public void setMachine(int machine) {
		Machine = machine;
	}
	public int getNumberOfSections() {
		return NumberOfSections;
	}
	public void setNumberOfSections(int numberOfSections) {
		NumberOfSections = numberOfSections;
	}
	public int getTimeDateStamp() {
		return TimeDateStamp;
	}
	public void setTimeDateStamp(int timeDateStamp) {
		TimeDateStamp = timeDateStamp;
	}
	public int getPointerToSymbolTable() {
		return PointerToSymbolTable;
	}
	public void setPointerToSymbolTable(int pointerToSymbolTable) {
		PointerToSymbolTable = pointerToSymbolTable;
	}
	public int getNumberOfSymbols() {
		return NumberOfSymbols;
	}
	public void setNumberOfSymbols(int numberOfSymbols) {
		NumberOfSymbols = numberOfSymbols;
	}
	public int getSizeOfOptionalHeader() {
		return SizeOfOptionalHeader;
	}
	public void setSizeOfOptionalHeader(int sizeOfOptionalHeader) {
		SizeOfOptionalHeader = sizeOfOptionalHeader;
	}
	public int getCharacteristics() {
		return Characteristics;
	}
	public void setCharacteristics(int characteristics) {
		Characteristics = characteristics;
	}

}
