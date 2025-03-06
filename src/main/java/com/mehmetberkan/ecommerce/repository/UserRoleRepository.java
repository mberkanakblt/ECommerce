package com.mehmetberkan.ecommerce.repository;

import com.mehmetberkan.ecommerce.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUserId(Long id);
}
