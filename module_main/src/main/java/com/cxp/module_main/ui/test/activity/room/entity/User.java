package com.cxp.module_main.ui.test.activity.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * 文 件 名: User
 * 创 建 人: CXP
 * 创建日期: 2018-03-26 18:35
 * 描    述: 用户实体类
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Entity(tableName = "user_table")
public class User {

    //主键  autoGenerate = true  自增长
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "user_name")
    public String name;

    @ColumnInfo(name = "user_age")
    public int age;

    @ColumnInfo(name = "update_time")
    public long updateTime;

    @Ignore
    public int sex;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

}
