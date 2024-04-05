package br.com.api.service;

import java.io.File;

public class ImageService {
	public void createDirectory(String enterprise) {
		String diretorioImagens = "/var/www/images/" + enterprise;
		File diretorio = new File(diretorioImagens);
		if (!diretorio.exists()) {
			boolean sucesso = diretorio.mkdirs();
			if (sucesso) {
				System.out.println("Diretório de imagens criado em: " + diretorioImagens);
			} else {
				System.err.println("Falha ao criar diretório de imagens em: " + diretorioImagens);
			}
		} else {
			System.out.println("Diretório de imagens já existe em: " + diretorioImagens);
		}

	}
}