package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//test will fail first, but:

@SpringBootTest
@AutoConfigureMockMvc
public class Sample03MockMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookingService bookingService; //injected mock bean instead of real bean here
	//after that 0 returned, and test still failed, but:

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		// given
		when(bookingService.getAvailablePlaceCount()).thenReturn(10); //so here we return 10 for our mock bean
		//which is the value we have been expecting
		//only now test should pass!
		// when
		this.mockMvc.perform(get("/greeting"))
			.andDo(print())
		
		// then
			.andExpect(status().isOk())
			.andExpect(content().string("Greetings from The Happy Hotel. We've got enough beds for 10 guests!"));
	}
}