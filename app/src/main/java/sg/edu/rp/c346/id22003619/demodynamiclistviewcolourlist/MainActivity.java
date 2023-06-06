package sg.edu.rp.c346.id22003619.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText etElement;
EditText etIndex;
Button btnAdd;
Button btnRemove;
Button btnUpdate;
ListView lvColour;
ArrayList<String> alcolours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement=findViewById(R.id.editTextColour);
        etIndex=findViewById(R.id.editTextIndex);
        btnAdd=findViewById(R.id.buttonAdd);
        btnRemove=findViewById(R.id.buttonRemove);
        btnUpdate=findViewById(R.id.buttonUpdate);
        lvColour=findViewById(R.id.listViewColour);

        alcolours= new ArrayList<String>();
        alcolours.add("Red");
        alcolours.add("Orange");

        ArrayAdapter aaColour=new ArrayAdapter(this, android.R.layout.simple_list_item_1,alcolours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcolour=etElement.getText().toString();
                int pos=Integer.parseInt(etIndex.getText().toString());
                alcolours.add(pos,newcolour);
                aaColour.notifyDataSetChanged();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=Integer.parseInt(etIndex.getText().toString());
                alcolours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcolour=etElement.getText().toString();
                int pos=Integer.parseInt(etIndex.getText().toString());
                alcolours.set(pos,newcolour);
                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour=alcolours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });

    }
}