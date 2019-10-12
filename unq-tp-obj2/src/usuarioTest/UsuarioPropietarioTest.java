package usuarioTest;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioPropietarioTest extends UsuarioTest {

	private SitioWeb web = new SitioWeb();
	private List<String> servicios = new ArrayList<String>();
	private Usuario prop1,prop2,prop3,inquilino1,inquilino2,inquilino3;
	
	@Before
	public void setUp() {
		
	Usuario prop1 = new UsuarioPropietario("Fer","Santacruz", "fer@email.com", 8001111);
	Usuario prop2 = new UsuarioPropietario("Gonza","Torrez", "gonza@email.com", 8002222);
	Usuario prop3 = new UsuarioPropietario("Leo","Delgado", "leo@email.com", 8003333);
	
	Usuario inquilino1 = new UsuarioInquilino("Diego","Cano", "diegotorres@email.com", 8004444);
	Usuario inquilino2 = new UsuarioInquilino("Diego","Torres", "diegocano@email.com", 8005555);
	Usuario inquilino3 = new UsuarioInquilino("Martin","Rosenfeld", "martinrosenfeld@email.com", 8006666);
	
	servicios.add("Gas");
	servicios.add("Agua");
	servicios.add("Wifi");
	
	Inmueble depto1 = new Inmueble("Depto","BsAs",servicios,3,1200,1000,50);
	}
	
	@Test
	public void testPropietarioNoRegistradoNoPuedePublicar() {

		Assert.error(prop1.publicarInmueble(depto1),"No puede publicar si no est� registrado.");
	}
	
	@Test
	public void testPropietarioRegistradoPuedePublicar() {

		
		prop1.registrarse();
		prop1.publicarInmueble(depto1);
		
		Assert.assertTrue(web.getInmuebles().contains(casa1));
	}

}
