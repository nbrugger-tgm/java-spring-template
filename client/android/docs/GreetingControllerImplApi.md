# GreetingControllerImplApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**greetHuman**](GreetingControllerImplApi.md#greetHuman) | **GET** /greet/{name} | 
[**greetWorld**](GreetingControllerImplApi.md#greetWorld) | **GET** /greet | 



## greetHuman

> String greetHuman(name)



### Example

```java
// Import classes:
//import com.domain.projectname.api.GreetingControllerImplApi;

GreetingControllerImplApi apiInstance = new GreetingControllerImplApi();
String name = null; // String | 
try {
    String result = apiInstance.greetHuman(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GreetingControllerImplApi#greetHuman");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  | [default to null]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*, text/plain


## greetWorld

> String greetWorld()



### Example

```java
// Import classes:
//import com.domain.projectname.api.GreetingControllerImplApi;

GreetingControllerImplApi apiInstance = new GreetingControllerImplApi();
try {
    String result = apiInstance.greetWorld();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GreetingControllerImplApi#greetWorld");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*, text/plain

