package com.example.RentalCars.repository;

import com.example.RentalCars.model.User;
import com.example.RentalCars.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(nativeQuery = true, value = """
				SELECT TB_USERS.email AS username, TB_USERS.password, TB_ROLE.id AS roleId, TB_ROLE.authority
				FROM TB_USERS
				INNER JOIN TB_USER_ROLE ON TB_USERS.id = TB_USER_ROLE.user_id
				INNER JOIN TB_ROLE ON TB_ROLE.id = TB_USER_ROLE.role_id
				WHERE TB_USERS.email = :email
			""")
	List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

	Optional<User> findByEmail(String email);
}
