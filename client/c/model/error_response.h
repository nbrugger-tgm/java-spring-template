/*
 * error_response.h
 *
 * 
 */

#ifndef _error_response_H_
#define _error_response_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct error_response_t error_response_t;




typedef struct error_response_t {
    char *message; // string
    char *code; // string
    char *error; // string

} error_response_t;

error_response_t *error_response_create(
    char *message,
    char *code,
    char *error
);

void error_response_free(error_response_t *error_response);

error_response_t *error_response_parseFromJSON(cJSON *error_responseJSON);

cJSON *error_response_convertToJSON(error_response_t *error_response);

#endif /* _error_response_H_ */

