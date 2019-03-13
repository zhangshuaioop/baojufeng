package com.company.springboot.service.bif;

import com.company.springboot.entity.bif.BifCpe;
import com.company.springboot.mapper.bif.BifCpeMapper;
import com.company.springboot.utils.CurrentUtil;
import com.company.springboot.utils.PageInfo;
import com.company.springboot.utils.Result;
import com.company.springboot.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @Author Chenliwen
 * @Date 2018/12/17 14:00
 **/
@Service
public class BifCpeService{

    @Resource
    private BifCpeMapper mapper;

    public Result getBifCpeList(BifCpe bifCpe) {
        List<BifCpe> list = new ArrayList<>();
        List<BifCpe> persons = mapper.getBifCpeList(bifCpe);
        if(persons!=null) {
            if (bifCpe.getPageNum() != null && bifCpe.getPageSize() != null) {
                PageHelper.startPage(bifCpe.getPageNum(), bifCpe.getPageSize());
                // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
                PageInfo<BifCpe> pageInfo = new PageInfo<>(persons);
                if(pageInfo.getList()==null||pageInfo.getList().size()==0){
                    pageInfo.setPageNum(1);
                    pageInfo.setPageSize(10);
                }
                return ResultUtil.success(pageInfo);
            }
            return ResultUtil.success(persons);
        }
        return ResultUtil.success(list);
    }

    public Result getBifCpeById(Integer id) {
        if(id !=null && id !=0){
            return ResultUtil.success(mapper.getBifCpeById(id));
        }
        return ResultUtil.success(new BifCpe());
    }

    public Result handle(BifCpe bifCpe) {
        if(bifCpe==null){
            return ResultUtil.validateError("参数错误!");
        }
        bifCpe.setUpdatePerson(CurrentUtil.getCurrent().getId()+"");
        bifCpe.setUpdateTime(new Date());
        if(bifCpe.getId()==null||bifCpe.getId()==0){
            bifCpe.setCreateTime(new Date());
            bifCpe.setBusinessType("STORE");
            mapper.insertSelective(bifCpe);
        }else{
            mapper.updateByPrimaryKeySelective(bifCpe);
        }
        return ResultUtil.successMsg("保存成功!");
    }

    public Result deleteById(Integer id) {
        if(mapper.deleteByid(id)>0){
            return ResultUtil.successMsg("删除成功!");
        }
        return ResultUtil.validateError("删除失败!");
    }
}