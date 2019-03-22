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
import com.linshang.mini.security.dao.RoleRepository;
import com.linshang.mini.security.model.Role;
import com.linshang.mini.security.condition.RoleCondition;
import com.linshang.mini.security.service.RoleService;
import com.linshang.mini.security.dao.RoleDao;
/**
* RoleServiceImpl: 角色权限 业务服务层实现
* 2018-11-02 14:35:46
* @author codegenerator
* @version 1.0
*/
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private RoleDao roleDao;
    
    private RoleRepository roleRepository;
    /**
    *构造方法
    * @param roleRepository 数据容器
    */
    @Autowired
    public RoleServiceImpl( RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public Page<Role> list(RoleCondition roleCondition, Pageable pageable) {
        log.info("角色权限查询列表");
        return roleDao.list(roleCondition, pageable);
    }
    
    @Override
    public List<Role> list(RoleCondition roleCondition) {
        log.info("角色权限查询列表无分页");
        return roleDao.list(roleCondition);
    }

    @Override 
    public Role findBy(String field,Object value){
        log.info("角色权限根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return roleDao.findBy(field,value);
    }
    
    @Override 
    public List<Role> findAllBy(String field,Object value){
        log.info("角色权限根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return roleDao.findAllBy(field,value);
    }
}