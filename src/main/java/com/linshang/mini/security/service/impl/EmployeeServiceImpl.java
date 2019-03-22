package com.linshang.mini.security.service.impl;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.linshang.mini.security.dao.EmployeeRepository;
import com.linshang.mini.security.model.Employee;
import com.linshang.mini.security.condition.EmployeeCondition;
import com.linshang.mini.security.service.EmployeeService;
import com.linshang.mini.security.dao.EmployeeDao;
/**
* EmployeeServiceImpl: 员工账号 业务服务层实现
* 2018-11-02 14:35:35
* @author codegenerator
* @version 1.0
*/
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long> implements EmployeeService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private EmployeeDao employeeDao;
    
    private EmployeeRepository employeeRepository;
    /**
    *构造方法
    * @param employeeRepository 数据容器
    */
    @Autowired
    public EmployeeServiceImpl( EmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<Employee> list(EmployeeCondition employeeCondition, Pageable pageable) {
        log.info("员工账号查询列表");
        return employeeDao.list(employeeCondition, pageable);
    }
    
    @Override
    public List<Employee> list(EmployeeCondition employeeCondition) {
        log.info("员工账号查询列表无分页");
        return employeeDao.list(employeeCondition);
    }

    @Override 
    public Employee findBy(String field,Object value){
        log.info("员工账号根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return employeeDao.findBy(field,value);
    }
    
    @Override 
    public List<Employee> findAllBy(String field,Object value){
        log.info("员工账号根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return employeeDao.findAllBy(field,value);
    }
}