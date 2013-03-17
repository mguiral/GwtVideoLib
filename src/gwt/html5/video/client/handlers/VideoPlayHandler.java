package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoPlayEvent;

public interface VideoPlayHandler extends EventHandler {
    void onPlay(VideoPlayEvent event);
}
