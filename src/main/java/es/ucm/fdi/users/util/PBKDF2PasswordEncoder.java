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
package es.ucm.fdi.users.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PBKDF2PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence cs) {
		try {
			return PasswordHash.createHash(cs.toString());
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		} catch (InvalidKeySpecException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public boolean matches(CharSequence cs, String string) {
		try {
			return PasswordHash.validatePassword(cs.toString(), string);
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		} catch (InvalidKeySpecException ex) {
			throw new RuntimeException(ex);
		}
	}

}
