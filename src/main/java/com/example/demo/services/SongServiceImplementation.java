package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService {
	@Autowired
	SongRepository srepo;
	
@Override
public String addSongs(Song song) {
	srepo.save(song);
	return "Song is Created an Saved";
}
@Override
public boolean songExists(String name) {
	Song song=srepo.findByName(name);
	if(song == null)
	{
		return false;
	}
	else {
		return true;
	}
}


@Override
public List<Song> getAllSongs() {
	List<Song> songlist=srepo.findAll();
	
	return songlist;
}



}



