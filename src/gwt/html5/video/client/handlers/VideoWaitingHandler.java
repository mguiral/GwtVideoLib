package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoWaitingEvent;

public interface VideoWaitingHandler extends EventHandler {
    void onWaiting(VideoWaitingEvent event);
}
