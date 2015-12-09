package com.example.eric.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private String[] data = { "Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };


    private List<Fruit> fruitList = new ArrayList<Fruit>();
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits(); // 初始化水果数据
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,data);
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initFruits() {
        Fruit apple = new Fruit("Apple", R.drawable.a);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana", R.drawable.b);
        fruitList.add(banana);
        Fruit orange = new Fruit("Orange", R.drawable.c);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.drawable.d);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.drawable.e);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape", R.drawable.f);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple", R.drawable.g);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("Strawberry", R.drawable.h);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry", R.drawable.i);
        fruitList.add(cherry);
        Fruit mango = new Fruit("Mango", R.drawable.j);
        fruitList.add(mango);
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
