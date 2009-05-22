package com.googlecode.gradlesamples.tipoftheday.ejb;

public class TipOfTheDayVO {
	
	private String text;

	public TipOfTheDayVO(String text) {
		super();
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

}
