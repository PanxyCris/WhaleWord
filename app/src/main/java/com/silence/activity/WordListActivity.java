package com.silence.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.silence.fragment.WordListFgt;
import com.silence.pojo.Unit;
import com.silence.utils.Const;
import com.silence.word.R;

public class WordListActivity extends AppCompatActivity implements WordListFgt.onWordClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        String key = getIntent().getStringExtra(Const.DIC_KEY);
        if (key != null) {
            setTitle(key);
            if (savedInstanceState == null) {
                WordListFgt wordListFgt = WordListFgt.newInstance(key);
                getSupportFragmentManager().beginTransaction().add(R.id.word_list_content, wordListFgt).commit();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getWordList(String metaKey, int unitKey, int wordKey) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Const.META_KEY, metaKey);
        intent.putExtra(Const.UNIT_KEY, unitKey);
        intent.putExtra(Const.WORD_KEY, wordKey);
        startActivity(intent);
    }
}