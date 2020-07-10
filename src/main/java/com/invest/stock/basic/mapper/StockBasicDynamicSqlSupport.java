package com.invest.stock.basic.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class StockBasicDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.235+08:00", comments="Source Table: stock_basic")
    public static final StockBasic stockBasic = new StockBasic();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.235+08:00", comments="Source field: stock_basic.ts_code")
    public static final SqlColumn<String> tsCode = stockBasic.tsCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.symbol")
    public static final SqlColumn<String> symbol = stockBasic.symbol;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.name")
    public static final SqlColumn<String> name = stockBasic.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.area")
    public static final SqlColumn<String> area = stockBasic.area;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.industry")
    public static final SqlColumn<String> industry = stockBasic.industry;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.fullname")
    public static final SqlColumn<String> fullname = stockBasic.fullname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.enname")
    public static final SqlColumn<String> enname = stockBasic.enname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.market")
    public static final SqlColumn<String> market = stockBasic.market;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.exchange")
    public static final SqlColumn<String> exchange = stockBasic.exchange;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.236+08:00", comments="Source field: stock_basic.curr_type")
    public static final SqlColumn<String> currType = stockBasic.currType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.237+08:00", comments="Source field: stock_basic.list_status")
    public static final SqlColumn<String> listStatus = stockBasic.listStatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.237+08:00", comments="Source field: stock_basic.list_date")
    public static final SqlColumn<String> listDate = stockBasic.listDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.237+08:00", comments="Source field: stock_basic.delist_date")
    public static final SqlColumn<String> delistDate = stockBasic.delistDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.237+08:00", comments="Source field: stock_basic.is_hs")
    public static final SqlColumn<String> isHs = stockBasic.isHs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-07-09T13:56:17.235+08:00", comments="Source Table: stock_basic")
    public static final class StockBasic extends SqlTable {
        public final SqlColumn<String> tsCode = column("ts_code", JDBCType.VARCHAR);

        public final SqlColumn<String> symbol = column("symbol", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> area = column("area", JDBCType.VARCHAR);

        public final SqlColumn<String> industry = column("industry", JDBCType.VARCHAR);

        public final SqlColumn<String> fullname = column("fullname", JDBCType.VARCHAR);

        public final SqlColumn<String> enname = column("enname", JDBCType.VARCHAR);

        public final SqlColumn<String> market = column("market", JDBCType.VARCHAR);

        public final SqlColumn<String> exchange = column("exchange", JDBCType.VARCHAR);

        public final SqlColumn<String> currType = column("curr_type", JDBCType.VARCHAR);

        public final SqlColumn<String> listStatus = column("list_status", JDBCType.VARCHAR);

        public final SqlColumn<String> listDate = column("list_date", JDBCType.VARCHAR);

        public final SqlColumn<String> delistDate = column("delist_date", JDBCType.VARCHAR);

        public final SqlColumn<String> isHs = column("is_hs", JDBCType.VARCHAR);

        public StockBasic() {
            super("stock_basic");
        }
    }
}