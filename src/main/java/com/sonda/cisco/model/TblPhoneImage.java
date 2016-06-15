package com.sonda.cisco.model;

import com.sonda.cisco.model.xml.KeyItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 20/05/2016.
 */
@Entity
@Table(name = "PhoneImage")
public class TblPhoneImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "titile", length = 50, nullable = false)
    private String title;
    @Column(name = "prompt", length=50, nullable = true)
    private String prompt;
    @Column(name = "windowMode",length = 10, nullable = true)
    private String windowMode;//atributo
    @Column(name = "locationX", nullable = false)
    private int locationX = -1;
    @Column(name = "locationY", nullable = false)
    private int locationY = -1;
    @Column(name = "width", nullable = false)
    private int width;
    @Column(name = "height", nullable = false)
    private int height;
    @Column(name = "depth", nullable = false)
    private int depth;
    @Column(name = "data", length = 50000,nullable = false)
    private String data;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "keyItems", nullable = true)
    private List<TblKeyItem> keyItems = new ArrayList<TblKeyItem>();

    @Column(name = "tiempo_refresh", nullable = true)
    private int tiempo_refresh;

    @Column(name = "url_refresh", nullable = true)
    private String url_refresh;

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

    public String getWindowMode() {
        return windowMode;
    }

    public void setWindowMode(String windowMode) {
        this.windowMode = windowMode;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<TblKeyItem> getKeyItems() {
        return keyItems;
    }

    public void setKeyItems(List<TblKeyItem> keyItems) {
        this.keyItems = keyItems;
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
}
