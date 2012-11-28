package fr.hd3d.html5.video.client;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

import fr.hd3d.html5.video.client.VideoSource.VideoType;
import fr.hd3d.html5.video.client.dom.VideoElement;
import fr.hd3d.html5.video.client.dom.VideoSourceElement;
import fr.hd3d.html5.video.client.events.VideoAbortEvent;
import fr.hd3d.html5.video.client.events.VideoCanPlayEvent;
import fr.hd3d.html5.video.client.events.VideoCanPlayThroughEvent;
import fr.hd3d.html5.video.client.events.VideoDurationChangeEvent;
import fr.hd3d.html5.video.client.events.VideoEmptyEvent;
import fr.hd3d.html5.video.client.events.VideoEndedEvent;
import fr.hd3d.html5.video.client.events.VideoErrorEvent;
import fr.hd3d.html5.video.client.events.VideoLoadDataEvent;
import fr.hd3d.html5.video.client.events.VideoLoadMetadataEvent;
import fr.hd3d.html5.video.client.events.VideoLoadStartEvent;
import fr.hd3d.html5.video.client.events.VideoPauseEvent;
import fr.hd3d.html5.video.client.events.VideoPlayEvent;
import fr.hd3d.html5.video.client.events.VideoPlayingEvent;
import fr.hd3d.html5.video.client.events.VideoProgressEvent;
import fr.hd3d.html5.video.client.events.VideoRateChangeEvent;
import fr.hd3d.html5.video.client.events.VideoSeekedEvent;
import fr.hd3d.html5.video.client.events.VideoSeekingEvent;
import fr.hd3d.html5.video.client.events.VideoStalledEvent;
import fr.hd3d.html5.video.client.events.VideoSuspendEvent;
import fr.hd3d.html5.video.client.events.VideoTimeUpdateEvent;
import fr.hd3d.html5.video.client.events.VideoVolumeChangeEvent;
import fr.hd3d.html5.video.client.events.VideoWaitingEvent;
import fr.hd3d.html5.video.client.handlers.HasVideoHandlers;
import fr.hd3d.html5.video.client.handlers.VideoAbortHandler;
import fr.hd3d.html5.video.client.handlers.VideoCanPlayHandler;
import fr.hd3d.html5.video.client.handlers.VideoCanPlayThroughHandler;
import fr.hd3d.html5.video.client.handlers.VideoDurationChangeHandler;
import fr.hd3d.html5.video.client.handlers.VideoEmptyHandler;
import fr.hd3d.html5.video.client.handlers.VideoEndedHandler;
import fr.hd3d.html5.video.client.handlers.VideoErrorHandler;
import fr.hd3d.html5.video.client.handlers.VideoLoadDataHandler;
import fr.hd3d.html5.video.client.handlers.VideoLoadMetadataHandler;
import fr.hd3d.html5.video.client.handlers.VideoLoadStartHandler;
import fr.hd3d.html5.video.client.handlers.VideoPauseHandler;
import fr.hd3d.html5.video.client.handlers.VideoPlayHandler;
import fr.hd3d.html5.video.client.handlers.VideoPlayingHandler;
import fr.hd3d.html5.video.client.handlers.VideoProgressHandler;
import fr.hd3d.html5.video.client.handlers.VideoRateChangeHandler;
import fr.hd3d.html5.video.client.handlers.VideoSeekedHandler;
import fr.hd3d.html5.video.client.handlers.VideoSeekingHandler;
import fr.hd3d.html5.video.client.handlers.VideoStalledHandler;
import fr.hd3d.html5.video.client.handlers.VideoSuspendHandler;
import fr.hd3d.html5.video.client.handlers.VideoTimeUpdateHandler;
import fr.hd3d.html5.video.client.handlers.VideoVolumeChangeHandler;
import fr.hd3d.html5.video.client.handlers.VideoWaitingHandler;

