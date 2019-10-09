package usuarioTest;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioInquilinoTest extends UsuarioTest {

	@Before
	public void setup() {
		SitioWeb web = new SitioWeb();
		
		Usuario prop1 = new UsuarioPropietario();
		Usuario prop2 = new UsuarioPropietario();
		
		Usuario inquilino1 = new UsuarioInquilino();
		Usuario inquilino2 = new UsuarioInquilino();
		
		Inmueble casa1 = new Inmueble();
		Inmueble casa2 = new Inmueble();
		Inmueble casa3 = new Inmueble();
	}
	
	@Test
	public void testInquilinoNoRegistradoNoPuedeAlquilar() {
		
	}
	
	@Test
	public void testInquilinoRegistradoPuedeAlquilar() {
		
	}
}
