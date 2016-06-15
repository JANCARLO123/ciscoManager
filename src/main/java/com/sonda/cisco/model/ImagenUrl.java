package com.sonda.cisco.model;

import javax.persistence.*;

/**
 * Created by JanCarlo on 25/05/2016.
 */
@Entity
@Table(name = "ImagenUrl")
public class ImagenUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url", length = 255, nullable = false)
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
