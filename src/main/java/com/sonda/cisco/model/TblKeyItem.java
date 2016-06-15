package com.sonda.cisco.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by JanCarlo on 20/05/2016.
 */
@Entity
@Table(name = "KeyItem")
public class TblKeyItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 60, nullable = false)
    private String name;
    @Column(name = "url", length = 210, nullable = false)
    private String url;
    @Column(name = "position", nullable = false)
    private long position;

/*    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "phone_id", referencedColumnName="id")
    private long phone;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
