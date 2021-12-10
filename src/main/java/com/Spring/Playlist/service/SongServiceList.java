//package com.Spring.Playlist.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.Spring.Playlist.domain.Song;
//
//public class SongServiceList implements SongService{
//	
//	
//private List<Song> newSong = new ArrayList<>();
//	
//@Override
//	public Song createSong( Song newSong) {
//		this.newSong.add(newSong);
//		Song created = this.newSong.get(this.newSong.size()-1);
//		return created;
//    }
//	
//@Override
//	public List<Song> getAllnewSong(){
//		return this.newSong;
//	}
//	
//	
//@Override
//	public Song getNewSongById( Integer id) {
//		return this.getNewSongById(id);
//	}
//	
//
//@Override
//	public Song getNewSong( String name) {
//		return null;
//	}
//	
//@Override
//	public Song replaceSong( Integer id, Song newSong) {
//		System.out.println("ID: " + id);
//		System.out.println("NEW SONG: " + newSong);
//		return null;
//	}
//	
//@Override
//	public void removeNewSong( Integer id) {
//		System.out.println("ID :" + id);
//	}
//
//@Override
//public Song getNewSongById(Integer id) {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public Song getNewSongByName(String name) {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//}
//
//
