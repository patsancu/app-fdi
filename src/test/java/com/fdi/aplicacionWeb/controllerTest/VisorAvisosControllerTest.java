//package com.fdi.aplicacionWeb.controllerTest;
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
//import com.fdi.aplicacionWeb.controller.GestorAvisosController;
//import com.fdi.aplicacionWeb.controller.VisorAvisosController;
//import com.fdi.aplicacionWeb.domain.Aviso;
//import com.fdi.aplicacionWeb.domain.repository.AvisoRepository;
//import com.fdi.aplicacionWeb.service.AvisoService;
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
