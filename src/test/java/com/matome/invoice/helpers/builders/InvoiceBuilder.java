package com.matome.invoice.helpers.builders;

import java.util.Date;
import java.util.List;

import com.matome.invoice.model.Invoice;
import com.matome.invoice.model.LineItem;

public class InvoiceBuilder extends AbstractEntityBuilder<Invoice> {
	private long id;
	private String client;
	private double vatRate;
	private Date invoiceDate;
	private List<LineItem> lineItems;

	public InvoiceBuilder withId(long id) {
		this.id = id;
		return this;
	}

	public InvoiceBuilder withClient(String client) {
		this.client = client;
		return this;
	}
	
	public InvoiceBuilder withVatRate(double vatRate) {
		this.vatRate = vatRate;
		return this;
	}
	
	public InvoiceBuilder withInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
		return this;
	}
	
	public InvoiceBuilder withLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
		return this;
	}

	@Override
	public Invoice build() {
		Invoice invoice = new Invoice();
		invoice.setId(id);
		invoice.setClient(client);
		invoice.setVatRate(vatRate);
		invoice.setInvoiceDate(invoiceDate);
		invoice.setLineItems(lineItems);
		
		return invoice;
	}
	
	public static InvoiceBuilder anInvoice() {
	    return new InvoiceBuilder();
	  }

}
