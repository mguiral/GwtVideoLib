package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoSuspendEvent;

public interface VideoSuspendHandler extends EventHandler {
    void onSuspend(VideoSuspendEvent event);
}
