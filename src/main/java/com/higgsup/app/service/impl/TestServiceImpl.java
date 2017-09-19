package com.higgsup.app.service.impl;

import com.higgsup.app.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created on 19-Sep-17.
 * OwnerBy anhvu
 */

@Service
public class TestServiceImpl implements TestService{
    public void test(){
        System.out.println("Ham sevice Test");
    }
}
