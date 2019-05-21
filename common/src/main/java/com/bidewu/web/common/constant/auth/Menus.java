package com.bidewu.web.common.constant.auth;


import lombok.Data;

import java.util.List;

@Data
public class Menus extends Menu{
    private List list;

    public Menus(String name, String title, List list) {
        super(name, title);
        this.list = list;
    }
}
