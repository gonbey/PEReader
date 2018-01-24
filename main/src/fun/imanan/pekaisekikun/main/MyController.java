package fun.imanan.pekaisekikun.main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.classic.Logger;
import fun.imanan.pekaisekikun.core.annotation.Log;

@RestController
public class MyController {

	@Log
	private Logger logger;

	@RequestMapping(path = "file/upload", method = RequestMethod.POST)
	public Object post(
			@RequestParam("upload_file") MultipartFile multipartFile) throws IOException {

		if (multipartFile.isEmpty()) {
			throw new IllegalStateException("ファイルが送信されていない");
		}


		File uploadFile = null;
		try {
			uploadFile = File.createTempFile("test", ".tmp");
			try (
				BufferedOutputStream uploadFileStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
			){
				byte[] bytes = multipartFile.getBytes();
				uploadFileStream.write(bytes);
				uploadFileStream.close();
				return new Main(uploadFile);
			}
		} finally {
			if (uploadFile != null) {
				if (!uploadFile.delete()) {
					throw new IllegalStateException("ファイルが消せない" + uploadFile.getAbsolutePath());
				}
			}
		}
	}
}
