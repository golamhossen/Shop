package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Invoice;

public interface IInvoiceDAO extends ICommonDAO<Invoice> {
    public Invoice getByOrderNo(int orderNo);
    public String deleteByOrderNo(int orderNo);
    public long getCount();
}
