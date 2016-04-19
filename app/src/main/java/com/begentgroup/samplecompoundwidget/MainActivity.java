package com.begentgroup.samplecompoundwidget;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    PersonView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (PersonView)findViewById(R.id.person_my);

        Person p = new Person();
        p.setName("ysi");
        p.setAge(42);
        p.setPhoto(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));

        myView.setPerson(p);

        myView.setOnImageClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView view, Person person) {
                Toast.makeText(MainActivity.this, "name : " + person.getName() , Toast.LENGTH_SHORT).show();
            }
        });

        if (myView.isOld()) {
            Toast.makeText(this, "old...", Toast.LENGTH_SHORT).show();
        }
    }
}
