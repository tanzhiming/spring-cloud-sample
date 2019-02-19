package com.tzm.springcloud.authserver.dao;

import com.tzm.springcloud.authserver.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface RoleMapper {

    @Select("SELECT DISTINCT r.code,r.name,r.description" +
            " FROM  user_role ur" +
            " INNER JOIN role r ON r.id = ur.role_id" +
            " WHERE ur.user_id = #{userId}")
    Set<Role> queryByUserId(long userId);
}