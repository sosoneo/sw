package com.sosoneo.repository;

import com.sosoneo.model.TAdminUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sosoneo on 2017/11/28.
 */
@Repository
public interface AdminUserRepository extends JpaRepository<TAdminUserEntity, Integer> {
    @Transactional
    @Query("select adminUser from TAdminUserEntity adminUser where username=:username and password=:password")
    public TAdminUserEntity getAdminUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
