import java.io.File;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Main {

	public static void main(String[] args) throws Exception {
		DataReader dr = new DataReader(new File("C:\\windows\\notepad.exe"));

		// ①IMAGE_DOS_HEADER
		ImageDosHeader dh = new ImageDosHeader();
		dh.setE_magic(dr.readWord());
		dh.setE_cblp(dr.readWord());
		dh.setE_cp(dr.readWord());
		dh.setE_crlc(dr.readWord());
		dh.setE_cparhdr(dr.readWord());
		dh.setE_minalloc(dr.readWord());
		dh.setE_maxalloc(dr.readWord());
		dh.setE_ss(dr.readWord());
		dh.setE_sp(dr.readWord());
		dh.setE_csum(dr.readWord());
		dh.setE_ip(dr.readWord());
		dh.setE_cs(dr.readWord());
		dh.setE_lfarlc(dr.readWord());
		dh.setE_ovno(dr.readWord());
		dh.setE_res(new int[] { dr.readWord(), dr.readWord(), dr.readWord(), dr.readWord() });
		dh.setE_oemid(dr.readWord());
		dh.setE_oeminfo(dr.readWord());
		dh.setE_res2(new int[] { dr.readWord(), dr.readWord(), dr.readWord(), dr.readWord(), dr.readWord(),
				dr.readWord(), dr.readWord(), dr.readWord(), dr.readWord(), dr.readWord() });
		dh.setE_lfanew(dr.readWord());

		// ②IMAGE_NT_HEADER
		ImageNtHeaders nh = new ImageNtHeaders();
		nh.setSignature(dr.readDword());

		// ②.1 IMAGE_FILE_HEADER
		ImageFileHeader fh = new ImageFileHeader();
		fh.setMachine(dr.readWord());
		fh.setNumberOfSections(dr.readWord());
		fh.setTimeDateStamp(dr.readDword());
		fh.setPointerToSymbolTable(dr.readDword());
		fh.setNumberOfSymbols(dr.readDword());
		fh.setSizeOfOptionalHeader(dr.readWord());
		fh.setCharacteristics(dr.readWord());

		nh.setFileHeader(fh);

		// ②.2 IMAGE_OPTIONAL_HEADER
		ImageOptionalHeader32 oh = new ImageOptionalHeader32();
		oh.setMagic(dr.readWord());
		oh.setMajorLinkerVersion(dr.readByte());
		oh.setMinorLinkerVersion(dr.readByte());
		oh.setSizeOfCode(dr.readDword());
		oh.setSizeOfInitializedData(dr.readDword());
		oh.setSizeOfUninitializedData(dr.readDword());
		oh.setAddressOfEntryPoint(dr.readDword());
		oh.setBaseOfCode(dr.readDword());
		oh.setBaseOfData(dr.readDword());

		oh.setImageBase(dr.readDword());
		oh.setSectionAlignment(dr.readDword());
		oh.setFileAlignment(dr.readDword());
		oh.setMajorOperatingSystemVersion(dr.readWord());
		oh.setMinorOperatingSystemVersion(dr.readWord());
		oh.setMajorImageVersion(dr.readWord());
		oh.setMinorImageVersion(dr.readWord());
		oh.setMajorSubsystemVersion(dr.readWord());
		oh.setMinorSubsystemVersion(dr.readWord());
		oh.setWin32VersionValue(dr.readDword());
		oh.setSizeOfImage(dr.readDword());
		oh.setSizeOfHeaders(dr.readDword());
		oh.setCheckSum(dr.readDword());
		oh.setSubsystem(dr.readWord());
		oh.setDllCharacteristics(dr.readWord());
		oh.setSizeOfStackReserve(dr.readDword());
		oh.setSizeOfStackCommit(dr.readDword());
		oh.setSizeOfHeapReserve(dr.readDword());
		oh.setSizeOfHeapCommit(dr.readDword());
		oh.setLoaderFlags(dr.readDword());
		oh.setNumberOfRvaAndSizes(dr.readDword());

		nh.setOptionalHeader(oh);

		// ③ IMAGE_SECTION_HEADER
		ImageSectionHeader sh = new ImageSectionHeader();
		sh.setName(new int[] { dr.readByte(), dr.readByte(), dr.readByte(), dr.readByte(), dr.readByte(), dr.readByte(),
				dr.readByte(), dr.readByte() });
		sh.setPhysicalAddressOrVirtualSize(dr.readDword());
		sh.setVirtualAddress(dr.readDword());
		sh.setSizeOfRawData(dr.readDword());
		sh.setPointerToRawData(dr.readDword());
		sh.setPointerToRelocations(dr.readDword());
		sh.setPointerToLinenumbers(dr.readDword());
		sh.setNumberOfRelocations(dr.readWord());
		sh.setNumberOfLinenumbers(dr.readWord());
		sh.setCharacteristics(dr.readDword());

		Object[] targets = { dh, nh, fh, oh, sh };
		for (Object target : targets) {
			Map<String, String> descMap = BeanUtils.describe(target);
			try {
				for (Map.Entry<String, String> map : descMap.entrySet()) {
					System.out.printf("%-10s, %04x\n", map.getKey(), Integer.parseInt(map.getValue()));
				}
			} catch (NumberFormatException e) {
				// nop
			}
		}
	}
}
