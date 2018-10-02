package com.apptozee.blogpages.services.discovery;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
class Route {

    @JsonProperty("id")
    private String id;
    @JsonProperty("fullPath")
    private String fullPath;
    @JsonProperty("location")
    private String location;
    @JsonProperty("path")
    private String path;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("retryable")
    private Boolean retryable;
    @JsonProperty("customSensitiveHeaders")
    private Boolean customSensitiveHeaders;
    @JsonProperty("prefixStripped")
    private Boolean prefixStripped;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("fullPath")
    public String getFullPath() {
        return fullPath;
    }

    @JsonProperty("fullPath")
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @JsonProperty("retryable")
    public Boolean getRetryable() {
        return retryable;
    }

    @JsonProperty("retryable")
    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }

    @JsonProperty("customSensitiveHeaders")
    public Boolean getCustomSensitiveHeaders() {
        return customSensitiveHeaders;
    }

    @JsonProperty("customSensitiveHeaders")
    public void setCustomSensitiveHeaders(Boolean customSensitiveHeaders) {
        this.customSensitiveHeaders = customSensitiveHeaders;
    }

    @JsonProperty("prefixStripped")
    public Boolean getPrefixStripped() {
        return prefixStripped;
    }

    @JsonProperty("prefixStripped")
    public void setPrefixStripped(Boolean prefixStripped) {
        this.prefixStripped = prefixStripped;
    }

}
