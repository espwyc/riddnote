package com.richard.riddnote.Model.Bo;

import com.richard.riddnote.Model.Vo.MarkdownVo;

import java.util.Date;

public class MarkdownBo {

    private String uid;

    private String ownerid;

    private String title;

    private String content;

    private String usernickname;

    private String intro;

    private String imgsrc;

    private Date lastedittime;

    private String opencount;


    static public MarkdownBo CreatrBoCreteria(MarkdownVo markdownVo)
    {
        MarkdownBo markdownBo = new MarkdownBo();
        markdownBo.setTitle(markdownVo.getTitle());
        markdownBo.setContent(markdownVo.getContent());
        markdownBo.setUid(markdownVo.getUid());

        return markdownBo;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsernickname() {
        return usernickname;
    }

    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getOpencount() {
        return opencount;
    }

    public void setOpencount(String opencount) {
        this.opencount = opencount;
    }

    public Date getLastedittime() {
        return lastedittime;
    }

    public void setLastedittime(Date lastedittime) {
        this.lastedittime = lastedittime;
    }

    //private String Createtime;

    //private String LastModifyedTime;
}
