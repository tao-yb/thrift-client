package com.tyb1222.thrift.service.impl;

import com.tyb1222.thrift.client.ThriftClient;
import com.tyb1222.thrift.service.PersonServiceInf;
import com.tyb1222.thrift.thrift.DataException;
import com.tyb1222.thrift.thrift.Person;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceInfImpl implements PersonServiceInf {

    @Autowired
    ThriftClient thriftClient;

    @Override
    public Person getStudentByName(String name) {
        try {
            thriftClient.open();
            System.out.println("客户端请求用户名为:" + name + "的数据");
            Person student = thriftClient.getService().getPersonByUsername("tao");
            System.out.println("获取成功！！！服务端返回的对象:" + student);
            System.out.println(" p_iface remote result :  "+thriftClient.getP_iface().getPersonByUsername("test"));
            return student;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Person student) {

    }
}
