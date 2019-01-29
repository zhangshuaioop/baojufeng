package com.teekee.blueoceanservice.controller.fdp;//package com.teekee.blueoceanservice.controller.fdp;
//
//import com.teekee.blueoceanservice.entity.fdp.FdpDispatchRequestChatLog;
//import com.teekee.blueoceanservice.service.fdp.FdpDispatchRequestChatLogService;
//import com.teekee.commoncomponets.utils.Result;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.log4j.Logger;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * @Author Chenliwen
// * @Date 2019/1/8 15:00
// **/
//@RestController
//@RequestMapping("/fdpDispatchRequestChatLog")
//@Api(description = "派工消息")
//public class FdpDispatchRequestChatLogController {
//
//    private Logger log = Logger.getLogger(FdpDispatchRequestChatLogController.class);
//
//    @Resource
//    private FdpDispatchRequestChatLogService service;
//
//    @ApiOperation(value = "新增调整信息", httpMethod = "POST")
//    @PostMapping(value = "/handle")
//    public Result handle(@RequestBody FdpDispatchRequestChatLog request) {
//        log.info("新增调整信息-开始,入参：request="+request.toString());
//        Result result = service.handle(request);
//        log.info("新增调整信息-结束,出参："+result.toString());
//        return result;
//    }
//
//
//    @ApiOperation(value = "查询派工信息", httpMethod = "POST")
//    @PostMapping(value = "/list")
//    public Result getFaultOrderRequestListByObject(@RequestBody FdpDispatchRequestChatLog request) {
//        log.info("查询派工信息-开始,入参：request="+request.toString());
//        Result result = service.list(request);
//        log.info("查询派工信息-结束,出参："+result.toString());
//        return result;
//    }
//
//
//    @ApiOperation(value = "查询未读信息列表", httpMethod = "GET")
//    @GetMapping(value = "/listLast")
//    public Result listLast() {
//        log.info("查询未读信息列表-开始,入参：无");
//        Result result = service.listLast();
//        log.info("查询未读信息列表-结束,出参："+result.toString());
//        return result;
//    }
//
//
//    @ApiOperation(value = "设置沟通消息已读", httpMethod = "GET")
//    @GetMapping(value = "/setRead")
//    public Result setRead(@RequestParam Integer requestId) {
//        log.info("设置沟通消息已读-开始,入参：requestId="+requestId);
//        Result result = service.setRead(requestId);
//        log.info("设置沟通消息已读-结束,出参："+result.toString());
//        return result;
//    }
//
//
//    @ApiOperation(value = "设置非本人发送沟通消息已读", httpMethod = "GET")
//    @GetMapping(value = "/setReadNotSend")
//    public Result setReadNotSend(@RequestParam Integer requestId) {
//        log.info("设置非本人发送沟通消息已读-开始,入参：requestId="+requestId);
//        Result result = service.setReadNotSend(requestId);
//        log.info("设置非本人发送沟通消息已读-结束,出参："+result.toString());
//        return result;
//    }
//}
