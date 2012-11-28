package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoProgressEvent;

public interface VideoProgressHandler extends EventHandler {
    void onProgress(VideoProgressEvent event);
}
