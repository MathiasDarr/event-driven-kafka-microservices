package org.mddarr.ui.request.service.api;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mddarr.ui.request.service.ContainersTestingServiceApplication;


import org.mddarr.ui.request.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ContainersTestingServiceApplication.class)
public class UsersApiTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;



    @MockBean
    UserService userService;

    @BeforeEach
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_post_user() throws Exception {

        mockMvc.perform(put("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"email\": \"SAVINGS\", \"first_name\": \"Jordan\", \"last_name\": \"Pence\",\"password\": \"password\"  }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_all_users() throws Exception {

        mockMvc.perform(get("/api/users/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }









//    @MockBean
//    private AccountService accountServiceMock;

//    public void should_create_account() throws Exception{     
//
//        when(accountServiceMock.createAccount(any(Account.class))).thenReturn(12345L);
//
//        mockMvc.perform(post("/api/account")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{ \"accountType\": \"SAVINGS\", \"balance\": 5000.0 }")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(header().string("Location", "/api/account/12345"))
//                .andExpect(jsonPath("$.accountId").value("12345"))
//                .andExpect(jsonPath("$.accountType").value("SAVINGS"))
//                .andExpect(jsonPath("$.balance").value(5000));
//    }

}
