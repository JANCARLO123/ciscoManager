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
@XmlRootElement(name = "CiscoIPPhoneImage")
@XmlType(propOrder={"title", "prompt", "locationX", "locationY", "width", "height", "depth", "data","keyItems"})
public class PhoneImage {
    private String title;
    private String prompt;
    private String windowMode;//atributo
    private int locationX = -1;
    private int locationY = -1;
    private int width;
    private int height;
    private int depth;
    private String data;

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

    public int getWidth() {
        return width;
    }

    @XmlElement(name = "Width")
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    @XmlElement(name = "Height")
    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    @XmlElement(name = "Depth")
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getData() {
        return data;
    }

    @XmlElement(name = "Data")
    public void setData(String data) {
        this.data = data;
    }

    public List<KeyItem> getKeyItems() {
        return keyItems;
    }

    @XmlElement(name = "SoftKeyItem")
    public void setKeyItems(List<KeyItem> keyItems) {
        this.keyItems = keyItems;
    }

    public String getWindowMode() {
        return windowMode;
    }

    @XmlAttribute(name = "WindowMode")
    public void setWindowMode(String windowMode) {
        this.windowMode = windowMode;
    }
}
