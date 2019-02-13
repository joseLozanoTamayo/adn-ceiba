//package org.adn.ceiba.ceibarest.controller.impl;
//
//import org.adn.ceiba.ceibarest.bussines.impl.ParqueaderoBussines;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.env.Environment;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ParqueaderoControllerTest {
//
//	@Autowired
//	private ParqueaderoBussines parqueaderoBussines;
//
//	@Autowired
//    private MockMvc mockMvc;
//	
//	@Autowired
//	Environment env;
//	
//	@Test
//	public void testHelloEndpointIsOK() throws Exception {
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8082/tipovehiculo/ping");
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		Assert.assertEquals(200, result.getResponse().getStatus());
////		assertTrue(result.getResponse().getContentAsString().split("placa").length - 1 >= 2);
//	}
//}
