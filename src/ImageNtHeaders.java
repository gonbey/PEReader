
public class ImageNtHeaders {
    private int Signature;
    private ImageFileHeader FileHeader;
    private ImageOptionalHeader32 OptionalHeader;
	public int getSignature() {
		return Signature;
	}
	public void setSignature(int signature) {
		Signature = signature;
	}
	public ImageFileHeader getFileHeader() {
		return FileHeader;
	}
	public void setFileHeader(ImageFileHeader fileHeader) {
		FileHeader = fileHeader;
	}
	public ImageOptionalHeader32 getOptionalHeader() {
		return OptionalHeader;
	}
	public void setOptionalHeader(ImageOptionalHeader32 optionalHeader) {
		OptionalHeader = optionalHeader;
	}
}
