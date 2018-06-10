package unapec.edu.loginprofile;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import unapec.edu.loginprofile.models.Person;

public class LoginActivity extends AppCompatActivity {

    private AppCompatButton buttonLogin;
    EditText inputUserName;
    EditText inputPassword;
    HashMap<String, Person> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        inputUserName = findViewById(R.id.editTextUserName);
        inputPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        creatDummyData();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = "";
                if(inputUserName != null){
                    userName = inputUserName.getText()
                                .toString()
                                .toLowerCase();
                }

                Person currentPerson = data.get(userName);
                if(currentPerson != null){
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    intent.putExtra("PROFILE_DATA", currentPerson);
                    startActivity(intent);
                }else{
                    showErrorDialog();
                    inputUserName.setText("");
                    inputPassword.setText("");
                }
            }
        });
    }

    private void showErrorDialog() {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(R.string.login_error_body);
        dlgAlert.setTitle(R.string.login_error_title);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }


    private void creatDummyData(){
        Person person = new Person("Brayan Kelly",
                "Software Developer specialize on web applicacion",
                "https://github.com/BrayanKellyBalbuena");

       data = new HashMap<>();
       data.put("brayankelly", person);
   }
}
