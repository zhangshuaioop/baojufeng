package com.teekee.blueoceanservice.controller.bif;

import com.teekee.commoncomponets.utils.Result;
import com.teekee.blueoceanservice.entity.bif.BifDispatchHrNegativeLog;
import com.teekee.blueoceanservice.service.bif.BifDispatchHrNegativeLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Chenliwen
 * @Date 2019/1/3 14:08
 **/
@RestController
@RequestMapping("/bifDispatchHrNegativeLog")
@Api(description = "负面评价日志")
public class BifDispatchHrNegativeLogController {

    private Logger log = Logger.getLogger(BifDispatchHrNegativeLogController.class);

    @Resource
    private BifDispatchHrNegativeLogService service;

    @ApiOperation(
            value = "新增派工人员负面评价日志",
            notes = "新增派工人员负面评价日志",
            consumes = "application/json",
            responseReference = "com.teekee.commoncomponets.utils.Result")
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public Result handle(@RequestBody BifDispatchHrNegativeLog request) {
        log.info("新增派工人员负面评价日志-开始，入参：request="+request.toString());
        Result result = service.handle(request);
        log.info("新增派工人员负面评价日志-结束，出参："+result.toString());
        return result;
    }
}
