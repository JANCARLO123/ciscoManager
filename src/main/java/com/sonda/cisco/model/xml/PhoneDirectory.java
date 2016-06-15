package com.sonda.cisco.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 13/05/2016.
 */
@XmlRootElement(name = "CiscoIPPhoneDirectory")
public class PhoneDirectory {

    private String title;
    private String prompt;



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
}
