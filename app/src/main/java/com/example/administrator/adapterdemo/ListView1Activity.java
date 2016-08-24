package com.example.administrator.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView1Activity extends AppCompatActivity {

    //视图AdapterView
    ListView listView;

    //数据
    String[] data = {"a","b","c","d"};

    //适配器：数据和视图之间的桥梁
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        listView = (ListView) findViewById(R.id.listView);

        //3个参数
        //第一个Context  上下文
        //第二个         资源模板--决定长什么样
        //第三个         数据
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        //给视图设置适配器
        listView.setAdapter(adapter);

    }
}
