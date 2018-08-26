package com.matome.invoice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String client;
	private double vatRate;
	
	@Temporal(TemporalType.DATE)
	private Date invoiceDate;
	
	@OneToMany
	private List<LineItem> lineItems; 
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	public double getVatRate() {
		return vatRate;
	}
	
	public void setVatRate(double vatRate) {
		this.vatRate = vatRate;
	}
	
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public BigDecimal getSubtotal() {
		double subTotal = 0.0;
		for (LineItem item: lineItems) {
			subTotal += Double.parseDouble(item.getItemTotal().toString());
		}
		return convertToDecimal(subTotal);
	}
	
	public BigDecimal getVat() {
		double vat = vatRate * Double.parseDouble(getSubtotal().toString());
		return convertToDecimal(vat);
	}
	
	public BigDecimal getTotal() {
		double total = Double.parseDouble(getSubtotal().toString()) + Double.parseDouble(getVat().toString());
		return convertToDecimal(total);
	}
	
	private BigDecimal convertToDecimal(double num) {
		return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}