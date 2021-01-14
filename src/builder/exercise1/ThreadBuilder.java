/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package builder.exercise1;

import java.util.*;

public class ThreadBuilder {
    private final Runnable target;
    private final String name;
    private ThreadGroup threadGroup = null;
    private long stackSize = 0;
    private boolean inheritThreadLocals = false;
    private Optional<Boolean> daemon = Optional.empty();
    private OptionalInt priority = OptionalInt.empty();
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;

    public ThreadBuilder(Runnable target, String name) {
        this.target = target;
        this.name = name;
    }

    public Thread build() {
        Thread thread = new Thread(threadGroup, target, name, stackSize, inheritThreadLocals);
        daemon.ifPresent(thread::setDaemon);
        priority.ifPresent(thread::setPriority);
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        return thread;
    }

    public ThreadBuilder threadGroup(ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;
        return this;
    }

    public ThreadBuilder stackSize(long stackSize) {
        this.stackSize = stackSize;
        return this;
    }

    public ThreadBuilder inheritThreadLocals(boolean inheritThreadLocals) {
        this.inheritThreadLocals = inheritThreadLocals;
        return this;
    }

    public ThreadBuilder daemon(boolean daemon) {
        this.daemon = Optional.of(daemon);
        return this;
    }

    public ThreadBuilder priority(int priority) {
        this.priority = OptionalInt.of(priority);
        return this;
    }

    public ThreadBuilder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        return this;
    }
}
