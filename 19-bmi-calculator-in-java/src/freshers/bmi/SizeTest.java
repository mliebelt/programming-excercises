package freshers.bmi;

import static org.junit.Assert.*;

import org.junit.Test;

public class SizeTest {

	@Test
	public void shouldAcceptCentimeters() {
		assertEquals(183, Size.valueOf("183").getCentimeters());
		assertEquals(183, Size.valueOf("183cm").getCentimeters());
		assertEquals(183, Size.valueOf("183 cm").getCentimeters());
		assertEquals(183, Size.valueOf("183 centimeters").getCentimeters());
	}

	@Test
	public void shouldAcceptMeters() {
		assertEquals(100, Size.valueOf("1m").getCentimeters());
		assertEquals(152, Size.valueOf("1,52 meter").getCentimeters());
		assertEquals(152, Size.valueOf("1.52 meter").getCentimeters());
		assertEquals(150, Size.valueOf("1.5 meter").getCentimeters());
	}

	@Test
	public void shouldAcceptInches() {
		assertEquals(183, Size.valueOf("72").getCentimeters());
		assertEquals(183, Size.valueOf("72\"").getCentimeters());
		assertEquals(183, Size.valueOf("72 in").getCentimeters());
		assertEquals(183, Size.valueOf("72inches").getCentimeters());
	}

	@Test
	public void shouldAcceptFeet() {
		assertEquals(183, Size.valueOf("6").getCentimeters());
		assertEquals(183, Size.valueOf("6\'").getCentimeters());
		assertEquals(183, Size.valueOf("6ft").getCentimeters());
		assertEquals(183, Size.valueOf("6 feet").getCentimeters());
		assertEquals(183, Size.valueOf("6 foot").getCentimeters());
	}


	@Test
	public void shouldAcceptFeetAndInches() {
		assertEquals(180, Size.valueOf("5'11").getCentimeters());
		assertEquals(180, Size.valueOf("5ft11").getCentimeters());
		assertEquals(180, Size.valueOf("5'11\"").getCentimeters());
		assertEquals(180, Size.valueOf("5 feet 11 inches").getCentimeters());
		assertEquals(180, Size.valueOf("5 foot 11 in").getCentimeters());
	}
}
