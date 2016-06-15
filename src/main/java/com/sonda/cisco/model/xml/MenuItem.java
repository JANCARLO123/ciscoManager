package com.sonda.cisco.model.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by JanCarlo on 13/05/2016.
 */

public class MenuItem {
    private String name;
    private String url;


    public String getName() {
        return name;
    }
    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
    @XmlElement(name = "URL")
    public void setUrl(String url) {
        this.url = url;
    }
}
