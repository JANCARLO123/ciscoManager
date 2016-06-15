package com.sonda.cisco.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 13/05/2016.
 */
@XmlRootElement(name = "CiscoIPPhoneInput")
@XmlType(propOrder = {"title","prompt","url","inputItems","keyItems"})
public class PhoneInput {
    private String title;
    private String prompt;
    private String url;
    private List<InputItem> inputItems= new ArrayList<InputItem>();
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


    public List<KeyItem> getKeyItems() {
        return keyItems;
    }
    @XmlElement(name="SoftKeyItem")
    public void setKeyItems(List<KeyItem> keyItems) {
        this.keyItems = keyItems;
    }

    public String getUrl() {
        return url;
    }
    @XmlElement(name="URL")
    public void setUrl(String url) {
        this.url = url;
    }

    public List<InputItem> getInputItems() {
        return inputItems;
    }
    @XmlElement(name="InputItem")
    public void setInputItems(List<InputItem> inputItems) {
        this.inputItems = inputItems;
    }
}
