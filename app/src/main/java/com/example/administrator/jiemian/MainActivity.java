package com.example.administrator.jiemian;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder hobby=new StringBuilder();
                CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox);
                CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);
                CheckBox checkBox3=(CheckBox)findViewById(R.id.checkBox3);
                EditText username=(EditText)findViewById(R.id.username);
                EditText password1=(EditText)findViewById(R.id.password);
                EditText password2=(EditText)findViewById(R.id.password2);
                RadioButton radioButton1=(RadioButton)findViewById(R.id.male);
                RadioButton radioButton2=(RadioButton)findViewById(R.id.female);
                if(password1.getText().toString().equals(password2.getText().toString())){
                    if (password1.getText().toString().equals("")||password2.getText().toString().equals("")||username.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "用户名密码不得为空", Toast.LENGTH_LONG).show();
                        Intent intent1=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent1);
                    }else{
                        Intent intent=new Intent(MainActivity.this,show.class);
                        Bundle bundle=new Bundle();

                        bundle.putString("username", username.getText().toString());
                        bundle.putString("password1", password1.getText().toString());
                        if(radioButton1.isChecked()){
                            bundle.putString("sex",radioButton1.getText().toString());
                        }else if (radioButton2.isChecked()){
                            bundle.putString("sex",radioButton2.getText().toString());
                        }
                        if (checkBox1.isChecked()){
                            hobby.append(checkBox1.getText().toString()+"  ");
                        }
                        if (checkBox2.isChecked()){
                            hobby.append(checkBox2.getText().toString()+"  ");
                        }
                        if (checkBox3.isChecked()){
                            hobby.append(checkBox3.getText().toString()+"  ");
                        }
                        bundle.putString("hobby",hobby.toString());
                        intent.putExtras(bundle);
                        startActivity(intent);}

                }else{
                    Toast.makeText(MainActivity.this,"两次密码不一致，请重新输入",Toast.LENGTH_LONG).show();
                    Intent intent1=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent1);
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
