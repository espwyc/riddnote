package com.richard.riddnote.Service;

import com.richard.riddnote.Model.Bo.MarkdownBo;
import com.richard.riddnote.Model.Bo.UserBo;

import java.util.Set;


public interface IMarkdownsService {

    void CreateNewMarkdown(MarkdownBo markdownBo, UserBo userBo);

    Set<MarkdownBo> GetMdList(UserBo userBo);

    MarkdownBo GetMarkdown(String uid);

    void SaveMarkdown(MarkdownBo markdownBo, UserBo userBo);

    void DeleteMarkdown(MarkdownBo markdownBo, UserBo userBo);
}
