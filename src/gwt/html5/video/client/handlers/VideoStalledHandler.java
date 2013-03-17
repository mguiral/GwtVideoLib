package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoStalledEvent;

public interface VideoStalledHandler extends EventHandler {
    void onStalled(VideoStalledEvent event);
}
