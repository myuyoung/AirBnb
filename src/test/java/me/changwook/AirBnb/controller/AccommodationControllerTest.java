package me.changwook.AirBnb.controller;

import me.changwook.AirBnb.domain.Accommodation;
import me.changwook.AirBnb.repository.AccommodationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccommodationControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @BeforeEach
    public void mockMvcSetup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    public void cleanUp(){
        accommodationRepository.deleteAll();
    }

    @DisplayName("숙소 정보를 조회한다")
    @Test
    public void getAccommodation() throws Exception {
        // given: 테스트 데이터 생성
        Accommodation saved = accommodationRepository.save(createTestAccommodation());

        // when: GET 요청 실행
        mockMvc.perform(get("/api/accommodations")
                        .param("id", String.valueOf(saved.getId())))

                // then: 응답 검증
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(saved.getName()))
                .andExpect(jsonPath("$.imageUrl").value(saved.getImageUrl()))
                .andExpect(jsonPath("$.latitude").value(saved.getLatitude()))
                .andExpect(jsonPath("$.longitude").value(saved.getLongitude()))
                .andExpect(jsonPath("$.price").value(saved.getPrice()))
                .andExpect(jsonPath("$.rating").value(saved.getRating()))
                .andExpect(jsonPath("$.reviewsCount").value(saved.getReviewsCount()));
    }

    private Accommodation createTestAccommodation() {
        Accommodation accommodation = new Accommodation();
        accommodation.setName("Test Accommodation");
        accommodation.setImageUrl("/img/test.jpg");
        accommodation.setLatitude(37.5665);
        accommodation.setLongitude(126.9780);
        accommodation.setPrice(100.0);
        accommodation.setRating(4.5);
        accommodation.setReviewsCount(20);

        return accommodation;
    }
}