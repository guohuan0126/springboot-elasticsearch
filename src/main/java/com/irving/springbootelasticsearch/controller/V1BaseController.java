package com.irving.springbootelasticsearch.controller;
import com.irving.springbootelasticsearch.dao.EmployeeRepository;
import com.irving.springbootelasticsearch.service.interf.UserSearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author irving
 * @date 2020-01-09
 */
@RequestMapping(value = "/api/v1")
public class V1BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected EmployeeRepository employeeRepository;
    @Resource
    protected UserSearchService userSearchService;
}
