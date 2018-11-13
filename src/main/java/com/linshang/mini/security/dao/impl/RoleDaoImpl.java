/*
 * 
 *  RoleDaoImpl 创建于 2018-11-02 14:35:46 版权归作者和作者当前组织所有
 */
package com.linshang.mini.security.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.linshang.mini.security.model.Role;
import com.linshang.mini.security.dao.RoleDao;

import com.linshang.mini.security.condition.RoleCondition;



/**
* RoleDaoImpl: 角色权限 数据持久层接口实现
*@author codegenerator
*@version 1.0
*
*/
@Repository
public class RoleDaoImpl extends SpringDataQueryDaoImpl<Role> implements RoleDao {
    
    
    public RoleDaoImpl(){
        super(Role.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param roleCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     */
    @Override 
    public Page<Role> list(RoleCondition roleCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Role model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Role> list(RoleCondition roleCondition){
        StringBuffer sb=new StringBuffer("select model from Role model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RoleCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select role_id,role_name,description,permission,created,updated from role  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Role findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Role model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Role> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Role> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Role model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}