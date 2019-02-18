package com.richard.riddnote.Model.Dto;

import com.richard.riddnote.Model.Bo.MarkdownBo;

public class MdinfoDto {

    private String title;

    private String intro;

    private String imgsrc;

    private String lastedittime;

    private String opencount;

    private String nickname;

    private String uid;


    static public MdinfoDto CreateDtoCreteria(MarkdownBo markdownBo)
    {
        MdinfoDto mdinfoDto = new MdinfoDto();
        mdinfoDto.setTitle(markdownBo.getTitle());
        mdinfoDto.setImgsrc(markdownBo.getImgsrc());
        mdinfoDto.setIntro(markdownBo.getIntro());
        mdinfoDto.setLastedittime(markdownBo.getLastedittime());
        mdinfoDto.setOpencount(markdownBo.getLastedittime());
        mdinfoDto.setNickname(markdownBo.getUsernickname());
        mdinfoDto.setUid(markdownBo.getUid());

        return mdinfoDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLastedittime() {
        return lastedittime;
    }

    public void setLastedittime(String lastedittime) {
        this.lastedittime = lastedittime;
    }

    public String getOpencount() {
        return opencount;
    }

    public void setOpencount(String opencount) {
        this.opencount = opencount;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
