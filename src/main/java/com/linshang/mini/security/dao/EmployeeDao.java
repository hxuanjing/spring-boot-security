/*
 * 
 *  EmployeeDao 创建于 2018-11-02 14:35:35 版权归作者和作者当前组织所有
 */
package com.linshang.mini.security.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.linshang.mini.security.condition.EmployeeCondition;
import com.linshang.mini.security.model.Employee;
/**
* EmployeeDao:员工账号 数据持久层接口
* @author codegenerator
* @version 1.0
*/
public interface EmployeeDao extends SpringDataQueryDao<Employee>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param employee 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     * 
     */
    Page<Employee> list(EmployeeCondition employee,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param employee 查询类
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     */
    List<Employee> list(EmployeeCondition employee);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param employee Employee类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(EmployeeCondition employee,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Employee 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author codegenerator
     * 
     * 
     */
    Employee findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Employee 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author codegenerator
     * 
     * 
     */
    List<Employee> findAllBy(String field,Object value);
    
    

}