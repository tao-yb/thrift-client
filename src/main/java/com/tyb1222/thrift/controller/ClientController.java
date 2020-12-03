package com.tyb1222.thrift.controller;

import com.tyb1222.thrift.service.PersonServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    PersonServiceInf personServiceInf;

    @RequestMapping("/test")
    public void test() {
        personServiceInf.getStudentByName("tao");
        System.out.println("send request");
    }
}
