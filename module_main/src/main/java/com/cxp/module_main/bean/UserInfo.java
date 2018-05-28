package com.cxp.module_main.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.cxp.module_main.BR;

/**
 * 文 件 名: UserInfo
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 9:08
 * 描    述: 用户实体类
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class UserInfo extends BaseObservable {

    //如果是 public 修饰符，则可以直接在成员变量上方加上 @Bindable 注解
    //姓名
    @Bindable
    public String name;
    //年龄
    private Integer age;
    //如果是 private 修饰符，则在成员变量的 get 方法上添加 @Bindable 注解
    //描述
    private String details;

    public UserInfo(String name, Integer age, String details) {
        this.name = name;
        this.age = age;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //只更新本字段
        notifyPropertyChanged(BR.name);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Bindable
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
        //更新所有字段
        notifyChange();
    }
}
