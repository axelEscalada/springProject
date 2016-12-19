package test;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.axel.config.AppConfig;
import com.axel.dao.PublicacionDao;
import com.axel.dao.UsuarioDao;
import com.axel.entities.Usuario;
import com.axel.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
@Transactional//Para que las transacciones hagan rollback al  terminar
public class Test{
		
	@Autowired
	private UsuarioDao usDao;
		
	@org.junit.Test
	public void testUsuarioDao() {
		
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("jerry");
		usuario.setPassword("seinfeld");
		usDao.save(usuario);
		
		Usuario usuario2 = usDao.findByName("jerry");
		
		assertEquals("jerry", usuario2.getNombreUsuario());
	}

}
