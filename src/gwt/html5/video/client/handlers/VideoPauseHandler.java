package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoPauseEvent;

public interface VideoPauseHandler extends EventHandler {
    void onPause(VideoPauseEvent event);
}
