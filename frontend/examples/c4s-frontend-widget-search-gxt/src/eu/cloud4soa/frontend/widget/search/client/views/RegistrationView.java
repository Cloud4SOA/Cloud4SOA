package eu.cloud4soa.frontend.widget.search.client.views;

public interface RegistrationView {
	enum UserAccountProperty{USERNAME, PASSWORD, FIRSTNAME, SURNAME, GEEKCODE}
	String getUserAccountProperty(UserAccountProperty property);
}
