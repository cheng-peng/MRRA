package com.cxp.module_news.bean;

import com.cxp.lib_common.bean.ResultsBean;

import java.util.List;

/**
 * 文 件 名: NewsData
 * 创 建 人: CXP
 * 创建日期: 2018-04-24 14:20
 * 描    述: 新闻数据
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class NewsData {

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }
}
