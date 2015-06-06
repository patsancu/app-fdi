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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.users.business.boundary.UsersManager;
import es.ucm.fdi.users.business.entity.User;
import es.ucm.fdi.users.business.entity.UserBuilder;
import es.ucm.fdi.users.business.entity.UserRole;

@Controller
public class UsersController {
	private static final Logger logger = LoggerFactory.getLogger("es.ucm.fdi.users");

	@Autowired
	private UsersManager usersManager;

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ModelAndView listUsers(HttpServletRequest request){
		Map<String, Object> model = new HashMap<>();
		model.put("users",usersManager.listUsers());

		return new ModelAndView("listarUsuarios", model);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = "/users/nuevo")
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

	@RequestMapping(method = RequestMethod.POST, value = "/users/nuevo")
	public ModelAndView creaNuevoAviso(@ModelAttribute("user") UserBuilder user,
			BindingResult result) throws IOException {
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
}
