package com.chinmayee.rest.web.usermanagementapi.user;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {

}