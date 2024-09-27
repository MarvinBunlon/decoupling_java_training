package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("target/captain.log");

        Predicate<String> fileCondition = message -> !message.contains("player");

        Logger filteredFileLogger = new FilteredLogger(new ContextualLogger(name, fileLogger), fileCondition);
        Logger contextualConsoleLogger = new ContextualLogger(name, consoleLogger);

        return new CompositeLogger(contextualConsoleLogger, filteredFileLogger);
    }
}