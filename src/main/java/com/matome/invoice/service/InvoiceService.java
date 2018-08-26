package com.matome.invoice.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matome.invoice.model.Invoice;
import com.matome.invoice.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public void addInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
		
	}
	
	public List<Invoice> viewAllInvoices() {
		List<Invoice> invoices = new ArrayList<>();
		invoiceRepository.findAll()
		    .forEach(invoices::add);
		return invoices;
	}
	
	public Invoice viewInvoice(long id) {
		if (invoiceRepository.findById(id) == null) {
			throw new NoResultException();
		}
		return invoiceRepository.findById(id);
	}
}
