# OpenAPIClient-php

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)


## Installation & Usage

### Requirements

PHP 7.3 and later.
Should also work with PHP 8.0 but has not been tested.

### Composer

To install the bindings via [Composer](https://getcomposer.org/), add the following to `composer.json`:

```json
{
  "repositories": [
    {
      "type": "vcs",
      "url": "https://github.com/GIT_USER_ID/GIT_REPO_ID.git"
    }
  ],
  "require": {
    "GIT_USER_ID/GIT_REPO_ID": "*@dev"
  }
}
```

Then run `composer install`

### Manual Installation

Download the files and include `autoload.php`:

```php
<?php
require_once('/path/to/OpenAPIClient-php/vendor/autoload.php');
```

## Getting Started

Please follow the [installation procedure](#installation--usage) and then run the following:

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');




$apiInstance = new OpenAPI\Client\Api\ApiControllerApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);

try {
    $result = $apiInstance->version();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling ApiControllerApi->version: ', $e->getMessage(), PHP_EOL;
}

```

## API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApiControllerApi* | [**version**](docs/Api/ApiControllerApi.md#version) | **GET** /api/version | 
*GreetingControllerImplApi* | [**greetHuman**](docs/Api/GreetingControllerImplApi.md#greethuman) | **GET** /greet/{name} | 
*GreetingControllerImplApi* | [**greetHumanPut**](docs/Api/GreetingControllerImplApi.md#greethumanput) | **PUT** /greet/{name} | 
*GreetingControllerImplApi* | [**greetWorld**](docs/Api/GreetingControllerImplApi.md#greetworld) | **GET** /greet | 

## Models

- [ErrorResponse](docs/Model/ErrorResponse.md)
- [VersionResponse](docs/Model/VersionResponse.md)

## Authorization
All endpoints do not require authorization.
## Tests

To run the tests, use:

```bash
composer install
vendor/bin/phpunit
```

## Author



## About this package

This PHP package is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project:

- API version: `v0`
- Build package: `org.openapitools.codegen.languages.PhpClientCodegen`