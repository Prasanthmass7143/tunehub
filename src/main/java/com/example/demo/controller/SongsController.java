package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;


@Controller
public class SongsController {
	@Autowired
	SongService sserv;
	
	
	@PostMapping("/addsongs")
	public String addsongs(@ModelAttribute Song song) {
		
		boolean status=sserv.songExists(song.getName());
		if(status==false) {
		sserv.addSongs(song);
		System.out.println("song added");
		return "songsuccess";
		}
		else
		{
			System.out.println("Song already present try some other songs");
			return "songfail";
		}
		
	}
	

	@GetMapping("/map-viewsongs")
		public String viewSongs(Model model) {
			List<Song> songlist= sserv.getAllSongs();
			System.out.println(songlist);
			model.addAttribute("songlist",songlist);
			return "viewsongs";
			
		}
	
}
