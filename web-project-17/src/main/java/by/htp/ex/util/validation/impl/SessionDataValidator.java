package by.htp.ex.util.validation.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.ex.util.validation.IValidationBuilder;
import jakarta.servlet.http.HttpSession;

public class SessionDataValidator {

	private List<String> errors;

	private SessionDataValidator(SessionValidationBuilder b) {
		this.errors = b.errors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public static class SessionValidationBuilder implements IValidationBuilder<SessionDataValidator> {
		private List<String> errors = new ArrayList<String>();
		
		public SessionValidationBuilder checkAccess(HttpSession session) {
			if (session == null) {
				errors.add("Access denied for this user ");
				return this;
			}
			String role = (String) session.getAttribute("role");

			if (!("admin".equals(role) || "editor".equals(role))) {
				errors.add("Access denied for this user ");
			}
			return this;
		}

		public SessionValidationBuilder checkAuthorization(HttpSession session) {
			if (session == null) {
				errors.add("User not authorized ");
			} else {
				String userStatus = (String) session.getAttribute("user");
				if ("not active".equals(userStatus) || userStatus == null) {
					errors.add("User not authorized ");
				}
			}
			return this;
		}

		@Override
		public SessionDataValidator check() {
			return new SessionDataValidator(this);
		}
	}

	public String errorMessage() {
		int count = errors.toArray().length;
		StringBuffer message = new StringBuffer();
		String str = "Error! There are problem%s".formatted(count > 1 ? "s: " : ": ");
		message.append(str).append(errors).deleteCharAt(message.lastIndexOf(" "))
				.append(". Troubles with used symbols!");
		return message.toString();
	}
}
