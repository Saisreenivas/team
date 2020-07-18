package com.example.saisreenivas.team;

import android.content.Intent;
import android.view.View;

/**
 * Created by Sai sreenivas on 10/26/2016.
 */

public class MyListener extends MainActivity {
        public void onClick(View v) {
            if(v.getId() == R.id.activity_feedback)
                startActivity(new Intent(getApplicationContext(), Feedback.class));
        }
}
