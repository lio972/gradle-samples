package com.googlecode.gradlesamples.tipoftheday.ejb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Session Bean implementation class TipOfTheDayBean
 */
@Stateless(mappedName = "TipOfTheDay")
public class TipOfTheDayBean implements TipOfTheDayBeanLocal {

	private static final Logger logger = LoggerFactory
			.getLogger(TipOfTheDayBean.class);

	private final TipOfTheDayVO[] tips;
	
	private final Random random = new Random();

	public TipOfTheDayBean() {
		tips = readTips();
	}

	private TipOfTheDayVO[] readTips() {
		return readTips(getClass().getResourceAsStream("tips.json"));
	}

	static TipOfTheDayVO[] readTips(InputStream is) {
		List<TipOfTheDayVO> list = new ArrayList<TipOfTheDayVO>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				is));
		try {
			while (reader.ready()) {
				String line = reader.readLine();
				JSONObject object = (JSONObject) JSONSerializer.toJSON(line);
				String title = object.getString("title");
				String text = object.getString("text");
				TipOfTheDayVO tip = new TipOfTheDayVO(title, text);
				list.add(tip);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				logger.warn(e.getMessage(), e);
			}
		}
		return (TipOfTheDayVO[]) list.toArray(new TipOfTheDayVO[list.size()]);
	}

	public TipOfTheDayVO nextTip() {
		return tips[random.nextInt(tips.length)];
	}

}
