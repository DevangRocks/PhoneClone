package com.example.phoneclone.allConnections;

import java.net.Socket;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
public final class MySocketHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static Socket socket;

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public synchronized Socket getSocket() {
            return MySocketHandler.socket;
        }

        public synchronized void setSocket(Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            MySocketHandler.socket = socket;
        }
    }
}
