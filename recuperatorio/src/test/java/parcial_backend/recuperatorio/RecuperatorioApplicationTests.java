package parcial_backend.recuperatorio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecuperatorioApplicationTests {

	@LocalServerPort
	private int port;

	private final TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	void testGetAllArtists() {
		String url = "http://localhost:" + port + "/api/artist";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}


}
