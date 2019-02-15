package com.richard.riddnote.Dao;

import com.richard.riddnote.Domain.Markdown;
import com.richard.riddnote.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MarkdownsRepository extends JpaRepository<Markdown,Long> {

    Markdown findByUid(String uid);

    Set<Markdown> findByOwner(User owner);

}
