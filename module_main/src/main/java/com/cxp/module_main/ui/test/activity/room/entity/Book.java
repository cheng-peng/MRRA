package com.cxp.module_main.ui.test.activity.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * 文 件 名: Book
 * 创 建 人: CXP
 * 创建日期: 2018-03-26 21:36
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
//foreignKeys关联表  主键id  外键book_id onDelete = CASCADE 关联表级联删除  indices 索引唯一
@Entity(tableName = "book_table",foreignKeys = @ForeignKey(entity = User.class,parentColumns = "id",childColumns = "book_id",onDelete = CASCADE), indices = @Index(value={"book_id"},unique = true))
public class Book {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "book_id")
    public int bookId;

    @ColumnInfo(name = "book_name")
    public String bookName;

    @ColumnInfo(name = "book_type")
    public String bookType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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
