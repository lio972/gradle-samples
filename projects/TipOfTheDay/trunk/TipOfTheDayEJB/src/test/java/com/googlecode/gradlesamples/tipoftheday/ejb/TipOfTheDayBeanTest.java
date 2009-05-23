package com.googlecode.gradlesamples.tipoftheday.ejb;

import junit.framework.TestCase;

public class TipOfTheDayBeanTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testReadTips() {
		TipOfTheDayVO[] tips = TipOfTheDayBean.readTips(getClass().getResourceAsStream("test_tips.json"));
		
		assertEquals("Tip 1", tips[0].getTitle());
		assertEquals("Text 1", tips[0].getText());
		
		assertEquals("Tip 2", tips[1].getTitle());
		assertEquals("Text 2", tips[1].getText());
	}
}
