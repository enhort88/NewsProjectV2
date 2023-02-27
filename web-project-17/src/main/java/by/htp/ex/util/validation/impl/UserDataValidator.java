package by.htp.ex.util.validation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.ex.util.validation.IValidationBuilder;

public class UserDataValidator {

	private List<String> errors;

	private UserDataValidator(UserDataValidationBuilder e) {
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
		UserDataValidator other = (UserDataValidator) obj;
		return Objects.equals(errors, other.errors);
	}

	public static class UserDataValidationBuilder implements IValidationBuilder<UserDataValidator> {

		private List<String> errors = new ArrayList<String>();

		private static final String REGEX_FOR_LOGIN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{3,18}$";
		private static final String REGEX_FOR_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^\\da-zA-Z]).{8,}$\r\n";
		private static final String REGEX_FOR_EMAIL = "^[^@\\\\s]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$\r\n";
		private static final String REGEX_FOR_NAME = "^[a-zA-Z]{1,12}$";
		private static final String REGEX_FOR_SURMANE = "^[a-zA-Z]{1,20}$";
		private static final String REGEX_FOR_BIRTHDAY = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

		public UserDataValidationBuilder checkLogin(String login) {
			Matcher loginMatcher = Pattern.compile(REGEX_FOR_LOGIN).matcher(login);
			if (!loginMatcher.matches()) {
				errors.add("Login ");
			}
			return this;
		}

		public UserDataValidationBuilder checkPassword(String password) {
			Matcher passwordMatcher = Pattern.compile(REGEX_FOR_PASSWORD).matcher(password);
			if (!passwordMatcher.matches()) {
				errors.add("Password ");
			}
			return this;
		}

		public UserDataValidationBuilder checkEmail(String email) {
			Matcher emailMatcher = Pattern.compile(REGEX_FOR_EMAIL).matcher(email);
			if (!emailMatcher.matches()) {
				errors.add("Email ");
			}
			return this;
		}

		public UserDataValidationBuilder checkName(String name) {
			Matcher nameMatcher = Pattern.compile(REGEX_FOR_NAME).matcher(name);
			if (!nameMatcher.matches()) {
				errors.add("Name ");
			}
			return this;
		}

		public UserDataValidationBuilder checkSurname(String surname) {
			Matcher surnameMatcher = Pattern.compile(REGEX_FOR_SURMANE).matcher(surname);
			if (!surnameMatcher.matches()) {
				errors.add("Surname ");
			}
			return this;
		}

		public UserDataValidationBuilder checkBirthday(String birthday) {
			Matcher birthdayMatcher = Pattern.compile(REGEX_FOR_BIRTHDAY).matcher(birthday);
			if (!birthdayMatcher.matches()) {
				errors.add("Birthday date ");
			}
			return this;
		}

		@Override
		public UserDataValidator check() {
			return new UserDataValidator(this);
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
