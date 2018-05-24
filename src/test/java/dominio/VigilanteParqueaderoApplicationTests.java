package dominio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import parqueadero.VigilanteParqueaderoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VigilanteParqueaderoApplication.class)
@DataJpaTest
public class VigilanteParqueaderoApplicationTests {

	@Test
	public void contextLoads() {

	}
	
	@Test
	public void test() {
		VigilanteParqueaderoApplication.main(
				new String[] { "--spring.main.web-environment=false", "--spring.autoconfigure.exclude=none",
				// Override any other environment properties according to your needs
				});
	}
}
