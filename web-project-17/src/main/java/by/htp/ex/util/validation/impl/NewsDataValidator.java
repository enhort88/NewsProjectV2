package by.htp.ex.util.validation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.ex.util.validation.IValidationBuilder;

public class NewsDataValidator   {

		private List<String> errors;

		private NewsDataValidator(NewsDataValidationBuilder e) {
			this.errors = e.errors;
		}

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}

		@Override
		public int hashCode() {
			return Objects.hash(errors);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NewsDataValidator other = (NewsDataValidator) obj;
			return Objects.equals(errors, other.errors);
		}

		public static class NewsDataValidationBuilder implements IValidationBuilder<NewsDataValidator> {
			private List<String> errors = new ArrayList<String>();
										
			private static final String REGEX_FOR_DATE = "(0?[1-9]|[12][0-9]|3[01])[^\\w\\d\\r\\n:](0?[1-9]|1[0-2])[^\\w\\d\\r\\n:](\\d{2}|\\d{4})";
			private static final String REGEX_FOR_TITLE = "^[a-zA-Z0-9-]{5,25}$";
			private static final String REGEX_FOR_BRIEF = "^[a-zA-Z0-9-]{5,80}$";
			private static final String REGEX_FOR_CONTENT = "^[a-zA-Z0-9-]{5,}$";

			public NewsDataValidationBuilder checkDate(String date) {
				Matcher dateMatcher = Pattern.compile(REGEX_FOR_DATE).matcher(date);
				if (!dateMatcher.matches()) {
					errors.add("Date ");
				}
				return this;
			}

			public NewsDataValidationBuilder checkTitle(String title) {
				Matcher titleMatcher = Pattern.compile(REGEX_FOR_TITLE).matcher(title);
				if (!titleMatcher.matches()) {
					errors.add("Title ");
				}
				return this;
			}

			public NewsDataValidationBuilder checkBrief(String brief) {
				Matcher briefMatcher = Pattern.compile(REGEX_FOR_BRIEF).matcher(brief);
				if (!briefMatcher.matches()) {
					errors.add("Brief ");
				}
				return this;
			}

			public NewsDataValidationBuilder checkContent(String content) {
				Matcher contentMatcher = Pattern.compile(REGEX_FOR_CONTENT).matcher(content);
				if (!contentMatcher.matches()) {
					errors.add("Content ");
				}
				return this;
			}

			@Override
			public NewsDataValidator check() {
				return new NewsDataValidator(this);
			}
		}

		public String errorMessage() {
			
			int count = errors.toArray().length;

			StringBuffer message = new StringBuffer();
			String str = "Error! There are problems in field%s".formatted(count > 1 ? "s: " : ": ");
			message.append(str).append(errors).deleteCharAt(message.lastIndexOf(" "))
					.append(". Troubles with used symbols!");

			return message.toString();
		}
		 
	}
	

