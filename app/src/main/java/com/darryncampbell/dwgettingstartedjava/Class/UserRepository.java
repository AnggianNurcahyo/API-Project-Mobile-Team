package com.darryncampbell.dwgettingstartedjava.Class;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static final String TAG = "UserRepost";
    private static UserRepository INSTANCE;
    private UserService mUserService;

    private UserRepository(Context context){
        mUserService = API.getUserService();
    }

    public static void initialize(Context context){
        if(INSTANCE==null){
            INSTANCE =  new UserRepository(context);
        }
    }

    public static UserRepository get(){
        return INSTANCE;
    }

    public MutableLiveData<List<User>> getUsers(){
        MutableLiveData<List<User>> users = new MutableLiveData<>();

        Call<List<User>> call = mUserService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    users.setValue(response.body());
                    Log.i(TAG, "getUsers.onResponse() called");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Error API call : ", t.getMessage());
            }
        });
        return users;
    }

    public boolean getLogin(String npk, String password){
        boolean cek = false;
        MutableLiveData<List<User>> users = new MutableLiveData<>();

        Call<List<User>> call = mUserService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    users.setValue(response.body());
                    Log.i(TAG, "getUsers.onResponse() called");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Error API call : ", t.getMessage());
            }
        });

        for(int i =0; i < users.getValue().size(); i++){
            if(npk.equals(users.getValue().get(i).getNpk())){
                if(password.equals(users.getValue().get(i).getPassword())){
                    cek=true;
                }
            }
        }
        return cek;
    }
}
