package com.matome.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matome.invoice.model.Invoice;
import com.matome.invoice.model.LineItem;
import com.matome.invoice.service.InvoiceService;
import com.matome.invoice.service.LineItemService;

@RestController
@RequestMapping("invoices")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private LineItemService lineItemService;
	
	@PostMapping()
	public void addInvoice(@RequestBody Invoice invoice) {
		invoiceService.addInvoice(invoice);
	}
	
	
	@PostMapping("/lineItem")
	public void addLineItem(@RequestBody LineItem lineItem) {
		lineItemService.addLineItem(lineItem);
	}
	
	@GetMapping()
	public List<Invoice> viewAllInvoices(){
		return invoiceService.viewAllInvoices();
	}
	
	@GetMapping("{invoiceId}")
	public Invoice viewInvoice(@PathVariable long invoiceId) {
		return invoiceService.viewInvoice(invoiceId);
	}
	

}

