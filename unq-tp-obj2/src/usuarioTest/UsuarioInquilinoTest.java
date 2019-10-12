package usuarioTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioInquilinoTest extends UsuarioTest {

	SitioWeb web = new SitioWeb();
	
	Usuario prop1 = new UsuarioPropietario();
	Usuario prop2 = new UsuarioInquilino();
	
	Usuario inquilino1 = new UsuarioInquilino();
	Usuario inquilino2 = new UsuarioInquilino();
	
	Inmueble casa1 = new Inmueble();
	Inmueble casa2 = new Inmueble();
	Inmueble casa3 = new Inmueble();
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testInquilinoNoRegistradoNoPuedeAlquilar() {
		
	}
	
	@Test
	public void testInquilinoRegistradoPuedeAlquilar() {
		
	}
}
