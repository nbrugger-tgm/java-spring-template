# openapi.api.GreetingControllerImplApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**greetHuman**](GreetingControllerImplApi.md#greethuman) | **GET** /greet/{name} | 
[**greetWorld**](GreetingControllerImplApi.md#greetworld) | **GET** /greet | 


# **greetHuman**
> String greetHuman(name)



### Example
```dart
import 'package:openapi/api.dart';

final api_instance = GreetingControllerImplApi();
final name = name_example; // String | 

try {
    final result = api_instance.greetHuman(name);
    print(result);
} catch (e) {
    print('Exception when calling GreetingControllerImplApi->greetHuman: $e\n');
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **greetWorld**
> String greetWorld()



### Example
```dart
import 'package:openapi/api.dart';

final api_instance = GreetingControllerImplApi();

try {
    final result = api_instance.greetWorld();
    print(result);
} catch (e) {
    print('Exception when calling GreetingControllerImplApi->greetWorld: $e\n');
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

