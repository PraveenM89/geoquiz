package com.geoquiz.praveen.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Praveen on 2/10/2015.
 */
public class CheatActivity extends Activity{

    private TextView ans_text;
    private Button sh_answer;
    private boolean ans;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        ans = getIntent().getBooleanExtra("cheat_answer",false);

        ans_text = (TextView)findViewById(R.id.answer_text);
        sh_answer = (Button)findViewById(R.id.show_answer);

        sh_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans)
                    ans_text.setText("true");
                else
                    ans_text.setText("false");

                Intent k = new Intent();
                k.putExtra("feedback","done");
                setResult(RESULT_OK,k);
            }
        });

    }
}
