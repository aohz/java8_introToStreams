package part5.optional.solution;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement getNullSafeValue method using Optional to pass all test
 * @author aohz
 *
 */
public class SolEx2Optional {

	private static final String DEFAULT_VALUE = "Empty";
	private static final String REAL_VALUE = "35.527756";

	private String getNullSafeValue(GPSData data) {
		return Optional.ofNullable(data)
				.flatMap(GPSData::getPosition)
				.flatMap(Position::getLatitude)
				.map(Latitude::getValue)
				.orElse(DEFAULT_VALUE);
	}

	@Test
	public void testNoNullElements() {
		GPSData data = new GPSData(new Position(new Latitude(REAL_VALUE)));
		Assert.assertEquals(REAL_VALUE, getNullSafeValue(data));
	}

	@Test
	public void testPositionIsNull() {
		GPSData data = new GPSData(null);
		Assert.assertEquals(DEFAULT_VALUE, getNullSafeValue(data));
	}

	@Test
	public void testGpsDataIsNull() {
		GPSData data = null;
		Assert.assertEquals(DEFAULT_VALUE, getNullSafeValue(data));
	}

	@Test
	public void testLatitudeIsNull() {
		GPSData data = new GPSData(new Position(null));
		Assert.assertEquals(DEFAULT_VALUE, getNullSafeValue(data));
	}

	@Test
	public void testValueIsNull() {
		GPSData data = new GPSData(new Position(new Latitude(null)));
		Assert.assertEquals(DEFAULT_VALUE, getNullSafeValue(data));
	}
}

class GPSData {

	private Position position;

	public GPSData(Position position) {
		this.position = position;
	}

	public Optional<Position> getPosition() {
		return Optional.ofNullable(this.position);
	}
}

class Position {

	private Latitude latitude;

	public Position(Latitude latitude) {
		this.latitude = latitude;
	}

	public Optional<Latitude> getLatitude() {
		return Optional.ofNullable(this.latitude);
	}
}

class Latitude {

	private String value;

	public Latitude(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
