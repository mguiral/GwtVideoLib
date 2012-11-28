package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoSeekingEvent;

public interface VideoSeekingHandler extends EventHandler {
    void onSeeking(VideoSeekingEvent event);
}
