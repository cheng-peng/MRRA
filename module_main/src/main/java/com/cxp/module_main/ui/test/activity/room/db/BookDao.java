package com.cxp.module_main.ui.test.activity.room.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cxp.module_main.ui.test.activity.room.entity.Book;
import com.cxp.module_main.ui.test.activity.room.entity.UserAndBook;

import java.util.List;

/**
 * 文 件 名: BookDao
 * 创 建 人: CXP
 * 创建日期: 2018-03-26 22:32
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Dao
public interface BookDao {

    /**
     * 查询
     */
    @Query("SELECT * FROM book_table")
    public List<Book> queryBookAll();


    /**
     * 多表查询
     */
    @Query("select u.user_name,u.user_age,b.book_name,book_type from book_table b,user_table u where b.book_id=u.id")
    public List<UserAndBook> queryBookAndUser();

    /**
     * 添加
     */
    @Insert
    public void insertBook(Book... books);

}
