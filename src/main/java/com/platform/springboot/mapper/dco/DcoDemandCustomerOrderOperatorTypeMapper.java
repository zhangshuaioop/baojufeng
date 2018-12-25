package com.platform.springboot.mapper.dco;

import com.platform.springboot.entity.dco.DcoDemandCustomerOrderOperatorType;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.entity.dco.DcoDemandCustomerOrderOperatorType;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DcoDemandCustomerOrderOperatorTypeMapper {

    int insertSelective(DcoDemandCustomerOrderOperatorType record);

    DcoDemandCustomerOrderOperatorType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DcoDemandCustomerOrderOperatorType record);

    DcoDemandCustomerOrderOperatorType getOptTypeByUserId(Integer userId);

    List<DcoDemandCustomerOrderOperatorType> getTechnologyListByUserId(List<SysCompanyUsers> list);

    List<DcoDemandCustomerOrderOperatorType> getCustomerServiceListByUserId(List<SysCompanyUsers> list);

    /**
     * 查询指定账户类型下所有的客服人员集合
     *
     * @param sysCompanyUsers
     * @return
     */
    List<DcoDemandCustomerOrderOperatorType> queryServiceListByActType(SysCompanyUsers sysCompanyUsers);

}