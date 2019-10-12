package clases;

public class Administrador {
	private SitioWeb web;
	
	public SitioWeb getSitioWeb() {
		return web;
	}

	public void setSitioWeb(SitioWeb sitioWeb) {
		web = sitioWeb;
	}

	public void crearCategoriaDeRankingPropietario(String categoria) {
		web.agregarCategoriaDeRankingPropietario(categoria);
		
	}

}
