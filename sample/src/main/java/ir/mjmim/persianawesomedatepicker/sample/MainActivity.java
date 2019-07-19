package ir.mjmim.persianawesomedatepicker.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mohamadamin.persianmaterialdatetimepicker.sample.R;
import ir.mjmim.persianawesomedatepicker.date.DatePickerDialog;
import ir.mjmim.persianawesomedatepicker.date.DatePickerDialog.OnDateSetListener;
import ir.mjmim.persianawesomedatepicker.utils.PersianCalendar;

public class MainActivity extends AppCompatActivity implements
    OnDateSetListener,
    View.OnClickListener {

  private static final String TIMEPICKER = "TimePickerDialog",
      DATEPICKER = "DatePickerDialog";

  private CheckBox modeDarkDate;
  private TextView dateTextView;
  private Button dateButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeViews();
    handleClicks();
  }

  private void initializeViews() {
    dateTextView = findViewById(R.id.date_textview);
    dateButton = findViewById(R.id.date_button);
    modeDarkDate = findViewById(R.id.mode_dark_date);
  }

  private void handleClicks() {
    dateButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    String fontName = "DroidNaskh-Regular";
    switch (view.getId()) {
      case R.id.date_button: {
        PersianCalendar now = new PersianCalendar();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
            MainActivity.this,
            now.getPersianYear(),
            now.getPersianMonth(),
            now.getPersianDay()
        );
        dpd.setThemeDark(modeDarkDate.isChecked());
        dpd.setTypeface(fontName);
        dpd.show(getFragmentManager(), DATEPICKER);
        break;
      }
      default:
        break;
    }
  }

  @Override
  public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
    // Note: monthOfYear is 0-indexed
    String date = "You picked the following date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
    dateTextView.setText(date);
  }
}
