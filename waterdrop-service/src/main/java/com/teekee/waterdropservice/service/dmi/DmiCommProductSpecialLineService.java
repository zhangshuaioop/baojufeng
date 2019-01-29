package com.teekee.waterdropservice.service.dmi;

import com.teekee.waterdropservice.entity.bif.ret.BifBuildingAddress.ShowRet;
import com.teekee.waterdropservice.entity.dmi.DmiCommProductSpecialLine;
import com.teekee.waterdropservice.entity.dmi.DmiStoreWithBusinessLicense;
import com.teekee.waterdropservice.entity.dmi.ret.dmiCommProductSpecialLine.SpecialLineRet;
import com.teekee.waterdropservice.mapper.dmi.DmiCommProductSpecialLineMapper;
import com.teekee.waterdropservice.service.bif.BifBuildingAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: zhangshuai
 * @create: 2018-12-17 15:14
 */
@Service
public class DmiCommProductSpecialLineService {

    @Resource
    private DmiCommProductSpecialLineMapper specialLineMapper;
    @Resource
    private DmiStoreService storeService;
    @Resource
    private BifBuildingAddressService bifBuildingAddressService;

    public SpecialLineRet show(int productId) {
        DmiCommProductSpecialLine sqlResult = specialLineMapper.selectByProductId(productId);
        if(sqlResult==null){
            return null;
        }
        SpecialLineRet result = new SpecialLineRet();
        DmiStoreWithBusinessLicense storeInfo = storeService.getStoreBasicInfo(sqlResult.getaStoreId());
        if (storeInfo != null){
            result.setaStore(storeInfo.getStoreName());
        }
        ShowRet addressInfo = bifBuildingAddressService.show(sqlResult.getaAddressId());
        if(addressInfo != null){
            result.setaAddress(addressInfo.getCity() + addressInfo.getDistrict() + addressInfo.getRoad());
        }
        result.setaPortType(sqlResult.getaPortType());
        result.setaBandWidth(sqlResult.getaBandWidth());
        result.setaBandWidthType(sqlResult.getaBandWidthType());
        result.setaLocalCode(sqlResult.getaLocalCode());
        result.setzStore(sqlResult.getzStoreId());
        result.setzPortType(sqlResult.getzPortType());
        result.setzBandWidth(sqlResult.getzBandWidth());
        result.setzBandWidthType(sqlResult.getzBandWidthType());
        result.setzLocalCode(sqlResult.getzLocalCode());
        result.setBandWidth(sqlResult.getBandWidth());
        result.setBandWidthType(sqlResult.getBandWidthType());
        return result;
    }
}
