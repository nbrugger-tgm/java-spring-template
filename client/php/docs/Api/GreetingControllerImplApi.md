# OpenAPI\Client\GreetingControllerImplApi

All URIs are relative to http://localhost:8080.

Method | HTTP request | Description
------------- | ------------- | -------------
[**greetHuman()**](GreetingControllerImplApi.md#greetHuman) | **GET** /greet/{name} | 
[**greetHumanPut()**](GreetingControllerImplApi.md#greetHumanPut) | **PUT** /greet/{name} | 
[**greetWorld()**](GreetingControllerImplApi.md#greetWorld) | **GET** /greet | 


## `greetHuman()`

```php
greetHuman($name): string
```



### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');



$apiInstance = new OpenAPI\Client\Api\GreetingControllerImplApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);
$name = 'name_example'; // string

try {
    $result = $apiInstance->greetHuman($name);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling GreetingControllerImplApi->greetHuman: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **string**|  |

### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `*/*`, `text/plain`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `greetHumanPut()`

```php
greetHumanPut($name): string
```



### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');



$apiInstance = new OpenAPI\Client\Api\GreetingControllerImplApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);
$name = 'name_example'; // string

try {
    $result = $apiInstance->greetHumanPut($name);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling GreetingControllerImplApi->greetHumanPut: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **string**|  |

### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `*/*`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `greetWorld()`

```php
greetWorld(): string
```



### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');



$apiInstance = new OpenAPI\Client\Api\GreetingControllerImplApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);

try {
    $result = $apiInstance->greetWorld();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling GreetingControllerImplApi->greetWorld: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `*/*`, `text/plain`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
