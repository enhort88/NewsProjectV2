package by.htp.main.bean;

import java.util.LinkedHashMap;

public class LocaleOptions {

	private String language;

	private LinkedHashMap<String, String> languageOptions;

	public LocaleOptions() {

		languageOptions = new LinkedHashMap<String, String>();
		languageOptions.put("ru", "RUS");
		languageOptions.put("en", "ENG");

	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public void setLanguageOptions(LinkedHashMap<String, String> languageOptions) {
		this.languageOptions = languageOptions;
	}
	
}
