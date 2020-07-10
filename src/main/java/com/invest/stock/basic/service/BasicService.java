package com.invest.stock.basic.service;

import com.invest.stock.basic.dao.StockBasic;
import com.invest.stock.basic.mapper.StockBasicMapper;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.invest.stock.basic.mapper.StockBasicDynamicSqlSupport.stockBasic;
import static com.invest.stock.basic.mapper.StockBasicDynamicSqlSupport.tsCode;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;


/**
 * @Author: songkai
 * @Date: 2020/7/9
 */
@Service
public class BasicService {

    @Autowired
    StockBasicMapper stockBasicMapper;

    public void insertBasicStock(StockBasic stockBasic){
        stockBasicMapper.insert(stockBasic);
    }

    public List<StockBasic> getStockBasic(String tsCodeParam){

        List<StockBasic> stockBasics;
        if (tsCodeParam == null || tsCodeParam.length() == 0){
            SelectStatementProvider selectStatement = select(tsCode)
                    .from(stockBasic)
                    .build().render(RenderingStrategy.MYBATIS3);

             stockBasics = stockBasicMapper.selectMany(selectStatement);
        }else {
            SelectStatementProvider selectStatement = select(tsCode)
                    .from(stockBasic)
                    .build()
                    .render(RenderingStrategy.MYBATIS3);

             stockBasics = stockBasicMapper.selectMany(selectStatement);
        }

        return stockBasics;

    }
}
