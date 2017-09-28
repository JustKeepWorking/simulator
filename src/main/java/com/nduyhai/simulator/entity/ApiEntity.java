package com.nduyhai.simulator.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "api")
public class ApiEntity implements Serializable{

    @EmbeddedId
    private ApiKey key;

    private String content;

    public ApiEntity() {
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
