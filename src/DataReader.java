import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataReader {
	BufferedInputStream bis;
	public DataReader(File f) throws Exception {
		bis = new BufferedInputStream(new FileInputStream(f));
		bis.mark(10000);
	}

	public int readByte() throws IOException {
		return bis.read();
	}

	public int readWord() throws IOException {
		return bis.read() << 8 | bis.read();
	}

	public int readDword() throws IOException {
		return readWord() << 16 | readWord();
	}

	public void skip(long size) throws IOException {
		bis.skip(size);
	}

	public void reset() throws IOException {
		bis.reset();
	}

}
