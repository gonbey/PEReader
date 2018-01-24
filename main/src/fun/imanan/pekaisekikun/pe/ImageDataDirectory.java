package fun.imanan.pekaisekikun.pe;

import java.io.IOException;

import fun.imanan.pekaisekikun.io.MyFileInputStream;

public class ImageDataDirectory {
	private int size;
	private int virtualAddress;

	public ImageDataDirectory(MyFileInputStream fis) throws IOException {
		size = fis.dwordRead();
		virtualAddress = fis.dwordRead();
	}
	public int getSize() {
		return size;
	}

	public int getVirtualAddress() {
		return virtualAddress;
	}
}