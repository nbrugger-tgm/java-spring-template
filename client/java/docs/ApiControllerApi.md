# ApiControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**version**](ApiControllerApi.md#version) | **GET** /api/version | 


<a name="version"></a>
# **version**
> VersionResponse version()



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.ApiControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ApiControllerApi apiInstance = new ApiControllerApi(defaultClient);
    try {
      VersionResponse result = apiInstance.version();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiControllerApi#version");
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

[**VersionResponse**](VersionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**500** | Internal Server Error |  -  |
**200** | OK |  -  |

