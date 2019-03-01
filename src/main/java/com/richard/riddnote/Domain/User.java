package com.richard.riddnote.Domain;


import com.richard.riddnote.Utils.SysUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column
    private Date  createtime;

    @LastModifiedDate
    @Column
    private Date lastmodifiedtime;


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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastmodifiedtime() {
        return lastmodifiedtime;
    }

    public void setLastmodifiedtime(Date lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime;
    }
}
