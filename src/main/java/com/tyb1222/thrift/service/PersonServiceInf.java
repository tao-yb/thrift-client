package com.tyb1222.thrift.service;

import com.tyb1222.thrift.thrift.Person;

public interface PersonServiceInf {
    //根据名称获取学生信息
    Person getStudentByName(String name);

    //保存学生信息
    void save(Person student);
}
