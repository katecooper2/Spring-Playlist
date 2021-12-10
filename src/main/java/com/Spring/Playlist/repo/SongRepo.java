package com.Spring.Playlist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Playlist.domain.Song;


@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
	
	Song getAllByName(String name);
	

}
