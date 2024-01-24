package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.models.DiffResources.Threads;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThreadAndPostsService {



    ////GET /api/forum/threads: Pobieranie wątków na forum.
    //    //POST /api/forum/threads: Tworzenie nowego wątku.
    //    //GET /api/forum/threads/{threadId}: Pobieranie postów w wątku.
    //    //POST /api/forum/threads/{threadId}/posts: Dodawanie posta do wątku.
    private List<Threads> threadsRepository = new ArrayList<>();

    private List<Threads> getThreadsRepository() {
        return threadsRepository;
    }



    public List<Threads> getAllThreadsFromForum()
    {
        return threadsRepository;
    }


























}
