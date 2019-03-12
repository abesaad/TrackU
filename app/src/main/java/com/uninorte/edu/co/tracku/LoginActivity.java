package com.uninorte.edu.co.tracku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        findViewById(R.id.login_button).setOnClickListener(this);
        findViewById(R.id.registration_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForRegistration=new Intent();
                intentForRegistration.setClass(getApplicationContext(),RegistrationActivity.class);
                startActivity(intentForRegistration);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.login_button){
            Intent intentToBeCalled=new Intent();
            String userName=((EditText)findViewById(R.id.login_username_value)).getText()+"";
            String password=((EditText)findViewById(R.id.login_password_value)).getText()+"";
            intentToBeCalled.putExtra("callType", "userLogin");
            intentToBeCalled.putExtra("userName",userName);
            intentToBeCalled.putExtra("password",password);
            intentToBeCalled.setClass(this,MainActivity.class);
            startActivity(intentToBeCalled);
        }

    }
}
