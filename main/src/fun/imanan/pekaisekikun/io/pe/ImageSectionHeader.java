package fun.imanan.pekaisekikun.io.pe;

import java.io.IOException;

import fun.imanan.pekaisekikun.io.MyFileInputStream;

public class ImageSectionHeader {
	private static final int IMAGE_SIZEOF_SHORT_NAME = 8;
	private int characteristics;
	private byte[] name = new byte[IMAGE_SIZEOF_SHORT_NAME];
	private short numberOfLinenumbers;
	private short numberOfRelocations;
	private int physicalAddressOrVirtualSize;
	private int pointerToLinenumbers;
	private int pinterToRawData;
	private int pointerToRelocations;
	private int sizeOfRawData;
	private int virtualAddress;

	public ImageSectionHeader(MyFileInputStream fis) throws IOException {
		for (int j = 0; j < ImageSectionHeader.IMAGE_SIZEOF_SHORT_NAME; j++) {
			name[j] = fis.byteRead();
		}
		physicalAddressOrVirtualSize = fis.dwordRead();
		virtualAddress = fis.dwordRead();
		sizeOfRawData = fis.dwordRead();
		pinterToRawData = fis.dwordRead();
		pointerToRelocations = fis.dwordRead();
		pointerToLinenumbers = fis.dwordRead();
		numberOfRelocations = fis.wordRead();
		numberOfLinenumbers = fis.wordRead();
		characteristics = fis.dwordRead();
	}

	public int getCharacteristics() {
		return characteristics;
	}

	public byte[] getName() {
		return name;
	}

	public short getNumberOfLinenumbers() {
		return numberOfLinenumbers;
	}

	public short getNumberOfRelocations() {
		return numberOfRelocations;
	}

	public int getPhysicalAddressOrVirtualSize() {
		return physicalAddressOrVirtualSize;
	}

	public int getPointerToLinenumbers() {
		return pointerToLinenumbers;
	}

	public int getPointerToRawData() {
		return pinterToRawData;
	}

	public int getPointerToRelocations() {
		return pointerToRelocations;
	}

	public int getSizeOfRawData() {
		return sizeOfRawData;
	}

	public int getVirtualAddress() {
		return virtualAddress;
	}
}