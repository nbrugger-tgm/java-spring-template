# openapi_client.ApiControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**version**](ApiControllerApi.md#version) | **GET** /api/version | 


# **version**
> VersionResponse version()



### Example


```python
import time
import openapi_client
from openapi_client.api import api_controller_api
from openapi_client.model.error_response import ErrorResponse
from openapi_client.model.version_response import VersionResponse
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:8080"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = api_controller_api.ApiControllerApi(api_client)

    # example, this endpoint has no required or optional parameters
    try:
        api_response = api_instance.version()
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling ApiControllerApi->version: %s\n" % e)
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

