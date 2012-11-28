package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoEndedEvent;

public interface VideoEndedHandler extends EventHandler {
    void onVideoEnded(VideoEndedEvent event);
}
