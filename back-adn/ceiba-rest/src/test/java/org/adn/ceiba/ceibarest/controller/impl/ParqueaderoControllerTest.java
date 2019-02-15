package org.adn.ceiba.ceibarest.controller.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.adn.ceiba.ceibarest.utils.ParqueaderoConstante;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes =  {ParqueaderoController.class})
public class ParqueaderoControllerTest {

	/** The mock mvc. */
	private MockMvc mockMvc;

	@Mock
	private ParqueaderoController parqueaderpController;
	

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(parqueaderpController).build();
		MockitoAnnotations.initMocks(this);
	}
		
	/**
	 * Verifyfind all.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void verifyObtenerlista() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/parqueadero/obtenerLista")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	@Test
	public void verifiOptenerParqueadero() throws Exception{
		MockHttpServletResponse response = mockMvc.perform(
	            post("/parqueadero/obtenerparqueadero",ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get())
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(asJsonString(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get()))).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void verifiCrear() throws Exception{
		MockHttpServletResponse response = mockMvc.perform(
	            post("/parqueadero/crear",ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get())
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(asJsonString(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get()))).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void verifiregistrarPago() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(
	            post("/parqueadero/crear",ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get())
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(asJsonString(ParqueaderoConstante.PARQUEADERO_DTO_CARRO.get()))).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	/**
	 * As json string.
	 *
	 * @param obj the obj
	 * @return the string
	 */
	private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
