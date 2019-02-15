package com.richard.riddnote.Configure.Dialect;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQL5DialectUTF8 extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
