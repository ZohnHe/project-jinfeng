package com.jfone.mall.base.service;


import com.jfone.mall.base.entity.work.ext.ExportCustOrdItem;

import java.util.List;

public interface ExportService {

    List<ExportCustOrdItem> getExport();
}
