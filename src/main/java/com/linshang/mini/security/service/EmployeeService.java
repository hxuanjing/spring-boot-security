package com.linshang.mini.security.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.linshang.mini.security.model.Employee;
import com.linshang.mini.security.condition.EmployeeCondition;

/**
* EmployeeService: 员工账号 业务服务层接口
*2018-11-02 14:35:35
*@author codegenerator
*@version 1.0
*/
public interface EmployeeService extends BaseService<Employee, Long> {
    /**
     * 生成的列表分页查询方法
     * @param employeeCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author codegenerator
     * 
     */
    Page<Employee> list(EmployeeCondition employeeCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  employee 查询类
     * @return 查询的结果集
     * @author codegenerator
     * 
     */
    public List<Employee> list(EmployeeCondition employee);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Employee 中的某个字段
     * @param value 字段的值
     * @return Employee 返回符合条件的结果，如果没有返回null
     * @author codegenerator
     * 
     * 
     */
    Employee findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Employee中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author codegenerator
     * 
     * 
     */
    List<Employee> findAllBy(String field,Object value);
}