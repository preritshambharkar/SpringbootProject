package com.springbootproject.service.serviceImpl;

import com.springbootproject.service.sampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootproject.dao.sampleDao;

@Service
public class sampleServiceImpl implements sampleService {

    @Autowired
    private sampleDao sampleDao;

    @Override
    public void sampleServiecFortune() {
        System.out.println("hi from serviecImplClass");
        sampleDao.sampleDaoFortune();
    }
}
