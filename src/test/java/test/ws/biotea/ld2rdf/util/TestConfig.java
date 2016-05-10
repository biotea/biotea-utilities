package test.ws.biotea.ld2rdf.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ws.biotea.ld2rdf.util.ResourceConfig;

public class TestConfig {
	@Test
	public void testGetProperty() {
		assertEquals(ResourceConfig.getProperty("inexistent"), "");
		assertEquals(ResourceConfig.getProperty("biotea.base"), "biotea.ws");
	}

}
