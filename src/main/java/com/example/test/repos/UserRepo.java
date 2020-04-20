package com.example.test.repos;

import com.example.test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
   List<User> findAllByOrderByIdAsc();
   List<User> findByActive(String status);
   List<User> findByTimestampGreaterThan(Date timestamp);
   List<User> findByTimestampGreaterThanAndActive(Date date,String status);
}
