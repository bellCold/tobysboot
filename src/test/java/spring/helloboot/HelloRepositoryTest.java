package spring.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired HelloRepositoryJdbc helloRepositoryJdbc;
    @Autowired JdbcTemplate jdbcTemplate;

    @Test
    void noSearchHell() {
        Hello jong = helloRepositoryJdbc.findHello("jong");
        assertThat(jong).isNull();
    }

    @Test
    void increaseCount() {
        helloRepositoryJdbc.increaseCount("jong");
        assertThat(helloRepositoryJdbc.countOf("jong")).isEqualTo(1);
    }
}
