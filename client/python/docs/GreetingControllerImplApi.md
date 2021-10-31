# ProjectName.Client.GreetingControllerImplApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**greet_human**](GreetingControllerImplApi.md#greet_human) | **GET** /greet/{name} | 
[**greet_world**](GreetingControllerImplApi.md#greet_world) | **GET** /greet | 


# **greet_human**
> str greet_human(name)



### Example


```python
import time
import ProjectName.Client
from ProjectName.Client.api import greeting_controller_impl_api
from ProjectName.Client.model.error_response import ErrorResponse
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = ProjectName.Client.Configuration(
    host = "http://localhost:8080"
)


# Enter a context with an instance of the API client
with ProjectName.Client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = greeting_controller_impl_api.GreetingControllerImplApi(api_client)
    name = "name_example" # str | 

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.greet_human(name)
        pprint(api_response)
    except ProjectName.Client.ApiException as e:
        print("Exception when calling GreetingControllerImplApi->greet_human: %s\n" % e)
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **str**|  |

### Return type

**str**

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **greet_world**
> str greet_world()



### Example


```python
import time
import ProjectName.Client
from ProjectName.Client.api import greeting_controller_impl_api
from ProjectName.Client.model.error_response import ErrorResponse
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = ProjectName.Client.Configuration(
    host = "http://localhost:8080"
)


# Enter a context with an instance of the API client
with ProjectName.Client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = greeting_controller_impl_api.GreetingControllerImplApi(api_client)

    # example, this endpoint has no required or optional parameters
    try:
        api_response = api_instance.greet_world()
        pprint(api_response)
    except ProjectName.Client.ApiException as e:
        print("Exception when calling GreetingControllerImplApi->greet_world: %s\n" % e)
```


### Parameters
This endpoint does not need any parameter.

### Return type

**str**

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

