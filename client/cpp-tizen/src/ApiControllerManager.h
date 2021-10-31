#ifndef _ApiControllerManager_H_
#define _ApiControllerManager_H_

#include <string>
#include <cstring>
#include <list>
#include <glib.h>
#include "ErrorResponse.h"
#include "VersionResponse.h"
#include "Error.h"

/** \defgroup Operations API Endpoints
 *  Classes containing all the functions for calling API endpoints
 *
 */

namespace Tizen{
namespace ArtikCloud {
/** \addtogroup ApiController ApiController
 * \ingroup Operations
 *  @{
 */
class ApiControllerManager {
public:
	ApiControllerManager();
	virtual ~ApiControllerManager();

/*! \brief . *Synchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool versionSync(char * accessToken,
	
	void(* handler)(VersionResponse, Error, void* )
	, void* userData);

/*! \brief . *Asynchronous*
 *
 * 
 * \param handler The callback function to be invoked on completion. *Required*
 * \param accessToken The Authorization token. *Required*
 * \param userData The user data to be passed to the callback function.
 */
bool versionAsync(char * accessToken,
	
	void(* handler)(VersionResponse, Error, void* )
	, void* userData);



	static std::string getBasePath()
	{
		return "http://localhost:8080";
	}
};
/** @}*/

}
}
#endif /* ApiControllerManager_H_ */
