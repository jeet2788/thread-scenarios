package com.thread.threadlocal;

class UserContextHolder {
    static ThreadLocal<UserContext> user = new ThreadLocal<>();
}
