package com.platform.springboot.mapper.dmi;

import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.dmi.DmiStoreCommProduct;
import com.platform.springboot.entity.dmi.ret.dmiStoreCommProduct.GetListByStoreIdRet;
import com.platform.springboot.entity.dto.dmi.DmiStoreCommProduct.CommListDto;
import com.platform.springboot.entity.ret.dmi.DmiStoreCommProduct.CommListForChargeRet;
import com.platform.springboot.base.BaseMapper;
import com.platform.springboot.entity.dmi.DmiStoreCommProduct;
import com.platform.springboot.entity.dmi.ret.dmiStoreCommProduct.GetListByStoreIdRet;
import com.platform.springboot.entity.dto.dmi.DmiStoreCommProduct.CommListDto;
import com.platform.springboot.entity.ret.dmi.DmiStoreCommProduct.CommListForChargeRet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmiStoreCommProductMapper extends BaseMapper<DmiStoreCommProduct> {

    int insertSelective(DmiStoreCommProduct record);

    DmiStoreCommProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmiStoreCommProduct record);

    List<GetListByStoreIdRet> getListByStoreId(Integer storeId);

    List<DmiStoreCommProduct> getListByMarketingCampaignId(Integer marketingCampaignId);

    List<DmiStoreCommProduct> getIndependenceProductList();

    List<DmiStoreCommProduct> getIndependenceProductListByStoreId(int storeId);

    DmiStoreCommProduct show(Integer id);

    List<CommListForChargeRet> getCommList(CommListDto record);

    List<CommListForChargeRet> getProductList(CommListDto record);

    List<CommListForChargeRet> getCampaignList(CommListDto record);

}