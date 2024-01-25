package com.example.tibiaeventbusproject.services;

import com.example.tibiaeventbusproject.models.DiffResources.Post;
import com.example.tibiaeventbusproject.models.DiffResources.Threads;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThreadAndPostsService {







    private final static List<Threads> threadsRepository = new ArrayList<>();

    static{
        Post post1 = new Post(12,"siema tutaj pablo",2);
        Post post2 = new Post(13,"siema tutaj drugi post od pablo",2);
        Threads threads = new Threads(1,"Pierwszy watek",new ArrayList<>(List.of(post1,post2)));
        threadsRepository.add(threads);
    }

    private List<Threads> getThreadsRepository() {
        return threadsRepository;
    }


    //GET /api/forum/threads: Pobieranie wątków na forum.
    public List<Threads> getAllThreadsFromForum()
    {

        return threadsRepository;
    }
    //POST /api/forum/threads: Tworzenie nowego wątku.
    public void createNewThreads(Threads threads)
    {
        Threads newthreads = new Threads(threads.getId(),threads.getName(),new ArrayList<>());
        threadsRepository.add(newthreads);
    }

    //GET /api/forum/threads/{threadId}: Pobieranie postów w wątku
    public Threads getPostFromThreadsById(int id)
    {
        Threads findedThread = threadsRepository.stream()
                .filter(threads -> threads.getId()==id).findFirst().orElse(null);

        return findedThread;
    }


    //POST /api/forum/threads/{threadId}/posts: Dodawanie posta do wątku.
    public ResponseEntity addPostToThreadsById(int id,Post post)
    {
        Threads findedThread = threadsRepository.stream()
                .filter(threads -> threads.getId()==id).findFirst().orElse(null);

        if(findedThread!=null && post!= null)
        {
            Post nowyPost = new Post(post.getId(), post.getName(), post.getUserID());
            findedThread.getPostList().add(nowyPost);

            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


























}
