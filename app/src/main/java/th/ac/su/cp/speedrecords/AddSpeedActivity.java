package th.ac.su.cp.speedrecords;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

import th.ac.su.cp.speedrecords.db.AppDatabase;
import th.ac.su.cp.speedrecords.model.Speed;
import th.ac.su.cp.speedrecords.util.AppExecutors;

public class AddSpeedActivity {
    private Calendar mBirthDateCalendar = Calendar.getInstance();
    private Calendar mSomeTimeCalendar = Calendar.getInstance();

        Button saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float sum;
            float distance;
            float duration;
                final Speed speed = new Speed(177.1f,31.0f, 0.6f);

                AppExecutors executors = new AppExecutors();
                executors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() { // worker thread
                        AppDatabase db = AppDatabase.getInstance(AddSpeedActivity.this,speed);
                        db.speedDao().addSpeed(speed);
                        finish();
                    }
                });
            }
        });
    }
}
