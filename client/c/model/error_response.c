#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "error_response.h"



error_response_t *error_response_create(
    char *message,
    char *code,
    char *error
    ) {
    error_response_t *error_response_local_var = malloc(sizeof(error_response_t));
    if (!error_response_local_var) {
        return NULL;
    }
    error_response_local_var->message = message;
    error_response_local_var->code = code;
    error_response_local_var->error = error;

    return error_response_local_var;
}


void error_response_free(error_response_t *error_response) {
    if(NULL == error_response){
        return ;
    }
    listEntry_t *listEntry;
    if (error_response->message) {
        free(error_response->message);
        error_response->message = NULL;
    }
    if (error_response->code) {
        free(error_response->code);
        error_response->code = NULL;
    }
    if (error_response->error) {
        free(error_response->error);
        error_response->error = NULL;
    }
    free(error_response);
}

cJSON *error_response_convertToJSON(error_response_t *error_response) {
    cJSON *item = cJSON_CreateObject();

    // error_response->message
    if (!error_response->message) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "message", error_response->message) == NULL) {
    goto fail; //String
    }


    // error_response->code
    if (!error_response->code) {
        goto fail;
    }
    
    if(cJSON_AddStringToObject(item, "code", error_response->code) == NULL) {
    goto fail; //String
    }


    // error_response->error
    if(error_response->error) { 
    if(cJSON_AddStringToObject(item, "error", error_response->error) == NULL) {
    goto fail; //String
    }
     } 

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

error_response_t *error_response_parseFromJSON(cJSON *error_responseJSON){

    error_response_t *error_response_local_var = NULL;

    // error_response->message
    cJSON *message = cJSON_GetObjectItemCaseSensitive(error_responseJSON, "message");
    if (!message) {
        goto end;
    }

    
    if(!cJSON_IsString(message))
    {
    goto end; //String
    }

    // error_response->code
    cJSON *code = cJSON_GetObjectItemCaseSensitive(error_responseJSON, "code");
    if (!code) {
        goto end;
    }

    
    if(!cJSON_IsString(code))
    {
    goto end; //String
    }

    // error_response->error
    cJSON *error = cJSON_GetObjectItemCaseSensitive(error_responseJSON, "error");
    if (error) { 
    if(!cJSON_IsString(error))
    {
    goto end; //String
    }
    }


    error_response_local_var = error_response_create (
        strdup(message->valuestring),
        strdup(code->valuestring),
        error ? strdup(error->valuestring) : NULL
        );

    return error_response_local_var;
end:
    return NULL;

}
