package learnprogramming.academy.imbizo_wil3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import learnprogramming.academy.imbizo_wil3.Fragments.AccountFragment;
import learnprogramming.academy.imbizo_wil3.Fragments.HomeFragment;
import learnprogramming.academy.imbizo_wil3.Main.MainContent;
import learnprogramming.academy.imbizo_wil3.Main.MainLectures;
import learnprogramming.academy.imbizo_wil3.Main.MainLogin;
import learnprogramming.academy.imbizo_wil3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    RecyclerView recyclerView;
    public static int checkView;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser == null) {
                    Intent intent = new Intent(MainActivity.this, MainLogin.class);
                    startActivity(intent);
                }
            }
        };


        if(checkView == 0) {
            replaceFragment(new HomeFragment());
        }
        if(checkView == 1) {
            replaceFragment(new MainLectures());
        }
        if (checkView ==2){
            startActivity(new Intent(MainActivity.this, MainContent.class));
            finish();
        }
        if (checkView == 4){
            replaceFragment(new HomeFragment());
        }



        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.homeNB:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.accountNB:
                    replaceFragment(new AccountFragment());
                    break;
//                case R.id.setGoalNB:
//                    replaceFragment(new SetGoalFragment());
//                    break;
//                case R.id.graphNB:
//                    replaceFragment(new GraphFragment());
//                    break;

            }
            return true;
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onBackPressed() {
        if(checkView == 0) {
            replaceFragment(new HomeFragment());
        }
        if(checkView == 1) {
            replaceFragment(new HomeFragment());
        }
        if (checkView ==2){
            replaceFragment(new MainLectures());
        }
        if (checkView ==3){

        }


    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }


}