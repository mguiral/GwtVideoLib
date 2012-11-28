package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoDurationChangeEvent;

public interface VideoDurationChangeHandler extends EventHandler {
    void onDurationChange(VideoDurationChangeEvent event);
}
