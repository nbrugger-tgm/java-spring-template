/*
 * VersionResponse.h
 *
 * 
 */

#ifndef _VersionResponse_H_
#define _VersionResponse_H_


#include <string>
#include "Object.h"

/** \defgroup Models Data Structures for API
 *  Classes containing all the Data Structures needed for calling/returned by API endpoints
 *
 */

namespace Tizen {
namespace ArtikCloud {


/*! \brief 
 *
 *  \ingroup Models
 *
 */

class VersionResponse : public Object {
public:
	/*! \brief Constructor.
	 */
	VersionResponse();
	VersionResponse(char* str);

	/*! \brief Destructor.
	 */
	virtual ~VersionResponse();

	/*! \brief Retrieve a string JSON representation of this class.
	 */
	char* toJson();

	/*! \brief Fills in members of this class from JSON string representing it.
	 */
	void fromJson(char* jsonStr);

	/*! \brief Get 
	 */
	std::string getVersion();

	/*! \brief Set 
	 */
	void setVersion(std::string  version);
	/*! \brief Get 
	 */
	bool getStable();

	/*! \brief Set 
	 */
	void setStable(bool  stable);

private:
	std::string version;
	bool stable;
	void __init();
	void __cleanup();

};
}
}

#endif /* _VersionResponse_H_ */
