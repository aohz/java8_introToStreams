package part5.optional.exercises;

import org.junit.Assert;
import org.junit.Test;

/**
 * Make this code NullPointerException safe using Optional 
 * @author aohz
 *
 */
public class OptionalExercise {

	private static final String REAL_VALUE = "35.527756";
	
	@Test
	public void testNoNullElements() {
		Position position = new Position(new Latitude(REAL_VALUE));
		Assert.assertEquals(REAL_VALUE, position.getLatitude().getValue());
	}
	
	@Test
	public void testValueIsNull() {
		Position position = new Position(new Latitude(null));
		Assert.assertNull(position.getLatitude().getValue());
	}
	
	@Test
	public void testPositionIsNull() {
		Position position = null;
		Assert.assertNull(position.getLatitude());
	}
	
	
	@Test
	public void testLatitudeIsNull() {
		Position position = new Position(null);
		Assert.assertNull(position.getLatitude().getValue());
	}	
}

class GPSData {

	private Position position;

	public GPSData(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return this.position;
	}
}

class Position {

	private Latitude latitude;

	public Position(Latitude latitude) {
		this.latitude = latitude;
	}

	public Latitude getLatitude() {
		return this.latitude;
	}
}

class Latitude {

	private String value;

	public Latitude(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
