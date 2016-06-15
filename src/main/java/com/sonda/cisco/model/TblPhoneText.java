package com.sonda.cisco.model;

import com.sonda.cisco.model.xml.KeyItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 19/05/2016.
 */

@Entity
@Table(name = "PhoneText")
public class TblPhoneText {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "prompt", nullable = true)
    private String prompt;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "tiempo_refresh", nullable = true)
    private int tiempo_refresh;
    @Column(name = "url_refresh", nullable = true)
    private String url_refresh;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "keyItems", nullable = true)
    private List<TblKeyItem> keyItems = new ArrayList<TblKeyItem>();




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getTiempo_refresh() {
        return tiempo_refresh;
    }

    public void setTiempo_refresh(int tiempo_refresh) {
        this.tiempo_refresh = tiempo_refresh;
    }

    public String getUrl_refresh() {
        return url_refresh;
    }

    public void setUrl_refresh(String url_refresh) {
        this.url_refresh = url_refresh;
    }

    public List<TblKeyItem> getKeyItems() {
        return keyItems;
    }

    public void setKeyItems(List<TblKeyItem> keyItems) {
        this.keyItems = keyItems;
    }
}
