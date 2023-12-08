package com.example.phoneclone.allConnections;

import android.util.Log;

import com.example.phoneclone.CommonClass.MConstants;
import com.example.phoneclone.interfaces.ConnectionInterface;
import java.net.ServerSocket;
import java.net.Socket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

public final class MyServer extends Thread {
    private final String TAG = getClass().getCanonicalName();
    private final ConnectionInterface connectionInterface;
    private ServerSocket serverSocket;
    private Socket socket;

    public MyServer(ConnectionInterface connectionInterface2) {
        Intrinsics.checkNotNullParameter(connectionInterface2, "connectionInterface");
        this.connectionInterface = connectionInterface2;
    }

    public final Socket getSocket() {
        return this.socket;
    }

    public final void setSocket(Socket socket2) {
        this.socket = socket2;
    }

    public final ServerSocket getServerSocket() {
        return this.serverSocket;
    }

    public final void setServerSocket(ServerSocket serverSocket2) {
        this.serverSocket = serverSocket2;
    }

    public void run() {
        try {
            ServerSocket serverSocket2 = this.serverSocket;
            if (serverSocket2 != null) {
                serverSocket2.setReuseAddress(true);
            }
            ServerSocket serverSocket3 = new ServerSocket(MConstants.PORT);
            this.serverSocket = serverSocket3;
            Intrinsics.checkNotNull(serverSocket3);
            this.socket = serverSocket3.accept();
            MySocketHandler.Companion companion = MySocketHandler.Companion;
            Socket socket2 = this.socket;
            Intrinsics.checkNotNull(socket2);
            companion.setSocket(socket2);
            this.connectionInterface.onConnectionSuccessful();
        } catch (Exception e) {
            String str = this.TAG;
            Log.e(str, "Exception server 1: " + e.getMessage());
        }
    }
}
