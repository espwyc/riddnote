package com.richard.riddnote.Service.Impl;

import com.richard.riddnote.Dao.MarkdownsRepository;
import com.richard.riddnote.Dao.UserRepository;
import com.richard.riddnote.Domain.Markdown;
import com.richard.riddnote.Domain.MdContent;
import com.richard.riddnote.Domain.User;
import com.richard.riddnote.Exception.AuthException;
import com.richard.riddnote.Exception.DataBaseException;
import com.richard.riddnote.Model.Bo.MarkdownBo;
import com.richard.riddnote.Model.Bo.UserBo;
import com.richard.riddnote.Service.IMarkdownsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MarkdownsServiceImpl implements IMarkdownsService {

    private final UserRepository userRepository;
    private final MarkdownsRepository markdownsRepository;

    @Autowired
    public MarkdownsServiceImpl(UserRepository userRepository, MarkdownsRepository markdownsRepository) {
        this.userRepository = userRepository;
        this.markdownsRepository = markdownsRepository;
    }

    @Override
    public void CreateNewMarkdown(MarkdownBo markdownBo, UserBo userBo) {

        if(userBo==null||userBo.getUid()==null)
        {
            throw new AuthException("空uservo或uid");
        }

        User owner =userRepository.findByUid(userBo.getUid());
        if(owner==null)
        {
            throw new DataBaseException("无该条用户数据");
        }

        Markdown markdown = new Markdown();
        markdown.setOwner(owner);

        MdContent content = new MdContent();
        content.setMdcontent(markdownBo.getContent());

        markdown.setContent(content);
        markdown.setTitle(markdownBo.getTitle());

        markdownsRepository.saveAndFlush(markdown);
    }

    @Override
    public Set<MarkdownBo> GetMdList(UserBo userBo) {
        User user=userRepository.findByUid(userBo.getUid());

        Set<Markdown> markdowns= markdownsRepository.findByOwner(user);

        Set<MarkdownBo> markdownBos = new HashSet<>();

        for(Markdown md :markdowns)
        {
            MarkdownBo tmp = new MarkdownBo();
            tmp.setTitle(md.getTitle());
//            tmp.setIntro();
            tmp.setUsernickname(user.getNickname());
//            tmp.setLastedittime();
//            tmp.setOpencount();
//            tmp.setImgsrc();
            tmp.setUid(md.getUid());

            markdownBos.add(tmp);
        }

        return markdownBos;
    }
}