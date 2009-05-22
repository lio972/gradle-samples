package com.googlecode.gradlesamples.tipoftheday.ejb;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Session Bean implementation class TipOfTheDayBean
 */
@Stateless(mappedName = "TipOfTheDay")
public class TipOfTheDayBean implements TipOfTheDayBeanLocal {
	
	private static final Logger logger = LoggerFactory.getLogger(TipOfTheDayBean.class);

    /**
     * Default constructor. 
     */
    public TipOfTheDayBean() {
        // TODO Auto-generated constructor stub
    }
    
    public TipOfTheDayVO nextTip() {
		TipOfTheDayVO tip = new TipOfTheDayVO("Tip Of The Day");
		logger.info(tip.getText());
		return tip;
	}

}
