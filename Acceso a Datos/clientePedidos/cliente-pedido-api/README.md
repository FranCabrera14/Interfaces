# openapi-java-client

OpenAPI definition
- API version: v0
  - Build date: 2025-02-07T16:05:02.357452500+01:00[Europe/Madrid]
  - Generator version: 7.11.0

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>v0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'openapi-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'openapi-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.openapitools:openapi-java-client:v0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-v0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.model.*;
import org.openapitools.client.api.ClientApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClientApiServiceApi apiInstance = new ClientApiServiceApi(defaultClient);
    CreateClientRequest createClientRequest = new CreateClientRequest(); // CreateClientRequest | 
    try {
      Cliente result = apiInstance.actualizeClient(createClientRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClientApiServiceApi#actualizeClient");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ClientApiServiceApi* | [**actualizeClient**](docs/ClientApiServiceApi.md#actualizeClient) | **PUT** /api/clients | 
*ClientApiServiceApi* | [**checkClientDni**](docs/ClientApiServiceApi.md#checkClientDni) | **GET** /api/clients/dni{dni} | 
*ClientApiServiceApi* | [**checkClientId**](docs/ClientApiServiceApi.md#checkClientId) | **GET** /api/clients/{id} | 
*ClientApiServiceApi* | [**createClient**](docs/ClientApiServiceApi.md#createClient) | **POST** /api/clients | 
*PedidoApiServiceApi* | [**addDetalle**](docs/PedidoApiServiceApi.md#addDetalle) | **PUT** /api/pedido/id/{id} | 
*PedidoApiServiceApi* | [**buscarPedidoDni**](docs/PedidoApiServiceApi.md#buscarPedidoDni) | **GET** /api/pedido/dni/{dni} | 
*PedidoApiServiceApi* | [**buscarPedidoFecha**](docs/PedidoApiServiceApi.md#buscarPedidoFecha) | **GET** /api/pedido/fecha | 
*PedidoApiServiceApi* | [**consultarPedido**](docs/PedidoApiServiceApi.md#consultarPedido) | **GET** /api/pedido/{id} | 
*PedidoApiServiceApi* | [**registrarPedido**](docs/PedidoApiServiceApi.md#registrarPedido) | **POST** /api/pedido | 


## Documentation for Models

 - [Articulo](docs/Articulo.md)
 - [Cliente](docs/Cliente.md)
 - [CreateClientRequest](docs/CreateClientRequest.md)
 - [Pedido](docs/Pedido.md)
 - [PedidoDetalle](docs/PedidoDetalle.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization

Endpoints do not require authorization.


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



