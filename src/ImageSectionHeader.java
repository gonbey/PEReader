
public class ImageSectionHeader {
	private static final int IMAGE_SIZEOF_SHORT_NAME = 8;
	private int Name[]; // IMAGE_SIZEOF_SHORT_NAME
	private int PhysicalAddressOrVirtualSize;
	private int VirtualAddress;
	private int SizeOfRawData;
	private int PointerToRawData;
	private int PointerToRelocations;
	private int PointerToLinenumbers;
	private int NumberOfRelocations;
	private int NumberOfLinenumbers;
	private int Characteristics;

	public int[] getName() {
		return Name;
	}

	public void setName(int[] name) {
		Name = name;
	}

	public int getPhysicalAddressOrVirtualSize() {
		return PhysicalAddressOrVirtualSize;
	}

	public void setPhysicalAddressOrVirtualSize(int physicalAddressOrVirtualSize) {
		PhysicalAddressOrVirtualSize = physicalAddressOrVirtualSize;
	}

	public int getVirtualAddress() {
		return VirtualAddress;
	}

	public void setVirtualAddress(int virtualAddress) {
		VirtualAddress = virtualAddress;
	}

	public int getSizeOfRawData() {
		return SizeOfRawData;
	}

	public void setSizeOfRawData(int sizeOfRawData) {
		SizeOfRawData = sizeOfRawData;
	}

	public int getPointerToRawData() {
		return PointerToRawData;
	}

	public void setPointerToRawData(int pointerToRawData) {
		PointerToRawData = pointerToRawData;
	}

	public int getPointerToRelocations() {
		return PointerToRelocations;
	}

	public void setPointerToRelocations(int pointerToRelocations) {
		PointerToRelocations = pointerToRelocations;
	}

	public int getPointerToLinenumbers() {
		return PointerToLinenumbers;
	}

	public void setPointerToLinenumbers(int pointerToLinenumbers) {
		PointerToLinenumbers = pointerToLinenumbers;
	}

	public int getNumberOfRelocations() {
		return NumberOfRelocations;
	}

	public void setNumberOfRelocations(int numberOfRelocations) {
		NumberOfRelocations = numberOfRelocations;
	}

	public int getNumberOfLinenumbers() {
		return NumberOfLinenumbers;
	}

	public void setNumberOfLinenumbers(int numberOfLinenumbers) {
		NumberOfLinenumbers = numberOfLinenumbers;
	}

	public int getCharacteristics() {
		return Characteristics;
	}

	public void setCharacteristics(int characteristics) {
		Characteristics = characteristics;
	}
}
