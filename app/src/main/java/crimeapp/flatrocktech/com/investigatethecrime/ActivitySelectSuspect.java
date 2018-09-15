package crimeapp.flatrocktech.com.investigatethecrime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySelectSuspect extends AppCompatActivity {

    private TextView mTextSuspectName;
    private Button mBtnSuspect1, mBtnSuspect2, mBtnSuspect3, mBtnSuspect4;
    private Button mBtnSolveCase;


    public static void newInstance(Context context) {
        Intent intent = new Intent(context, ActivitySelectSuspect.class);
        context.startActivity(intent);
    }

    private View.OnClickListener mListenerSuspectSelected = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v instanceof TextView) {
                if(v.getId()==mBtnSolveCase.getId()) // no onclick event for solve case
                    solveTheCase(mTextSuspectName.getText().toString());
               else
                   setTextSuspectName(((Button) v).getText().toString());
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_suspect);
        initViews();
        setListeners();
    }


    private void initViews() {
        mBtnSuspect1 = findViewById(R.id.btn_1);
        mBtnSuspect2 = findViewById(R.id.btn_2);
        mBtnSuspect3 = findViewById(R.id.btn_3);
        mBtnSuspect4 = findViewById(R.id.btn_4);
        mTextSuspectName = findViewById(R.id.text1); // assigned textview to xml textview
        mBtnSolveCase = findViewById(R.id.btn_5);
    }

    private void setListeners() {
        mBtnSuspect1.setOnClickListener(mListenerSuspectSelected);
        mBtnSuspect2.setOnClickListener(mListenerSuspectSelected); // added onClickListener for button 2
        mBtnSuspect3.setOnClickListener(mListenerSuspectSelected);
        mBtnSuspect4.setOnClickListener(mListenerSuspectSelected);
        mBtnSolveCase.setOnClickListener(mListenerSuspectSelected);
            }

    private void setTextSuspectName(String suspectName) {
        mTextSuspectName.setText(suspectName);
    }

    private void solveTheCase(String suspectName) {  // changed typo no need but I thought it would be better usability-wise
        ActivityCaseSolved.newInstance(this, suspectName); // fixed the typo
    }


}
