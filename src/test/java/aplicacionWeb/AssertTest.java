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
package aplicacionWeb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Assert;
import org.junit.Test;

public class AssertTest {
	@Test
	public void assertTrueAndFalseTest() throws Exception {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
	}
	@Test
	public void assertNullAndNotNullTest() throws Exception {
		Object myObject = null;
		Assert.assertNull(myObject);
		myObject = new String("Some value");
		Assert.assertNotNull(myObject);
	}

	@Test
	public void assertEqualsTest() throws Exception {
		Integer i = new Integer("5");
		Integer j = new Integer("5");;
		assertEquals(i,j);
	}


	@Test
	public void assertNotSameTest() throws Exception {
		Integer i = new Integer("5");
		Integer j = new Integer("5");;
		assertNotSame(i , j);
	}

	@Test
	public void assertSameTest() throws Exception {
		Integer i = new Integer("5");
		Integer j = i;
		assertSame(i,j);
	}
}