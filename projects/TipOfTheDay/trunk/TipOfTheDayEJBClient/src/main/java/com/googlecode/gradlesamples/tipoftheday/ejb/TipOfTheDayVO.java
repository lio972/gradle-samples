package com.googlecode.gradlesamples.tipoftheday.ejb;

public class TipOfTheDayVO {
	
	private final String title;
	
	private final String text;
	
	public TipOfTheDayVO(String title, String text) {
		super();
		this.title = title;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String getTitle() {
		return title;
	}

}
