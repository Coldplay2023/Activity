package com.huqingyong.www.dao;


import com.huqingyong.www.po.Sponsor;


public interface SponsorDao {
    //查询主办方
    Sponsor querySponsor(String account);
    //验证主办方是否存在
    boolean identifySponsor(String account,String password,String whetherNull);
    //存放主办方
    void savingSponsor(Sponsor sponsor);
    //更新主办方
    void updateSponsor(Sponsor sponsor);

}
