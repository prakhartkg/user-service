package com.pinecone.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinecone.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByUserId(Long userId);

}
