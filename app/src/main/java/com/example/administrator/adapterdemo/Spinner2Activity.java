package com.example.administrator.adapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * 使用Spinner适配器视图
 * 动态进行数据的处理操作
 */
public class Spinner2Activity extends AppCompatActivity {

    // 视图
    private Spinner spinner;

    // 数据
    private ArrayList<String> data;

    // 适配器：视图与数据之间的桥
    private ArrayAdapter<String> adapter;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);

        spinner = (Spinner) findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.editText);

        initView();//初始化
    }

    private void initView() {

        // 初始化数据：可以数据源或网络获取
        data = new ArrayList<>();
        data.add("Android");
        data.add("iOS");
        data.add("Java");
        data.add("C++");

        // 参数一：上下文（Context）
        // 参数二：系统中的布局资源 android.R.layout.simple_spinner_dropdown_item
        // 参数三：数据，可以是字符串数据【长度不可变】，也可以是 ArrayList【长度可变】
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data);

        // 将适配器设置为视图
        spinner.setAdapter(adapter);
    }

    /**
     * 从 Spinner 中删除一项
     *
     * @param v button_remove
     */
    public void doRemove(View v) {

        // 获得选中项的位置；若无，则返回 -1
        int position = spinner.getSelectedItemPosition();

        if (-1 == position) {
            Toast.makeText(this, "无选中项", Toast.LENGTH_SHORT).show();
        } else {

            // 从数据中删除当前选中项
            data.remove(position);

            // 适配器通知【视图】数据集已改变，视图会重绘
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 在 Spinner 中新增一项
     *
     * @param v button_add
     */
    public void doAdd(View v) {
        // 获得输入内容
        String input = editText.getText().toString();

        if (input.equals("")) {
            return;       //防止添加“空行”
        }

        editText.setText("");

        // 在数据中添加新内容
        data.add(input);

        // 获得列表的适配器中数据项的总数
        int size = spinner.getAdapter().getCount();
        //size = data.size();

        // 设置选中选的位置
        spinner.setSelection(size - 1);
    }

}
