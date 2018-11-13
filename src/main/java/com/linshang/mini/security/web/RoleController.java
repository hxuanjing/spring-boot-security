/*
 * 
 *  角色权限Controller 创建于 2018-11-02 14:35:46 版权归作者和作者当前组织所有
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
import com.linshang.mini.security.service.RoleService;
import com.linshang.mini.security.model.Role;
import com.linshang.mini.security.condition.RoleCondition;

/**
*@Title: RoleController
*@Description: 角色权限 的web控制层
*@author codegenerator
*/
@RestController
public class RoleController {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    @Resource 
    private RoleService roleService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/security/role/list")
    public ModelAndView list(){
        log.info("角色权限列表查询");
        ModelAndView modelAndView = new ModelAndView("security/role/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param roleCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/security/role/gridData")
    @ResponseBody
    public  Page<Role> loadList(RoleCondition roleCondition, Pageable pageable){
        log.info("获取角色权限列表数据");
        Page<Role> rolePage = roleService.list(roleCondition,pageable);
        return rolePage;
    }
    
    /**
     * 新增页面
     * @return 跳转到角色权限新增页面
     */
    @RequestMapping("/security/role/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("security/role/form");
        modelAndView.addObject("role", new Role());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param role  跳转到编辑页面
     */ 
    @RequestMapping("/security/role/edit")
    public ModelAndView editPage(Role role){
        log.info("角色权限编辑页面");
        role = roleService.find(role.getRoleId());
        ModelAndView modelAndView = new ModelAndView("security/role/form");
        modelAndView.addObject("role", role);
        return modelAndView ;
    }
    
    
    /**
     * 角色权限数据保存方法
     * @param role 要保存的数据
     * @return role 保存后的数据
     */
    @RequestMapping("/security/role/save")
    @ResponseBody
    public ResultData save(Role role){
        log.info("角色权限保存");
        try {
            roleService.save(role);
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
            return new ResultData(false,"角色权限保存失败");
        }
        return new ResultData(true,"角色权限保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param role 参数
     * @return 详情数据
     */ 
    @RequestMapping("/security/role/details")
    @ResponseBody
    public Role details(Role role){
        log.info("角色权限详细信息");
        role = roleService.find(role.getRoleId());
        return role;
    }
    
    /**
     * 删除数据操作组方法
     * @param role
     * @return
     */
    @RequestMapping("/security/role/delete")
    public ResultData delete(Role role){
        log.info("角色权限删除");
        try {
            roleService.delete(role);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultData(false, "删除失败");
        }
        return new ResultData(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param  roleList
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/security/role/deleteAll")
    public boolean delete(List<Role> roleList){
        log.info("角色权限批量删除");
        try {
            roleService.delete(roleList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}