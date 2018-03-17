package br.com.skip.test;

import org.junit.Test;

public class EndPointTests {

	@Test
	public void test() {
		
		RestConsumer consumer = new RestConsumer("http://localhost:8080/Skip-API/api/v1/Cousine/", "GET");
		
		String json = consumer.execute();
		
		
		
		
	}
	
	

}
