package com.matome.invoice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matome.invoice.model.LineItem;;

@Repository
@Transactional
public interface LineItemRepository extends JpaRepository<LineItem, Long> {
	LineItem findById(long id);

}
