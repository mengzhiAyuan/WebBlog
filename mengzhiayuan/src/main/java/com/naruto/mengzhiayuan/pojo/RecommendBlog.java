package com.naruto.mengzhiayuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendBlog {

    private Long id;
    private String title;
    private boolean recommend;
}
