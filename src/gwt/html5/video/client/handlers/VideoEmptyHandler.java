package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoEmptyEvent;

public interface VideoEmptyHandler extends EventHandler {
    void onEmptyState(VideoEmptyEvent event);
}
