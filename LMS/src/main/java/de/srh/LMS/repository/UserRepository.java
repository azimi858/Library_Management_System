package de.srh.LMS.repository;

import de.srh.LMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// QUERIES
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // SELECT * FROM user WHERE email= ***
    @Query("SELECT s FROM User s WHERE s.email = ?1")
    Optional<User> findUserByEMail(String email);
}
