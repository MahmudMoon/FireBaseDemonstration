package moonc.example.com.firebasedemonstration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Detailed extends AppCompatActivity {

    Intent intent;
    ArrayList<Employee> employees_detail;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        init_views();
        init_variables();
        init_functions();


                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot data:dataSnapshot.getChildren()){
                            Employee value = data.getValue(Employee.class);
                            employees_detail.add(value);
                            Toast.makeText(getApplicationContext(),Integer.toString(employees_detail.size()),Toast.LENGTH_SHORT).show();
                        }
                        Adapter adapter = new Adapter(getApplicationContext(),employees_detail);
                        listView.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });




    }

    private void init_functions() {

    }


    private void init_variables() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Employee_info");

    }

    private void init_views() {
         listView = (ListView)findViewById(R.id.list_view);
         employees_detail = new ArrayList<>();
    }
}
