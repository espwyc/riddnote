package com.richard.riddnote.Domain;


import com.richard.riddnote.Utils.SysUtils;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="t_markdowns")
public class Markdown implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String uid= SysUtils.uid();

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "contentid",referencedColumnName = "uid")
    private MdContent content;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "ownerid",referencedColumnName = "uid")
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public MdContent getContent() {
        return content;
    }

    public void setContent(MdContent content) {
        this.content = content;
    }
}
