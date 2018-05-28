package com.cxp.module_main.ui.test.activity.room.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cxp.module_main.ui.test.activity.room.entity.User;

import java.util.List;

/**
 * 文 件 名: UserDao
 * 创 建 人: CXP
 * 创建日期: 2018-03-26 18:38
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Dao
public interface UserDao {

    /**
     * 根据条件查询查询
     */
    @Query("SELECT * FROM user_table WHERE user_age=:age")
    public User queryUser(int age);

    /**
     * 查询
     */
    @Query("SELECT * FROM user_table")
    public List<User> queryUserAll();

    /**
     * 添加
     */
    @Insert
    public void insertUser(User... users);

    /**
     * 批量添加
     */
    @Insert
    public void insertUserAll(List<User> list);

    /**
     * 更新
     */
    @Update
    public void updateUser(User... users);

    /**
     * 批量更新
     */
    @Update
    public void updateUserAll(List<User> list);

    /**
     * 删除
     */
    @Delete
    public void deleteUser(User... users);

    /**
     * 批量删除
     */
    @Delete
    public void deleteUserAll(List<User> list);

}
