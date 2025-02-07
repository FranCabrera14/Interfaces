# UserApiServiceApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**changePassword**](UserApiServiceApi.md#changePassword) | **PUT** /api/users | Cambio de contraseña
[**crear**](UserApiServiceApi.md#crear) | **POST** /api/users | Creacion  de usuarios
[**getById**](UserApiServiceApi.md#getById) | **GET** /api/users/{idUser} | Solicitar usuario
[**login**](UserApiServiceApi.md#login) | **GET** /api/users/login | Login de usuario

<a name="changePassword"></a>
# **changePassword**
> changePassword(body)

Cambio de contraseña

Método para cambiar la contraseña del usuario

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApiServiceApi;


UserApiServiceApi apiInstance = new UserApiServiceApi();
ChangePasswordRequest body = new ChangePasswordRequest(); // ChangePasswordRequest | 
try {
    apiInstance.changePassword(body);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApiServiceApi#changePassword");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ChangePasswordRequest**](ChangePasswordRequest.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="crear"></a>
# **crear**
> User crear(body)

Creacion  de usuarios

Crear un usuario

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApiServiceApi;


UserApiServiceApi apiInstance = new UserApiServiceApi();
Object body = null; // Object | 
try {
    User result = apiInstance.crear(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApiServiceApi#crear");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Object**](Object.md)|  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getById"></a>
# **getById**
> User getById(idUser)

Solicitar usuario

Método para comprobar un usuario por id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApiServiceApi;


UserApiServiceApi apiInstance = new UserApiServiceApi();
Object idUser = null; // Object | 
try {
    User result = apiInstance.getById(idUser);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApiServiceApi#getById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idUser** | [**Object**](.md)|  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="login"></a>
# **login**
> User login(username, password)

Login de usuario

Método para que el usuario haga login con su contraseña y usuario.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApiServiceApi;


UserApiServiceApi apiInstance = new UserApiServiceApi();
Object username = null; // Object | 
Object password = null; // Object | 
try {
    User result = apiInstance.login(username, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApiServiceApi#login");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | [**Object**](.md)|  |
 **password** | [**Object**](.md)|  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

