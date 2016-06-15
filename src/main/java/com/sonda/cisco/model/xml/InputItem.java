package com.sonda.cisco.model.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by JanCarlo on 13/05/2016.
 */
public class InputItem {

    private String displayName;
    private String queryStringParam;
    private String defaultValue;
    private String inputFlags;

    public String getDisplayName() {
        return displayName;
    }
@XmlElement(name="DisplayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getQueryStringParam() {
        return queryStringParam;
    }
    @XmlElement(name="QueryStringParam")
    public void setQueryStringParam(String queryStringParam) {
        this.queryStringParam = queryStringParam;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    @XmlElement(name="DefaultValue")
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getInputFlags() {
        return inputFlags;
    }
    @XmlElement(name="InputFlags")
    public void setInputFlags(String inputFlags) {
        this.inputFlags = inputFlags;
    }
}
