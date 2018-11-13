/*
 * 
 *  Role 创建于 2018-11-02 14:35:46 版权归作者和作者当前组织所有
 */
package com.linshang.mini.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Role: 角色权限 数据领域模型
* 2018-11-02 14:35:46
*@author codegenerator
*@version 1.0
*/
@Entity
@Table(name="role")
public class Role {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id",columnDefinition="COMMENT ''")
    private Long roleId;

    /**
     * 
     */
    @Column(name="role_name",columnDefinition="COMMENT ''")
    private String roleName;

    /**
     * 
     */
    @Column(name="description",columnDefinition="COMMENT ''")
    private String description;

    /**
     * 
     */
    @Column(name="permission",columnDefinition="COMMENT ''")
    private String permission;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="created",columnDefinition="COMMENT ''")
    private Date created;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="updated",columnDefinition="COMMENT ''")
    private Date updated;


    /** 
	* @return roleId ：
	*/
    public Long getRoleId() {
        return roleId;
    }
    /** 
    *@param roleId 设置 
    */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /** 
	* @return roleName ：
	*/
    public String getRoleName() {
        return roleName;
    }
    /** 
    *@param roleName 设置 
    */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /** 
	* @return description ：
	*/
    public String getDescription() {
        return description;
    }
    /** 
    *@param description 设置 
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 
	* @return permission ：
	*/
    public String getPermission() {
        return permission;
    }
    /** 
    *@param permission 设置 
    */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /** 
	* @return created ：
	*/
    public Date getCreated() {
        return created;
    }
    /** 
    *@param created 设置 
    */
    public void setCreated(Date created) {
        this.created = created;
    }

    /** 
	* @return updated ：
	*/
    public Date getUpdated() {
        return updated;
    }
    /** 
    *@param updated 设置 
    */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }


}