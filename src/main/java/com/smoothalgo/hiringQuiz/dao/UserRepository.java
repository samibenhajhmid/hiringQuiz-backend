package com.smoothalgo.hiringQuiz.dao;


import com.smoothalgo.hiringQuiz.entities.User;
import com.smoothalgo.hiringQuiz.enumerations.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   public Optional<User> findByEmail(String email);
   // boolean existsByEmail(String email);
   public User findByEmailAndPassword(String email, String password);
   public List<User> findByRole(Role role);
   @Transactional
   @Modifying
   @Query("UPDATE User u " +
           "SET u.enabled = TRUE WHERE u.email = ?1")
   int enableUser(String email);

}
