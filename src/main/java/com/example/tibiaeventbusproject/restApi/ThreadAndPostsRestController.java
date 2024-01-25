package com.example.tibiaeventbusproject.restApi;

import com.example.tibiaeventbusproject.models.DiffResources.Post;
import com.example.tibiaeventbusproject.models.DiffResources.Threads;
import com.example.tibiaeventbusproject.services.ThreadAndPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/forum")
public class ThreadAndPostsRestController {


    //GET /api/forum/threads: Pobieranie wątków na forum.
    //POST /api/forum/threads: Tworzenie nowego wątku.
    //GET /api/forum/threads/{threadId}: Pobieranie postów w wątku.
    //POST /api/forum/threads/{threadId}/posts: Dodawanie posta do wątku.


    private ThreadAndPostsService service;

    @Autowired
    public ThreadAndPostsRestController(ThreadAndPostsService service) {
        this.service = service;
    }

    //GET /api/forum/threads: Pobieranie wątków na forum.
    @GetMapping("/threads")
    public List<Threads> getAllThreads()
    {

        return service.getAllThreadsFromForum();
    }

    @PostMapping("/threads")
    public void createThreads(@RequestBody Threads threads)
    {
        service.createNewThreads(threads);
    }


    //GET /api/forum/threads/{threadId}: Pobieranie postów w wątku.
    @GetMapping("/threads/{threadId}")
    public ResponseEntity<List<Post>> getAllPostByThreadId(@PathVariable int threadId)
    {
        Threads posts = service.getPostFromThreadsById(threadId);

        if (posts != null) {

            return new ResponseEntity<>(posts.getPostList(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/threads/{threadId}/posts")
    public ResponseEntity getAllPostByThreadId(@PathVariable int threadId,@RequestBody Post post)
    {
        return service.addPostToThreadsById(threadId,post);
    }


}
