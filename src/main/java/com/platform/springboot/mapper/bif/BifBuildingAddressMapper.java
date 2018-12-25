package com.platform.springboot.mapper.bif;

import com.platform.springboot.entity.bif.BifBuildingAddress;
import com.platform.springboot.entity.bif.BifBuildingAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BifBuildingAddressMapper {

    int insertSelective(BifBuildingAddress record);

    BifBuildingAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BifBuildingAddress record);

    List<BifBuildingAddress> byMajor(BifBuildingAddress record);

    void deleteByBuildingId(BifBuildingAddress record);

    List<BifBuildingAddress> selectByBuildingId(Integer buildingId);

    int updateByBuildingId(BifBuildingAddress record);

    int updateByBuildingIdNotMajor(BifBuildingAddress record);
}