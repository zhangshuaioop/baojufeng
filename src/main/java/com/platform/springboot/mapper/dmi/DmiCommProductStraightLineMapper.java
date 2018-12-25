package com.platform.springboot.mapper.dmi;

import com.platform.springboot.entity.dmi.DmiCommProductStraightLine;
import com.platform.springboot.entity.dmi.DmiCommProductStraightLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiCommProductStraightLineMapper {

    int insertSelective(DmiCommProductStraightLine record);

    DmiCommProductStraightLine selectByPrimaryKey(Integer id);

    DmiCommProductStraightLine selectByProductId(Integer productId);

    int updateByPrimaryKeySelective(DmiCommProductStraightLine record);

    int updateByProductIdSelective(DmiCommProductStraightLine record);



    List<DmiCommProductStraightLine> selectAllByProductId(Integer storeCommProductId);
}