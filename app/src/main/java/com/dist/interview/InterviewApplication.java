package com.dist.interview;

import net.thevpc.nuts.NApplication;
import net.thevpc.nuts.NSession;
import net.thevpc.nuts.io.NPrintStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.dist.interview.javacc.dal.mongodb.repo")
@SpringBootApplication
public class InterviewApplication implements NApplication {
    @Autowired
    private Toz fik;
    public static void main(String[] args) {
        SpringApplication.run(InterviewApplication.class, args);
    }
    @Override
    public void run(NSession session) {
        NPrintStream out = session.out();
        out.println("Let's get it started \uD83D\uDE80\uD83D\uDE80");
    }
}

