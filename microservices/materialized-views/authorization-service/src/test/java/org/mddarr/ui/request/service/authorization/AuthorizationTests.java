package org.mddarr.ui.request.service.authorization;


import com.google.gson.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mddarr.ui.request.service.security.ApplicationUserDetails;
import org.mddarr.ui.request.service.ContainersTestingServiceApplication;

import org.mddarr.ui.request.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ContainersTestingServiceApplication.class)
public class AuthorizationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    ApplicationUserDetails applicationUserDetails;

    @MockBean
    UserService userService;

    @BeforeEach
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_authenticate() throws Exception {

        MvcResult result = mockMvc.perform(post("/api/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"username\": \"cdick@gmail.com\", \"password\": \"password\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse =  result.getResponse();

        String jsonResponse = mockHttpServletResponse.getContentAsString();

        JsonObject jobj = new Gson().fromJson(jsonResponse, JsonObject.class);
        String token = jobj.get("jwt").toString();
        System.out.println(token);

    }

    @Test
    public void should_create_user_and_login() throws Exception {

        final String EMAIL = "useremail@gmail.com";
        final String PASSWORD = "password";
        final String firstname = "Charles";
        final String lastname = "Andrews";


        MvcResult result = mockMvc.perform(put("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"email\": \"useremail@gmail.com\", \"first_name\": \"Charles\", \"last_name\": \"Andrews\",\"password\": \"password\"  }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse mockHttpServletResponse =  result.getResponse();


        MvcResult getAllUsersResult = mockMvc.perform(get("/api/users/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        MockHttpServletResponse getAllUsersMockHttpServletResponse =  getAllUsersResult.getResponse();
        String jsonResponse = getAllUsersMockHttpServletResponse.getContentAsString();
        System.out.println(jsonResponse);
//        JsonObject jobj = new Gson().fromJson(jsonResponse, JsonObject.class);
//        String token = jobj.get("jwt").toString();
//        System.out.println(token);
//
//        System.out.println(getAllUsersResult.getResponse().toString());



//        MvcResult getResponse = mockMvc.perform(post("/api/users/all")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        String getUsersResponse = getResponse.getResponse().getContentAsString();
//
//        JsonObject jobj = new Gson().fromJson(getUsersResponse, JsonObject.class);
//        System.out.println(jobj);

        //        MvcResult trickydick = mockMvc.perform(post("/api/authenticate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{ \"username\": \"cdick@gmail.com\", \"password\": \"password\"}")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();




//        MvcResult authenticationResult = mockMvc.perform(post("/api/authenticate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{ \"username\": \"useremail@gmail.com\", \"password\": \"password\"}")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        MockHttpServletResponse mockHttpServletAuthenticationResponse =  authenticationResult.getResponse();
//
//        String jsonResponse = mockHttpServletAuthenticationResponse.getContentAsString();
//
//        JsonObject jobj = new Gson().fromJson(jsonResponse, JsonObject.class);
//        String token = jobj.get("jwt").toString();
//        System.out.println(token);

    }



}