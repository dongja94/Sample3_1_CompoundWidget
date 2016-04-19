package com.begentgroup.samplecompoundwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dongja94 on 2016-04-19.
 */
public class PersonView extends FrameLayout {
    public PersonView(Context context) {
        this(context, null);
    }

    TextView nameView, ageView;
    ImageView photoView;

    public interface OnImageClickListener {
        public void onImageClick(PersonView view, Person person);
    }

    OnImageClickListener mListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mListener = listener;
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        LayoutInflater.from(context).inflate(R.layout.view_person, this);
        inflate(context, R.layout.view_person, this);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
        photoView = (ImageView)findViewById(R.id.image_photo);
        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageClick(PersonView.this, person);
                }
            }
        });
    }

    Person person;
    public void setPerson(Person p) {
        person = p;
        nameView.setText(p.getName());
        ageView.setText(""+p.getAge());
        photoView.setImageDrawable(p.getPhoto());
    }

    public boolean isOld() {
        if (person == null) return false;
        return person.getAge() > 40 ? true : false;
    }

}
