package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoAbortEvent;

public interface VideoAbortHandler extends EventHandler {
    void onAbort(VideoAbortEvent event);
}
