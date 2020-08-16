package net.esm.modules.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.esm.common.annotation.RestAnon;
import net.esm.common.entity.Result;
import net.esm.modules.business.pojo.SearchData;
import net.esm.modules.business.service.BusiDeviceSensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 测试接口
 *
 */
@Api(value = "测试接口", description = "测试接口")
@RestController
@RequestMapping("/rest")
public class RestTestController {

    @Autowired
    private BusiDeviceSensorDataService busiDeviceSensorDataService;
    /**
     * 验证拦截
     * @return
     */
    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/testAuth", method = RequestMethod.GET)
    public String test() {
        return "auth token";
    }

    /**
     * 匿名调用：@RestAnon
     * @return
     */
    @ApiOperation(value = "匿名访问接口")
    @ApiImplicitParam(name = "token", value = "授权码")
    @RequestMapping(value = "/testAnon", method = RequestMethod.GET)
    @RestAnon
    public String testAnon() {
        return "rest anon";
    }

    @ApiOperation(value = "data")
    @ApiImplicitParam(name = "testData", value = "data")
    @RequestMapping(value = "/testData", method = RequestMethod.POST)
    @RestAnon
    public Result testData(@RequestBody SearchData searchData) {
        return busiDeviceSensorDataService.selectHistoryData(searchData.getDeviceNumber(),searchData.getStart(),searchData.getEnd());
    }


}
