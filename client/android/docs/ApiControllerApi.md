# ApiControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**version**](ApiControllerApi.md#version) | **GET** /api/version | 



## version

> VersionResponse version()



### Example

```java
// Import classes:
//import org.openapitools.client.api.ApiControllerApi;

ApiControllerApi apiInstance = new ApiControllerApi();
try {
    VersionResponse result = apiInstance.version();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApiControllerApi#version");
    e.printStackTrace();
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

