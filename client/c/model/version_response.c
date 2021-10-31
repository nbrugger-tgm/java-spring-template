#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "version_response.h"



version_response_t *version_response_create(
    char *version,
    int stable
    ) {
    version_response_t *version_response_local_var = malloc(sizeof(version_response_t));
    if (!version_response_local_var) {
        return NULL;
    }
    version_response_local_var->version = version;
    version_response_local_var->stable = stable;

    return version_response_local_var;
}


void version_response_free(version_response_t *version_response) {
    if(NULL == version_response){
        return ;
    }
    listEntry_t *listEntry;
    if (version_response->version) {
        free(version_response->version);
        version_response->version = NULL;
    }
    free(version_response);
}

cJSON *version_response_convertToJSON(version_response_t *version_response) {
    cJSON *item = cJSON_CreateObject();

    // version_response->version
    if(version_response->version) { 
    if(cJSON_AddStringToObject(item, "version", version_response->version) == NULL) {
    goto fail; //String
    }
     } 


    // version_response->stable
    if(version_response->stable) { 
    if(cJSON_AddBoolToObject(item, "stable", version_response->stable) == NULL) {
    goto fail; //Bool
    }
     } 

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

version_response_t *version_response_parseFromJSON(cJSON *version_responseJSON){

    version_response_t *version_response_local_var = NULL;

    // version_response->version
    cJSON *version = cJSON_GetObjectItemCaseSensitive(version_responseJSON, "version");
    if (version) { 
    if(!cJSON_IsString(version))
    {
    goto end; //String
    }
    }

    // version_response->stable
    cJSON *stable = cJSON_GetObjectItemCaseSensitive(version_responseJSON, "stable");
    if (stable) { 
    if(!cJSON_IsBool(stable))
    {
    goto end; //Bool
    }
    }


    version_response_local_var = version_response_create (
        version ? strdup(version->valuestring) : NULL,
        stable ? stable->valueint : 0
        );

    return version_response_local_var;
end:
    return NULL;

}
