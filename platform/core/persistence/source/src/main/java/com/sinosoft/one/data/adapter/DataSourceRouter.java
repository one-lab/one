package com.sinosoft.one.data.adapter;


public interface  DataSourceRouter<Key,T> {

     Key router(T t);

}
