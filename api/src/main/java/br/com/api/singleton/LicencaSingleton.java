package br.com.api.singleton;

import br.com.api.model.Licenca;
import java.util.ArrayList;
import java.util.List;

public class LicencaSingleton {
	private static LicencaSingleton instance;
	private List<Licenca> licencas = new ArrayList();

	private LicencaSingleton() {
	}

	public static LicencaSingleton getInstance() {
		if (instance == null) {
			Class var0 = LicencaSingleton.class;
			synchronized (LicencaSingleton.class) {
				if (instance == null) {
					instance = new LicencaSingleton();
				}
			}
		}

		return instance;
	}

	public List<Licenca> getLicencas() {
		return this.licencas;
	}

	public void addLicenca(Licenca licenca) {
		this.licencas.add(licenca);
	}
}