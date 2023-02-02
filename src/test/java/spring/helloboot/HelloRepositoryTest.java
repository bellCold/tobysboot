package spring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
    @Autowired
    HelloRepositoryJdbc helloRepositoryJdbc;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void noSearchHell() {
        assertThat(helloRepositoryJdbc.findHello("jong")).isNull();
    }

    @Test
    void increaseCount() {
        helloRepositoryJdbc.increaseCount("jong");
        assertThat(helloRepositoryJdbc.countOf("jong")).isEqualTo(1);
    }
}
