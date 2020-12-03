package com.tyb1222.thrift.client;

import com.tyb1222.thrift.thrift.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.lang.reflect.Proxy;

public class ThriftClient {
    private String host;

    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    private TTransport tTransport;

    private TProtocol tProtocol;

    private PersonService.Client client;

    private PersonService.Iface p_iface;

    private void init() {
        tTransport = new TFramedTransport(new TSocket(host, port), 600);
        //协议对象 这里使用协议对象需要和服务器的一致
        tProtocol = new TCompactProtocol(tTransport);

        client = new PersonService.Client(tProtocol);

        p_iface =  (PersonService.Iface)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{PersonService.Iface.class},new ThriftHandler(client));
    }



    public PersonService.Client getService() {
        return client;
    }

    public PersonService.Iface getP_iface(){
        return p_iface;
    }

    public void open() throws TTransportException {
        if (null != tTransport && !tTransport.isOpen())
            tTransport.open();
    }

    public void close() {
        if (null != tTransport && tTransport.isOpen())
            tTransport.close();
    }
}

