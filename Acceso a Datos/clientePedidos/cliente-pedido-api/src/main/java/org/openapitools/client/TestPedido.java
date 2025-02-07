package org.openapitools.client;

import org.openapitools.client.api.ClientApiServiceApi;
import org.openapitools.client.api.PedidoApiServiceApi;
import org.openapitools.client.model.Cliente;
import org.openapitools.client.model.CreateClientRequest;

public class TestPedido {
	public static void main(String[] args) {
		ApiClient client = new ApiClient();
		client.setBasePath("http://localhost:8080");
		
		PedidoApiServiceApi clientPedido = new PedidoApiServiceApi();
		ClientApiServiceApi clientCliente = new ClientApiServiceApi();
		try {
			CreateClientRequest request = new CreateClientRequest();
			request.setDni("5684954GH");
			request.setDireccion("buenastardesmigente@gmail.com");
			request.setNombre("Abraham Mateo");
			Cliente cliente = clientCliente.createClient(request);
			System.out.println(cliente);
		}catch (ApiException e) {
			System.out.println(e.getCode());
			System.out.println(e.getResponseBody());
		}
	}
}
