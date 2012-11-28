package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoSuspendEvent;

public interface VideoSuspendHandler extends EventHandler {
    void onSuspend(VideoSuspendEvent event);
}
