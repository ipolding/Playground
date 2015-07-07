package uk.co.ipolding.akkajavafx.config;

import akka.dispatch.DispatcherPrerequisites;
import akka.dispatch.ExecutorServiceConfigurator;
import akka.dispatch.ExecutorServiceFactory;
import com.typesafe.config.Config;
import javafx.application.Platform;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class JavaFxExecutorConfigurator extends ExecutorServiceConfigurator {
    public JavaFxExecutorConfigurator(Config config, DispatcherPrerequisites prerequisites) {
        super(config, prerequisites);
    }

    @Override
    public ExecutorServiceFactory createExecutorServiceFactory(String id, ThreadFactory threadFactory) {
        return () -> {return new JavaFxExecutorService();};
    }
}