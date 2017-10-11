package NumeroRomano.NumerosRomanos;

import org.junit.Test;

import junit.framework.TestCase;

public class ConversorRomanoTest extends TestCase {

	@Test
	public void test() {
		ConversorRomano conversor = new ConversorRomano();
		
		assertEquals(new Integer(1), conversor.converter("i"));
		assertEquals(new Integer(9), conversor.converter("ix"));
		assertEquals(new Integer(30), conversor.converter("xxx"));
		assertEquals(null, conversor.converter("xxxx"));
		assertEquals(null, conversor.converter("0"));
		assertEquals(null, conversor.converter("ABC"));
		assertEquals(null, conversor.converter(null));
		assertEquals(null, conversor.converter("xiiii"));
		assertEquals(new Integer(1280), conversor.converter("MCCLXXX"));
		assertEquals(null, conversor.converter(""));
		assertEquals(new Integer(4974), conversor.converter("MMMMCMLXXIV"));
		
	}
}
