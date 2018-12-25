package com.platform.springboot.mapper.cfg;

import com.github.pagehelper.Page;
import com.platform.springboot.entity.cfg.CfgFaultTypeModel;
import com.platform.springboot.entity.cfg.CfgFaultTypeModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CfgFaultTypeModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CfgFaultTypeModel record);

    int insertSelective(CfgFaultTypeModel record);

    CfgFaultTypeModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CfgFaultTypeModel record);

    int updateByPrimaryKey(CfgFaultTypeModel record);

    Page<CfgFaultTypeModel> selectByType(CfgFaultTypeModel model);



    Page<CfgFaultTypeModel> selectListHistory(CfgFaultTypeModel model);

    Integer selectVersion(CfgFaultTypeModel model);
}