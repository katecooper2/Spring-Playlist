package com.Spring.Playlist.web;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.Spring.Playlist.domain.Song;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:song-schema-sql.sql",
"classpath:song-data-sql.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class SongControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Test
	void testCreate() throws Exception{
		Song testSong = new Song( "Umbrella",  "Rihanna", 2008);
		String testSongAsJSON = this.mapper.writeValueAsString(testSong);
		RequestBuilder req = post( "/create").contentType(MediaType.APPLICATION_JSON).content(testSongAsJSON);
		
		
		Song testCreateSong = new Song(2, "Umbrella", "Rihanna", 2008);
		String testCreatedSongAsJSON = this.mapper.writeValueAsString(testCreateSong);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedSongAsJSON);
		
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
		@Test
		void getAllTest() throws Exception{
			List<Song>testSong = List.of(new Song(1,  "Umbrella",  "rihanna",2008));
			String json = this.mapper.writeValueAsString(testSong);
			
			RequestBuilder req = get( "/getAll");
					ResultMatcher checkStatus = status().isOk();
			        ResultMatcher checkBody = content().json(json);
			        
			        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
//		
//		@Test
//		void getByIdTest() throws Exception{
//			List<Song> testSong = List.of(new Song(1, "Umbrella", "rihanna", 2008));
//			String json = this.mapper.writeValueAsString(testSong);
//			
//			RequestBuilder req = get("/get/{id}");
//			ResultMatcher checkStatus = status().isOk();
//			ResultMatcher checkBody = content().json(json);
//			
//			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//			
//		}



     @Test
      void testReplace() throws Exception{
    	 Song testSong = new Song(1, "Disterbia", "rihanna", 2008);
    	 String json = this.mapper.writeValueAsString(testSong);
    	 
    	 RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_PROBLEM_JSON).content(json);
    	 ResultMatcher checkStatus = status().isAccepted();
    	 ResultMatcher checkBody = content().json(json);
    	 this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    	 
     }
     
     
     @Test
     void testDelete() throws Exception{
    	 RequestBuilder req = delete("/remove/1").contentType(MediaType.APPLICATION_PROBLEM_JSON);
    	 ResultMatcher checkStatus = status().isNoContent();
    	 this.mvc.perform(req).andExpect(checkStatus);
     }

	
}