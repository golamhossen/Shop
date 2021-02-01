package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Invoice;

public interface IInvoiceService extends ICommonService<Invoice> {

    public Invoice getByOrderNo(int orderNo);

    public String deleteByOrderNo(int orderNo);

    public long getCount();
}
