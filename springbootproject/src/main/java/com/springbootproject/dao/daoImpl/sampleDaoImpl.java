package com.springbootproject.dao.daoImpl;

import com.springbootproject.dao.sampleDao;
import org.springframework.stereotype.Service;

@Service
public class sampleDaoImpl implements sampleDao {
    @Override
    public void sampleDaoFortune() {
        System.out.println("hi from sampleDaoImplClass");
    }
}
