package fun.imanan.pekaisekikun.io.pe;

import java.io.IOException;

import fun.imanan.pekaisekikun.io.MyFileInputStream;

public class ImageNtHeaders {
	private ImageFileHeader fileHeader;

	private ImageOptionalHeader32 optionalHeader32;

	private int signature;

	public ImageNtHeaders(MyFileInputStream fis) throws IOException {
		signature = fis.dwordRead();
		fileHeader = new ImageFileHeader(fis);
		optionalHeader32 = new ImageOptionalHeader32(fis);
	}

	public ImageFileHeader getFileHeader() {
		return fileHeader;
	}

	public ImageOptionalHeader32 getOptionalHeader() {
		return optionalHeader32;
	}

	public int getSignature() {
		return signature;
	}
}