package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoSeekingEvent;

public interface VideoSeekingHandler extends EventHandler {
    void onSeeking(VideoSeekingEvent event);
}
