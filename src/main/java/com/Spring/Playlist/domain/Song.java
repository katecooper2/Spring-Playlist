package com.Spring.Playlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", releaseDate=" + releaseDate + "]";
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
    private Integer id;
	
	private String name;
	
	private String artist;
	
	private Integer releaseDate;
	
	
	
	
	
	
	public Song(Integer id, String name, String artist, Integer releaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.releaseDate = releaseDate;
	}



	public Song(String name, String artist, Integer releaseDate) {
		super();
		this.name = name;
		this.artist = artist;
		this.releaseDate = releaseDate;
	}



	public Song() {
		super();
	}

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}


	public Integer getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Integer releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	
}


