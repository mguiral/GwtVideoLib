package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoErrorEvent;

public interface VideoErrorHandler extends EventHandler {
    void onError(VideoErrorEvent event);
}
