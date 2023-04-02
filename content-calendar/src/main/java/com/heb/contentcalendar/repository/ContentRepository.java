package com.heb.contentcalendar.repository;

import com.heb.contentcalendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {
    List<Content> findAllByContentType(String type);

    List<Content> findAllByTitleContains(String keyword);
}

