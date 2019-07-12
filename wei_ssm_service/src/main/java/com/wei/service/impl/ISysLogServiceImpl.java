package com.wei.service.impl;

import com.wei.dao.ISysLogDao;
import com.wei.domain.sysLog;
import com.wei.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao iSysLogDao;
    public void save(sysLog sysLog) {
        iSysLogDao.save(sysLog);
    }

    public List<sysLog> findAll() {
        List<sysLog> sysLogs=iSysLogDao.findAll();
        return sysLogs;
    }
}