/**
 * A standard HTML5 video widget
 * 
 * @author michael.guiral
 * 
 */
public class VideoWidget extends Widget implements HasVideoHandlers {
    // private static final String UNSUPPORTED_VIDEO_TAG =
    // "Sorry, your browser does not support the &lt;video&gt; element.";
    private VideoElement videoElement;
    // private Element unsupportedElement;
    private HandlerManager videoHandlerManager;
    private VideoSourceElement sourceElement;
    private int frameRate;

    public enum TypeSupport {
        NO, PROBABLY, MAYBE;
    }

    /**
     * Create a default video HTML tag <br/>
     * <br/>
     * Default values<br/>
     * <li>autoPlay : false</li> <li>controls : false</li> <li>poster : null</li>
     */
    public VideoWidget() {
        this(false, false, null);
    }

    /**
     * @param autoPlay
     *            <b>true</b> if you want the user agent automatically begin playback of the media resource as soon as
     *            it can do so without stopping. <b>false</b> otherwise
     * @param controls
     *            - <b>false</b> if you want to have custom scripted controller, <b>true</b> if you would like the user
     *            agent to provide its own set of controls.
     * @param poster
     *            - <b>The image file address</b> that the user agent can show while no video data is available
     */
    public VideoWidget(boolean autoPlay, boolean controls, String poster) {
        super();
        videoElement = VideoElement.as(DOM.createElement(VideoElement.TAG));
        this.videoHandlerManager = new HandlerManager(this);
        setDefaultPlaybackRate(1);
        setElement(videoElement);
        // addUnsupportedMessage();
        setAutoPlay(autoPlay);
        setControls(controls);
        setPoster(poster);
    }

    /**
     * @param poster
     *            represent the address of an image file that the user agent can show while no video data is available
     */
    public void setPoster(String poster) {
        if (poster != null) {
            videoElement.setPoster(poster);
        }
    }

    /**
     * @return <li><b>The image file address</b> that the user agent can show while no video data is available</li> <br/>
     *         <li><b>null</b> if no image has been set</li>
     * 
     */
    public String getPoster() {
        return videoElement.getPoster();
    }

    /**
     * @param autoPlay
     *            <b>true</b> if you want the user agent automatically begin playback of the media resource as soon as
     *            it can do so without stopping. <br/>
     *            <b>false</b> otherwise
     * @throws IllegalArgumentException
     *             if autoPlay is <b>null</b>
     */
    public void setAutoPlay(Boolean autoPlay) {
        if (autoPlay == null) {
            throw new IllegalArgumentException("autoplay must not be null");
        }
        videoElement.setAutoPlay(autoPlay);
    }

    /**
     * @param controls
     *            <b>false</b> if you want to have custom scripted controller, <br/>
     *            <b>true</b> if you would like the user agent to provide its own set of controls.
     * @throws IllegalArgumentException
     *             if controls is <b>null</b>
     */
    public void setControls(Boolean controls) {
        if (controls == null) {
            throw new IllegalArgumentException("controls must not be null");
        }
        videoElement.setControls(controls);
    }

    /**
     * @return <b>true</b> if the user agent automatically begin playback. <br/>
     *         <b>false</b> otherwise
     */
    public boolean isAutoPlay() {
        return videoElement.isAutoPlay();
    }

    /**
     * @return <b>false</b> if you want to have custom scripted controller <br/>
     *         <b>true</b> if you would like the user agent to provide its own set of controls.
     */
    public boolean isControls() {
        return videoElement.isControls();
    }

    /**
     * @param sources
     *            list of {@link VideoSource} that represent all the available sources for the video element
     */
    public void setSources(List<VideoSource> sources) {
        for (VideoSource videoSource : sources) {
            addSource(videoSource);
        }
    }

    public void addSource(String src) {
        addSource(new VideoSource(src));
    }

