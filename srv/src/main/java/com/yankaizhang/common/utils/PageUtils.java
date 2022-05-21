package com.yankaizhang.common.utils;

import com.github.pagehelper.PageHelper;
import com.yankaizhang.common.utils.sql.SqlUtil;
import com.yankaizhang.framework.web.page.PageDomain;
import com.yankaizhang.framework.web.page.TableSupport;

/**
 * 分页工具类
 *
 */
public class PageUtils extends PageHelper
{
    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            Boolean reasonable = pageDomain.getReasonable();
            PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
        }
    }
}