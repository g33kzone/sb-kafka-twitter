package com.g33kzone.kaftwit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g33kzone.kaftwit.service.TwitterService;

import twitter4j.TwitterException;

@RestController
@RequestMapping(value = "/twitter/")
public class TwitterController {

	@Autowired
	private TwitterService twitterService;
	
	@GetMapping(value = "/search")
	public List<String> producer(@RequestParam("query") String query) throws TwitterException {
		
		List<String> tweets = twitterService.searchTweets(query);
		
		return tweets;
	}
	
	@GetMapping(value = "/stream")
	public String stream(@RequestParam("query") String query) throws InterruptedException {
		
		twitterService.streamFeed(query);
		
		return "Twitter Streaming to console...";
	}
}
