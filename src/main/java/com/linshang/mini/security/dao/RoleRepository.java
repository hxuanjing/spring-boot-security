/*
 *  RoleRepository 创建于 2018-11-02 14:35:46 版权归作者和作者当前组织所有
 */
package com.linshang.mini.security.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.linshang.mini.security.model.Role;

/**
* RoleRepository: 角色权限 数据资源层
* 2018-11-02 14:35:46
* @author codegenerator
* @version 1.0
*/
public interface RoleRepository extends JpaRepository<Role, Long>{


}