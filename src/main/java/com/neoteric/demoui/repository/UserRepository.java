package com.neoteric.demoui.repository;
import com.neoteric.demoui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
