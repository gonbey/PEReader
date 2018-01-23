package fun.imanan.pekaisekikun.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream implements AutoCloseable {
	FileInputStream fis = null;
	private int pos = 0;
	public int getPos() {
		return pos;
	}
	public MyFileInputStream(File in) throws FileNotFoundException {
		fis = new FileInputStream(in);
	}
	private int read() throws IOException {
		pos++;
		return fis.read();
	}
	public long skip(long n) throws IOException {
		pos += n;
		return fis.skip(n);
	}
	public long longRead() throws IOException {
		return (dwordRead() & 0x00000000ffffffffl) | ((long) dwordRead() << 32l);
	}
	public int dwordRead()  throws IOException {
		return read() | read() << 8 | read() << 16 | read() << 24;
	}
	public short wordRead() throws IOException {
		return (short)(read() | read() << 8);
	}
	public byte byteRead() throws IOException {
		return (byte)(this.read());
	}
	@Override
	public void close() throws Exception {
		if (fis != null) {
			fis.close();
		}
	}
}