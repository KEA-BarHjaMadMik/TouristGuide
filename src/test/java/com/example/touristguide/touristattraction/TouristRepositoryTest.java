package com.example.touristguide.touristattraction;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.repository.TouristRepository;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:h2init.sql", executionPhase = BEFORE_TEST_METHOD)
public class TouristRepositoryTest {

    @Autowired
    private TouristRepository repository;

    @Test
    void showAllAttractions(){
        List<TouristAttraction> all = repository.getAttractions();

        assertThat(all).isNotNull();
        assertThat(all).isNotEmpty();
    }

    @Test
    void addAttractionAndShow(){
        repository.addAttraction(new TouristAttraction("Motorcross",
                "Motorcross på seje baner og i højt tempo",
                "København K", new ArrayList<>()));
        TouristAttraction a = repository.findAttractionByName("Motorcross");
        assertThat(a).isNotNull();
        assertThat(a.getCity()).isEqualTo("København K");
    }
}
