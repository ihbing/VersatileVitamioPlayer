
package io.vov.vitamio.demo.videoview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.app.AppActivity;
import io.vov.vitamio.demo.R;
import io.vov.vitamio.demo.mediaplayers.MediaPlayerDemo_Video;
import io.vov.vitamio.demo.mediaplayers.MediaPlayerDemo_setTextureView;
import media.explore.activities.FileExplorerActivity;

public class VideoViewDemoList extends AppActivity {
  public Button mlocalvideo;
  public Button mlocalvideoSurface;
  public Button mstream_rtmp;
  public Button mstreamvideo;
  public static final String MEDIA = "media";
  public static final int LOCAL_AUDIO = 1;
  public static final int STREAM_AUDIO = 2;
  public static final int RESOURCES_AUDIO = 3;
  public static final int LOCAL_VIDEO = 4;
  public static final int STREAM_VIDEO = 5;
  public static final int RESOURCES_VIDEO = 6;
  public static final int LOCAL_VIDEO_SURFACE = 7;
  public static final int STREAM_RTMP = 8;

  @Override protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.videoview_list);

    mlocalvideo = (Button) findViewById(R.id.localvideo);
    mlocalvideo.setOnClickListener(mLocalVideoListener);

    mstreamvideo = (Button) findViewById(R.id.streamvideo);
    mstreamvideo.setOnClickListener(mStreamVideoListener);

    mstream_rtmp = (Button) findViewById(R.id.stream_rtmp);
    mstream_rtmp.setOnClickListener(mStreamRtmpListener);


    mlocalvideoSurface = (Button) findViewById(R.id.localvideo_set_textureview);
    mlocalvideoSurface.setOnClickListener(mSetSurfaceVideoListener);
  }

  private OnClickListener mLocalVideoListener = new OnClickListener() {
    public void onClick(View v) {
      Intent intent = new Intent(VideoViewDemoList.this, FileExplorerActivity.class);
      intent.putExtra(FileExplorerActivity.ActionFileExplore,FileExplorerActivity.VideoView);
      startActivity(intent);
    }
  };

  private OnClickListener mStreamVideoListener = new OnClickListener() {
    public void onClick(View v) {
      VideoViewDemo.intentTo(VideoViewDemoList.this, "http://video19.ifeng.com/video06/2012/04/11/629da9ec-60d4-4814-a940-997e6487804a.mp4", "陈思成", STREAM_VIDEO);
    }
  };

  private OnClickListener mStreamRtmpListener = new OnClickListener() {
    public void onClick(View v) {
      VideoViewDemo.intentTo(VideoViewDemoList.this, "rtmp://live.hkstv.hk.lxdns.com/live/hks", "RTMP香港电视台", STREAM_RTMP);
    }
  };

  private OnClickListener mSetSurfaceVideoListener = new OnClickListener() {
    public void onClick(View v) {
      Intent intent = new Intent(VideoViewDemoList.this, VideoViewBuffer.class);
      intent.putExtra(MEDIA, LOCAL_VIDEO_SURFACE);
      startActivity(intent);
    }
  };

}
