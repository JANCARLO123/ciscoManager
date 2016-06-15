package com.sonda.cisco.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 13/05/2016.
 */
@XmlRootElement(name = "CiscoIPPhoneImageFile")
@XmlType(propOrder = {"title","prompt","locationX","locationY","url","keyItems"})
public class PhoneImageFile {
    private String title;
    private String prompt;
    private String windowMode;//atributo
    private int locationX = -1;
    private int locationY = -1;
    private String url;

    private List<KeyItem> keyItems = new ArrayList<KeyItem>();


    public String getTitle() {
        return title;
    }

    @XmlElement(name = "Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrompt() {
        return prompt;
    }

    @XmlElement(name = "Prompt")
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public int getLocationX() {
        return locationX;
    }

    @XmlElement(name = "LocationX")
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    @XmlElement(name = "LocationY")
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public String getWindowMode() {
        return windowMode;
    }
    @XmlAttribute(name = "windowMode")
    public void setWindowMode(String windowMode) {
        this.windowMode = windowMode;
    }

    public String getUrl() {
        return url;
    }
    @XmlElement(name = "URL")
    public void setUrl(String url) {
        this.url = url;
    }

    public List<KeyItem> getKeyItems() {
        return keyItems;
    }
    @XmlElement(name="SoftKeyItem")
    public void setKeyItems(List<KeyItem> keyItems) {
        this.keyItems = keyItems;
    }
}
