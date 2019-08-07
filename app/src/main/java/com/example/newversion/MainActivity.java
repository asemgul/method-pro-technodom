package com.example.newversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Dialog.DialogListener {
    private EditText phone, password;
    private Button button;
    private TextView newPassword;

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);

        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")//наш сервер
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });



//        private void createPost(){
//            //User post=new User(23,"new title", "new text");
//
//            Call<User> call = jsonPlaceHolderApi.createPost(phone,password, newPassword);
//
//            call.enqueue(new Callback<User>() {
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
//
//                    if (!response.isSuccessful()){
//                        textViewResult.setText("Code: " + response.code());
//                        return;
//                    }
//
//                    User postResponse=response.body();
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//                    textViewResult.setText(t.getMessage());
//
//                }
//            });
//        }

//        private void getPosts(){
//            Call<List<Post>> call = jsonPlaceHolderApi.getPosts(4);
//
//            call.enqueue(new Callback<List<Post>>() {
//                @Override
//                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                    if(!response.isSuccessful()){
//                        textViewResult.setText("Code: " + response.code());
//                        return;
//                    }
//
//                    List<Post> posts = response.body();
//
//                    for (Post post:posts){
//                        String content ="";
//                        //content +="ID: "+ post.getId() +"\n";
//                        content +="Phone number " + post.getPhone()+"\n"; //UserId
//                        content +="Password: "+ post.getPassword()+"\n"; //Title
//                        //content+="Text: " + post.getText()+"\n\n";
//
//                        textViewResult.append(content);
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<List<Post>> call, Throwable t) {
//                    textViewResult.setText(t.getMessage());
//                }
//            });
//        }

    }

    public void openDialog(){
        Dialog dialog=new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog");

    }

    @Override
    public void applyText(String newPassword) {//возьму новый пароль

     }
}
