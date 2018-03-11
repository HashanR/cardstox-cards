package com.cardstox.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface test extends JpaRepository<testingDao, Integer>{

}
