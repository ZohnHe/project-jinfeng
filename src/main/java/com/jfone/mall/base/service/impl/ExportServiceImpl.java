package com.jfone.mall.base.service.impl;


import com.jfone.mall.base.entity.work.ext.ExportCustOrdItem;
import com.jfone.mall.base.mapping.work.ext.ExportCustOrdItemMapper;
import com.jfone.mall.base.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private ExportCustOrdItemMapper exportCustOrdItemMapper;

    @Override
    public List<ExportCustOrdItem> getExport() {

        return exportCustOrdItemMapper.getexport();
    }
}
