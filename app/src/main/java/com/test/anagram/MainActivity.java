package com.test.anagram;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.test.anagram.utils.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_text1)
    EditText inputFirstText;
    @BindView(R.id.input_text2)
    EditText inputSeocondText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.button_is_anagram)
    void onClickIsAnagram() {

        boolean isAnagram = TextUtils.isAnagram(inputFirstText.getText().toString(),
                inputSeocondText.getText().toString());

        if (isAnagram) {
            showDilaog(getString(R.string.your_input_is_anagram));
        } else {
            showDilaog(getString(R.string.your_input_not_anagram));
        }

    }


    private void showDilaog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }
}
