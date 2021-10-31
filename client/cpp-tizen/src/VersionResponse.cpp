#include <map>
#include <cstdlib>
#include <glib-object.h>
#include <json-glib/json-glib.h>
#include "Helpers.h"


#include "VersionResponse.h"

using namespace std;
using namespace Tizen::ArtikCloud;

VersionResponse::VersionResponse()
{
	//__init();
}

VersionResponse::~VersionResponse()
{
	//__cleanup();
}

void
VersionResponse::__init()
{
	//version = std::string();
	//stable = bool(false);
}

void
VersionResponse::__cleanup()
{
	//if(version != NULL) {
	//
	//delete version;
	//version = NULL;
	//}
	//if(stable != NULL) {
	//
	//delete stable;
	//stable = NULL;
	//}
	//
}

void
VersionResponse::fromJson(char* jsonStr)
{
	JsonObject *pJsonObject = json_node_get_object(json_from_string(jsonStr,NULL));
	JsonNode *node;
	const gchar *versionKey = "version";
	node = json_object_get_member(pJsonObject, versionKey);
	if (node !=NULL) {
	

		if (isprimitive("std::string")) {
			jsonToValue(&version, node, "std::string", "");
		} else {
			
		}
	}
	const gchar *stableKey = "stable";
	node = json_object_get_member(pJsonObject, stableKey);
	if (node !=NULL) {
	

		if (isprimitive("bool")) {
			jsonToValue(&stable, node, "bool", "");
		} else {
			
		}
	}
}

VersionResponse::VersionResponse(char* json)
{
	this->fromJson(json);
}

char*
VersionResponse::toJson()
{
	JsonObject *pJsonObject = json_object_new();
	JsonNode *node;
	if (isprimitive("std::string")) {
		std::string obj = getVersion();
		node = converttoJson(&obj, "std::string", "");
	}
	else {
		
	}
	const gchar *versionKey = "version";
	json_object_set_member(pJsonObject, versionKey, node);
	if (isprimitive("bool")) {
		bool obj = getStable();
		node = converttoJson(&obj, "bool", "");
	}
	else {
		
	}
	const gchar *stableKey = "stable";
	json_object_set_member(pJsonObject, stableKey, node);
	node = json_node_alloc();
	json_node_init(node, JSON_NODE_OBJECT);
	json_node_take_object(node, pJsonObject);
	char * ret = json_to_string(node, false);
	json_node_free(node);
	return ret;
}

std::string
VersionResponse::getVersion()
{
	return version;
}

void
VersionResponse::setVersion(std::string  version)
{
	this->version = version;
}

bool
VersionResponse::getStable()
{
	return stable;
}

void
VersionResponse::setStable(bool  stable)
{
	this->stable = stable;
}


