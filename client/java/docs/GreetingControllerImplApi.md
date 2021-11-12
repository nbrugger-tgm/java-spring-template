# GreetingControllerImplApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**greetHuman**](GreetingControllerImplApi.md#greetHuman) | **GET** /greet/{name} | 
[**greetWorld**](GreetingControllerImplApi.md#greetWorld) | **GET** /greet | 


<a name="greetHuman"></a>
# **greetHuman**
> String greetHuman(name)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GreetingControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    GreetingControllerImplApi apiInstance = new GreetingControllerImplApi(defaultClient);
    String name = "name_example"; // String | 
    try {
      String result = apiInstance.greetHuman(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GreetingControllerImplApi#greetHuman");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**500** | Internal Server Error |  -  |
**200** | OK |  -  |

<a name="greetWorld"></a>
# **greetWorld**
> String greetWorld()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GreetingControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    GreetingControllerImplApi apiInstance = new GreetingControllerImplApi(defaultClient);
    try {
      String result = apiInstance.greetWorld();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GreetingControllerImplApi#greetWorld");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
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

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**500** | Internal Server Error |  -  |
**200** | OK |  -  |

