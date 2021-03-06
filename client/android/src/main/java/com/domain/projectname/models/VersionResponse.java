/**
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.domain.projectname.models;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@ApiModel(description = "")
public class VersionResponse implements Serializable {
  
  @SerializedName("version")
  private String version = null;
  @SerializedName("stable")
  private Boolean stable = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getStable() {
    return stable;
  }
  public void setStable(Boolean stable) {
    this.stable = stable;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionResponse versionResponse = (VersionResponse) o;
    return (this.version == null ? versionResponse.version == null : this.version.equals(versionResponse.version)) &&
        (this.stable == null ? versionResponse.stable == null : this.stable.equals(versionResponse.stable));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.version == null ? 0: this.version.hashCode());
    result = 31 * result + (this.stable == null ? 0: this.stable.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionResponse {\n");
    
    sb.append("  version: ").append(version).append("\n");
    sb.append("  stable: ").append(stable).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
