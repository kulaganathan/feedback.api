package com.kalaiworld.feedback.api;

import com.kalaiworld.feedback.api.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserDto userDto;

    @Test
    private void shouldSaveNewUser() throws Exception {
        userDto.setUserId("Kalaiselvan");
        userDto.setPassword("Password");
        this.mockMvc
                .perform(post("/users/new"))
                .andDo(print());
    }
}
