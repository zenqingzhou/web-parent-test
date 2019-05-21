package com.bidewu.web.common.constant.auth;

import lombok.Data;

@Data
public class Menu {
    protected String name;
    protected String title;

    public Menu(String name, String title) {
        this.name = name;
        this.title = title;
    }
}
