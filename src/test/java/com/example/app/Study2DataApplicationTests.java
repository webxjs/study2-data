package com.example.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Study2DataApplicationTests {
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void testBootApplication() {
		 Assert.assertEquals(true, true);
		 Assert.assertNotNull(mvc);
	}

}
