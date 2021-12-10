package com.Spring.Playlist.service;


import java.util.List;

import com.Spring.Playlist.domain.Song;

public interface SongService {

	
	//create
	public Song createSong( Song newSong);
	
	//get all
	public List<Song> getAllnewSong();
	
	//get by id
	public Song getNewSongById( Integer id);
	
	//get by name
	public Song getNewSongByName( String name);
	
	//replace
	public Song replaceSong( Integer id, Song newSong);
	
	//remove
	public void removeNewSong( Integer id);

}
