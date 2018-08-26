package com.matome.invoice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matome.invoice.model.Invoice;

@Repository
@Transactional
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	Invoice findById(long id);

}

