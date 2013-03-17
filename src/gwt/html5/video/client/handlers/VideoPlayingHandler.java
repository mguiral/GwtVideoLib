package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoPlayingEvent;

public interface VideoPlayingHandler extends EventHandler {
    void onPlaying(VideoPlayingEvent event);
}
