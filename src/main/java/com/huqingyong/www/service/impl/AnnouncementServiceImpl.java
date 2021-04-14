package com.huqingyong.www.service.impl;

import com.huqingyong.www.dao.AnnouncementDao;
import com.huqingyong.www.dao.Impl.AnnouncementDaoImpl;
import com.huqingyong.www.service.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService {
    AnnouncementDao announcementDao=new AnnouncementDaoImpl();

    @Override
    public void updateAnnouncement(String context) {
        announcementDao.update(context);
    }

    @Override
    public String checkAnnouncement() {
        return announcementDao.queryContext();
    }
}
