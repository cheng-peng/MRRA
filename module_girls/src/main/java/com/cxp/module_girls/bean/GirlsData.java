package com.cxp.module_girls.bean;

import com.cxp.lib_common.bean.ResultsBean;

import java.util.List;

/**
 * 文 件 名: GirlsData
 * 创 建 人: CXP
 * 创建日期: 2018-04-24 14:16
 * 描    述: 妹子数据
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class GirlsData {

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
