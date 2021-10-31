# GreetingControllerImplAPI

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GreetingControllerImplAPI_greetHuman**](GreetingControllerImplAPI.md#GreetingControllerImplAPI_greetHuman) | **GET** /greet/{name} | 
[**GreetingControllerImplAPI_greetWorld**](GreetingControllerImplAPI.md#GreetingControllerImplAPI_greetWorld) | **GET** /greet | 


# **GreetingControllerImplAPI_greetHuman**
```c
char* GreetingControllerImplAPI_greetHuman(apiClient_t *apiClient, char * name);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**name** | **char \*** |  | 

### Return type

char*



### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **GreetingControllerImplAPI_greetWorld**
```c
char* GreetingControllerImplAPI_greetWorld(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

char*



### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

