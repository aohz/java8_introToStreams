package part5.exercises;

import org.junit.Test;

import org.junit.Assert;

public class OptionalExercise {

	
	@Test
	public void testNoNullElements() {
		Position position = new Position(new Latitude(35.527756));
		Assert.assertEquals(35.527756, position.getLatitude().getValue().doubleValue(), 0.00001);
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
	
	@Test
	public void testValueIsNull() {
		Position position = new Position(new Latitude(null));
		Assert.assertNull(position.getLatitude().getValue().doubleValue());
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

	private Double value;

	public Latitude(Double value) {
		this.value = value;
	}

	public Double getValue() {
		return this.value;
	}
}
