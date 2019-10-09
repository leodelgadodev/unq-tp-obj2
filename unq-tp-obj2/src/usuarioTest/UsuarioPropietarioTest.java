package usuarioTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import clases.SitioWeb;
import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioPropietarioTest extends UsuarioTest {

	SitioWeb web = new SitioWeb();
	
	Usuario prop1 = new UsuarioPropietario("Fer", "fer@email.com", 8001111);
	Usuario prop2 = new UsuarioPropietario("Gonza", "gonza@email.com", 8002222);
	Usuario prop3 = new UsuarioPropietario("Leo", "leo@email.com", 8003333);
	
	Usuario inquilino1 = new UsuarioInquilino("Diego", "diegotorres@email.com", 8004444);
	Usuario inquilino2 = new UsuarioInquilino("Diego", "diegocano@email.com", 8005555);

	
	
	
	@Test
	public void testPropietarioNoRegistradoNoPuedePublicar() {
		ArrayList<String> servicios = new ArrayList<String>;
		servicios.add("wifi");
		servicios.add("agua");
		servicios.add("gas");
		
		Assert.error(prop1.publicarInmueble("Depto", "Arg", "BsAs", 
				servicios, 2, 1000, 2200),"No puede publicar si no está registrado.");
	}
	
	@Test
	public void testPropietarioRegistradoPuedePublicar() {

		
		prop1.registrarse();
		prop1.publicarInmueble(casa1);
		
		Assert.assertTrue(web.getInmuebles().contains(casa1));
	}

}
