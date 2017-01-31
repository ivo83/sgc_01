package ivant.example.com.sgc_00;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        toast = Toast.makeText(WelcomeActivity.this, "Method onCreate in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    protected void onStart() {
        super.onStart();

        toast = Toast.makeText(WelcomeActivity.this, "Method onStart in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();

        //start method ToToast();
    }

    @Override
    protected void onStop() {
        super.onStop();

        toast = Toast.makeText(WelcomeActivity.this, "Method onStop in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();
        //start method ToToast();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        toast = Toast.makeText(WelcomeActivity.this, "Method onDestroy in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();
        //start method ToToast();
    }

    @Override
    protected void onPause() {
        super.onPause();

        toast = Toast.makeText(WelcomeActivity.this, "Method onPause in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();
        //start method ToToast();
    }

    @Override
    protected void onResume() {
        super.onResume();

        toast = Toast.makeText(WelcomeActivity.this, "Method onResume in WelcomeActivity executed.", Toast.LENGTH_SHORT);
        toast.show();
        //start method ToToast();
    }
}
