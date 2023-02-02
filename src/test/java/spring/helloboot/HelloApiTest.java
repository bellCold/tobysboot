package spring.helloboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
public class HelloApiTest {

    @ParameterizedTest
    @ValueSource(strings = {"kim", "jong", "chan"})
    void helloApi(String name) {
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app/hello?name=" + name, String.class, name);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(res.getBody()).isEqualTo("*" + "Hello " + name + "*");
    }

    @Test
    void failHelloApi() {
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
