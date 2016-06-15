package com.sonda.cisco.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 11/05/2016.
 */
@XmlRootElement(name = "CiscoIPPhoneText")
@XmlType(propOrder = {"title","prompt","text","keyItems"})
public class PhoneText {


    private String title;
    private String prompt;
    private String text;
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

    public String getText() {
        return text;
    }

    @XmlElement(name = "Text")
    public void setText(String text) {
        this.text = text;
    }

    public List<KeyItem> getKeyItems() {
        return keyItems;
    }
    @XmlElement(name="SoftKeyItem")
    public void setKeyItems(List<KeyItem> keyItems) {
        this.keyItems = keyItems;
    }
}
