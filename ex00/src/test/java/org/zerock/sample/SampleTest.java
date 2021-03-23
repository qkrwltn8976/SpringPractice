package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {

	@Autowired
	private Restaurant restaurant;
	
	@Autowired
	private SampleHotel hotel;
	
	@Test
	public void testHotel() {
		Log.info(hotel);
	}
	
	@Test
	public void test1() {
		System.out.println("test1.................");
		Log.info("test1..................");
		Log.info(restaurant);
	}
}
