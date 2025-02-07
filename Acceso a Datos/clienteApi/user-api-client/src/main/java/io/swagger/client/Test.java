package io.swagger.client;

import io.swagger.client.api.UserApiServiceApi;
import io.swagger.client.model.User;

public class Test {
	
	public static void main(String[] args) {
		ApiClient client = new ApiClient();
		
		client.setBasePath("http://localhost:8080");
		client.addDefaultHeader("API-KEY", "hola");
		UserApiServiceApi clientUser = new UserApiServiceApi(client);
		try {
			User user = clientUser.getById(33);
			System.out.println(user);
		} catch (ApiException e) {
			System.out.println(e.getCode());
			System.out.println(e.getResponseBody());
		}
	}
}
