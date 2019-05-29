package com.actiontech.dble.plan.common.item.function;

import com.actiontech.dble.net.mysql.FieldPacket;
import com.actiontech.dble.net.mysql.RowDataPacket;
import com.actiontech.dble.plan.common.item.Item;
import com.actiontech.dble.plan.common.time.MySQLTime;
import com.actiontech.dble.server.ServerConnection;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by szf on 2019/5/28.
 */
public class ItemFuncInner extends ItemFunc {

    private final String clazzName;
    private final String funcName;

    public ItemFuncInner(String funcName, List<Item> args, String clazzName) {
        super(args);
        this.funcName = funcName;
        this.clazzName = clazzName;
    }

    public List<FieldPacket> getField() {
        try {
            Class<?> threadClazz = Class.forName(clazzName);
            Method method = threadClazz.getMethod("getField");
            return (List<FieldPacket>) method.invoke(null);
        } catch (Exception e) {

        }
        return null;
    }

    public List<RowDataPacket> getRows(ServerConnection connection) {
        try {
            Class<?> threadClazz = Class.forName(clazzName);
            Method method = threadClazz.getMethod("getRows", ServerConnection.class);
            return (List<RowDataPacket>) method.invoke(null, connection);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public void fixLengthAndDec() {

    }

    @Override
    public String funcName() {
        return null;
    }

    @Override
    public BigDecimal valReal() {
        return null;
    }

    @Override
    public BigInteger valInt() {
        return null;
    }

    @Override
    public String valStr() {
        return null;
    }

    @Override
    public boolean getDate(MySQLTime ltime, long fuzzydate) {
        return false;
    }

    @Override
    public boolean getTime(MySQLTime ltime) {
        return false;
    }
}
