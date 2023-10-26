package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AppController.class)
public class AppControllerTest {

  @Autowired
  private MockMvc mockMvc;

//   @Test
//   public void testNotHomePage() throws Exception {
//     mockMvc.perform(get("/not_home"))   
//       .andExpect(status().isOk()) 
//       .andExpect(view().name("not_home"))
//       .andExpect(content().string(       
//           containsString("Not Home - BLAH Welcome")));
//   }

    @Test
    public void testWelcomePage() throws Exception {
    mockMvc.perform(get("/welcome_page"))   
      .andExpect(status().isOk()) 
      .andExpect(view().name("welcome_page"));
    }

    @Test
    public void testSignUpPage() throws Exception {
      mockMvc.perform(get("/signUp"))
        .andExpect(status().isOk())
        .andExpect(view().name("signUp"));
    }

    @Test
    public void testQuizHomePage() throws Exception {
      mockMvc.perform(get("/quiz_home"))
        .andExpect(status().isOk())
        .andExpect(view().name("quiz_home"));
    }

}