package com.geoquiz.praveen.geoquiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends ActionBarActivity {
    private Button mtrue_button;
    private Button mfalse_button;
    private Button mprev_button;
    private Button mnext_button;
    private Button mcheat_button;
    private TextView mtext;
    private String mIsCheater;
    private int currdata;

    private TestData dataarr[] = new TestData[]{
            new TestData(R.string.q1,false),
            new TestData(R.string.q2,true),
            new TestData(R.string.q3,false),
            new TestData(R.string.q4,false),
            new TestData(R.string.q5,true)};

    private int curr_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mtrue_button = (Button)findViewById(R.id.true_button);
        mfalse_button = (Button)findViewById(R.id.false_button);
        mprev_button = (Button)findViewById(R.id.prev_button);
        mnext_button = (Button)findViewById(R.id.next_button);
        mcheat_button = (Button)findViewById(R.id.cheat_button);
        mtext = (TextView)findViewById(R.id.q_text);

        mtrue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean temp = dataarr[curr_index].getmBoolean();
                if(temp == true)
                    Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });

        mfalse_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean temp = dataarr[curr_index].getmBoolean();
                if(temp == false)
                    Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

            }
        });

        mnext_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr_index = (curr_index + 1)%5;
                updateview(mtext);

            }
        });

        mprev_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curr_index == 0)
                    curr_index = 5;
                curr_index = Math.abs((curr_index - 1)%5);
                updateview(mtext);

            }
        });

        mcheat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,"check",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(QuizActivity.this, CheatActivity.class);
                    i.putExtra("cheat_answer",dataarr[curr_index].getmBoolean());
                    startActivityForResult(i,1);
            }
        });

        if(savedInstanceState != null){
            curr_index = savedInstanceState.getInt("mykey",0);
        }

        updateview(mtext);

    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i("hi","message");
        savedInstanceState.putInt("mykey",curr_index);
    }

    private void updateview(TextView mtext){

        int temp = dataarr[curr_index].getMquestion();
        mtext.setText(temp);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        mIsCheater = data.getStringExtra("feedback");

    }


}
