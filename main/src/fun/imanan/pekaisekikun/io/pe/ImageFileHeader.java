package fun.imanan.pekaisekikun.io.pe;

import java.io.IOException;

import fun.imanan.pekaisekikun.io.MyFileInputStream;

public class ImageFileHeader {
	private short characteristics;
	private short machine;
	private short numberOfSections;
	private int numberOfSymbols;
	private int pointerToSymbolTable;
	private short sizeOfOptionalHeader;
	private int timeDateStamp;

	public ImageFileHeader(MyFileInputStream fis) throws IOException {
		machine = fis.wordRead();
		numberOfSections = fis.wordRead();
		timeDateStamp = fis.dwordRead();
		pointerToSymbolTable = fis.dwordRead();
		numberOfSymbols = fis.dwordRead();
		sizeOfOptionalHeader = fis.wordRead();
		characteristics = fis.wordRead();
	}

	public short getCharacteristics() {
		return characteristics;
	}

	public short getMachine() {
		return machine;
	}

	public short getNumberOfSections() {
		return numberOfSections;
	}

	public int getNumberOfSymbols() {
		return numberOfSymbols;
	}

	public int getPointerToSymbolTable() {
		return pointerToSymbolTable;
	}

	public short getSizeOfOptionalHeader() {
		return sizeOfOptionalHeader;
	}

	public int getTimeDateStamp() {
		return timeDateStamp;
	}
}