package learnprogramming.academy.imbizo_wil3.Main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import learnprogramming.academy.imbizo_wil3.Create.AddContent;
import learnprogramming.academy.imbizo_wil3.Create.CreateCategory;
import learnprogramming.academy.imbizo_wil3.Fragments.HomeFragment;
import learnprogramming.academy.imbizo_wil3.MainActivity;
import learnprogramming.academy.imbizo_wil3.R;


public class MainContent extends YouTubeBaseActivity {

    FirebaseDatabase databaseCategories;
    FirebaseStorage storage;
    DatabaseReference refCategories;
    StorageReference storageRef;

    YouTubePlayerView  ytPlayer;


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainContent.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_content);
        ytPlayer = (YouTubePlayerView)findViewById(R.id.ytPlayerFragment);

        loadData();

    }


    public void loadData() {

        databaseCategories = FirebaseDatabase.getInstance();
        refCategories = databaseCategories.getReference("ContentDetails");
        storage = FirebaseStorage.getInstance();

        refCategories.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot s : snapshot.getChildren()){
                    if(s.child("userName").getValue().toString().equals(HomeFragment.usernameEmail.toString()) && s.child("lectureName").getValue().toString().equals(MainLectures.lectureName) && s.child("categoryType").getValue().toString().equals(HomeFragment.categoryName) ) {

                        String[] tokens = s.child("link").getValue().toString().split("/");

                        ytPlayer.initialize(
                                "AIzaSyBIubEWojtaOz_3JUS9eBzWJtB2rdv51Wg",
                                new YouTubePlayer.OnInitializedListener() {
                                    // Implement two methods by clicking on red
                                    // error bulb inside onInitializationSuccess
                                    // method add the video link or the playlist
                                    // link that you want to play In here we
                                    // also handle the play and pause
                                    // functionality
                                    @Override
                                    public void onInitializationSuccess(
                                            YouTubePlayer.Provider provider,
                                            YouTubePlayer youTubePlayer, boolean b)
                                    {
                                        if(tokens.length <= 1)
                                        {
                                            youTubePlayer.loadVideo(s.child("link").getValue().toString());
                                            youTubePlayer.play();
                                        }
                                        else {
                                            youTubePlayer.loadVideo(tokens[3]);
                                            youTubePlayer.play();
                                        }
                                    }

                                    // Inside onInitializationFailure
                                    // implement the failure functionality
                                    // Here we will show toast
                                    @Override
                                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                                        YouTubeInitializationResult
                                                                                youTubeInitializationResult)
                                    {
                                        Toast.makeText(MainContent.this, "Video player Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });


                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}