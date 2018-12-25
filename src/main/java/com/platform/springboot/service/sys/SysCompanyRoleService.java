package com.platform.springboot.service.sys;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.platform.springboot.base.BaseService;
import com.platform.springboot.entity.sys.SysCompanyPermission;
import com.platform.springboot.entity.sys.SysCompanyRole;
import com.platform.springboot.entity.sys.SysCompanyRolePermission;
import com.platform.springboot.entity.sys.SysCompanyUsers;
import com.platform.springboot.mapper.sys.SysCompanyPermissionMapper;
import com.platform.springboot.mapper.sys.SysCompanyRoleMapper;
import com.platform.springboot.mapper.sys.SysCompanyRolePermissionMapper;
import com.platform.springboot.utils.*;
import com.platform.springboot.mapper.sys.SysCompanyPermissionMapper;
import com.platform.springboot.mapper.sys.SysCompanyRoleMapper;
import com.platform.springboot.mapper.sys.SysCompanyRolePermissionMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @description: 公司角色
 * @author: zhangshuai
 * @create: 2018-12-12 09:28
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysCompanyRoleService extends BaseService<SysCompanyRoleMapper,SysCompanyRole> {

    private final Logger logger = Logger.getLogger(getClass());


    @Autowired
    private SysCompanyRoleMapper sysCompanyRoleMapper;

    @Autowired
    private SysCompanyRolePermissionMapper sysCompanyRolePermissionMapper;

    @Autowired
    private SysCompanyPermissionMapper sysCompanyPermissionMapper;

    /**
     * 分页查询
     * @param sysCompanyRole
     * @return
     */
    public Result findPage(SysCompanyRole sysCompanyRole) {

//        sysCompanyRole.setRelationCompanyIds(CurrentUtil.getCurrent().getRelationCompanyIds());
        sysCompanyRole.setCompanyId(CurrentUtil.getCurrent().getCompanyId());
        PageHelper.startPage(sysCompanyRole.getPageNum(), sysCompanyRole.getPageSize());
        Page<SysCompanyRole> persons = sysCompanyRoleMapper.findPage(sysCompanyRole);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<SysCompanyRole> pageInfo = new PageInfo<>(persons);
        return ResultUtil.success(pageInfo);
    }


    /**
     * 角色赋权
     * @param sysCompanyRolePermission
     * @return
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public Result updateRolePermission(SysCompanyRolePermission sysCompanyRolePermission) {
        SysCompanyUsers sysCompanyUsers = CurrentUtil.getCurrent();
        try {
            logger.info("删除当前公司角色权限");
            sysCompanyRolePermission.setCompanyId(sysCompanyUsers.getCompanyId());
            sysCompanyRolePermissionMapper.deleteByRoleAndCompanyId(sysCompanyRolePermission);
            logger.info("保存当前公司角色权限");
            sysCompanyRolePermissionMapper.saveRoleAuthority(sysCompanyRolePermission.getRoleId(),sysCompanyUsers.getCompanyId(),
                    sysCompanyUsers.getId(),sysCompanyUsers.getId(),sysCompanyRolePermission.getPermissionIds().split(","));

            SysCompanyPermission sysCompanyPermission = new SysCompanyPermission();
            sysCompanyPermission.setCompanyId(sysCompanyUsers.getCompanyId());
            sysCompanyPermission.setUserId(sysCompanyUsers.getId());
            logger.info("更新redis中角色权限");
            String jsonStr = JsonUtils.getListToJson(sysCompanyPermissionMapper.selectPermission(sysCompanyPermission));
            RedisUtil.set("sys_company_users,"+sysCompanyUsers.getId(),jsonStr);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorExceptionMsg("");
        }
        return ResultUtil.success();
    }



}
