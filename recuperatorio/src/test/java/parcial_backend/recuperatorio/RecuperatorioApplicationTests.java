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
	@Test
	void testGetAllAlbums() {
		String url = "http://localhost:" + port + "/api/album";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}
	@Test
	void testGetAllCustomers() {
		String url = "http://localhost:" + port + "/api/customers";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}
	@Test
	void testGetAllGenre() {
		String url = "http://localhost:" + port + "/api/genre";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}
	@Test
	void testGetAllInvoice_item() {
		String url = "http://localhost:" + port + "/api/invoice_item";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}
	@Test
	void testGetAllInvoice() {
		String url = "http://localhost:" + port + "/api/invoice";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}
	@Test
	void testGetAllPlaylist_track() {
		String url = "http://localhost:" + port + "/api/playlist_track";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}
	@Test
	void testGetAllPlaylist() {
		String url = "http://localhost:" + port + "/api/playlist";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}
	@Test
	void testGetAllTrack() {
		String url = "http://localhost:" + port + "/api/track";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);


	}


}
