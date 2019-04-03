package com.servlet.async;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;
public class MyAsyncListener implements AsyncListener {

    @Override
    public void onComplete(AsyncEvent asyncEvent)  throws IOException
    {
        System.out.println("onComplete");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException
    {
        System.out.println("onError");
    }
    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException
    {
        System.out.println("onStartAsync");
    }
    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException
    {
        System.out.println("onTimeout");
    }


}
