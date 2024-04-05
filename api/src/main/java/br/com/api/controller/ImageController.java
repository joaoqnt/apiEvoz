package br.com.api.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {
	@PostMapping({"/upload"})
	@ResponseBody
	public String fileUpload(@RequestParam MultipartFile file, @RequestParam String nomeEmpresa) {
		if (!file.isEmpty()) {
			try {
				String directory = "/var/www/images/" + nomeEmpresa + "/";
				File dir = new File(directory);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				File dest = new File(directory + file.getOriginalFilename());
				file.transferTo(dest);
				Process process = Runtime.getRuntime().exec("chmod -R 777 " + directory);

				try {
					process.waitFor();
					int exitCode = process.exitValue();
					if (exitCode == 0) {
						System.out.println("Permissões definidas com sucesso para o diretório " + directory);
					} else {
						System.err.println("Erro ao definir permissões para o diretório " + directory);
					}
				} catch (InterruptedException var8) {
					var8.printStackTrace();
				}

				return "Upload realizado com sucesso!";
			} catch (IOException var9) {
				return "Erro durante o upload: " + var9.getMessage();
			}
		} else {
			return "Arquivo vazio!";
		}
	}
}