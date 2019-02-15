package org.adn.ceiba.ceibarest.controller.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes =  {TipoVehiculoController.class})
public class TipoVehiculoControllerTest {

	/** The mock mvc. */
	private MockMvc mockMvc;

	@Mock
	private TipoVehiculoController tipoVehiculoController;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(tipoVehiculoController).build();
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Verifyfind all.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void verifyObtenerlista() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/tipovehiculo/obtenerlista").accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}

}
