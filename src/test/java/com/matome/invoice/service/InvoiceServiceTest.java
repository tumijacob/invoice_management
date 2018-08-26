package com.matome.invoice.service;

import static com.matome.invoice.helpers.builders.InvoiceBuilder.anInvoice;
import static com.matome.invoice.helpers.builders.LineItemBuilder.aLineItem;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.matome.invoice.controller.InvoiceController;
import com.matome.invoice.model.Invoice;
import com.matome.invoice.model.LineItem;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceServiceTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private InvoiceService service;
	
	@Ignore
	public void testWhenGivenInvoices_thenReturnJsonArray() throws Exception {
		List<LineItem> lineItems = Arrays.asList(
				                 aLineItem()
				                  .withId(1L)
				                  .withDescription("Shoes")
				                  .withQuantity(2)
				                  .withUnitPrice(450.99)
				                  .build()
				                  );
			
		List<Invoice> invoices = Arrays.asList(
				          anInvoice()
				              .withId(1L)
				              .withClient("Sports wear")
				              .withInvoiceDate(new Date())
				              .withLineItems(lineItems)
				              .withVatRate(0.15)
				              .build()				              
				   
				);
		
		//given(service.viewAllInvoices()).willReturn(invoices);
		mvc.perform(get("invoices")
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$[0].client", is(invoices.get(0).getClient().toString())));
	}
	
/**
 *  Add unit tests for Post 
 **/	
	

}
