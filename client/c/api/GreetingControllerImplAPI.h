#include <stdlib.h>
#include <stdio.h>
#include "../include/apiClient.h"
#include "../include/list.h"
#include "../external/cJSON.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"
#include "../model/error_response.h"


char*
GreetingControllerImplAPI_greetHuman(apiClient_t *apiClient, char * name );


char*
GreetingControllerImplAPI_greetWorld(apiClient_t *apiClient);


