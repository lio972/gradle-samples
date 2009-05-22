package com.googlecode.gradlesamples.tipoftheday.ejb;
import javax.ejb.Local;

@Local
public interface TipOfTheDayBeanLocal {
	
	TipOfTheDayVO nextTip();

}
