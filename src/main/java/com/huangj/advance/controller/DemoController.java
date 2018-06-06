package com.huangj.advance.controller;

import com.huangj.advance.common.ErrorCode;
import com.huangj.advance.common.ResultDto;
import com.huangj.advance.exception.ServiceException;
import com.huangj.advance.model.StoreInfoModel;
import com.huangj.advance.service.StoreInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huangj
 * @Description:  demo controller
 * @date 2018/5/25
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    StoreInfoService storeInfoService;

    @GetMapping(value = "/exception")
    @ApiOperation(value = "异常处理测试", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultDto exceptionTest(@RequestParam String name){
        if(!"admin".equals(name)){
            throw new ServiceException(ErrorCode.BAD_REQUEST);
        }
        return ResultDto.fail(ErrorCode.BAD_REQUEST);
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return "hello world";
    }


    @GetMapping(value = "/stores")
    public List<StoreInfoModel> queryAllStoreInfo(){
       return storeInfoService.queryAllStoreInfo();
    }

}


















