package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoWaitingEvent;

public interface VideoWaitingHandler extends EventHandler {
    void onWaiting(VideoWaitingEvent event);
}
