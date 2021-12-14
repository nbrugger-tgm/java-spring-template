# ApiInfoApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getVersion**](ApiInfoApi.md#getVersion) | **GET** /api/version | Get API version


<a name="getVersion"></a>
# **getVersion**
> VersionDto getVersion()

Get API version

Get API version

### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.ApiInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ApiInfoApi apiInstance = new ApiInfoApi(defaultClient);
    try {
      VersionDto result = apiInstance.getVersion();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiInfoApi#getVersion");
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

[**VersionDto**](VersionDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

