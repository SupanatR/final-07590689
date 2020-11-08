package th.ac.su.cp.speedrecords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import th.ac.su.cp.speedrecords.adapter.SpeedAdapter;
import th.ac.su.cp.speedrecords.db.AppDatabase;
import th.ac.su.cp.speedrecords.model.Speed;
import th.ac.su.cp.speedrecords.util.AppExecutors;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private RecyclerView mRecyclerView;

    @Override
    protected void onResume() {
        super.onResume();

        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                final Speed[] speeds = db.speedDao().getAllSpeeds();

                executors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        SpeedAdapter adapter = new SpeedAdapter(MainActivity.this,speeds);
                        mRecyclerView.setAdapter(adapter);
                    }
                });

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.speed_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddSpeedActivity.class);
                startActivity(i);
            }
        });
    }
}