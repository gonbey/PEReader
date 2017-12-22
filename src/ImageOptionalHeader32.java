
public class ImageOptionalHeader32 {
	// Standard fields.
	private int Magic;
	private int MajorLinkerVersion;
	private int MinorLinkerVersion;
	private int SizeOfCode;
	private int SizeOfInitializedData;
	private int SizeOfUninitializedData;
	private int AddressOfEntryPoint;
	private int BaseOfCode;
	private int BaseOfData;
	// NT additional fields.
	private int ImageBase;
	private int SectionAlignment;
	private int FileAlignment;
	private int MajorOperatingSystemVersion;
	private int MinorOperatingSystemVersion;
	private int MajorImageVersion;
	private int MinorImageVersion;
	private int MajorSubsystemVersion;
	private int MinorSubsystemVersion;
	private int Win32VersionValue;
	private int SizeOfImage;
	private int SizeOfHeaders;
	private int CheckSum;
	private int Subsystem;
	private int DllCharacteristics;
	private int SizeOfStackReserve;
	private int SizeOfStackCommit;
	private int SizeOfHeapReserve;
	private int SizeOfHeapCommit;
	private int LoaderFlags;
	private int NumberOfRvaAndSizes;
	private imageDataDirectory DataDirectory[]; // NumberOfRvaAndSizes
	public int getMagic() {
		return Magic;
	}
	public void setMagic(int magic) {
		Magic = magic;
	}
	public int getMajorLinkerVersion() {
		return MajorLinkerVersion;
	}
	public void setMajorLinkerVersion(int majorLinkerVersion) {
		MajorLinkerVersion = majorLinkerVersion;
	}
	public int getMinorLinkerVersion() {
		return MinorLinkerVersion;
	}
	public void setMinorLinkerVersion(int minorLinkerVersion) {
		MinorLinkerVersion = minorLinkerVersion;
	}
	public int getSizeOfCode() {
		return SizeOfCode;
	}
	public void setSizeOfCode(int sizeOfCode) {
		SizeOfCode = sizeOfCode;
	}
	public int getSizeOfInitializedData() {
		return SizeOfInitializedData;
	}
	public void setSizeOfInitializedData(int sizeOfInitializedData) {
		SizeOfInitializedData = sizeOfInitializedData;
	}
	public int getSizeOfUninitializedData() {
		return SizeOfUninitializedData;
	}
	public void setSizeOfUninitializedData(int sizeOfUninitializedData) {
		SizeOfUninitializedData = sizeOfUninitializedData;
	}
	public int getAddressOfEntryPoint() {
		return AddressOfEntryPoint;
	}
	public void setAddressOfEntryPoint(int addressOfEntryPoint) {
		AddressOfEntryPoint = addressOfEntryPoint;
	}
	public int getBaseOfCode() {
		return BaseOfCode;
	}
	public void setBaseOfCode(int baseOfCode) {
		BaseOfCode = baseOfCode;
	}
	public int getBaseOfData() {
		return BaseOfData;
	}
	public void setBaseOfData(int baseOfData) {
		BaseOfData = baseOfData;
	}
	public int getImageBase() {
		return ImageBase;
	}
	public void setImageBase(int imageBase) {
		ImageBase = imageBase;
	}
	public int getSectionAlignment() {
		return SectionAlignment;
	}
	public void setSectionAlignment(int sectionAlignment) {
		SectionAlignment = sectionAlignment;
	}
	public int getFileAlignment() {
		return FileAlignment;
	}
	public void setFileAlignment(int fileAlignment) {
		FileAlignment = fileAlignment;
	}
	public int getMajorOperatingSystemVersion() {
		return MajorOperatingSystemVersion;
	}
	public void setMajorOperatingSystemVersion(int majorOperatingSystemVersion) {
		MajorOperatingSystemVersion = majorOperatingSystemVersion;
	}
	public int getMinorOperatingSystemVersion() {
		return MinorOperatingSystemVersion;
	}
	public void setMinorOperatingSystemVersion(int minorOperatingSystemVersion) {
		MinorOperatingSystemVersion = minorOperatingSystemVersion;
	}
	public int getMajorImageVersion() {
		return MajorImageVersion;
	}
	public void setMajorImageVersion(int majorImageVersion) {
		MajorImageVersion = majorImageVersion;
	}
	public int getMinorImageVersion() {
		return MinorImageVersion;
	}
	public void setMinorImageVersion(int minorImageVersion) {
		MinorImageVersion = minorImageVersion;
	}
	public int getMajorSubsystemVersion() {
		return MajorSubsystemVersion;
	}
	public void setMajorSubsystemVersion(int majorSubsystemVersion) {
		MajorSubsystemVersion = majorSubsystemVersion;
	}
	public int getMinorSubsystemVersion() {
		return MinorSubsystemVersion;
	}
	public void setMinorSubsystemVersion(int minorSubsystemVersion) {
		MinorSubsystemVersion = minorSubsystemVersion;
	}
	public int getWin32VersionValue() {
		return Win32VersionValue;
	}
	public void setWin32VersionValue(int win32VersionValue) {
		Win32VersionValue = win32VersionValue;
	}
	public int getSizeOfImage() {
		return SizeOfImage;
	}
	public void setSizeOfImage(int sizeOfImage) {
		SizeOfImage = sizeOfImage;
	}
	public int getSizeOfHeaders() {
		return SizeOfHeaders;
	}
	public void setSizeOfHeaders(int sizeOfHeaders) {
		SizeOfHeaders = sizeOfHeaders;
	}
	public int getCheckSum() {
		return CheckSum;
	}
	public void setCheckSum(int checkSum) {
		CheckSum = checkSum;
	}
	public int getSubsystem() {
		return Subsystem;
	}
	public void setSubsystem(int subsystem) {
		Subsystem = subsystem;
	}
	public int getDllCharacteristics() {
		return DllCharacteristics;
	}
	public void setDllCharacteristics(int dllCharacteristics) {
		DllCharacteristics = dllCharacteristics;
	}
	public int getSizeOfStackReserve() {
		return SizeOfStackReserve;
	}
	public void setSizeOfStackReserve(int sizeOfStackReserve) {
		SizeOfStackReserve = sizeOfStackReserve;
	}
	public int getSizeOfStackCommit() {
		return SizeOfStackCommit;
	}
	public void setSizeOfStackCommit(int sizeOfStackCommit) {
		SizeOfStackCommit = sizeOfStackCommit;
	}
	public int getSizeOfHeapReserve() {
		return SizeOfHeapReserve;
	}
	public void setSizeOfHeapReserve(int sizeOfHeapReserve) {
		SizeOfHeapReserve = sizeOfHeapReserve;
	}
	public int getSizeOfHeapCommit() {
		return SizeOfHeapCommit;
	}
	public void setSizeOfHeapCommit(int sizeOfHeapCommit) {
		SizeOfHeapCommit = sizeOfHeapCommit;
	}
	public int getLoaderFlags() {
		return LoaderFlags;
	}
	public void setLoaderFlags(int loaderFlags) {
		LoaderFlags = loaderFlags;
	}
	public int getNumberOfRvaAndSizes() {
		return NumberOfRvaAndSizes;
	}
	public void setNumberOfRvaAndSizes(int numberOfRvaAndSizes) {
		NumberOfRvaAndSizes = numberOfRvaAndSizes;
	}
	public imageDataDirectory[] getDataDirectory() {
		return DataDirectory;
	}
	public void setDataDirectory(imageDataDirectory[] dataDirectory) {
		DataDirectory = dataDirectory;
	}
}
