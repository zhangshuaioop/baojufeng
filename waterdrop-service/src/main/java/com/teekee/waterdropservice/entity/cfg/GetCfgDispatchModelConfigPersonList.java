package com.teekee.waterdropservice.entity.cfg;

import com.teekee.commoncomponets.base.BaseEntity;

/**
 * @Author Niting
 * @date 2018/9/29
 **/
public class GetCfgDispatchModelConfigPersonList extends BaseEntity {
    private Integer id;
    private String createPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }
}
