package fun.imanan.pekaisekikun.io.pe;

import java.io.IOException;

import fun.imanan.pekaisekikun.io.MyFileInputStream;

public class ImageOptionalHeader32 {
	public ImageOptionalHeader32(MyFileInputStream fis) throws IOException {
		magic = fis.wordRead();
		majorLinkerVersion = fis.byteRead();
		minorLinkerVersion = fis.byteRead();
		sizeOfCode = fis.dwordRead();
		sizeOfInitializedData = fis.dwordRead();
		sizeOfUninitializedData = fis.dwordRead();
		addressOfEntryPoint = fis.dwordRead();
		baseOfCode = fis.dwordRead();
		baseOfData = fis.dwordRead();

		imageBase = fis.dwordRead();
		sectionAlignment = fis.dwordRead();
		fileAlignment = fis.dwordRead();
		majorOperatingSystemVersion = fis.wordRead();
		minorOperatingSystemVersion = fis.wordRead();
		majorImageVersion = fis.wordRead();
		minorImageVersion = fis.wordRead();
		majorSubsystemVersion = fis.wordRead();
		minorSubsystemVersion = fis.wordRead();
		win32VersionValue = fis.dwordRead();
		sizeOfImage = fis.dwordRead();
		sizeOfHeaders = fis.dwordRead();
		checkSum = fis.dwordRead();
		subsystem = fis.wordRead();
		dllCharacteristics = fis.wordRead();
		sizeOfStackReserve = fis.dwordRead();
		sizeOfStackCommit = fis.dwordRead();
		sizeOfHeapReserve = fis.dwordRead();
		sizeOfHeapCommit = fis.dwordRead();
		loaderFlags = fis.dwordRead();
		numberOfRvaAndSizes = fis.dwordRead();
		for (int i = 0; i < ImageOptionalHeader32.IMAGE_NUMBEROF_DIRECTORY_ENTRIES; i++) {
			dataDirectory[i] = new ImageDataDirectory(fis);
		}
	}

	private static final int IMAGE_NUMBEROF_DIRECTORY_ENTRIES = 16;
	//
	// Standard fields.
	//

	private int addressOfEntryPoint;
	private int baseOfCode;
	private int baseOfData;
	private int checkSum;
	private ImageDataDirectory[] dataDirectory = new ImageDataDirectory[IMAGE_NUMBEROF_DIRECTORY_ENTRIES];
	private short dllCharacteristics;
	private int fileAlignment;
	private int imageBase;
	private int loaderFlags;
	private short magic;
	private short majorImageVersion;
	private byte majorLinkerVersion;
	private short majorOperatingSystemVersion;
	private short majorSubsystemVersion;
	private short minorImageVersion;
	private byte minorLinkerVersion;
	private short minorOperatingSystemVersion;
	private short minorSubsystemVersion;
	private int numberOfRvaAndSizes;
	private int sectionAlignment;
	private int sizeOfCode;
	private int sizeOfHeaders;
	private int sizeOfHeapCommit;
	private int sizeOfHeapReserve;
	private int sizeOfImage;
	private int sizeOfInitializedData;
	private int sizeOfStackCommit;
	private int sizeOfStackReserve;
	private int sizeOfUninitializedData;
	private short subsystem;
	private int win32VersionValue;

	public int getAddressOfEntryPoint() {
		return addressOfEntryPoint;
	}

	public int getBaseOfCode() {
		return baseOfCode;
	}

	public int getBaseOfData() {
		return baseOfData;
	}

	public int getCheckSum() {
		return checkSum;
	}

	public ImageDataDirectory[] getDataDirectory() {
		return dataDirectory;
	}

	public short getDllCharacteristics() {
		return dllCharacteristics;
	}

	public int getFileAlignment() {
		return fileAlignment;
	}

	public int getImageBase() {
		return imageBase;
	}

	public int getImageNumberofDirectoryEntries() {
		return IMAGE_NUMBEROF_DIRECTORY_ENTRIES;
	}

	public int getLoaderFlags() {
		return loaderFlags;
	}

	public short getMagic() {
		return magic;
	}

	public short getMajorImageVersion() {
		return majorImageVersion;
	}

	public byte getMajorLinkerVersion() {
		return majorLinkerVersion;
	}

	public short getMajorOperatingSystemVersion() {
		return majorOperatingSystemVersion;
	}

	public short getMajorSubsystemVersion() {
		return majorSubsystemVersion;
	}

	public short getMinorImageVersion() {
		return minorImageVersion;
	}

	public byte getMinorLinkerVersion() {
		return minorLinkerVersion;
	}

	public short getMinorOperatingSystemVersion() {
		return minorOperatingSystemVersion;
	}

	public short getMinorSubsystemVersion() {
		return minorSubsystemVersion;
	}

	public int getNumberOfRvaAndSizes() {
		return numberOfRvaAndSizes;
	}

	public int getSectionAlignment() {
		return sectionAlignment;
	}

	public int getSizeOfCode() {
		return sizeOfCode;
	}

	public int getSizeOfHeaders() {
		return sizeOfHeaders;
	}

	public int getSizeOfHeapCommit() {
		return sizeOfHeapCommit;
	}

	public int getSizeOfHeapReserve() {
		return sizeOfHeapReserve;
	}

	public int getSizeOfImage() {
		return sizeOfImage;
	}

	public int getSizeOfInitializedData() {
		return sizeOfInitializedData;
	}

	public int getSizeOfStackCommit() {
		return sizeOfStackCommit;
	}

	public int getSizeOfStackReserve() {
		return sizeOfStackReserve;
	}

	public int getSizeOfUninitializedData() {
		return sizeOfUninitializedData;
	}

	public short getSubsystem() {
		return subsystem;
	}

	public int getWin32VersionValue() {
		return win32VersionValue;
	}
}