/**
 * This file is part of Portal Web de la FDI.
 *
 * Portal Web de la FDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Portal Web de la FDI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ucm.fdi.anuncios.controllerTest;
//package es.ucm.fdi.anuncios.controllerTest;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import es.ucm.fdi.anuncios.controller.GestorAvisosController;
//import es.ucm.fdi.anuncios.controller.VisorAvisosController;
//import es.ucm.fdi.anuncios.domain.Aviso;
//import es.ucm.fdi.anuncios.domain.repository.AvisoRepository;
//import es.ucm.fdi.anuncios.service.AvisoService;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration({"test-DispatcherServlet-context.xml", "file:src/main/webapp/WEB-INF/spring/webcontext/DispatcherServlet-context.xml"})
////@ContextConfiguration({"test-DispatcherServlet-context.xml"})
//@ContextConfiguration
//@WebAppConfiguration
//public class VisorAvisosControllerTest {
//	@Autowired
//	private WebApplicationContext wac;
//	
//	@Autowired
//	private AvisoService avisoService;
//	
//	@Autowired
//	private AvisoRepository avisoRepository;
//
//	private MockMvc mockMvc;
//	
//	@Before
//	public void setup() {
//		//this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//		this.mockMvc = MockMvcBuilders.standaloneSetup(new GestorAvisosController()).build();
//		Aviso aviso = new Aviso();
//		aviso.setTitulo("pruebaJUnit");
//		aviso.setEtiqueta("patata");
//
//		List<Aviso> lista = new ArrayList<Aviso>();
//		lista.add(aviso);
//		when(avisoService.getAvisoById("67")).thenReturn(aviso);
//		when(avisoService.getAllAvisos()).thenReturn(lista);
//	}
//	@Test
//	public void testGetAvisos() throws Exception {
//		this.mockMvc.perform(get("/avisos/gestor")).andDo(print())
//		.andExpect(model().attributeExists("avisos"));
//	}
//	@Test
//	public void testGetProductById() throws Exception {
//		//Arrange
//		Aviso aviso = new Aviso();
//		aviso.setTitulo("pruebaJUnit");
//		aviso.setEtiqueta("patata");
//		this.mockMvc.perform(get("/avisos/ver").param("id", "67"))
//		.andDo(print())
//		.andExpect(model().attributeExists("avisos"));
//
//		//		Product product = new Product("P1234","iPhone 5s", new
//		//				BigDecimal(500));
//		//		//Act & Assert
//		//		this.mockMvc.perform(get("/products/product")
//		//				.param("id", "P1234"))
//		//				.andExpect(model().attributeExists("product"))
//		//				.andExpect(model().attribute("product", product));
//	}
//
//
//	@Configuration
//	public static class testConfiguration {
//		@Bean
//		public GestorAvisosController gestorAvisosController() {
//			return new GestorAvisosController();
//		}
//		
//		@Bean
//		public VisorAvisosController visosAvisosController() {
//			return new VisorAvisosController();
//		}
//
//		@Bean
//		public AvisoService avisoService() {
//			return mock(AvisoService.class);
//		}
//
//		@Bean
//		public AvisoRepository memberService() {
//			return mock(AvisoRepository.class);
//		}
//		//
//		//		@Bean
//		//		public MemberRepository memberRepository() {
//		//			return mock(MemberRepository.class);
//		//		}
//		//
//		//		@Bean
//		//		public SigninService signinService() {
//		//			return mock(SigninService.class);
//		//		}
//		//
//		//		@Bean
//		//		public MessageSource messageSource() {
//		//			return mock(MessageSource.class);
//		//		}
//
//	}
//}
//
//
