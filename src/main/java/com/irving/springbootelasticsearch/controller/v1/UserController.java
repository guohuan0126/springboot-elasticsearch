package com.irving.springbootelasticsearch.controller.v1;

import com.irving.springbootelasticsearch.common.http.ApiResult;
import com.irving.springbootelasticsearch.controller.V1BaseController;
import com.irving.springbootelasticsearch.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "SpringBoot集成ElasticSearch测试接口", tags = "UserOperationApi")
@RestController
public class UserController extends V1BaseController {

    @GetMapping("/getAll")
    @ApiOperation(value = "查询全部User信息", notes = "获取全部User信息", response = ApiResult.class)
    public ApiResult getAll() {
        return ApiResult.success(userSearchService.getUserAll());
    }

    @GetMapping("/getUserByName")
    @ApiOperation(value = "根据用户名查询User信息", notes = "根据用户名查询User信息", response = ApiResult.class)
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query")
    public ApiResult getUserByName(String name) {
        return ApiResult.success(userSearchService.getUserByName(name));
    }

    @GetMapping("/getLimitUser")
    @ApiOperation(value = "根据用户名查询User信息", notes = "根据用户名查询User信息", response = ApiResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", dataType = "String"),
            @ApiImplicitParam(name = "size", value = "条数", dataType = "String")
    })
    public ApiResult getLimitUser(@RequestParam(defaultValue = "0", required = false) String page,
                                  @RequestParam(defaultValue = "5", required = false) String size) {
        return ApiResult.success(userSearchService.getUserLimit(
                Integer.parseInt(page), Integer.parseInt(size)));
    }

    @PostMapping("/saveUser")
    @ApiOperation(value = "添加User信息", response = ApiResult.class)
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    public ApiResult saveUser(@RequestBody User user) {
        Boolean isSuccess = userSearchService.insertUser(user);
        if (isSuccess) {
            return ApiResult.success();
        }
        return ApiResult.error();
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改User信息", response = ApiResult.class)
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    public ApiResult updateUser(@RequestBody User user) {
        Boolean isSuccess = userSearchService.updateUser(user);
        if (isSuccess) {
            return ApiResult.success("修改成功!");
        }
        return ApiResult.error("添加失败!");
    }

    @GetMapping("/deleteUser")
    @ApiOperation(value = "刪除User信息", response = ApiResult.class)
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "Integer")
    public ApiResult updateUser(Integer id) {
        Boolean isSuccess = userSearchService.dropUser(id);
        if (isSuccess) {
            return ApiResult.success("删除成功!");
        }
        return ApiResult.error("删除失败!");
    }
}
