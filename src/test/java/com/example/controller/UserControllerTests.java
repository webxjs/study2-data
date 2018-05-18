package com.example.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.app.Study2DataApplication;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = Study2DataApplication.class)
//@ContextConfiguration(classes={Study2DataApplication.class})

public class UserControllerTests {
    
	@Autowired
    private MockMvc mvc;
//	
//	@Autowired
//	private ApplicationContext applicationContext;
    
    @Test
    public void testUsers_hello() throws Exception {
    	this.mvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("123")));
    }
    
    @Test
    public void testUsers_getUsers() throws Exception {
    	this.mvc.perform(get("/users")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("name2")));
    }
}
