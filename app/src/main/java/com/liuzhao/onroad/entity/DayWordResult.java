package com.liuzhao.onroad.entity;


/**
 *　每日一言
 */
public class DayWordResult extends BaseResult {
    private DayWordData datum;

    public DayWordData getDatum() {
        return datum;
    }

    public void setDatum(DayWordData datum) {
        this.datum = datum;
    }
}
