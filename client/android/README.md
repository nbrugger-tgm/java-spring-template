# openapi-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

- target/openapi-android-client-1.0.0.jar
- target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import org.openapitools.client.api.ApiControllerApi;

public class ApiControllerApiExample {

    public static void main(String[] args) {
        ApiControllerApi apiInstance = new ApiControllerApi();
        try {
            VersionResponse result = apiInstance.version();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiControllerApi#version");
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



