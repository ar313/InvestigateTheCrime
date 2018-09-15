package crimeapp.flatrocktech.com.investigatethecrime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static crimeapp.flatrocktech.com.investigatethecrime.AnswerHelper.checkAnswer;

public class ActivityCaseSolved extends AppCompatActivity {
    public static final String EXTRA_SUSPECT_NAME = "suspect_name";

    private TextView mTextPlayerAnswer;

    public static void newInstance(Context context, String suspectName) {
        Intent intent = new Intent(context, ActivityCaseSolved.class);
        intent.putExtra(EXTRA_SUSPECT_NAME, suspectName);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_solved);

        mTextPlayerAnswer=findViewById(R.id.text1); //assigned player answer to textview

        String answer = null;
        if (getIntent().hasExtra(EXTRA_SUSPECT_NAME)) {
            answer = getIntent().getExtras().getString(EXTRA_SUSPECT_NAME);
        }

        if (checkAnswer(answer)) {
            mTextPlayerAnswer.setText(String.format(getString(R.string.text_correct_answer), answer));
        } else {
            mTextPlayerAnswer.setText(String.format(getString(R.string.text_incorrect_answer), answer));
            // fixed the @string name to incorrect answer and changed the incorrect answer %d placholder to string one
        }
    }

}
