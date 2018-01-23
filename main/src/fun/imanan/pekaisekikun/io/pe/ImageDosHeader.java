package fun.imanan.pekaisekikun.io.pe;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import fun.imanan.pekaisekikun.io.MyFileInputStream;

public class ImageDosHeader {
	private short e_cblp;

	private short e_cp;

	private short e_cparhdr;

	private short e_crlc;

	private short e_cs;

	private short e_csum;

	private short e_ip;

	private int e_lfanew;

	private short e_lfarlc;

	private short e_magic;

	private short e_maxalloc;

	private short e_minalloc;

	private short e_oemid;

	private short e_oeminfo;

	private short e_ovno;

	private short e_res[] = new short[4];

	private short e_res2[] = new short[10];

	private short e_sp;

	private short e_ss;

	public ImageDosHeader(MyFileInputStream fis)
			throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		e_magic = fis.wordRead();
		e_cblp = fis.wordRead();
		e_cp = fis.wordRead();
		e_crlc = fis.wordRead();
		e_cparhdr = fis.wordRead();
		e_minalloc = fis.wordRead();
		e_maxalloc = fis.wordRead();
		e_ss = fis.wordRead();
		e_sp = fis.wordRead();
		e_csum = fis.wordRead();
		e_ip = fis.wordRead();
		e_cs = fis.wordRead();
		e_lfarlc = fis.wordRead();
		e_ovno = fis.wordRead();
		for (int i = 0; i < 4; i++) {
			e_res[i] = fis.wordRead();
		}
		e_oemid = fis.wordRead();
		e_oeminfo = fis.wordRead();
		for (int i = 0; i < 10; i++) {
			e_res2[i] = fis.wordRead();
		}
		e_lfanew = fis.dwordRead();
	}

	public short getE_cblp() {
		return e_cblp;
	}

	public short getE_cp() {
		return e_cp;
	}

	public short getE_cparhdr() {
		return e_cparhdr;
	}

	public short getE_crlc() {
		return e_crlc;
	}

	public short getE_cs() {
		return e_cs;
	}

	public short getE_csum() {
		return e_csum;
	}

	public short getE_ip() {
		return e_ip;
	}

	public int getE_lfanew() {
		return e_lfanew;
	}

	public short getE_lfarlc() {
		return e_lfarlc;
	}

	public short getE_magic() {
		return e_magic;
	}

	public short getE_maxalloc() {
		return e_maxalloc;
	}

	public short getE_minalloc() {
		return e_minalloc;
	}

	public short getE_oemid() {
		return e_oemid;
	}

	public short getE_oeminfo() {
		return e_oeminfo;
	}

	public short getE_ovno() {
		return e_ovno;
	}

	public short[] getE_res() {
		return e_res;
	}

	public short[] getE_res2() {
		return e_res2;
	}

	public short getE_sp() {
		return e_sp;
	}

	public short getE_ss() {
		return e_ss;
	}
}