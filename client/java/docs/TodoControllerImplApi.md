# TodoControllerImplApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createItem**](TodoControllerImplApi.md#createItem) | **POST** /todo/lists/{name}/items | 
[**createList**](TodoControllerImplApi.md#createList) | **POST** /todo/lists | 
[**deleteItem**](TodoControllerImplApi.md#deleteItem) | **DELETE** /todo/lists/{name}/items/{itemName} | 
[**deleteList**](TodoControllerImplApi.md#deleteList) | **DELETE** /todo/lists/{name} | 
[**getItem**](TodoControllerImplApi.md#getItem) | **GET** /todo/lists/{name}/items/{itemName} | 
[**getItemNames**](TodoControllerImplApi.md#getItemNames) | **GET** /todo/lists/{name}/itemNames | 
[**getItems**](TodoControllerImplApi.md#getItems) | **GET** /todo/lists/{name}/items | 
[**getList**](TodoControllerImplApi.md#getList) | **GET** /todo/lists/{name} | 
[**getLists**](TodoControllerImplApi.md#getLists) | **GET** /todo/lists | Get all lists
[**setDone**](TodoControllerImplApi.md#setDone) | **PATCH** /todo/lists/{list}/items/{itemName}/done/{done} | 
[**updateItem**](TodoControllerImplApi.md#updateItem) | **POST** /todo/lists/{name}/items/{itemName} | 
[**updateList**](TodoControllerImplApi.md#updateList) | **POST** /todo/lists/{name} | 


<a name="createItem"></a>
# **createItem**
> createItem(todoEntryDto, name)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    TodoEntryDto todoEntryDto = new TodoEntryDto(); // TodoEntryDto | 
    String name = "name_example"; // String | 
    try {
      apiInstance.createItem(todoEntryDto, name);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#createItem");
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
 **todoEntryDto** | [**TodoEntryDto**](TodoEntryDto.md)|  |
 **name** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="createList"></a>
# **createList**
> createList(todoListDto)



Add a new todo list

### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    TodoListDto todoListDto = new TodoListDto(); // TodoListDto | 
    try {
      apiInstance.createList(todoListDto);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#createList");
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
 **todoListDto** | [**TodoListDto**](TodoListDto.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteItem"></a>
# **deleteItem**
> deleteItem(name, itemName)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    String name = "name_example"; // String | 
    String itemName = "itemName_example"; // String | 
    try {
      apiInstance.deleteItem(name, itemName);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#deleteItem");
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
 **itemName** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteList"></a>
# **deleteList**
> deleteList(name)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    String name = "name_example"; // String | 
    try {
      apiInstance.deleteList(name);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#deleteList");
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getItem"></a>
# **getItem**
> TodoEntryDto getItem(name, itemName)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    String name = "name_example"; // String | 
    String itemName = "itemName_example"; // String | 
    try {
      TodoEntryDto result = apiInstance.getItem(name, itemName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#getItem");
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
 **itemName** | **String**|  |

### Return type

[**TodoEntryDto**](TodoEntryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getItemNames"></a>
# **getItemNames**
> Set&lt;String&gt; getItemNames(name)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    String name = "name_example"; // String | 
    try {
      Set<String> result = apiInstance.getItemNames(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#getItemNames");
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

**Set&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getItems"></a>
# **getItems**
> Set&lt;TodoEntryDto&gt; getItems(name)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    String name = "name_example"; // String | 
    try {
      Set<TodoEntryDto> result = apiInstance.getItems(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#getItems");
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

[**Set&lt;TodoEntryDto&gt;**](TodoEntryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getList"></a>
# **getList**
> TodoListDto getList(name)



Get a list of todo items with the specified name

### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    String name = "name_example"; // String | 
    try {
      TodoListDto result = apiInstance.getList(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#getList");
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

[**TodoListDto**](TodoListDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getLists"></a>
# **getLists**
> Set&lt;TodoListDto&gt; getLists()

Get all lists

Get a list of all todo lists

### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    try {
      Set<TodoListDto> result = apiInstance.getLists();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#getLists");
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

[**Set&lt;TodoListDto&gt;**](TodoListDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="setDone"></a>
# **setDone**
> setDone(list, itemName, done)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    String list = "list_example"; // String | 
    String itemName = "itemName_example"; // String | 
    Boolean done = true; // Boolean | 
    try {
      apiInstance.setDone(list, itemName, done);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#setDone");
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
 **list** | **String**|  |
 **itemName** | **String**|  |
 **done** | **Boolean**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateItem"></a>
# **updateItem**
> updateItem(todoEntryDto, name, itemName)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    TodoEntryDto todoEntryDto = new TodoEntryDto(); // TodoEntryDto | 
    String name = "name_example"; // String | 
    String itemName = "itemName_example"; // String | 
    try {
      apiInstance.updateItem(todoEntryDto, name, itemName);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#updateItem");
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
 **todoEntryDto** | [**TodoEntryDto**](TodoEntryDto.md)|  |
 **name** | **String**|  |
 **itemName** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateList"></a>
# **updateList**
> updateList(todoListDto, name)



### Example
```java
// Import classes:
import com.domain.projectname.client.ApiClient;
import com.domain.projectname.client.ApiException;
import com.domain.projectname.client.Configuration;
import com.domain.projectname.client.models.*;
import com.domain.projectname.api.TodoControllerImplApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    TodoControllerImplApi apiInstance = new TodoControllerImplApi(defaultClient);
    TodoListDto todoListDto = new TodoListDto(); // TodoListDto | 
    String name = "name_example"; // String | 
    try {
      apiInstance.updateList(todoListDto, name);
    } catch (ApiException e) {
      System.err.println("Exception when calling TodoControllerImplApi#updateList");
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
 **todoListDto** | [**TodoListDto**](TodoListDto.md)|  |
 **name** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

