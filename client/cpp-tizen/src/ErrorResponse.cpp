#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "ErrorResponse.h"

using namespace std;
using namespace Tizen::ArtikCloud;

ErrorResponse::ErrorResponse()
{
	//__init();
}

ErrorResponse::~ErrorResponse()
{
	//__cleanup();
}

void
ErrorResponse::__init()
{
	//message = std::string();
	//code = std::string();
	//error = std::string();
}

void
ErrorResponse::__cleanup()
{
	//if(message != NULL) {
	//
	//delete message;
	//message = NULL;
	//}
	//if(code != NULL) {
	//
	//delete code;
	//code = NULL;
	//}
	//if(error != NULL) {
	//
	//delete error;
	//error = NULL;
	//}
	//
}

void
ErrorResponse::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *messageKey = "message";
	node = json_object_get_member(pJsonObject, messageKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&message, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *codeKey = "code";
	node = json_object_get_member(pJsonObject, codeKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&code, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *errorKey = "error";
	node = json_object_get_member(pJsonObject, errorKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&error, node, "std::string", "");
		} else {
			
		}
	}
}

ErrorResponse::ErrorResponse(char* json)
{
	this->fromJson(json);
}

char*
ErrorResponse::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("std::string")) {
		std::string obj = getMessage();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *messageKey = "message";
	json_object_set_member(pJsonObject, messageKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getCode();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *codeKey = "code";
	json_object_set_member(pJsonObject, codeKey, node);
	if (isprimitive("std::string")) {
		std::string obj = getError();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *errorKey = "error";
	json_object_set_member(pJsonObject, errorKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::string
ErrorResponse::getMessage()
{
	return message;
}

void
ErrorResponse::setMessage(std::string  message)
{
	this->message = message;
}

std::string
ErrorResponse::getCode()
{
	return code;
}

void
ErrorResponse::setCode(std::string  code)
{
	this->code = code;
}

std::string
ErrorResponse::getError()
{
	return error;
}

void
ErrorResponse::setError(std::string  error)
{
	this->error = error;
}


