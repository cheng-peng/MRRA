package com.cxp.module_main.ui.test.activity.room.entity;

import android.arch.persistence.room.ColumnInfo;

/**
 * 文 件 名: UserAndBook
 * 创 建 人: CXP
 * 创建日期: 2018-03-27 0:04
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class UserAndBook {

    @ColumnInfo(name = "user_name")
    protected String name;
    @ColumnInfo(name = "user_age")
    protected String age;
    @ColumnInfo(name = "book_name")
    protected String bookName;
    @ColumnInfo(name = "book_type")
    protected String bookType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
