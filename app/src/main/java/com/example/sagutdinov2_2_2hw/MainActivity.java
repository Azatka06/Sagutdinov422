package com.example.sagutdinov2_2_2hw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sagutdinov2_2_2hw.R;
import com.example.sagutdinov2_2_2hw.ToolsArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolsList();
    }

    private void initToolsList() {
        ArrayList<ToolsArrayAdapter.Tool> list = new ArrayList<>();

        list.add(new ToolsArrayAdapter.Tool(R.drawable.ic_launcher_background, R.string.notes, R.string.notes_decription));
        list.add(new ToolsArrayAdapter.Tool(R.drawable.ic_launcher_background, R.string.tasks, R.string.tasks_description));
        list.add(new ToolsArrayAdapter.Tool(R.drawable.ic_launcher_background, R.string.pay, R.string.pay_description));
        list.add(new ToolsArrayAdapter.Tool(R.drawable.ic_launcher_background, R.string.spinner, R.string.spinner_description));

        ListView toolsList = findViewById(R.id.toolsList);
        toolsList.setAdapter(new ToolsArrayAdapter(this, list));

        Button btnDelete = findViewById(R.id.btnDelete);


        toolsList.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, NotesActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, CalendarActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, CheckboxActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(this, SpinnerActivity.class));
                    break;
            }
        });
    }
}