    public void addSource(VideoSource videoSource) {
        if (sourceElement == null) {
            sourceElement = VideoSourceElement.as(DOM.createElement(VideoSourceElement.TAG));
        }
        if (videoSource.getSrc() == null) {
            throw new IllegalArgumentException("src must not be null");
        }
        sourceElement.setSrc(videoSource.getSrc());
        if (videoSource.getVideoType() != null) {
            sourceElement.setType(videoSource.getVideoType().getType());
        }
        if (VideoType.WEBM.equals(videoSource.getVideoType())) {
            videoElement.insertFirst(sourceElement);
        } else {
            videoElement.appendChild(sourceElement);
        }
    }

    // public void changeSource(String src)
    // {
    // if (this.sourceElement == null)
    // {
    // addSource(src);
    // }
    // else
    // {
    // this.sourceElement.setSrc(src);
    // }
    // }
    // /**
    // * Add a message that be show if the user agent can display HTML5 video tag
    // */
    // private void addUnsupportedMessage()
    // {
    // unsupportedElement = DOM.createElement("p");
    // unsupportedElement.setInnerHTML(UNSUPPORTED_VIDEO_TAG);
    // videoElement.appendChild(unsupportedElement);
    // }
    /**
     * Switch the playback status between paused and played
     */
    public void playPause() {
        videoElement.playPause();
    }

    /**
     * @return <b>true</b> if playback is paused<br/>
     *         <b>false</b> otherwise
     */
    public boolean isPaused() {
        return videoElement.isPaused();
    }

    /**
     * @return <b>true</b> if playback is played <br/>
     *         <b>false</b> otherwise
     */
    public boolean isPlayed() {
        return videoElement.isPlayed();
    }

    /**
     * @return <b>true</b> if the user agent is currently seeking. <br/>
     *         <b>false</b> otherwise
     */
    public boolean isSeeking() {
        return videoElement.isSeeking();
    }

    /**
     * @param time
     *            the time where user agent want to seek
     * @return <b>true</b> if it is possible for the user agent to seek. <br/>
     *         <b>false</b> otherwise
     */
    public boolean isSeekable(double time) {
        return videoElement.isSeekable(time);
    }

    /**
     * @param currentTime
     *            the current playback position, expressed in seconds
     */
    public void setCurrentTime(double currentTime) {
        videoElement.setCurrentTime(currentTime);
    }

    /**
     * @return the current playback position, expressed in seconds
     */
    public double getCurrentTime() {
        return videoElement.getCurrentTime();
    }

    /**
     * @return <b>the initial playback position</b>, that is, time to which the media resource was automatically seeked
     *         when it was loaded. <br/>
     *         <b>0</b> if the initial playback position is still unknown.
     */
    public double getInitialTime() {
        return videoElement.getInitialTime();
    }

    /**
     * @return <li><b>the length of the media resource, in seconds, </b>assuming that the start of the media resource is
     *         at time zero.</li> <br/>
     *         <li><b>-1</b> for unbounded streams.</li>
     * @throws NumberFormatException
     *             if duration is NaN
     */
    public double getDuration() {
        double duration = videoElement.getDuration();
        if (Double.isNaN(duration)) {
            throw new NumberFormatException("The video duration isn't available");
        } else if (Double.isInfinite(duration)) {
            duration = -1;
        }
        return duration;
    }

    /**
     * @return <b>true</b> if playback has reached the end of the media resource. <br/>
     *         <b>false</b> otherwise
     */
    public boolean isEnded() {
        return videoElement.isEnded();
    }

    /**
     * The default rate has no direct effect on playback, but if the user switches to a fast-forward mode, when they
     * return to the normal playback mode, it is expected that the rate of playback will be returned to the default rate
     * of playback.
     * 
     * @param defaultPlaybackRate
     *            the desired speed at which the media resource is to play. <br/>
     *            if value < 1.0 the playback is slower <br/>
     *            if value > 1.0 the playback is faster
     */
    public void setDefaultPlaybackRate(double defaultPlaybackRate) {
        videoElement.setDefaultPlaybackRate(defaultPlaybackRate);
    }

