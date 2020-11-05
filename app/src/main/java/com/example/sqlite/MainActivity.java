package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnThem;
    private Button btnSua;
    private Button btnXoa;
    private EditText etId;
    private EditText etTen;
    private EditText etToan;
    private EditText etLi;
    private EditText etHoa;
    private MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = new MyDatabase(this);
        initView();
        initListener();

    }
    private  void initListener(){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etTen.getText().toString();
                String toan = etToan.getText().toString();
                String li = etLi.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean bl = myDatabase.insertData(ten,toan,li,hoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"đã chèn", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"chèn lỗi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                String ten = etTen.getText().toString();
                String toan = etToan.getText().toString();
                String li = etLi.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean bl = myDatabase.updateData(id,ten,toan,li,hoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"đã sửa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"sửa lỗi", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                boolean bl = myDatabase.deleteData(id);
                if(bl){
                    Toast.makeText(MainActivity.this,"đã xóa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"xóa lỗi", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void initView(){
        btnThem = (Button) findViewById(R.id.btn_them);
        btnSua= (Button) findViewById(R.id.btn_sua);
        btnXoa = (Button) findViewById(R.id.btn_xoa);
        etId = (EditText) findViewById(R.id.et_id);
        etTen = (EditText) findViewById(R.id.et_ten);
        etToan = (EditText) findViewById(R.id.et_toan);
        etLi = (EditText) findViewById(R.id.et_li);
        etHoa = (EditText) findViewById(R.id.et_hoa);

    }
}