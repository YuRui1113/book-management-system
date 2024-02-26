package com.taylor.infosys.restapi;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taylor.infosys.restapi.controllers.BookController;
import com.taylor.infosys.restapi.orm.entities.Book;
import com.taylor.infosys.restapi.services.BookService;

@WebMvcTest(BookController.class)
class BookControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BookService service;

	static List<Book> books = new ArrayList<>();

	@BeforeAll
	static void setup() {
		initialData();
	}

	@Test
	public void testGetBooksByPageAPI() throws Exception {
		Page<Book> bookPage = new PageImpl<>(books, PageRequest.of(1, 10), books.size());
		when(service.getBooksByPage(Optional.of(1), Optional.of(10))).thenReturn(bookPage);

		mvc.perform(MockMvcRequestBuilders
				.get("/api/v1/book?page=1&size=10")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.content").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.content[*].id").isNotEmpty());
	}

	@Test
	public void testCreateBookAPI() throws Exception {
		Book book = new Book("Ballinby Boys 1", "Abraham Stackhouse 1",
				(short) 2021, "989-28-3705-123-2");
		Book newBook = new Book(1020L, "Ballinby Boys 1", "Abraham Stackhouse 1",
				(short) 2021, "989-28-3705-123-2");

		when(service.createBook(Mockito.any(Book.class))).thenReturn(newBook);

		mvc.perform(MockMvcRequestBuilders.post("/api/v1/book")
				.contentType(MediaType.APPLICATION_JSON)
				.content(object2Json(book))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void testGetBookByIdAPI() throws Exception {
		Long id = 1012L;
		Book book = new Book(1012L, "9803 North Millworks Road", "Clifford Wolitzer",
				(short) 2012, "989-28-3705-987-7");

		when(service.getBookById(id)).thenReturn(book);

		mvc.perform(MockMvcRequestBuilders
				.get("/api/v1/book/{id}", id)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
	}

	@Test
	public void testUpdateBookAPI() throws Exception {
		Long id = 1012L;
		String newTitle = "UPDATE - 9803 North Millworks Road";
		Book bookForUpdate = new Book(id, newTitle, "Clifford Wolitzer",
				(short) 2012, "989-28-3705-987-7");

		when(service.updateBook(Mockito.any(Long.class), Mockito.any(Book.class))).thenReturn(bookForUpdate);

		mvc.perform(MockMvcRequestBuilders.put("/api/v1/book/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.content(object2Json(bookForUpdate))
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").value(newTitle));
	}

	@Test
	public void testDeleteBookAPI() throws Exception {
		Long id = 1012L;
		mvc.perform(MockMvcRequestBuilders.delete("/api/v1/book/{id}", id))
				.andExpect(status().isAccepted());
	}

	private static String object2Json(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static List<Book> initialData() {
		books.add(new Book(1001L, "Ballinby Boys", "Abraham Stackhouse",
				(short) 2001, "989-28-3705-007-2"));
		books.add(new Book(1002L, "Nothing But Capers", "Amelia Wangerin, Jr.",
				(short) 2002, "989-28-79-11297-4"));
		books.add(new Book(1003L, "Alanna Saves the Day", "Anastasia Inez",
				(short) 2003, "989-28-79-11297-8"));
		books.add(new Book(1004L, "Post Alley", "Arthur McCrumb",
				(short) 2004, "989-28-79-18127-7"));
		books.add(new Book(1005L, "Thatchwork Cottage", "Arturo Hijuelos",
				(short) 2005, "989-28-79-82197-5"));
		books.add(new Book(1006L, "Zero over Twelve", "Bernard Hopf",
				(short) 2006, "989-28-79-05638-4"));
		books.add(new Book(1007L, "Portmeirion", "Bianca Thompson",
				(short) 2007, "989-28-654-5018-9"));
		books.add(new Book(1008L, "Rystwyth", "Bravig Lewisohn",
				(short) 2008, "989-28-79-69807-2"));
		books.add(new Book(1009L, "The Mallemaroking", "Burton Malamud",
				(short) 2009, "989-28-79-69807-4"));
		books.add(new Book(1010L, "Can I Be Honest?", "Carolyn Segal",
				(short) 2010, "989-28-79-05670-4"));
		books.add(new Book(1011L, "No More Lightning", "Charles Fenimore",
				(short) 2011, "989-28-79-82749-6"));
		books.add(new Book(1012L, "9803 North Millworks Road", "Clifford Wolitzer",
				(short) 2012, "989-28-3705-987-7"));

		return books;
	}
}