package com.springbootproject.controller;

import com.springbootproject.vo.loginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springbootproject.service.loginServiec;

@RestController
@RequestMapping("/login")
public class loginController {

//    @Autowired
//    private loginServiec loginServiec;

    @RequestMapping(value = "/dologin", method = RequestMethod.POST, consumes = "application/json")
    public String doLogin(@RequestBody loginVo login) {
        return login.getUsername() + " " + login.getPassword() + " " + "success";
    }

    @RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
    public ResponseEntity forgetPassword() {
        return new ResponseEntity("hellow from frogetpassword", HttpStatus.OK);
    }
}
