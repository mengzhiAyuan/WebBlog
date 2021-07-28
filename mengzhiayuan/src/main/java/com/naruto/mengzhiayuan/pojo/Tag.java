package com.naruto.mengzhiayuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/27 11:34
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private Long id;
    private String name;

    private List<Blog> blogs = new ArrayList<>();
}
