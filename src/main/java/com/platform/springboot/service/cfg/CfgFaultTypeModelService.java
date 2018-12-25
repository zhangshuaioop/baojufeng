package com.platform.springboot.service.cfg;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.entity.cfg.CfgFaultTypeConfig;
import com.platform.springboot.entity.cfg.CfgFaultTypeModel;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.cfg.CfgFaultTypeConfigMapper;
import com.platform.springboot.mapper.cfg.CfgFaultTypeModelMapper;
import com.platform.springboot.mapper.dmi.DmiCompanyInfoMapper;
import com.platform.springboot.utils.CurrentUtil;
import com.platform.springboot.utils.Result;
import com.platform.springboot.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghao
 * @Title: CfgFaultTypeModelService
 * @ProjectName WaterDrop
 * @Description: TODO
 * @date 2018/12/18下午3:02
 */
@Service
public class CfgFaultTypeModelService {

    @Resource
    CfgFaultTypeModelMapper mapper;
    @Resource
    CfgFaultTypeConfigMapper configMapper;
    @Resource
    DmiCompanyInfoMapper infoMapper;

    public Result handle(String json) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        List<CfgFaultTypeConfig> config = JSON.parseArray(json, CfgFaultTypeConfig.class);
        CfgFaultTypeModel model = new CfgFaultTypeModel();
        model.setModelUserType(users.getActType());
        model.setModelUserObjId(users.getActObjectId());
        model.setFaultDefineType(config.get(0).getFaultTypeName());
        model.setCreateTime(new Date());
        model.setCreatePerson(users.getId());
        Integer verson = mapper.selectVersion(model);
        if (verson == null) {
            verson = 0;
        }
        model.setVersion(verson + 1);
        mapper.insertSelective(model);

        int i = 1;
        for (CfgFaultTypeConfig cc : config ){
            cc.setId(0);
            cc.setOrderId(i++);
            cc.setModelId(model.getId());
            configMapper.insertSelective(cc);
        }
        return ResultUtil.success();
    }

    public Result list(String faultDefineType) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        CfgFaultTypeModel model = new CfgFaultTypeModel();
        model.setModelUserType(users.getActType());
        model.setModelUserObjId(users.getActObjectId());
        model.setFaultDefineType(faultDefineType);
        List<CfgFaultTypeModel> list = mapper.selectByType(model);
        if (list.size() == 0) {
            if (model.getModelUserType().equals("DEMAND")) {
                Integer vendorId = infoMapper.selectVendorId(model.getModelUserObjId());
                model.setModelUserObjId(vendorId);
                model.setModelUserType("VENDOR");
                List<CfgFaultTypeModel> listVendor = mapper.selectByType(model);
                if (listVendor.size() == 0) {
                    model.setModelUserObjId(0);
                    model.setModelUserType("PLATFORM");
                    List<CfgFaultTypeModel> listPlatform = mapper.selectByType(model);
                    return ResultUtil.success(listPlatform);

                } else {
                    return ResultUtil.success(listVendor);
                }
            } else {
                model.setModelUserObjId(0);
                model.setModelUserType("PLATFORM");
                List<CfgFaultTypeModel> listPlatform = mapper.selectByType(model);
                return ResultUtil.success(listPlatform);
            }
        } else {
            return ResultUtil.success(list);
        }


    }

    public Result listConfig(Integer modelId) {
        if(modelId == null || modelId==0){
            return ResultUtil.validateError("参数错误");
        }
        return  ResultUtil.success(configMapper.selectByModelId(modelId));
    }

    public Result listConfigByCustomer(String faultDefineType) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        CfgFaultTypeModel model = new CfgFaultTypeModel();
        model.setModelUserType(users.getActType());
        model.setModelUserObjId(users.getActObjectId());
        model.setFaultDefineType(faultDefineType);
        List<CfgFaultTypeConfig> list = configMapper.selectMaxVersionConfig(model);
        if (list.size() == 0) {
            if (model.getModelUserType().equals("DEMAND")) {
                Integer vendorId = infoMapper.selectVendorId(model.getModelUserObjId());
                model.setModelUserObjId(vendorId);
                model.setModelUserType("VENDOR");
                List<CfgFaultTypeModel> listVendor = mapper.selectByType(model);
                if (listVendor.size() == 0) {
                    model.setModelUserObjId(0);
                    model.setModelUserType("PLATFORM");
                    List<CfgFaultTypeModel> platfromList = mapper.selectByType(model);

                    return  ResultUtil.success(configMapper.selectCustomerConfig(platfromList.get(0).getId()));

                } else {

                    Integer modelId =listVendor.get(0).getId();
                    return  ResultUtil.success(configMapper.selectCustomerConfig(modelId));
                }
            } else {
                model.setModelUserObjId(0);
                model.setModelUserType("PLATFORM");
                List<CfgFaultTypeModel> platfromList = mapper.selectByType(model);

                return  ResultUtil.success(configMapper.selectCustomerConfig(platfromList.get(0).getId()));

            }
        } else {
            return ResultUtil.success(list);
        }
    }

    public Result listHistory(CfgFaultTypeModel model) {
        SysCompanyUsers users = CurrentUtil.getCurrent();
        if(users==null){
            return ResultUtil.JurisdictionError("");
        }
        model.setModelUserType(users.getActType());
        model.setModelUserObjId(users.getActObjectId());
        PageHelper.startPage(model.getPageNum(), model.getPageSize());
        Page<CfgFaultTypeModel> persons = mapper.selectListHistory(model);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        return ResultUtil.success(persons);
    }
}
