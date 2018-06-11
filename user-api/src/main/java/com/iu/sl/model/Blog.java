package com.iu.sl.model;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/6/1 11:00
 */
public class Blog implements Serializable {

    private static final long serialVersionUID = -5631440486771082337L;
    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
