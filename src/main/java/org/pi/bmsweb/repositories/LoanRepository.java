package org.pi.bmsweb.repositories;

import org.pi.bmsweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<User, Long> {
}
