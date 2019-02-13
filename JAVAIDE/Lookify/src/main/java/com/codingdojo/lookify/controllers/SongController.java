package com.codingdojo.lookify.controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;
	public  SongController(SongService songService)
	{
		this.songService=songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/songs/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.getAllSongs();
		model.addAttribute("songs", songs);
		return "/songs/dashboard.jsp";
	}
	@RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "/songs/new.jsp";

}
	
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
		
		
	@RequestMapping("/search/topten")
		public String top(Model model) 
	{
			List<Song> song = songService.findTopSongs();
			model.addAttribute("song", song);
			return "/songs/top.jsp";
		}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song  = songService.findSong(id);
		model.addAttribute("song", song);
		return "/songs/show.jsp";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
    public String create(@RequestParam("search") String search) {
    	return "redirect:/search/"+search;
	}
	
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result){
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/search/{artist}")
	public String findSongByArtist(Model model, @PathVariable("artist") String artist) {
		List<Song> songs = songService.findSongByArtist(artist);
		model.addAttribute("songs", songs);
		return "songs/search.jsp";
	}
	
	}
	

	
	
	
	
	
	
	

