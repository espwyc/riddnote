package com.richard.riddnote.Domain;

import com.richard.riddnote.Utils.SysUtils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_mdcontent")
public class MdContent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String uid= SysUtils.uid();


    @Lob
    @Column(columnDefinition = "LONGTEXT",nullable = true)
    private String mdcontent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMdcontent() {
        return mdcontent;
    }

    public void setMdcontent(String mdcontent) {
        this.mdcontent = mdcontent;
    }
}
