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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class SanityTest {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("***Before Class is invoked");
	}
	@Before
	public void before() {
		System.out.println("____________________");
		System.out.println("\t Before is invoked");
	}
	@After
	public void after() {
		System.out.println("\t After is invoked");
		System.out.println("=================");
	}
	@Test
	public void someTest() {
		System.out.println("\t\t someTest is invoked");
	}
	@Test
	public void someTest2() {
		System.out.println("\t\t someTest2 is invoked");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("***After Class is invoked");
	}
}