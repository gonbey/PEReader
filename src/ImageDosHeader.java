
public class ImageDosHeader {
	private int e_magic; // Magic number
	private int e_cblp; // Bytes on last page of file
	private int e_cp; // Pages in file
	private int e_crlc; // Relocations
	private int e_cparhdr; // Size of header in paragraphs
	private int e_minalloc; // Minimum extra paragraphs needed
	private int e_maxalloc; // Maximum extra paragraphs needed
	private int e_ss; // Initial (relative) SS value
	private int e_sp; // Initial SP value
	private int e_csum; // Checksum
	private int e_ip; // Initial IP value
	private int e_cs; // Initial (relative) CS value
	private int e_lfarlc; // File address of relocation table
	private int e_ovno; // Overlay number
	private int[] e_res = new int[4]; // Reserved ints
	private int e_oemid; // OEM identifier (for e_oeminfo)
	private int e_oeminfo; // OEM information; e_oemid specific
	private int[] e_res2 = new int[10]; // Reserved ints
	private int e_lfanew; // File address of new exe header

	public int getE_magic() {
		return e_magic;
	}

	public void setE_magic(int e_magic) {
		this.e_magic = e_magic;
	}

	public int getE_cblp() {
		return e_cblp;
	}

	public void setE_cblp(int e_cblp) {
		this.e_cblp = e_cblp;
	}

	public int getE_cp() {
		return e_cp;
	}

	public void setE_cp(int e_cp) {
		this.e_cp = e_cp;
	}

	public int getE_crlc() {
		return e_crlc;
	}

	public void setE_crlc(int e_crlc) {
		this.e_crlc = e_crlc;
	}

	public int getE_cparhdr() {
		return e_cparhdr;
	}

	public void setE_cparhdr(int e_cparhdr) {
		this.e_cparhdr = e_cparhdr;
	}

	public int getE_minalloc() {
		return e_minalloc;
	}

	public void setE_minalloc(int e_minalloc) {
		this.e_minalloc = e_minalloc;
	}

	public int getE_maxalloc() {
		return e_maxalloc;
	}

	public void setE_maxalloc(int e_maxalloc) {
		this.e_maxalloc = e_maxalloc;
	}

	public int getE_ss() {
		return e_ss;
	}

	public void setE_ss(int e_ss) {
		this.e_ss = e_ss;
	}

	public int getE_sp() {
		return e_sp;
	}

	public void setE_sp(int e_sp) {
		this.e_sp = e_sp;
	}

	public int getE_csum() {
		return e_csum;
	}

	public void setE_csum(int e_csum) {
		this.e_csum = e_csum;
	}

	public int getE_ip() {
		return e_ip;
	}

	public void setE_ip(int e_ip) {
		this.e_ip = e_ip;
	}

	public int getE_cs() {
		return e_cs;
	}

	public void setE_cs(int e_cs) {
		this.e_cs = e_cs;
	}

	public int getE_lfarlc() {
		return e_lfarlc;
	}

	public void setE_lfarlc(int e_lfarlc) {
		this.e_lfarlc = e_lfarlc;
	}

	public int getE_ovno() {
		return e_ovno;
	}

	public void setE_ovno(int e_ovno) {
		this.e_ovno = e_ovno;
	}

	public int[] getE_res() {
		return e_res;
	}

	public void setE_res(int[] e_res) {
		this.e_res = e_res;
	}

	public int getE_oemid() {
		return e_oemid;
	}

	public void setE_oemid(int e_oemid) {
		this.e_oemid = e_oemid;
	}

	public int getE_oeminfo() {
		return e_oeminfo;
	}

	public void setE_oeminfo(int e_oeminfo) {
		this.e_oeminfo = e_oeminfo;
	}

	public int[] getE_res2() {
		return e_res2;
	}

	public void setE_res2(int[] e_res2) {
		this.e_res2 = e_res2;
	}

	public int getE_lfanew() {
		return e_lfanew;
	}

	public void setE_lfanew(int e_lfanew) {
		this.e_lfanew = e_lfanew;
	}
}
