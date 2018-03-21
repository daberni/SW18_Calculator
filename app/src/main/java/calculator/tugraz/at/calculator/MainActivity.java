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
    private Button clearBtn;
    private List<Button> numberButtons​ = new ArrayList<>();

    private Integer firstNumber;
    private State state = State.INIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.txt_input);
        clearBtn = findViewById(R.id.button_clear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("0");
            }
        });

        for (int i = 0; i <= 9; i++) {
            int buttonId = getResources().getIdentifier("button" + i, "id", R.class.getPackage().getName());
            Button button = findViewById(buttonId);
            button.setOnClickListener(this);

            numberButtons​.add(button);
        }

        findViewById(R.id.button_minus).setOnClickListener(this);
        findViewById(R.id.button_plus).setOnClickListener(this);
        findViewById(R.id.button_divide).setOnClickListener(this);
        findViewById(R.id.button_multiply).setOnClickListener(this);
        findViewById(R.id.button_equal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (numberButtons​.contains(v)) {
            String recentNumber = inputText.getText().toString();
            if (state == State.INIT) {
                recentNumber = "";
                state = State.NUM;
            }
            Button button = (Button) v;
            inputText.setText(recentNumber + button.getText());
        } else if (v.getId() == R.id.button_minus) {
            clearNumberView();
            state = State.SUB;
        } else if (v.getId() == R.id.button_plus) {
            clearNumberView();
            state = State.ADD;
        } else if (v.getId() == R.id.button_multiply) {
            clearNumberView();
            state = State.MUL;
        } else if (v.getId() == R.id.button_divide) {
            clearNumberView();
            state = State.DIV;
        } else if (v.getId() == R.id.button_equal) {
            calculateResult();
        }
    }

    private void clearNumberView() {
        String tempString = inputText.getText().toString();
        if (!tempString.equals("")) {
            firstNumber = Integer.valueOf(tempString);
        }
        inputText.setText("");
        state = State.INIT;
    }

    private void calculateResult() {
        int secondNumber = 0;
        String tempString = inputText.getText().toString();
        if (!tempString.equals("")) {
            secondNumber = Integer.valueOf(tempString);
        }
        int result;
        switch (state) {
            case ADD:
                result = Calculations.doAddition(firstNumber, secondNumber);
                break;
            case SUB:
                result = Calculations.doSubtraction(firstNumber, secondNumber);
                break;
            case MUL:
                result = Calculations.doMultiplication(firstNumber, secondNumber);
                break;
            case DIV:
                result = Calculations.doDivision(firstNumber, secondNumber);
                break;
            default:
                result = secondNumber;
        }
        inputText.setText(Integer.toString(result));
    }

    public enum State {
        ADD, SUB, MUL, DIV, INIT, NUM
    }
}
