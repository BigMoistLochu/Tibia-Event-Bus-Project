package com.example.tibiaeventbusproject.restApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/forum")
public class ThreadAndPostsRestController {


    //GET /api/forum/threads: Pobieranie wątków na forum.
    //POST /api/forum/threads: Tworzenie nowego wątku.
    //GET /api/forum/threads/{threadId}: Pobieranie postów w wątku.
    //POST /api/forum/threads/{threadId}/posts: Dodawanie posta do wątku.



}
