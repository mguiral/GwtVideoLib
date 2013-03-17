package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoRateChangeEvent;

public interface VideoRateChangeHandler extends EventHandler {
    void onRateChange(VideoRateChangeEvent event);
}
