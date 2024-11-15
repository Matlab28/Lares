//package com.example.lares.client;
//
//import com.example.lares.dto.tvShow.Root;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//import java.util.List;
//
//@FeignClient(name = "tvShow", url = "https://tvshow.p.rapidapi.com/Movie/NowPlaying?Page=1&Language=en-US&Adult=true")
//public interface TvShowClient {
//    @GetMapping
//    List<Root> getShows(@RequestHeader("x-rapidapi-host") String host,
//                       @RequestHeader("x-rapidapi-key") String Key);
//}
