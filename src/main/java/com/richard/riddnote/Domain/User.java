package com.richard.riddnote.Domain;


import com.richard.riddnote.Utils.SysUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String uid= SysUtils.uid();

    @Column(unique = true,nullable = false)
    private String uname;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = true)
    private String intro;

    @Column(nullable = false)
    private boolean valid;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerid",referencedColumnName = "uid")
    private Set<Markdown> markdowns;


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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Set<Markdown> getMarkdowns() {
        return markdowns;
    }

    public void setMarkdowns(Set<Markdown> markdowns) {
        this.markdowns = markdowns;
    }
}
