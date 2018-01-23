package fun.imanan.pekaisekikun.io.pe;

import java.io.IOException;

import fun.imanan.pekaisekikun.io.MyFileInputStream;

public class ImageSectionHeaders {
	private ImageSectionHeader[] imageSectionHeader = null;

	public ImageSectionHeaders(MyFileInputStream fis, ImageNtHeaders imageNtHeader) throws IOException {
		int num = imageNtHeader.getFileHeader().getNumberOfSections();
		imageSectionHeader = new ImageSectionHeader[num];
		for (int i = 0; i < num; i++) {
			imageSectionHeader[i] = new ImageSectionHeader(fis);
		}
	}

	public ImageSectionHeader[] getImageSectionHeader() {
		return imageSectionHeader;
	}
}