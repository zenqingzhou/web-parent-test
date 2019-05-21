package com.bidewu.web.common.constant.auth;

import lombok.Data;

import java.util.List;


@Data
public class Menuf extends Menus{
    private String icon;

    public Menuf(String name, String title, List list, String icon) {
        super(name, title, list);
        this.icon = icon;
    }
}
