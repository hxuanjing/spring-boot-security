/*
 * 
 *  Employee 创建于 2018-11-02 14:35:35 版权归作者和作者当前组织所有
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
* Employee: 员工账号 数据领域模型
* 2018-11-02 14:35:35
*@author codegenerator
*@version 1.0
*/
@Entity
@Table(name="employee")
public class Employee {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id",columnDefinition="COMMENT ''")
    private Long employeeId;

    /**
     * 
     */
    @Column(name="role_id",columnDefinition="COMMENT ''")
    private Long roleId;

    /**
     * 
     */
    @Column(name="type",columnDefinition="COMMENT ''")
    private String type;

    /**
     * 
     */
    @Column(name="phone",columnDefinition="COMMENT ''")
    private String phone;

    /**
     * 
     */
    @Column(name="pass_word",columnDefinition="COMMENT ''")
    private String passWord;

    /**
     * 
     */
    @Column(name="remark",columnDefinition="COMMENT ''")
    private String remark;

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
	* @return employeeId ：
	*/
    public Long getEmployeeId() {
        return employeeId;
    }
    /** 
    *@param employeeId 设置 
    */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

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
	* @return type ：
	*/
    public String getType() {
        return type;
    }
    /** 
    *@param type 设置 
    */
    public void setType(String type) {
        this.type = type;
    }

    /** 
	* @return phone ：
	*/
    public String getPhone() {
        return phone;
    }
    /** 
    *@param phone 设置 
    */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** 
	* @return passWord ：
	*/
    public String getPassWord() {
        return passWord;
    }
    /** 
    *@param passWord 设置 
    */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /** 
	* @return remark ：
	*/
    public String getRemark() {
        return remark;
    }
    /** 
    *@param remark 设置 
    */
    public void setRemark(String remark) {
        this.remark = remark;
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