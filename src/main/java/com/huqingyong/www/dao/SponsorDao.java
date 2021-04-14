package com.huqingyong.www.dao;

import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Sponsor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface SponsorDao {
    Sponsor querySponsor(String account);
    boolean identifySponsor(String account,String password);
    void savingSponsor(Sponsor sponsor);
    void updateSponsor(Sponsor sponsor);

}
