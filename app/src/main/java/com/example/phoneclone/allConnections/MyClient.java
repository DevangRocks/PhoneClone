package com.example.phoneclone.allConnections;

import android.util.Log;

import com.example.phoneclone.CommonClass.MConstants;
import com.example.phoneclone.interfaces.ConnectionInterface;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import kotlin.jvm.internal.Intrinsics;
public final class MyClient extends Thread {
    private String hostAddress;
    private ConnectionInterface mConnectionInterface;
    private Socket socket = new Socket();

    public MyClient(InetAddress inetAddress, ConnectionInterface connectionInterface) {
        String hostAddress2 = inetAddress.getHostAddress();
        Intrinsics.checkNotNull(hostAddress2);
        this.hostAddress = hostAddress2;
        this.mConnectionInterface = connectionInterface;
    }

    public final Socket getSocket() {
        return this.socket;
    }

    public final void setSocket(Socket socket2) {
        Intrinsics.checkNotNullParameter(socket2, "<set-?>");
        this.socket = socket2;
    }

    public final String getHostAddress() {
        return this.hostAddress;
    }

    public final void setHostAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hostAddress = str;
    }

    public final ConnectionInterface getMConnectionInterface() {
        return this.mConnectionInterface;
    }

    public final void setMConnectionInterface(ConnectionInterface connectionInterface) {
        Intrinsics.checkNotNullParameter(connectionInterface, "<set-?>");
        this.mConnectionInterface = connectionInterface;
    }

    public void run() {
        try {
            this.socket.connect(new InetSocketAddress(this.hostAddress, MConstants.PORT), 500);
            MySocketHandler.Companion.setSocket(this.socket);
            this.mConnectionInterface.onConnectionSuccessful();
        } catch (Exception e) {
            Log.e("abc", "Exception Client: " + e.getMessage());
        }
    }
}
