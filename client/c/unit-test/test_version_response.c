#ifndef version_response_TEST
#define version_response_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define version_response_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/version_response.h"
version_response_t* instantiate_version_response(int include_optional);



version_response_t* instantiate_version_response(int include_optional) {
  version_response_t* version_response = NULL;
  if (include_optional) {
    version_response = version_response_create(
      "a",
      1
    );
  } else {
    version_response = version_response_create(
      "a",
      1
    );
  }

  return version_response;
}


#ifdef version_response_MAIN

void test_version_response(int include_optional) {
    version_response_t* version_response_1 = instantiate_version_response(include_optional);

	cJSON* jsonversion_response_1 = version_response_convertToJSON(version_response_1);
	printf("version_response :\n%s\n", cJSON_Print(jsonversion_response_1));
	version_response_t* version_response_2 = version_response_parseFromJSON(jsonversion_response_1);
	cJSON* jsonversion_response_2 = version_response_convertToJSON(version_response_2);
	printf("repeating version_response:\n%s\n", cJSON_Print(jsonversion_response_2));
}

int main() {
  test_version_response(1);
  test_version_response(0);

  printf("Hello world \n");
  return 0;
}

#endif // version_response_MAIN
#endif // version_response_TEST
