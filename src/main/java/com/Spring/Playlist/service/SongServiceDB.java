package com.Spring.Playlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Playlist.domain.Song;
import com.Spring.Playlist.repo.SongRepo;

@Service
public class SongServiceDB implements SongService{

	private SongRepo repo;
	
	
	@Autowired
	public SongServiceDB(SongRepo repo) {
		super();
		this.repo = repo;
	}


	@Override
	public Song createSong(Song newSong) {
		
		return this.repo.save(newSong);
	}


	@Override
	public List<Song> getAllnewSong() {
		
		return this.repo.findAll();
	}


	@Override
	public Song getNewSongById(Integer id) {
		
		return this.repo.getById(id) ;
	}


	@Override
	public Song getNewSongByName(String name) {
		
		return this.repo.getAllByName(name);
	}


	@Override
	public Song replaceSong(Integer id, Song newSong) {
		Song existing = this.repo.getById(id);
		existing.setArtist(newSong.getArtist());
		existing.setName(newSong.getName());
		existing.setReleaseDate(newSong.getReleaseDate());
		return this.repo.save(existing);
	}


	@Override
	public void removeNewSong(Integer id) {
	this.repo.deleteById(id);
		
	}
	
}
