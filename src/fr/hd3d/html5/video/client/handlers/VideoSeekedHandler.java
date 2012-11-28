package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoSeekedEvent;

public interface VideoSeekedHandler extends EventHandler {
    void onSeeked(VideoSeekedEvent event);
}
