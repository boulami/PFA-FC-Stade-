package com.projet.pfa.repositories;

import com.projet.pfa.collections.ERole;
import com.projet.pfa.collections.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
