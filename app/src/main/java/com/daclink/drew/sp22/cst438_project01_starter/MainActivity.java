package com.daclink.drew.sp22.cst438_project01_starter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.daclink.drew.sp22.cst438_project01_starter.AppStorage.AppDatabase;
import com.daclink.drew.sp22.cst438_project01_starter.AppStorage.UserDAO;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.daclink.drew.sp22.cst438_project01_starter.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button
        ;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private static final String USER_ID_KEY = "com.example.project2onlinestore_marcosmos.userIdKey";
    private static final String PREFERENCES_KEY = "com.example.project2onlinestore_marcosmos.PREFERENCES_KEY";

    private ActivityMainBinding binding;

    private TextView mUserDisplay;

    private EditText userInput;
    private TextView userOutput;

    private UserDAO mUserDAO;

    private List<User> mUsers;
    private int mUserId = -1;
    private SharedPreferences mPreferences = null;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void loginUser(int mUserId) {
        mUser = mUserDAO.getUsersByID(mUserId);
        invalidateOptionsMenu();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void getDatabase() {
        mUserDAO = Room.databaseBuilder(this, AppDatabase.class,AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }
    public static Intent intentFactory(Context context, int userId){
        Intent intent = new Intent(context, Activity.class);
        intent.putExtra(USER_ID_KEY, userId);
        return intent;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Displaying Toast with Hello Javatpoint message
        Toast.makeText(getApplicationContext(),"Incorrect Username/Password",Toast.LENGTH_SHORT).show();
    }
}