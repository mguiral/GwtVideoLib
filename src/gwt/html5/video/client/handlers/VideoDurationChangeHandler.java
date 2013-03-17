package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoDurationChangeEvent;

public interface VideoDurationChangeHandler extends EventHandler {
    void onDurationChange(VideoDurationChangeEvent event);
}
