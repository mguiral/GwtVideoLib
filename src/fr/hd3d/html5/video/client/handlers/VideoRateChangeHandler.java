package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoRateChangeEvent;

public interface VideoRateChangeHandler extends EventHandler {
    void onRateChange(VideoRateChangeEvent event);
}
