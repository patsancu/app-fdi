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
package es.ucm.fdi.users.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.users.business.boundary.UsersManager;
import es.ucm.fdi.users.business.entity.User;
import es.ucm.fdi.users.business.entity.UserBuilder;
import es.ucm.fdi.users.business.entity.UserRole;
import es.ucm.fdi.util.Constants;

@Controller
public class UsersController {
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.users");

	@Autowired
	private UsersManager usersManager;

	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_LISTAR_USUARIOS )
	public ModelAndView listUsers(HttpServletRequest request){
		Map<String, Object> model = new HashMap<>();
		model.put("users",usersManager.listUsers());

		return new ModelAndView("listarUsuarios", model);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_NUEVO_USUARIO )
	public ModelAndView nuevoUsuario() {
		Map<String, Object> model = new HashMap<>();
		model.put("modo", "Crear");
		model.put("method", "POST");
		model.put("user", new UserBuilder());
		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(new UserRole("ROLE_USER"));
		roles.add(new UserRole("ROLE_ADMIN"));
		model.put("roles", roles);
		return new ModelAndView("editorUsuarios", model);
	}

	@RequestMapping(method = RequestMethod.POST, value = Constants.URL_NUEVO_USUARIO )
	public ModelAndView creaNuevoAviso(@ModelAttribute("user") UserBuilder user, BindingResult result) throws IOException {
		logger.debug("Creando usuario: " + user);
		Map<String, Object> model = new HashMap<>();


		if ( result.hasErrors()){
			logger.debug("Han habido errores ");
			logger.debug(result.getAllErrors().toString());
			model.put("modo", "Crear");
			model.put("method", "POST");
			model.put("user", new UserBuilder());
			return new ModelAndView("editorUsuarios", model);
		}


		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			logger.error("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		User nuevoUsuario = usersManager.saveUser(user);
		logger.warn(nuevoUsuario.toString());

		return new ModelAndView("redirect:/users", model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_USUARIO_INDIVIDIDUAL)
	public ModelAndView editarUsuario(@PathVariable("id") Long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User usuarioLogueado = (User)auth.getPrincipal();		
		boolean esDestinatario = usuarioLogueado.getId().intValue() == id;
		boolean administrador = usuarioLogueado.getRoles().contains("ROLE_ADMIN");
		
		for (UserRole rol : usuarioLogueado.getRoles()){
			logger.warn(rol.toString());
			if ("ROLE_ADMIN".equals(rol.getRole()) ){
				administrador = true;
				break;
			}
		}

		if (! esDestinatario && !administrador){
			logger.warn("El usuario no es admin, y no está modificando sus propios datos");
			return new ModelAndView("redirect:/", null);	
		}	
		
		
		Map<String, Object> model = new HashMap<>();
		
		UserBuilder userForm = new UserBuilder();
		User user = usersManager.getUser(id);
		BeanUtils.copyProperties(user, userForm);
		userForm.setPassword("");
		
		model.put("modo", "Editar");
		model.put("method", "PUT");
		model.put("user", userForm);		
		
		return new ModelAndView("editorUsuarios", model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = Constants.URL_USUARIO_INDIVIDIDUAL_USERNAME)
	public String editarUsuarioUsername(@PathVariable("username") String username){
		User user = (User) usersManager.loadUserByUsername(username);
		
		return "redirect:/" + "users/" + user.getId();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = Constants.URL_USUARIO_INDIVIDIDUAL)
	public String actualizaUsuario(@PathVariable("id") Long userId, @ModelAttribute("user") UserBuilder userBuilder){		
		logger.debug("Actualizando usuario:" + userBuilder);
		userBuilder.setId(userId);
		usersManager.updateUser(userBuilder);
		
		return "redirect:/";
	}
}
