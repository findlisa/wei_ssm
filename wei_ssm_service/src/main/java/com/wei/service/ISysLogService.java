package com.wei.service;

import com.wei.domain.sysLog;

import java.util.List;

public interface ISysLogService {
    void save(sysLog sysLog);

    List<sysLog> findAll();
}
