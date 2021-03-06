# openapi-java-client

OpenAPI definition
- API version: v0
  - Build date: 2021-11-18T01:26:47.733405Z[Etc/UTC]

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>v0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-java-client:v0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-v0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ApiControllerApi;

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

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApiControllerApi* | [**version**](docs/ApiControllerApi.md#version) | **GET** /api/version | 
*GreetingControllerImplApi* | [**greetHuman**](docs/GreetingControllerImplApi.md#greetHuman) | **GET** /greet/{name} | 
*GreetingControllerImplApi* | [**greetHumanPut**](docs/GreetingControllerImplApi.md#greetHumanPut) | **PUT** /greet/{name} | 
*GreetingControllerImplApi* | [**greetWorld**](docs/GreetingControllerImplApi.md#greetWorld) | **GET** /greet | 


## Documentation for Models

 - [ErrorResponse](docs/ErrorResponse.md)
 - [VersionResponse](docs/VersionResponse.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



