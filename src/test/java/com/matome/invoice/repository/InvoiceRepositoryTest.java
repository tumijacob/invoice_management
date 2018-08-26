package com.matome.invoice.repository;


import static com.matome.invoice.helpers.builders.InvoiceBuilder.anInvoice;
import static com.matome.invoice.helpers.builders.LineItemBuilder.aLineItem;
import static com.matome.invoice.helpers.matchers.InvoiceMatcher.hasSameStateAsInvoice;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.matome.invoice.Application;
import com.matome.invoice.model.Invoice;
import com.matome.invoice.model.LineItem;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes= {Application.class})
public class InvoiceRepositoryTest {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private LineItemRepository lineItemRepository;
	
	@Test
	  public void testFindByIdWithExistingInvoice_shouldReturnExistingInvoice() {
	    // Set up
		List<LineItem> lineItems = Arrays.asList(
				        lineItemRepository.save(aLineItem()
						        .withId(1L)
						        .withDescription("Clothes")
						        .withQuantity(4)
						        .withUnitPrice(120.99)
						        .build())
				);
		
	    Invoice invoice = anInvoice()
	        .withClient("Edgars")
	        .withInvoiceDate(new Date())
	        .withVatRate(0.14)
	        .withLineItems(lineItems)
	        .build();
	    invoiceRepository.save(invoice);

	    // Test
	    Invoice returnedInvoice = invoiceRepository.findById(invoice.getId());

	    // Verify
	    assertThat(invoice, hasSameStateAsInvoice(returnedInvoice));
	  }
	
//	@Test(expected = NoResultException.class)
//	  public void testFindInvoiceByIdWithNoExistingInvoice_shouldThrow() {
//	    // Test
//		invoiceRepository.findById(852L);
//	  }
	
	/**
	 * Add more unit tests to cover all scenarios
	 * 
	 **/


}
