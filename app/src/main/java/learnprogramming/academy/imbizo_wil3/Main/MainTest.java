package learnprogramming.academy.imbizo_wil3.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import learnprogramming.academy.imbizo_wil3.R;

public class MainTest extends YouTubeBaseActivity {


    String api_key = "AIzaSyBIubEWojtaOz_3JUS9eBzWJtB2rdv51Wg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

        // Get reference to the view of Video player
//        YouTubePlayerView ytPlayer = (YouTubePlayerView)findViewById(R.id.ytPlayer);
//
//
//        ytPlayer.initialize(
//                "AIzaSyBIubEWojtaOz_3JUS9eBzWJtB2rdv51Wg",
//                new YouTubePlayer.OnInitializedListener() {
//                    // Implement two methods by clicking on red
//                    // error bulb inside onInitializationSuccess
//                    // method add the video link or the playlist
//                    // link that you want to play In here we
//                    // also handle the play and pause
//                    // functionality
//                    @Override
//                    public void onInitializationSuccess(
//                            YouTubePlayer.Provider provider,
//                            YouTubePlayer youTubePlayer, boolean b)
//                    {
//                        youTubePlayer.loadVideo("w9xfXsqIGKk");
//                        youTubePlayer.play();
//                    }
//
//                    // Inside onInitializationFailure
//                    // implement the failure functionality
//                    // Here we will show toast
//                    @Override
//                    public void onInitializationFailure(YouTubePlayer.Provider provider,
//                                                        YouTubeInitializationResult
//                                                                youTubeInitializationResult)
//                    {
//                        Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
//                    }
//                });

    }
}