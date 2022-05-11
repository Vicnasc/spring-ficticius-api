package com.totvs.ficticius;

import com.totvs.ficticius.carsapi.application.controllers.CarController;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CarController.class)
//@ContextConfiguration(classes = FicticiusApplication.class)
//@WebMvcTest(controllers = CarController.class)
class FicticiusApplicationTests {
//    @Autowired
//    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
    }

//    @Test
//    public void testGetCars() throws Exception {
////        this.mockMvc.perform(get("/api/v1/cars"))
////                .andExpect(status().isOk())
////                .andExpect(content().contentType("application/json"));
//    }
}
