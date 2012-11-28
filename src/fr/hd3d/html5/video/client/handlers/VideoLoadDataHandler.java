package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoLoadDataEvent;

public interface VideoLoadDataHandler extends EventHandler {
    void onDataLoaded(VideoLoadDataEvent event);
}
