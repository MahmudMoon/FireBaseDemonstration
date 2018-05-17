package moonc.example.com.firebasedemonstration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText name,email,phone_num;
    Button insertData,show_result;
    String user_name, user_email, user_phone;
    ArrayList<Employee> arrayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_views();
        init_variables();
        init_functions();

    }

    private void init_functions() {
        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = name.getText().toString();
                user_email = email.getText().toString();
                user_phone = phone_num.getText().toString();

                String key = databaseReference.push().getKey();
                Employee employee = new Employee(user_name,user_email,user_phone);

                databaseReference.child(key).setValue(employee);

                name.setText("");
                email.setText("");
                phone_num.setText("");

            }
        });

        show_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Detailed.class);
                startActivity(intent);
            }
        });


    }

    private void init_variables() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Employee_info");
        arrayList = new ArrayList<>();
    }

    private void init_views() {
         name = (EditText)findViewById(R.id.et_name);
         email = (EditText)findViewById(R.id.et_email);
         phone_num = (EditText)findViewById(R.id.et_phn);
         insertData = (Button)findViewById(R.id.btn_insert);
         show_result = (Button)findViewById(R.id.btn_show);
    }
}
