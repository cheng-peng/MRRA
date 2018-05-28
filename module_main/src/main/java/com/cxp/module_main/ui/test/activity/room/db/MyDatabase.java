package com.cxp.module_main.ui.test.activity.room.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.cxp.module_main.ui.test.activity.room.entity.Book;
import com.cxp.module_main.ui.test.activity.room.entity.User;


/**
 * 文 件 名: MyDatabase
 * 创 建 人: CXP
 * 创建日期: 2018-03-26 18:40
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Database(entities = {User.class, Book.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

    public abstract BookDao getBookDao();

}