    /**
     * The default rate has no direct effect on playback, but if the user switches to a fast-forward mode, when they
     * return to the normal playback mode, it is expected that the rate of playback will be returned to the default rate
     * of playback.
     * 
     * @return the default rate of playback, for when the user is not fast-forwarding or reversing through the media
     *         resource.
     */
    public double getDefaultPlaybackRate() {
        return videoElement.getDefaultPlaybackRate();
    }

    /**
     * @param playbackRate
     *            the current rate playback, where 1.0 is normal speed.
     */
    public void setPlaybackRate(double playbackRate) {
        videoElement.setPlaybackRate(playbackRate);
    }

    /**
     * @return the current rate playback, where 1.0 is normal speed.
     */
    public double getPlaybackRate() {
        return videoElement.getPlaybackRate();
    }

    /**
     * @return the current buffer position end time, in second
     */
    public double getBufferedEndTime() {
        return videoElement.getBufferedEndTime();
    }

    /**
     * @return <b>the address</b> of the current media resource. <br/>
     *         <b>""</b> when there is no media resource.
     */
    public String getCurrentSrc() {
        return videoElement.getCurrentSrc();
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    public int getFrameRate() {
        return frameRate;
    }

    /**
     * Use this function to test if the media could be play by the video tag
     * 
     * @param videoType
     *            the videoType to check
     * @return <b>TypeSupport.NO</b> if videoType is a type that the user agent knows it cannot render <br/>
     *         <b>TypeSupport.PROBABLY</b> if if the user agent is confident that the type represents a media resource
     *         that it can render if used in with this audio or video element <br/>
     *         <b>TypeSupport.MAYBE</b> otherwise
     */
    public TypeSupport canPlayType(String videoType) {
        String canPlayType = videoElement.canPlayType(videoType);
        TypeSupport typeSupport = TypeSupport.NO;
        try {
            typeSupport = TypeSupport.valueOf(canPlayType.toUpperCase());
        } catch (Exception e) {
        }
        return typeSupport;
    }

    /**
     * This function is call in JNI code to dispatch {@link GwtEvent}
     * 
     * @param event
     */
    public void fireEvent(Object event) {
        if (event instanceof GwtEvent<?>) {
            GwtEvent<?> gwtEvent = (GwtEvent<?>) event;
            if (videoHandlerManager != null) {
                videoHandlerManager.fireEvent(gwtEvent);
            }
        }
    }

    /**
     * Handlers
     */
    /**
     * The user agent stops fetching the media data before it is completely downloaded, but not due to an error.
     * 
     * @param abortHandler
     */
    @Override
    public HandlerRegistration addAbortHandler(VideoAbortHandler abortHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoAbortEvent.getType(), abortHandler);
        addAbortEventHandler();
        return handlerRegistration;
    }

