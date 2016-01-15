package part5.solution;

import org.junit.Test;

import java.util.Optional;

import org.junit.Assert;

public class OptionalSolutionUsingFlapMap {

	private static final String DEFAULT_VALUE = "Empty";
	private static final String REAL_VALUE = "35.527756";

	private String getNullSafeValue(Position position) {
		return Optional.ofNullable(position).flatMap(Position::getLatitude).map(Latitude::getValue).orElse(DEFAULT_VALUE);
	}

	@Test
	public void testNoNullElements() {
		Position position = new Position(new Latitude(REAL_VALUE));
		Assert.assertEquals(REAL_VALUE, getNullSafeValue(position));
	}

	@Test
	public void testPositionIsNull() {
		Position position = null;
		Assert.assertEquals(DEFAULT_VALUE, getNullSafeValue(position));
	}

	@Test
	public void testLatitudeIsNull() {
		Position position = new Position(null);
		Assert.assertEquals(DEFAULT_VALUE, getNullSafeValue(position));
	}

	@Test
	public void testValueIsNull() {
		Position position = new Position(new Latitude(null));
		Assert.assertEquals(DEFAULT_VALUE, getNullSafeValue(position));
	}
}

//class GPSData {
//
//	private Position position;
//
//	public GPSData(Position position) {
//		this.position = position;
//	}
//
//	public Optional<Position> getPosition() {
//		return Optional.ofNullable(this.position);
//	}
//}
//
//class Position {
//
//	private Latitude latitude;
//
//	public Position(Latitude latitude) {
//		this.latitude = latitude;
//	}
//
//	public Optional<Latitude> getLatitude() {
//		return Optional.ofNullable(this.latitude);
//	}
//}
//
//class Latitude {
//
//	private String value;
//
//	public Latitude(String value) {
//		this.value = value;
//	}
//
//	public String getValue() {
//		return this.value;
//	}
//}
