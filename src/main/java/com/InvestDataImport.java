package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: songkai
 * @Date: 2020/7/7
 */
@SpringBootApplication
@MapperScan({"com.invest.stock.basic.mapper"})
public class InvestDataImport {
    public static void main(String[] args){
        SpringApplication.run(InvestDataImport.class,args);
    }
}
