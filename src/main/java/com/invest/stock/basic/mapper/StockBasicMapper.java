package com.invest.stock.basic.mapper;

import static com.invest.stock.basic.mapper.StockBasicDynamicSqlSupport.*;

import com.invest.stock.basic.dao.StockBasic;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockBasicMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.253+08:00", comments="Source Table: stock_basic")
    BasicColumn[] selectList = BasicColumn.columnList(tsCode, symbol, name, area, industry, fullname, enname, market, exchange, currType, listStatus, listDate, delistDate, isHs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.238+08:00", comments="Source Table: stock_basic")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.239+08:00", comments="Source Table: stock_basic")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.239+08:00", comments="Source Table: stock_basic")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<StockBasic> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.241+08:00", comments="Source Table: stock_basic")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<StockBasic> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.243+08:00", comments="Source Table: stock_basic")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("StockBasicResult")
    Optional<StockBasic> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.244+08:00", comments="Source Table: stock_basic")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="StockBasicResult", value = {
        @Result(column="ts_code", property="tsCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="symbol", property="symbol", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.VARCHAR),
        @Result(column="industry", property="industry", jdbcType=JdbcType.VARCHAR),
        @Result(column="fullname", property="fullname", jdbcType=JdbcType.VARCHAR),
        @Result(column="enname", property="enname", jdbcType=JdbcType.VARCHAR),
        @Result(column="market", property="market", jdbcType=JdbcType.VARCHAR),
        @Result(column="exchange", property="exchange", jdbcType=JdbcType.VARCHAR),
        @Result(column="curr_type", property="currType", jdbcType=JdbcType.VARCHAR),
        @Result(column="list_status", property="listStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="list_date", property="listDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="delist_date", property="delistDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_hs", property="isHs", jdbcType=JdbcType.VARCHAR)
    })
    List<StockBasic> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.246+08:00", comments="Source Table: stock_basic")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.247+08:00", comments="Source Table: stock_basic")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, stockBasic, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.247+08:00", comments="Source Table: stock_basic")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, stockBasic, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.248+08:00", comments="Source Table: stock_basic")
    default int insert(StockBasic record) {
        return MyBatis3Utils.insert(this::insert, record, stockBasic, c ->
            c.map(tsCode).toProperty("tsCode")
            .map(symbol).toProperty("symbol")
            .map(name).toProperty("name")
            .map(area).toProperty("area")
            .map(industry).toProperty("industry")
            .map(fullname).toProperty("fullname")
            .map(enname).toProperty("enname")
            .map(market).toProperty("market")
            .map(exchange).toProperty("exchange")
            .map(currType).toProperty("currType")
            .map(listStatus).toProperty("listStatus")
            .map(listDate).toProperty("listDate")
            .map(delistDate).toProperty("delistDate")
            .map(isHs).toProperty("isHs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.25+08:00", comments="Source Table: stock_basic")
    default int insertMultiple(Collection<StockBasic> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, stockBasic, c ->
            c.map(tsCode).toProperty("tsCode")
            .map(symbol).toProperty("symbol")
            .map(name).toProperty("name")
            .map(area).toProperty("area")
            .map(industry).toProperty("industry")
            .map(fullname).toProperty("fullname")
            .map(enname).toProperty("enname")
            .map(market).toProperty("market")
            .map(exchange).toProperty("exchange")
            .map(currType).toProperty("currType")
            .map(listStatus).toProperty("listStatus")
            .map(listDate).toProperty("listDate")
            .map(delistDate).toProperty("delistDate")
            .map(isHs).toProperty("isHs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.25+08:00", comments="Source Table: stock_basic")
    default int insertSelective(StockBasic record) {
        return MyBatis3Utils.insert(this::insert, record, stockBasic, c ->
            c.map(tsCode).toPropertyWhenPresent("tsCode", record::getTsCode)
            .map(symbol).toPropertyWhenPresent("symbol", record::getSymbol)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(area).toPropertyWhenPresent("area", record::getArea)
            .map(industry).toPropertyWhenPresent("industry", record::getIndustry)
            .map(fullname).toPropertyWhenPresent("fullname", record::getFullname)
            .map(enname).toPropertyWhenPresent("enname", record::getEnname)
            .map(market).toPropertyWhenPresent("market", record::getMarket)
            .map(exchange).toPropertyWhenPresent("exchange", record::getExchange)
            .map(currType).toPropertyWhenPresent("currType", record::getCurrType)
            .map(listStatus).toPropertyWhenPresent("listStatus", record::getListStatus)
            .map(listDate).toPropertyWhenPresent("listDate", record::getListDate)
            .map(delistDate).toPropertyWhenPresent("delistDate", record::getDelistDate)
            .map(isHs).toPropertyWhenPresent("isHs", record::getIsHs)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.254+08:00", comments="Source Table: stock_basic")
    default Optional<StockBasic> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, stockBasic, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.255+08:00", comments="Source Table: stock_basic")
    default List<StockBasic> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, stockBasic, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.255+08:00", comments="Source Table: stock_basic")
    default List<StockBasic> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, stockBasic, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.256+08:00", comments="Source Table: stock_basic")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, stockBasic, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.256+08:00", comments="Source Table: stock_basic")
    static UpdateDSL<UpdateModel> updateAllColumns(StockBasic record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tsCode).equalTo(record::getTsCode)
                .set(symbol).equalTo(record::getSymbol)
                .set(name).equalTo(record::getName)
                .set(area).equalTo(record::getArea)
                .set(industry).equalTo(record::getIndustry)
                .set(fullname).equalTo(record::getFullname)
                .set(enname).equalTo(record::getEnname)
                .set(market).equalTo(record::getMarket)
                .set(exchange).equalTo(record::getExchange)
                .set(currType).equalTo(record::getCurrType)
                .set(listStatus).equalTo(record::getListStatus)
                .set(listDate).equalTo(record::getListDate)
                .set(delistDate).equalTo(record::getDelistDate)
                .set(isHs).equalTo(record::getIsHs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.257+08:00", comments="Source Table: stock_basic")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(StockBasic record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tsCode).equalToWhenPresent(record::getTsCode)
                .set(symbol).equalToWhenPresent(record::getSymbol)
                .set(name).equalToWhenPresent(record::getName)
                .set(area).equalToWhenPresent(record::getArea)
                .set(industry).equalToWhenPresent(record::getIndustry)
                .set(fullname).equalToWhenPresent(record::getFullname)
                .set(enname).equalToWhenPresent(record::getEnname)
                .set(market).equalToWhenPresent(record::getMarket)
                .set(exchange).equalToWhenPresent(record::getExchange)
                .set(currType).equalToWhenPresent(record::getCurrType)
                .set(listStatus).equalToWhenPresent(record::getListStatus)
                .set(listDate).equalToWhenPresent(record::getListDate)
                .set(delistDate).equalToWhenPresent(record::getDelistDate)
                .set(isHs).equalToWhenPresent(record::getIsHs);
    }
}