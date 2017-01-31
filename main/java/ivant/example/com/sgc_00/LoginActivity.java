package ivant.example.com.sgc_00;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etLogin;
    EditText etPass;
    Button btLogin;
    Button btExit;
    CheckBox cbRememberMe;
    TextView tvStatus;
    TextView tvRegister;

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPass  = (EditText) findViewById(R.id.etPass);
        btLogin = (Button) findViewById(R.id.btLogin);
        btExit  = (Button) findViewById(R.id.btExit);
        cbRememberMe    = (CheckBox) findViewById(R.id.cbRememberMe);
        tvStatus        = (TextView) findViewById(R.id.tvStatus);
        tvRegister      = (TextView) findViewById(R.id.tvRegister);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btLogin :
                        userLogin();
                        break;
                    case R.id.btExit :
                        userExit();
                        break;
                    case R.id.cbRememberMe :
                        clickRememberMe();
                        break;
                    case R.id.tvRegister :
                        startRegistration();
                        break;
                }
            }
        };

        btLogin.setOnClickListener(onClickListener);
        btExit.setOnClickListener(onClickListener);
        cbRememberMe.setOnClickListener(onClickListener);
        tvRegister.setOnClickListener(onClickListener);

    }

    private void startRegistration() {
        Intent intentRegister = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intentRegister);
    }

    private void clickRememberMe() {
        tvStatus.setText("Status of Remember Me changed. ");
    }

    private void userExit() {
        tvStatus.setText("Exiting application...");
    }

    public void userLogin() {
        tvStatus.setText("Checking credentials...");

        String enteredLogin = etLogin.getText().toString();
        String enteredPassw = etPass.getText().toString();

        if( enteredLogin!= ""){

            String temp = getUser();
            String[] user = temp.split(" ");

            if((user[1] == enteredLogin) && (user[2] == enteredPassw)) {

                Toast.makeText(LoginActivity.this, "You've logged in successfully!", Toast.LENGTH_SHORT);

                Intent intentLogin = new Intent(LoginActivity.this, WelcomeActivity.class);
                startActivity(intentLogin);
            }
            else
            {
                Toast.makeText(LoginActivity.this, "Bad credentials! Try again", Toast.LENGTH_SHORT);
            }

        }


    }

    public void setUser(String sLogin, String sPass) {      //

        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        //saving Login
        ed.putString("Login", sLogin);
        ed.commit();
        //saving password
        ed.putString("Password", sPass);
        ed.commit();
        Toast.makeText(LoginActivity.this, "Login and Password saved.", Toast.LENGTH_SHORT).show();

    }

    public String getUser(){

        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        String Login = sPref.getString("Login", "");
        String Pass = sPref.getString("Password", "");

        Toast.makeText(LoginActivity.this, "Credentials are got.", Toast.LENGTH_SHORT).show();

        return Login + " " + Pass;

    }
}
