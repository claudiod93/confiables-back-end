package cl.confiables;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.confiables.config.ConfiablesBackApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConfiablesBackApplication.class)
@WebAppConfiguration
public class ConfiablesBackApplicationTests {

	@Test
	public void contextLoads() {
	}

}
