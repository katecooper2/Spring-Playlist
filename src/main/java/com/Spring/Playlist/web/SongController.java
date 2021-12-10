package com.Spring.Playlist.web;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Playlist.domain.Song;
import com.Spring.Playlist.service.SongService;

@RestController
public class SongController {

	private SongService service;
	
   
	
    public SongController(SongService service) {
	 super();
	 this.service = service;
 }
	
	@GetMapping("/Your Playlist:") //endpoint
	public String Playlist() {
		return "Your Playlist:";
	}
	
	
	@PostMapping("/create") // 201 created
	public ResponseEntity<Song> createSong(@RequestBody Song newSong){ 
		Song created = this.service.createSong(newSong);
		ResponseEntity<Song> response = new ResponseEntity<Song>(created, HttpStatus.CREATED);
		return response;
	
    }
	
	
	@GetMapping("/getAll") // 200
	public ResponseEntity<List<Song>> getAllnewSong(){
		return ResponseEntity.ok(this.service.getAllnewSong());
	}
	
	
	@GetMapping("/Get/{id}") // 200
	public Song getNewSong(@PathVariable Integer id) {
		return this.service.getNewSongById(id);
	}
	
	
	@GetMapping("/Get/{name}") // 200
	public Song getNewSong(@PathVariable String name) {
		return this.service.getNewSongByName(name);
	}
	
	@PutMapping("/replace/{id}") // 202 Accepted
	public ResponseEntity<Song> replaceNewSong(@PathVariable Integer id, @RequestBody Song newSong){
	Song body = this.service.replaceSong(id, newSong);
	ResponseEntity<Song> response = new ResponseEntity<Song>(body, HttpStatus.ACCEPTED);
	return response;
		
	}
	
	
	@DeleteMapping("/remove/{id}") // 204
	public ResponseEntity<?> removeSong(@PathVariable Integer id) {
		this.service.removeNewSong(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}



