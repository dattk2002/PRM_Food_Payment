package com.example.prm_assignment_foodanddrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private TextView tvNotAccountYet, tvSignIn;
    private Button btnSignIn;
    private String bitmap, shader;
    private final String REQUIRE = "Require";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etUsername = (EditText) findViewById(R.id.editTextUsername);
        etPassword = (EditText) findViewById(R.id.editTextPassword);
        tvNotAccountYet = (TextView) findViewById(R.id.textViewCreateAccount);
        tvSignIn = (TextView) findViewById(R.id.textViewSignIn);
        btnSignIn = (Button) findViewById(R.id.buttonSignIn);

        tvNotAccountYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
//        Shader shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        tvSignIn.getPaint().setShader(shader);
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }
        return true;
    }

    private void signIn() {
        if (!checkInput()) {
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void signUpForm() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonSignIn) {
            signIn();
        } else if (v.getId() == R.id.textViewCreateAccount) {
            signUpForm();
        }
    }

}