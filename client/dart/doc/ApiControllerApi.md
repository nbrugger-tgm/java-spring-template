# ProjectName Client.api.ApiControllerApi

## Load the API package
```dart
import 'package:ProjectName Client/api.dart';
```

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**version**](ApiControllerApi.md#version) | **GET** /api/version | 


# **version**
> VersionResponse version()



### Example
```dart
import 'package:ProjectName Client/api.dart';

final api_instance = ApiControllerApi();

try {
    final result = api_instance.version();
    print(result);
} catch (e) {
    print('Exception when calling ApiControllerApi->version: $e\n');
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

