package com.sonda.cisco.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 11/05/2016.
 */

@XmlRootElement(name="CiscoIPPhoneMenu")
@XmlType(propOrder = {"title", "prompt","menuItems","keyItems"})
public class PhoneMenu {


    private String title;
    private String prompt;
    private List<MenuItem> menuItems= new ArrayList<MenuItem>();
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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    @XmlElement(name="MenuItem")
    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    public List<KeyItem> getKeyItems() {
        return keyItems;
    }
    @XmlElement(name="SoftKeyItem")
    public void setKeyItems(List<KeyItem> keyItems) {
        this.keyItems = keyItems;
    }
}


