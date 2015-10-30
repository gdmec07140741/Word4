package com.example.administrator.word4;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText etName,etMobile,etQQ,etdabwei,etAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.edit1);
        etMobile = (EditText) findViewById(R.id.edit2);
        etQQ = (EditText) findViewById(R.id.edit3);
        etdabwei = (EditText) findViewById(R.id.edit4);
        etAddress = (EditText) findViewById(R.id.edit5);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"保存");
        menu.add(0,2,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if(!etName.getText().toString().equals("")){
                    MyUser myUser = new MyUser();
                    myUser.setName(etName.getText().toString());
                    myUser.setMoblie(etMobile.getText().toString());
                    myUser.setQq(etQQ.getText().toString());
                    myUser.setDdanwei(etdabwei.getText().toString());
                    myUser.setAddress(etAddress.getText().toString());
                    ContentTable ct=new ContentTable(MainActivity.this);
                    if(ct.addData(myUser)){
                        Toast.makeText(MainActivity.this, "添加成功!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "添加失败!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "请先输入数据!", Toast.LENGTH_SHORT).show();
                }break;
            case 2:
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
