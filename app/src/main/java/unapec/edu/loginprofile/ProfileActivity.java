package unapec.edu.loginprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import unapec.edu.loginprofile.models.Person;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewFullName;
    TextView textViewAbout;
    TextView textViewRepo;
    AppCompatButton buttonShare;
    private final String PROFILE_DATA = "PROFILE_DATA";
    Person currentPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        textViewFullName = findViewById(R.id.textViewFullName);
        textViewAbout = findViewById(R.id.textViewAbout);
        textViewRepo = findViewById(R.id.textViewRepo);
        buttonShare = findViewById(R.id.btnShare);

        if(getIntent() != null && getIntent().getExtras() != null){
            currentPerson = getIntent().getParcelableExtra(PROFILE_DATA);
            if(currentPerson != null){
                textViewFullName.setText(currentPerson.getFullName());
                textViewAbout.setText(currentPerson.getAbout());
                textViewRepo.setText(currentPerson.getRepo());
            }
        }
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareProfileData(currentPerson);
            }
        });

    }

    private void shareProfileData(Person currentPerson) {
        Intent sendIntent = new Intent();

        String textToSend = currentPerson.getFullName() + "\n" + currentPerson.getAbout();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textToSend);
        sendIntent.setType("text/plain");

        startActivity(sendIntent);
    }
}
