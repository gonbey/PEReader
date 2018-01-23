package fun.imanan.pekaisekikun.io.main;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import fun.imanan.pekaisekikun.io.MyFileInputStream;
import fun.imanan.pekaisekikun.io.pe.ImageDosHeader;
import fun.imanan.pekaisekikun.io.pe.ImageNtHeaders;
import fun.imanan.pekaisekikun.io.pe.ImageSectionHeaders;
import fun.imanan.pekaisekikun.io.util.Util;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("実行ファイルを指定してね");
		}
		new Main(new File(args[0]));
	}

	private Map<String, String> imageDosHeaderMap;
	private Map<String, String> imageFileHeaderMap;
	private Map<String, String> imageNtHeadersMap;
	private Map<String, String> imageOptionalHeaderMap;
	private Map<String, Map<String, String>> imageSectionHeadersMapList;

	public Main(File input) {
		exec(input);
	}

	private void exec(File input) {
		try (
			MyFileInputStream fis = new MyFileInputStream(input)) {
			ImageDosHeader imageDosHeader = new ImageDosHeader(fis);
			imageDosHeaderMap = new LinkedHashMap<>();
			imageDosHeaderMap.put("e_magic", Util.toHexString(imageDosHeader.getE_magic()));
			imageDosHeaderMap.put("e_cblp", Util.toHexString(imageDosHeader.getE_cblp()));
			imageDosHeaderMap.put("e_cp", Util.toHexString(imageDosHeader.getE_cp()));
			imageDosHeaderMap.put("e_crlc", Util.toHexString(imageDosHeader.getE_crlc()));
			imageDosHeaderMap.put("e_cparhdr", Util.toHexString(imageDosHeader.getE_cparhdr()));
			imageDosHeaderMap.put("e_minalloc", Util.toHexString(imageDosHeader.getE_minalloc()));
			imageDosHeaderMap.put("e_maxalloc", Util.toHexString(imageDosHeader.getE_maxalloc()));
			imageDosHeaderMap.put("e_ss", Util.toHexString(imageDosHeader.getE_ss()));
			imageDosHeaderMap.put("e_sp", Util.toHexString(imageDosHeader.getE_sp()));
			imageDosHeaderMap.put("e_csum", Util.toHexString(imageDosHeader.getE_csum()));
			imageDosHeaderMap.put("e_ip", Util.toHexString(imageDosHeader.getE_ip()));
			imageDosHeaderMap.put("e_cs", Util.toHexString(imageDosHeader.getE_cs()));
			imageDosHeaderMap.put("e_lfarlc", Util.toHexString(imageDosHeader.getE_lfarlc()));
			imageDosHeaderMap.put("e_ovno", Util.toHexString(imageDosHeader.getE_ovno()));

			for (int i = 0; i < 4; i++) {
				imageDosHeaderMap.put("e_res_" + i, Util.toHexString(imageDosHeader.getE_res()[i]));
			}

			imageDosHeaderMap.put("e_oemid", Util.toHexString(imageDosHeader.getE_oemid()));
			imageDosHeaderMap.put("e_oeminfo", Util.toHexString(imageDosHeader.getE_oeminfo()));
			for (int i = 0; i < 10; i++) {
				imageDosHeaderMap.put("e_res2_" + i, Util.toHexString(imageDosHeader.getE_res2()[i]));
			}
			imageDosHeaderMap.put("e_lfanew", Util.toHexString(imageDosHeader.getE_lfanew()));
			fis.skip(imageDosHeader.getE_lfanew() - fis.getPos()); // TODO e_lfanewがlong/2 -1より大きいとバグる！

			imageNtHeadersMap = new LinkedHashMap<>();
			ImageNtHeaders imageNtHeaders = new ImageNtHeaders(fis);
			imageNtHeadersMap.put("Signature", Util.toHexString(imageNtHeaders.getSignature()));

			imageFileHeaderMap = new LinkedHashMap<>();
			imageFileHeaderMap.put("Machine", Util.toHexString(imageNtHeaders.getFileHeader().getMachine()));
			imageFileHeaderMap.put("NumberOfSections", Util.toHexString(imageNtHeaders.getFileHeader().getNumberOfSections()));
			imageFileHeaderMap.put("TimeDateStamp", Util.toHexString(imageNtHeaders.getFileHeader().getTimeDateStamp()));
			imageFileHeaderMap.put("PointerToSymbolTable", Util.toHexString(imageNtHeaders.getFileHeader().getPointerToSymbolTable()));
			imageFileHeaderMap.put("NumberOfSymbols", Util.toHexString(imageNtHeaders.getFileHeader().getNumberOfSymbols()));
			imageFileHeaderMap.put("SizeOfOptionalHeader", Util.toHexString(imageNtHeaders.getFileHeader().getSizeOfOptionalHeader()));
			imageFileHeaderMap.put("Characteristics", Util.toHexString(imageNtHeaders.getFileHeader().getCharacteristics()));

			imageOptionalHeaderMap = new LinkedHashMap<>();

			imageOptionalHeaderMap.put("Magic", Util.toHexString(imageNtHeaders.getOptionalHeader().getMagic()));
			imageOptionalHeaderMap.put("MajorLinkerVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMajorLinkerVersion()));
			imageOptionalHeaderMap.put("MinorLinkerVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMinorLinkerVersion()));
			imageOptionalHeaderMap.put("SizeOfCode", Util.toHexString(imageNtHeaders.getOptionalHeader().getSizeOfCode()));
			imageOptionalHeaderMap.put("SizeOfInitializedData", Util.toHexString(imageNtHeaders.getOptionalHeader().getSizeOfInitializedData()));
			imageOptionalHeaderMap.put("AddressOfEntryPoint", Util.toHexString(imageNtHeaders.getOptionalHeader().getAddressOfEntryPoint()));
			imageOptionalHeaderMap.put("BaseOfCode", Util.toHexString(imageNtHeaders.getOptionalHeader().getBaseOfCode()));
			imageOptionalHeaderMap.put("BaseOfData", Util.toHexString(imageNtHeaders.getOptionalHeader().getBaseOfData()));
			imageOptionalHeaderMap.put("ImageBase", Util.toHexString(imageNtHeaders.getOptionalHeader().getImageBase()));
			imageOptionalHeaderMap.put("SectionAlignment", Util.toHexString(imageNtHeaders.getOptionalHeader().getSectionAlignment()));
			imageOptionalHeaderMap.put("FileAlignment", Util.toHexString(imageNtHeaders.getOptionalHeader().getFileAlignment()));
			imageOptionalHeaderMap.put("MajorOperatingSystemVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMajorOperatingSystemVersion()));
			imageOptionalHeaderMap.put("MinorOperatingSystemVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMinorOperatingSystemVersion()));
			imageOptionalHeaderMap.put("MajorImageVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMajorOperatingSystemVersion()));
			imageOptionalHeaderMap.put("MajorOperatingSystemVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMajorImageVersion()));
			imageOptionalHeaderMap.put("MinorImageVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMinorImageVersion()));
			imageOptionalHeaderMap.put("MajorSubsystemVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMajorSubsystemVersion()));
			imageOptionalHeaderMap.put("MinorSubsystemVersion", Util.toHexString(imageNtHeaders.getOptionalHeader().getMinorSubsystemVersion()));
			imageOptionalHeaderMap.put("Win32VersionValue", Util.toHexString(imageNtHeaders.getOptionalHeader().getWin32VersionValue()));
			imageOptionalHeaderMap.put("SizeOfImage", Util.toHexString(imageNtHeaders.getOptionalHeader().getSizeOfImage()));
			imageOptionalHeaderMap.put("SizeOfHeaders", Util.toHexString(imageNtHeaders.getOptionalHeader().getSizeOfHeaders()));
			imageOptionalHeaderMap.put("CheckSum", Util.toHexString(imageNtHeaders.getOptionalHeader().getCheckSum()));
			imageOptionalHeaderMap.put("Subsystem", Util.toHexString(imageNtHeaders.getOptionalHeader().getSubsystem()));
			imageOptionalHeaderMap.put("DllCharacteristics", Util.toHexString(imageNtHeaders.getOptionalHeader().getDllCharacteristics()));
			imageOptionalHeaderMap.put("SizeOfStackReserve", Util.toHexString(imageNtHeaders.getOptionalHeader().getSizeOfStackReserve()));
			imageOptionalHeaderMap.put("SizeOfStackCommit", Util.toHexString(imageNtHeaders.getOptionalHeader().getSizeOfStackCommit()));
			imageOptionalHeaderMap.put("SizeOfHeapReserve", Util.toHexString(imageNtHeaders.getOptionalHeader().getSizeOfHeapReserve()));
			imageOptionalHeaderMap.put("SizeOfHeapCommit", Util.toHexString(imageNtHeaders.getOptionalHeader().getSizeOfHeapCommit()));
			imageOptionalHeaderMap.put("LoaderFlags", Util.toHexString(imageNtHeaders.getOptionalHeader().getLoaderFlags()));
			imageOptionalHeaderMap.put("NumberOfRvaAndSizes", Util.toHexString(imageNtHeaders.getOptionalHeader().getNumberOfRvaAndSizes()));
			ImageSectionHeaders imageSectionHeaders = new ImageSectionHeaders(fis, imageNtHeaders);
			imageSectionHeadersMapList = Arrays.stream(imageSectionHeaders.getImageSectionHeader()).map(h -> {
				Map<String, String> map = new LinkedHashMap<>();
				map.put("Name", new String(h.getName(), Charset.forName("ASCII")));
				map.put("PhysicalAddressOrVirtualSize", Util.toHexString(h.getPhysicalAddressOrVirtualSize()));
				map.put("VirtualAddress", Util.toHexString(h.getVirtualAddress()));
				map.put("SizeOfRawData", Util.toHexString(h.getSizeOfRawData()));
				map.put("PointerToRawData", Util.toHexString(h.getPointerToRawData()));
				map.put("PointerToRelocations", Util.toHexString(h.getPointerToRelocations()));
				map.put("PointerToLinenumbers", Util.toHexString(h.getPointerToLinenumbers()));
				map.put("NumberOfRelocations", Util.toHexString(h.getNumberOfRelocations()));
				map.put("NumberOfLinenumbers", Util.toHexString(h.getNumberOfLinenumbers()));
				map.put("Characteristics", Util.toHexString(h.getCharacteristics()));
				return map;
			}).collect(Collectors.toMap(t -> t.get("Name"), t -> t));

			imageDosHeaderMap.forEach((key, value) -> System.out.println("imageDosHeaderMap" + key + ":" + value));
			imageNtHeadersMap.forEach((key, value) -> System.out.println("imageNtHeadersMap" + key + ":" + value));
			imageFileHeaderMap.forEach((key, value) -> System.out.println("imageFileHeaderMap" + key + ":" + value));
			imageOptionalHeaderMap
					.forEach((key, value) -> System.out.println("imageOptionalHeaderMap" + key + ":" + value));
			imageSectionHeadersMapList.forEach((name, map) -> {
				map.forEach((key, value) -> System.out.println("imageSectionHeaderMap" + name + key + ":" + value));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getImageDosHeaderMap() {
		return imageDosHeaderMap;
	}

	public Map<String, String> getImageFileHeaderMap() {
		return imageFileHeaderMap;
	}

	public Map<String, String> getImageNtHeadersMap() {
		return imageNtHeadersMap;
	}

	public Map<String, String> getImageOptionalHeaderMap() {
		return imageOptionalHeaderMap;
	}

	public Map<String, Map<String, String>> getImageSectionHeadersMapList() {
		return imageSectionHeadersMapList;
	}

	public void setImageDosHeaderMap(Map<String, String> imageDosHeaderMap) {
		this.imageDosHeaderMap = imageDosHeaderMap;
	}

	public void setImageFileHeaderMap(Map<String, String> imageFileHeaderMap) {
		this.imageFileHeaderMap = imageFileHeaderMap;
	}

	public void setImageNtHeadersMap(Map<String, String> imageNtHeadersMap) {
		this.imageNtHeadersMap = imageNtHeadersMap;
	}

	public void setImageOptionalHeaderMap(Map<String, String> imageOptionalHeaderMap) {
		this.imageOptionalHeaderMap = imageOptionalHeaderMap;
	}

	public void setImageSectionHeadersMapList(Map<String, Map<String, String>> imageSectionHeadersMapList) {
		this.imageSectionHeadersMapList = imageSectionHeadersMapList;
	}
}