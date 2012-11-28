package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoLoadStartEvent;

public interface VideoLoadStartHandler extends EventHandler {
    void onLoadStart(VideoLoadStartEvent event);
}
