package com.example.tashf.myapplication128;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PostActivity extends AppCompatActivity {

     private  EditText ed1,ed2,ed3;
     private Button buttonAdd;
     private DatabaseReference databaselists;
    private FirebaseAuth mauth;
    private ListView listView;
    private   List<Infos>arraylists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        databaselists= FirebaseDatabase.getInstance().getReference("Lists");
        mauth=FirebaseAuth.getInstance();
        arraylists=new ArrayList<Infos>();
        ed1=(EditText)findViewById(R.id.latitudeid);
        ed2=(EditText) findViewById(R.id.longitudeid);
        ed3=(EditText)findViewById(R.id.aliveid);
        buttonAdd=(Button)findViewById(R.id.postbuttonid);
        listView=(ListView)findViewById(R.id.listviewid);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              addlistt();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaselists.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arraylists.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    Infos info=dataSnapshot1.getValue(Infos.class);
                    arraylists.add(info);
                }
                MainList adapter=new MainList(PostActivity.this,arraylists);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addlistt()
    {
        String latti=ed1.getText().toString().trim();
        double val1=Double.parseDouble(latti);
        String longi= ed2.getText().toString().trim();
        double val2=Double.parseDouble(longi);
        String alive=ed3.getText().toString().trim();
        int val3=Integer.parseInt(alive);
        if(!TextUtils.isEmpty(latti) && !TextUtils.isEmpty(longi) && ! TextUtils.isEmpty(alive))
        {
            String id=databaselists.push().getKey();
            Infos info=new Infos(id,val1,val2,val3);
            databaselists.child(id).setValue(info);
            Toast.makeText(getApplicationContext(),"List added",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Enter all info",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.action_Google_maps)
        {
           Toast.makeText(getApplicationContext(),"Map icon clicked",Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.action_logout)
        {
            mauth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }




}
