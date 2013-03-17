package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoErrorEvent;

public interface VideoErrorHandler extends EventHandler {
    void onError(VideoErrorEvent event);
}
