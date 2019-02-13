package com.codingdojo.lookify.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repository.SongRepository;



@Service
public class SongService {
	private final SongRepository songRepository;

	
	 
	 public SongService(SongRepository songRepository) {
			this.songRepository = songRepository;
		}
		
	 
	 public ArrayList<Song> getAllSongs() {
		return (ArrayList<Song>) songRepository.findAll();
		}
	 

	 
	 public Song findSong(Long id) {
	        Optional<Song> optionalSong = songRepository.findById(id);
	        if(optionalSong.isPresent()) {
	            return optionalSong.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public void deleteSong(Long id) {
			songRepository.deleteById(id);
		}
	 
	 public Song updateSong(Long id, String title, String artist, int rating) {
			Optional<Song> optionalSong = songRepository.findById(id);
			if(optionalSong.isPresent()) 
			{	
				Song song =optionalSong.get();
				song.setTitle(title);
				song.setArtist(artist);
				song.setRating(rating);
				
				return songRepository.save(song);
		    
				
			}
			else
			{
				return null;
			}
			
			
		}
	 
	 public List<Song> findSongByArtist(String artist) {
			return songRepository.findByArtistContaining(artist);
		}
		
		public List<Song> findTopSongs() {
			return songRepository.findTop10ByOrderByRatingDesc();
		}
		
		public  Song createSong( Song s) {
            return songRepository.save(s);
        }
	 
	 
	 
}
