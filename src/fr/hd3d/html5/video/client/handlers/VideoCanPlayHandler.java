package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoCanPlayEvent;

public interface VideoCanPlayHandler extends EventHandler {
    void onCanPlay(VideoCanPlayEvent event);
}
