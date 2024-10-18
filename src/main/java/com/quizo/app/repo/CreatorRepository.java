package com.quizo.app.repo;

import com.quizo.app.entity.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Long> {

	Optional<Creator> findByEmail(String email);

}