    /**
     * The user agent can resume playback of the media data, but estimates that if playback were to be started now, the
     * media resource could not be rendered at the current playback rate up to its end without having to stop for
     * further buffering of content.
     * 
     * @param canPlayHandler
     */
    @Override
    public HandlerRegistration addCanPlayHandler(VideoCanPlayHandler canPlayHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoCanPlayEvent.getType(), canPlayHandler);
        addCanPlayEventHandler();
        return handlerRegistration;
    }

    /**
     * The user agent estimates that if playback were to be started now, the media resource could be rendered at the
     * current playback rate all the way to its end without having to stop for further buffering.
     * 
     * @param canPlayThroughHandler
     */
    @Override
    public HandlerRegistration addCanPlayThroughHandler(VideoCanPlayThroughHandler canPlayThroughHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoCanPlayThroughEvent.getType(), canPlayThroughHandler);
        addCanPlayThroughEventHandler();
        return handlerRegistration;
    }

    /**
     * The duration attribute has just been updated.
     * 
     * @param durationChangeHandler
     */
    @Override
    public HandlerRegistration addDurationChangeHandler(VideoDurationChangeHandler durationChangeHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoDurationChangeEvent.getType(), durationChangeHandler);
        addDurationChangeEventHandler();
        return handlerRegistration;
    }

    /**
     * The media element has not yet been initialized. All attributes are in their initial states.
     * 
     * @param emptyHandler
     */
    @Override
    public HandlerRegistration addEmptyHandler(VideoEmptyHandler emptyHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoEmptyEvent.getType(), emptyHandler);
        addEmptyEventHandler();
        return handlerRegistration;
    }

    /**
     * Playback has stopped because the end of the media resource was reached.
     * 
     * @param endedHandler
     */
    @Override
    public HandlerRegistration addEndedHandler(VideoEndedHandler endedHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoEndedEvent.getType(), endedHandler);
        addEndedEventHandler();
        return handlerRegistration;
    }

    /**
     * An error occurs while fetching the media data.
     * 
     * @param errorHandler
     */
    @Override
    public HandlerRegistration addErrorHandler(VideoErrorHandler errorHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoErrorEvent.getType(), errorHandler);
        addErrorEventHandler();
        return handlerRegistration;
    }

    /**
     * The user agent can render the media data at the current playback position for the first time.
     * 
     * @param loadDataHandler
     */
    @Override
    public HandlerRegistration addLoadDataHandler(VideoLoadDataHandler loadDataHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoLoadDataEvent.getType(), loadDataHandler);
        addLoadDataEventHandler();
        return handlerRegistration;
    }

    /**
     * The user agent has just determined the duration and dimensions of the media resource
     * 
     * @param loadMetadataHandler
     */
    @Override
    public HandlerRegistration addLoadMetadataHandler(VideoLoadMetadataHandler loadMetadataHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoLoadMetadataEvent.getType(), loadMetadataHandler);
        addLoadMetadataEventHandler();
        return handlerRegistration;
    }

    /**
     * The user agent begins looking for media data, as part of the resource selection algorithm.
     * 
     * @param loadStartHandler
     */
    @Override
    public HandlerRegistration addLoadStartHandler(VideoLoadStartHandler loadStartHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoLoadStartEvent.getType(), loadStartHandler);
        addLoadStartEventHandler();
        return handlerRegistration;
    }

    /**
     * Playback has been paused. Fired after the pause() method has returned.
     * 
     * @param pauseHandler
     */
    @Override
    public HandlerRegistration addPauseHanlder(VideoPauseHandler pauseHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoPauseEvent.getType(), pauseHandler);
        addPauseEventHandler();
        return handlerRegistration;
    }

    /**
     * Playback has begun. Fired after the play() method has returned, or when the autoplay attribute has caused
     * playback to begin
     * 
     * @param playHandler
     */
    @Override
    public HandlerRegistration addPlayHandler(VideoPlayHandler playHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoPlayEvent.getType(), playHandler);
        addPlayEventHandler();
        return handlerRegistration;
    }

    /**
     * Playback has started.
     * 
     * @param playingHandler
     */
    @Override
    public HandlerRegistration addPlayingHandler(VideoPlayingHandler playingHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoPlayingEvent.getType(), playingHandler);
        addPlayingEventHandler();
        return handlerRegistration;
    }

    /**
     * The user agent is fetching media data
     * 
     * @param progressHandler
     */
    @Override
    public HandlerRegistration addProgressHandler(VideoProgressHandler progressHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoProgressEvent.getType(), progressHandler);
        addProgressEventHandler();
        return handlerRegistration;
    }

    /**
     * Either the defaultPlaybackRate or the playbackRate attribute has just been updated
     * 
     * @param rateChangeHandler
     */
    @Override
    public HandlerRegistration addRateChangeHandler(VideoRateChangeHandler rateChangeHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoRateChangeEvent.getType(), rateChangeHandler);
        addRateChangeEventHandler();
        return handlerRegistration;
    }

    /**
     * The seeking attribute changed to false
     * 
     * @param seekedHandler
     */
    @Override
    public HandlerRegistration addSeekedHandler(VideoSeekedHandler seekedHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoSeekedEvent.getType(), seekedHandler);
        addSeekedEventHandler();
        return handlerRegistration;
    }

    /**
     * The seeking attribute changed to true and the seek operation is taking long enough that the user agent has time
     * to fire the event
     * 
     * @param seekingHandler
     */
    @Override
    public HandlerRegistration addSeekingHandler(VideoSeekingHandler seekingHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoSeekingEvent.getType(), seekingHandler);
        addSeekingEventHandler();
        return handlerRegistration;
    }

    /**
     * The user agent is trying to fetch media data, but data is unexpectedly not forthcoming
     * 
     * @param stalledHandler
     */
    @Override
    public HandlerRegistration addStalledHandler(VideoStalledHandler stalledHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoStalledEvent.getType(), stalledHandler);
        addStalledEventHandler();
        return handlerRegistration;
    }

    /**
     * The user agent is intentionally not currently fetching media data, but does not have the entire media resource
     * downloaded
     * 
     * @param suspendHandler
     */
    @Override
    public HandlerRegistration addSuspendHandler(VideoSuspendHandler suspendHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoSuspendEvent.getType(), suspendHandler);
        addSuspendEventHandler();
        return handlerRegistration;
    }

    /**
     * Add a listener when the current playback position changed as part of normal playback or in an especially
     * interesting way, for example discontinuously.
     * 
     * @param timeUpdateHandler
     */
    @Override
    public HandlerRegistration addTimeUpdateHandler(VideoTimeUpdateHandler timeUpdateHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoTimeUpdateEvent.getType(), timeUpdateHandler);
        addTimeUpdateEventHandler();
        return handlerRegistration;
    }

    /**
     * Either the volume attribute or the muted attribute has changed. Fired after the relevant attribute's setter has
     * returned
     * 
     * @param volumeChangeHandler
     */
    @Override
    public HandlerRegistration addVolumeChangeHandler(VideoVolumeChangeHandler volumeChangeHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoVolumeChangeEvent.getType(), volumeChangeHandler);
        addVolumeChangeEventHandler();
        return handlerRegistration;
    }

    /**
     * Playback has stopped because the next frame is not available, but the user agent expects that frame to become
     * available in due course
     * 
     * @param waitingHandler
     */
    @Override
    public HandlerRegistration addWaitingHandler(VideoWaitingHandler waitingHandler) {
        HandlerRegistration handlerRegistration = videoHandlerManager.addHandler(VideoWaitingEvent.getType(), waitingHandler);
        addWaitingEventHandler();
        return handlerRegistration;
    }

    /**
     * JNI for event handlers
     */
    private final native void addAbortEventHandler() /*-{
                                                     var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                     var videoWidget = this;
                                                     videoElement
                                                     .addEventListener(
                                                     'abort',
                                                     function() {
                                                     var event = @fr.hd3d.html5.video.client.events.VideoAbortEvent::new()();
                                                     videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                     }, true);
                                                     }-*/;

    private final native void addCanPlayEventHandler() /*-{
                                                       var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                       var videoWidget = this;
                                                       videoElement
                                                       .addEventListener(
                                                       'canplay',
                                                       function() {
                                                       var event = @fr.hd3d.html5.video.client.events.VideoCanPlayEvent::new()();
                                                       videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                       }, true);
                                                       }-*/;

    private final native void addCanPlayThroughEventHandler() /*-{
                                                              var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                              var videoWidget = this;
                                                              videoElement
                                                              .addEventListener(
                                                              'canplaythrough',
                                                              function() {
                                                              var event = @fr.hd3d.html5.video.client.events.VideoCanPlayThroughEvent::new()();
                                                              videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                              }, true);
                                                              }-*/;

    private final native void addDurationChangeEventHandler() /*-{
                                                              var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                              var videoWidget = this;
                                                              videoElement
                                                              .addEventListener(
                                                              'durationchange',
                                                              function() {
                                                              var event = @fr.hd3d.html5.video.client.events.VideoDurationChangeEvent::new()();
                                                              videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                              }, true);
                                                              }-*/;

    private final native void addEmptyEventHandler() /*-{
                                                     var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                     var videoWidget = this;
                                                     videoElement
                                                     .addEventListener(
                                                     'emptied',
                                                     function() {
                                                     var event = @fr.hd3d.html5.video.client.events.VideoEmptyEvent::new()();
                                                     videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                     }, true);
                                                     }-*/;

    private final native void addEndedEventHandler() /*-{
                                                     var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                     var videoWidget = this;
                                                     videoElement
                                                     .addEventListener(
                                                     'ended',
                                                     function() {
                                                     var event = @fr.hd3d.html5.video.client.events.VideoEndedEvent::new()();
                                                     videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                     }, true);
                                                     }-*/;

    private final native void addErrorEventHandler() /*-{
                                                     var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                     var videoWidget = this;
                                                     videoElement
                                                     .addEventListener(
                                                     'error',
                                                     function() {
                                                     var event = @fr.hd3d.html5.video.client.events.VideoErrorEvent::new()();
                                                     videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                     }, true);
                                                     }-*/;

    private final native void addLoadDataEventHandler() /*-{
                                                        var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                        var videoWidget = this;
                                                        videoElement
                                                        .addEventListener(
                                                        'loadeddata',
                                                        function() {
                                                        var event = @fr.hd3d.html5.video.client.events.VideoLoadDataEvent::new()();
                                                        videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                        }, true);
                                                        }-*/;

    private final native void addLoadMetadataEventHandler() /*-{
                                                            var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                            var videoWidget = this;
                                                            videoElement
                                                            .addEventListener(
                                                            'loadedmetadata',
                                                            function() {
                                                            var event = @fr.hd3d.html5.video.client.events.VideoLoadMetadataEvent::new()();
                                                            videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                            }, true);
                                                            }-*/;

    private final native void addLoadStartEventHandler() /*-{
                                                         var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                         var videoWidget = this;
                                                         videoElement
                                                         .addEventListener(
                                                         'loadstart',
                                                         function() {
                                                         var event = @fr.hd3d.html5.video.client.events.VideoLoadStartEvent::new()();
                                                         videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                         }, true);
                                                         }-*/;

    private final native void addPauseEventHandler() /*-{
                                                     var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                     var videoWidget = this;
                                                     videoElement
                                                     .addEventListener(
                                                     'pause',
                                                     function() {
                                                     var event = @fr.hd3d.html5.video.client.events.VideoPauseEvent::new()();
                                                     videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                     }, true);
                                                     }-*/;

    private final native void addPlayEventHandler() /*-{
                                                    var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                    var videoWidget = this;
                                                    videoElement
                                                    .addEventListener(
                                                    'play',
                                                    function() {
                                                    var event = @fr.hd3d.html5.video.client.events.VideoPlayEvent::new()();
                                                    videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                    }, true);
                                                    }-*/;

    private final native void addPlayingEventHandler() /*-{
                                                       var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                       var videoWidget = this;
                                                       videoElement
                                                       .addEventListener(
                                                       'playing',
                                                       function() {
                                                       var event = @fr.hd3d.html5.video.client.events.VideoPlayingEvent::new()();
                                                       videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                       }, true);
                                                       }-*/;

    private final native void addProgressEventHandler() /*-{
                                                        var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                        var videoWidget = this;
                                                        videoElement
                                                        .addEventListener(
                                                        'progress',
                                                        function() {
                                                        var event = @fr.hd3d.html5.video.client.events.VideoProgressEvent::new()();
                                                        videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                        }, true);
                                                        }-*/;

    private final native void addRateChangeEventHandler() /*-{
                                                          var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                          var videoWidget = this;
                                                          videoElement
                                                          .addEventListener(
                                                          'ratechange',
                                                          function() {
                                                          var event = @fr.hd3d.html5.video.client.events.VideoRateChangeEvent::new()();
                                                          videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                          }, true);
                                                          }-*/;

    private final native void addSeekedEventHandler() /*-{
                                                      var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                      var videoWidget = this;
                                                      videoElement
                                                      .addEventListener(
                                                      'seeked',
                                                      function() {
                                                      var event = @fr.hd3d.html5.video.client.events.VideoSeekedEvent::new()();
                                                      videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                      }, true);
                                                      }-*/;

    private final native void addSeekingEventHandler() /*-{
                                                       var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                       var videoWidget = this;
                                                       videoElement
                                                       .addEventListener(
                                                       'seeking',
                                                       function() {
                                                       var event = @fr.hd3d.html5.video.client.events.VideoSeekingEvent::new()();
                                                       videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                       }, true);
                                                       }-*/;

    private final native void addStalledEventHandler() /*-{
                                                       var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                       var videoWidget = this;
                                                       videoElement
                                                       .addEventListener(
                                                       'stalled',
                                                       function() {
                                                       var event = @fr.hd3d.html5.video.client.events.VideoStalledEvent::new()();
                                                       videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                       }, true);
                                                       }-*/;

    private final native void addSuspendEventHandler() /*-{
                                                       var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                       var videoWidget = this;
                                                       videoElement
                                                       .addEventListener(
                                                       'suspend',
                                                       function() {
                                                       var event = @fr.hd3d.html5.video.client.events.VideoSuspendEvent::new()();
                                                       videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                       }, true);
                                                       }-*/;

    private final native void addTimeUpdateEventHandler() /*-{
                                                          var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                          var videoWidget = this;
                                                          videoElement
                                                          .addEventListener(
                                                          'timeupdate',
                                                          function() {
                                                          var currentTime = videoElement.currentTime;
                                                          var duration = videoElement.duration;
                                                          var event = @fr.hd3d.html5.video.client.events.VideoTimeUpdateEvent::new()();
                                                          event.@fr.hd3d.html5.video.client.events.VideoTimeUpdateEvent::setCurrentTime(D)(currentTime);
                                                          event.@fr.hd3d.html5.video.client.events.VideoTimeUpdateEvent::setDuration(D)(duration);
                                                          videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                          }, true);
                                                          }-*/;

    private final native void addVolumeChangeEventHandler() /*-{
                                                            var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                            var videoWidget = this;
                                                            videoElement
                                                            .addEventListener(
                                                            'volumechange',
                                                            function() {
                                                            var event = @fr.hd3d.html5.video.client.events.VideoVolumeChangeEvent::new()();
                                                            videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                            }, true);
                                                            }-*/;

    private final native void addWaitingEventHandler() /*-{
                                                       var videoElement = this.@fr.hd3d.html5.video.client.VideoWidget::videoElement;
                                                       var videoWidget = this;
                                                       videoElement
                                                       .addEventListener(
                                                       'waiting',
                                                       function() {
                                                       var event = @fr.hd3d.html5.video.client.events.VideoWaitingEvent::new()();
                                                       videoWidget.@fr.hd3d.html5.video.client.VideoWidget::fireEvent(Ljava/lang/Object;)(event);
                                                       }, true);
                                                       }-*/;

    public void load() {
        this.videoElement.load();
    }

    public void setSrc(String src) {
        this.videoElement.setSrc(src);
    }
}
