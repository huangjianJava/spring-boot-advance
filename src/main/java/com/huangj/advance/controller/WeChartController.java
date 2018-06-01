package com.huangj.advance.controller;

import com.huangj.advance.common.ErrorCode;
import com.huangj.advance.common.ResultDto;
import com.huangj.advance.exception.ServiceException;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangj
 * @Description:  we-chart 相关接口
 * @date 2018/6/1
 */
@RestController
@RequestMapping("/we-chart")
public class WeChartController {

    @GetMapping(value = "/exception")
    @ApiOperation(value = "异常处理测试", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultDto exceptionTest(@RequestParam String name){
        if(!"admin".equals(name)){
            throw new ServiceException(ErrorCode.BAD_REQUEST);
        }
        return ResultDto.fail(ErrorCode.BAD_REQUEST);
    }

}
