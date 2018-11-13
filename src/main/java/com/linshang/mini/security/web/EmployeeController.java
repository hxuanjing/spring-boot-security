/*
 * 
 *  员工账号Controller 创建于 2018-11-02 14:35:35 版权归作者和作者当前组织所有
 */
package com.linshang.mini.security.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.puyunsoft.common.ResultData;
import com.linshang.mini.security.service.EmployeeService;
import com.linshang.mini.security.model.Employee;
import com.linshang.mini.security.condition.EmployeeCondition;

/**
*@Title: EmployeeController
*@Description: 员工账号 的web控制层
*@author codegenerator
*/
@RestController
public class EmployeeController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private EmployeeService employeeService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/security/employee/list")
    public ModelAndView list(){
        log.info("员工账号列表查询");
        ModelAndView modelAndView = new ModelAndView("security/employee/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param employeeCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/security/employee/gridData")
    @ResponseBody
    public  Page<Employee> loadList(EmployeeCondition employeeCondition, Pageable pageable){
        log.info("获取员工账号列表数据");
        Page<Employee> employeePage = employeeService.list(employeeCondition,pageable);
        return employeePage;
    }
    
    /**
     * 新增页面
     * @return 跳转到员工账号新增页面
     */
    @RequestMapping("/security/employee/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("security/employee/form");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param employee  跳转到编辑页面
     */ 
    @RequestMapping("/security/employee/edit")
    public ModelAndView editPage(Employee employee){
        log.info("员工账号编辑页面");
        employee = employeeService.find(employee.getEmployeeId());
        ModelAndView modelAndView = new ModelAndView("security/employee/form");
        modelAndView.addObject("employee", employee);
        return modelAndView ;
    }
    
    
    /**
     * 员工账号数据保存方法
     * @param employee 要保存的数据
     * @return employee 保存后的数据
     */
    @RequestMapping("/security/employee/save")
    @ResponseBody
    public ResultData save(Employee employee){
        log.info("员工账号保存");
        try {
            employeeService.save(employee);
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultData(false,"员工账号保存失败");
        }
        return new ResultData(true,"员工账号保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param employee 参数
     * @return 详情数据
     */ 
    @RequestMapping("/security/employee/details")
    @ResponseBody
    public Employee details(Employee employee){
        log.info("员工账号详细信息");
        employee = employeeService.find(employee.getEmployeeId());
        return employee;
    }
    
    /**
     * 删除数据操作组方法
     * @param employee
     * @return
     */
    @RequestMapping("/security/employee/delete")
    public ResultData delete(Employee employee){
        log.info("员工账号删除");
        try {
            employeeService.delete(employee);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultData(false, "删除失败");
        }
        return new ResultData(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param  employeeList
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/security/employee/deleteAll")
    public boolean delete(List<Employee> employeeList){
        log.info("员工账号批量删除");
        try {
            employeeService.delete(employeeList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}