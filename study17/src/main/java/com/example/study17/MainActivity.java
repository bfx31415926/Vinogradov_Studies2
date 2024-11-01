package com.example.study17;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llMain;
    RadioGroup rgGravity;
    EditText etName;
    Button btnCreate;
    Button btnClear;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCreate) {
            // Создание LayoutParams c шириной и высотой по содержимому
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                    wrapContent, wrapContent);
            // переменная для хранения значения выравнивания
            // по умолчанию пусть будет LEFT
            int btnGravity = Gravity.LEFT;
            // определяем, какой RadioButton "чекнут" и
            // соответственно заполняем btnGravity
            if(rgGravity.getCheckedRadioButtonId() == R.id.rbLeft)
                    btnGravity = Gravity.LEFT;
            else if(rgGravity.getCheckedRadioButtonId() == R.id.rbCenter)
                    btnGravity = Gravity.CENTER_HORIZONTAL;
            else //rgGravity.getCheckedRadioButtonId() == case R.id.rbRight
                    btnGravity = Gravity.RIGHT;

            // переносим полученное значение выравнивания в LayoutParams
            lParams.gravity = btnGravity;

            // создаем Button, пишем текст и добавляем в LinearLayout
            Button btnNew = new Button(this);
            btnNew.setText(etName.getText().toString());
            llMain.addView(btnNew, lParams);
        }
        else { //v.getId() == R.id.btnClear:
                llMain.removeAllViews();
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
        }
    }

}