import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.Test;

class Tests {

	private Games games;
	
	@After 
	public void executeAfter() {
		games = null;
	}
	
	@Test
	public void rangeValid() {
		games = new Games();
		assertEquals(true, games.validateRange(0, 5, 4));
	}
	@Test
	public void rangeInValid() {
		games = new Games();
		assertEquals(false, games.validateRange(0, 5, 6));
	}
	@Test
	public void rangeInValidNegativeNumber() {
		games = new Games();
		assertEquals(false, games.validateRange(0, 5, -1));
	}
	
	
	
	

}
