package com.example.administrator.adapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListView2Activity extends AppCompatActivity {

    // 数据的标签（KEY）
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";

    // 视图
    private ListView listView;

    // 数据：由键值对构成的列表【供简单适配器使用】
    private ArrayList<HashMap<String, Object>> data;

    // 适配器：简单适配器【一行可以显示多个控件】
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        listView = (ListView) findViewById(R.id.listView);

        initView();//初始化
    }

    private void initView() {
        // 初始化数据
        data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put(KEY_NAME, "联系人 " + i);
            item.put(KEY_PHONE, "号码 " + i);

            data.add(item);
        }

        // 数据的 KEY 构成的数组
        String[] from = {KEY_NAME, KEY_PHONE};

        // 控件的 ID 构成的数组
        int[] to = {android.R.id.text1, android.R.id.text2};

        // 参数一：上下文
        // 参数二：数据
        // 参数三：系统布局模版【activated 代表可高亮显示，2 代表有两个控件】
        // 参数四：数据的 KEY 构成的数组
        // 参数五：控件的 ID 构成的数组
        adapter = new SimpleAdapter(
                getApplicationContext(),
                data,
                android.R.layout.simple_list_item_activated_2,
                from,
                to);

        // 设置为多选模式
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // 设置适配器
        listView.setAdapter(adapter);
    }

    /**
     * 显示选中内容
     *
     * @param v button
     */
    public void doClick(View v) {

        // 获得选中项的总数
        int count = listView.getCheckedItemCount();

        // 获得选中项的标识【使用SQLite及游标时可用】
        long[] ids = listView.getCheckedItemIds();

        // 获得选中的位置【单选】
        int position = listView.getCheckedItemPosition();

        // 获得选中的位置【多选，获得一个稀疏矩阵】
        SparseBooleanArray array = listView.getCheckedItemPositions();

        // 显示结果
        Toast.makeText(this, array.toString(), Toast.LENGTH_SHORT).show();
    }

}
