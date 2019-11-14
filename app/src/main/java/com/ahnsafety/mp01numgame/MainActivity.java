package com.ahnsafety.mp01numgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //멤버변수
    EditText et;
    Button btn;
    TextView tv;
    //사용자가 맞추어야할 정답값을 가지고 있는 정수형 변수
    int com;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //랜덤한 정답값 저장 500~1000
        rnd= new Random();
        com= rnd.nextInt(501) + 500;

        //XML 에서 만든 View 객체들을 참조하기
        et= findViewById(R.id.et);
        btn= findViewById(R.id.btn);
        tv= findViewById(R.id.tv);

        //버튼클릭에 반응하는 리스너객체 생성 및 추가
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText 에 써있는 글씨 얻어오기
                Editable editable= et.getText();
                String s= editable.toString();

                //얻어온 글씨(String s)를 int형으로 변환
                int user=Integer.parseInt(s);

                //변환된 숫자(user)와 정답값(com)을 비교
                    if(user < com)tv.setText(user+"보다 큽니다.");
                    else if(user > com)tv.setText(user +"보다 작습니다.");
                    else tv.setText("축하합니다.\n 정답입니다.");
                //EditText 에 써있는 글씨 없애기
                    et.setText("");
                }
        });
    }
}
