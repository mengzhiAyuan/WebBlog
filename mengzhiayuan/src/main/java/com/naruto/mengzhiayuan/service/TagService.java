package com.naruto.mengzhiayuan.service;

import com.naruto.mengzhiayuan.pojo.Tag;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TagService {
    int saveTag(Tag tag);

    int deleteTag(Long id);

    int updateTag(Tag tag);

    Tag getById(Long id);

    Tag getByName(String name);

    List<Tag> getAllTag();

    List<Tag> getTagByString(String text);

    List<Tag> getAdminTag();
}
