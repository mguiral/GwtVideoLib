package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoAbortEvent;

public interface VideoAbortHandler extends EventHandler {
    void onAbort(VideoAbortEvent event);
}
