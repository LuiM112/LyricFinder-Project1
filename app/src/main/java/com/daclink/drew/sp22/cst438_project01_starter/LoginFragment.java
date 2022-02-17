package com.daclink.drew.sp22.cst438_project01_starter;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.daclink.drew.sp22.cst438_project01_starter.AppStorage.AppDatabase;
import com.daclink.drew.sp22.cst438_project01_starter.AppStorage.UserDAO;
import com.daclink.drew.sp22.cst438_project01_starter.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private EditText mUsername;
    private EditText mPassword;

    private Button mButton;
    private UserDAO mUserDAO;

    private String mUserString;
    private String mPasswordString;
    private User mUser;

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    private void LoginDisplay(){
        mUsername = mUsername.findViewById(R.id.editTextLoginUserName);
        mPassword = mPassword.findViewById(R.id.editTextLoginPassword);

        mButton = mButton.findViewById(R.id.buttonLogin);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInfoFromDisplay();
                if(checkForUserDB()){
                    if(!validatePassword()){
                        Toast.makeText(getContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                    } else{
                        Intent intent = MainActivity.intentFactory(getContext(), mUser.getUserId());
                        startActivity(intent);
                    }
                }

            }


        });
    }

    private void getInfoFromDisplay(){
        mUserString = mUsername.getText().toString();
        mPasswordString = mPassword.getText().toString();
    }

    private boolean validatePassword(){
        return mUser.getPassword().equals(mPasswordString);
    }
    private void getDatabase(){
        mUserDAO = Room.databaseBuilder(getContext(), AppDatabase.class,AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }
    private boolean checkForUserDB(){
        mUser = mUserDAO.getUserByUsername(mUserString);
        if(mUser == null){
            Toast.makeText(getContext(), "No User " + mUserString + " found ", Toast.LENGTH_SHORT).show();

            return false;
        }
        return true;
    }
    public static  Intent intentFactory(Context context){
        Intent intent = new Intent(context, LoginFragment.class);
        return intent;
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_LoginFragment_to_RegisterFragment);
            }
        });

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_SearchFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}