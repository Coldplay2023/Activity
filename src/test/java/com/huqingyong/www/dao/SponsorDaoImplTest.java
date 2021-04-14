package com.huqingyong.www.dao;

import com.huqingyong.www.dao.Impl.SponsorDaoImpl;
import com.huqingyong.www.dao.SponsorDao;
import com.huqingyong.www.po.Sponsor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SponsorDaoImplTest {
    SponsorDao sponsorDao=new SponsorDaoImpl();

    @Test
    void querySponsor() {
        System.out.println(sponsorDao.querySponsor("12"));
    }

    @Test
    void identifySponsor() {
        System.out.println(sponsorDao.identifySponsor("12","12"));
    }

    @Test
    void savingSponsor() {
        Sponsor sponsor=new Sponsor("14","14","好呀","yong","123456","123456");
        sponsorDao.savingSponsor(sponsor);
    }

    @Test
    void updateSponsor() {
        Sponsor sponsor=new Sponsor("14","15","好呀","yong","123456","123456");
        sponsorDao.updateSponsor(sponsor);
    }
}