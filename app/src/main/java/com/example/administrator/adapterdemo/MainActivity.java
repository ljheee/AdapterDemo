package com.example.administrator.adapterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 主活动
 * 继承   应用程序兼容活动，而不推荐直接继承Activity
 *
 */
public class MainActivity extends AppCompatActivity {

    //声明控件
    Spinner spinner;
    TextView textViewShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //获得资源---字符串数组
        final String[] data = getResources().getStringArray(R.array.crouses);

        spinner = (Spinner) findViewById(R.id.spinner);
        textViewShow = (TextView) findViewById(R.id.textView_show);


        //注册监听器：选项被选中
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * @param parent   父元素Spinner
             * @param view     视图：被点击的这一项
             * @param position 位置：
             * @param id       标识，编号（DB中主键值）
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textViewShow.setText(data[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            /**
//             *
//             * @param parent   父元素Spinner
//             * @param view     视图：被点击的这一项
//             * @param position 位置：
//             * @param id       标识，编号（DB中主键值）
//             */
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                textViewShow.setText(data[position]);
//            }
//        });
    }

    /**
     * 点击Button按钮，执行活动跳转
     * @param view
     */
    public void doNext(View view) {
        startActivity(new Intent(this,ListView1Activity.class));
    }

    public void doAdapter2(View view) {
        startActivity(new Intent(this,Spinner2Activity.class));
    }

    public void doListView2(View view) {
        startActivity(new Intent(this,ListView2Activity.class));
    }
}
