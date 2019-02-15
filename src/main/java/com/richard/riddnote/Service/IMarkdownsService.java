package com.richard.riddnote.Service;

import com.richard.riddnote.Model.Bo.MarkdownBo;
import com.richard.riddnote.Model.Bo.UserBo;

import java.util.Set;


public interface IMarkdownsService {

    void CreateNewMarkdown(MarkdownBo markdownBo, UserBo userBo);

    Set<MarkdownBo> GetMdList(UserBo userBo);
}
