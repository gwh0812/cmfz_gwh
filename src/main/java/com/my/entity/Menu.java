package com.my.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private String id;
    private String name;
    private String iconCls;
    private String href;
    private String parentld;
    private String text1;
    private String text2;
    private List<Menu> children =new ArrayList<Menu>();

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", parentld='" + parentld + '\'' +
                ", text1='" + text1 + '\'' +
                ", text2='" + text2 + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(name, menu.name) &&
                Objects.equals(iconCls, menu.iconCls) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(parentld, menu.parentld) &&
                Objects.equals(text1, menu.text1) &&
                Objects.equals(text2, menu.text2) &&
                Objects.equals(children, menu.children);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, iconCls, href, parentld, text1, text2, children);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getParentld() {
        return parentld;
    }

    public void setParentld(String parentld) {
        this.parentld = parentld;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(String id, String name, String iconCls, String href, String parentld, String text1, String text2, List<Menu> children) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.parentld = parentld;
        this.text1 = text1;
        this.text2 = text2;
        this.children = children;
    }

    public Menu() {
    }
}
