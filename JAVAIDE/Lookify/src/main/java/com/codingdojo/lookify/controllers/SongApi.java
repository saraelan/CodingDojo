package com.codingdojo.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@RestController
@RequestMapping("/api")
public class SongApi {
	private final SongService songService;
	
	public SongApi(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/songs")
	public List<Song> index(){
		return songService.getAllSongs();
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
    public Song create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") Integer rating) {
        Song song = new Song(title, artist, rating);
        return songService.createSong(song);
    }
	
	@RequestMapping("/songs/{id}")
    public Song show(@PathVariable("id") Long id) {
        Song song = songService.findSong(id);
        return song;
    }
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public Song update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") Integer rating) {
        Song song = songService.updateSong(id, title, artist, rating);
        return song;
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
    }
    
    
}