package com.googlecode.gradlesamples.tipoftheday.t5.pages;

import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import com.googlecode.gradlesamples.tipoftheday.ejb.TipOfTheDayBeanLocal;
import com.googlecode.gradlesamples.tipoftheday.ejb.TipOfTheDayVO;

public class Index
{
	
	@Inject
	private Logger logger;
	
	@Inject
	@Service("TipOfTheDay")
	private TipOfTheDayBeanLocal tipOfTheDayService;
	
	@Property(write=false)
	private TipOfTheDayVO tipOfTheDay;
	
	@BeginRender
	void setup() {
		tipOfTheDay = tipOfTheDayService.nextTip();
		logger.info(tipOfTheDay.getTitle());
	}
	
}
