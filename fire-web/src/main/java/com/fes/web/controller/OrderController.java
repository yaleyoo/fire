package com.fes.web.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qigege on 2017/10/2.
 */

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
@Validated
public class OrderController {

}
