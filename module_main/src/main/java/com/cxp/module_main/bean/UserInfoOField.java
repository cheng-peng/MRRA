package com.cxp.module_main.bean;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * 文 件 名: UserInfoOField
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 10:51
 * 描    述: ObservableField  声明属性,不需要继承接口
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class UserInfoOField {

    private ObservableField<String> name;

    private ObservableInt age;

    private ObservableField<String> details;

    public UserInfoOField(String name, int age, String details) {
        this.name = new ObservableField<>(name);
        this.age = new ObservableInt(age);
        this.details = new ObservableField<>(details);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableInt getAge() {
        return age;
    }

    public void setAge(ObservableInt age) {
        this.age = age;
    }

    public ObservableField<String> getDetails() {
        return details;
    }

    public void setDetails(ObservableField<String> details) {
        this.details = details;
    }
}
