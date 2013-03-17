package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoLoadStartEvent;

public interface VideoLoadStartHandler extends EventHandler {
    void onLoadStart(VideoLoadStartEvent event);
}
