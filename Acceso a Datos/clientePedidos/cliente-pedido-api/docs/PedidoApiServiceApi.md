# PedidoApiServiceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addDetalle**](PedidoApiServiceApi.md#addDetalle) | **PUT** /api/pedido/id/{id} |  |
| [**buscarPedidoDni**](PedidoApiServiceApi.md#buscarPedidoDni) | **GET** /api/pedido/dni/{dni} |  |
| [**buscarPedidoFecha**](PedidoApiServiceApi.md#buscarPedidoFecha) | **GET** /api/pedido/fecha |  |
| [**consultarPedido**](PedidoApiServiceApi.md#consultarPedido) | **GET** /api/pedido/{id} |  |
| [**registrarPedido**](PedidoApiServiceApi.md#registrarPedido) | **POST** /api/pedido |  |


<a id="addDetalle"></a>
# **addDetalle**
> Pedido addDetalle(id, pedidoDetalle)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    String id = "id_example"; // String | 
    PedidoDetalle pedidoDetalle = new PedidoDetalle(); // PedidoDetalle | 
    try {
      Pedido result = apiInstance.addDetalle(id, pedidoDetalle);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#addDetalle");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |
| **pedidoDetalle** | [**PedidoDetalle**](PedidoDetalle.md)|  | |

### Return type

[**Pedido**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="buscarPedidoDni"></a>
# **buscarPedidoDni**
> List&lt;Pedido&gt; buscarPedidoDni(dni)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    String dni = "dni_example"; // String | 
    try {
      List<Pedido> result = apiInstance.buscarPedidoDni(dni);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#buscarPedidoDni");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dni** | **String**|  | |

### Return type

[**List&lt;Pedido&gt;**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="buscarPedidoFecha"></a>
# **buscarPedidoFecha**
> List&lt;Pedido&gt; buscarPedidoFecha(antes, despues)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    LocalDate antes = LocalDate.now(); // LocalDate | 
    LocalDate despues = LocalDate.now(); // LocalDate | 
    try {
      List<Pedido> result = apiInstance.buscarPedidoFecha(antes, despues);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#buscarPedidoFecha");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **antes** | **LocalDate**|  | |
| **despues** | **LocalDate**|  | |

### Return type

[**List&lt;Pedido&gt;**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarPedido"></a>
# **consultarPedido**
> Pedido consultarPedido(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Pedido result = apiInstance.consultarPedido(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#consultarPedido");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |

### Return type

[**Pedido**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="registrarPedido"></a>
# **registrarPedido**
> String registrarPedido(pedido)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidoApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidoApiServiceApi apiInstance = new PedidoApiServiceApi(defaultClient);
    Pedido pedido = new Pedido(); // Pedido | 
    try {
      String result = apiInstance.registrarPedido(pedido);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidoApiServiceApi#registrarPedido");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **pedido** | [**Pedido**](Pedido.md)|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

