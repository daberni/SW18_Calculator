package calculator.tugraz.at.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView inputText;
    private List<Button> numberButtons​ = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.txt_input);

        for (int i = 0; i <= 9; i++) {
            int buttonId = getResources().getIdentifier("button" + i, "id", R.class.getPackage().getName());
            Button button = findViewById(buttonId);
            button.setOnClickListener(this);

            numberButtons​.add(button);
        }
    }

    @Override
    public void onClick(View v) {
        if (numberButtons​.contains(v)) {
            Button button = (Button) v;
            inputText.setText(inputText.getText().toString() + button.getText());
        }
    }
}
