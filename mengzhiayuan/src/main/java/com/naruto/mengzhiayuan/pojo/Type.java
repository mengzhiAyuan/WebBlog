package com.naruto.mengzhiayuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/27 11:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private Long id;
    private String name;

    //此属性是用来返回所有的分类博客列表
    private List<Blog> blogs = new ArrayList<>();
}
