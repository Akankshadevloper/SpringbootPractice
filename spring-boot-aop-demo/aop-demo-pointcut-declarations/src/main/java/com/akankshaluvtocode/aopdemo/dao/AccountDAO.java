package com.akankshaluvtocode.aopdemo.dao;

import com.akankshaluvtocode.aopdemo.Account;

public interface AccountDAO {


    void addAccount(Account theAccount , boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
