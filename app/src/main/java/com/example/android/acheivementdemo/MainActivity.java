package com.example.android.acheivementdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // families that exist under some social worker
    Family[] families = {
            new Family("Family 1", 1, "red", false),
            new Family("Family 2", 2, "yellow", false),
            new Family("Family 3", 3, "green", false)
    };

    // the family that is currently selected
    Family currentFamily;

    // number of achievements some social worker has, 0 to begin
    int numAchievements = 0;

    /**
     * This is run when the instance is created (when the app starts up)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // sets the content to the contents of "content_main.xml"
        setContentView(R.layout.content_main);

        // button action for FAMILY 1 button
        final Button button_family1 = findViewById(R.id.button_family1);
        button_family1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentFamily = families[0];
                updateViews(currentFamily);
            }
        });

        // button action for FAMILY 2 button
        final Button button_family2 = findViewById(R.id.button_family2);
        button_family2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentFamily = families[1];
                updateViews(currentFamily);
            }
        });

        // button action for FAMILY 3 button
        final Button button_family3 = findViewById(R.id.button_family3);
        button_family3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentFamily = families[2];
                updateViews(currentFamily);
            }
        });

        // button action for RED button
        final Button button_red = findViewById(R.id.button_red);
        button_red.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentState = currentFamily.getStoplightColor();
                String newState = "red";
                currentFamily.setStoplightColor(newState);

                boolean didImprove = didImprove(currentState, newState);
                if (didImprove) {
                    currentFamily.setHasAchievement(true);
                } else {
                    currentFamily.setHasAchievement(false);
                }

                updateViews(currentFamily);
            }
        });

        // button action for YELLOW button
        final Button button_yellow = findViewById(R.id.button_yellow);
        button_yellow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentState = currentFamily.getStoplightColor();
                String newState = "yellow";
                currentFamily.setStoplightColor(newState);

                boolean didImprove = didImprove(currentState, newState);
                if (didImprove) {
                    currentFamily.setHasAchievement(true);
                } else {
                    currentFamily.setHasAchievement(false);
                }

                updateViews(currentFamily);
            }
        });

        // button action for GREEN button
        final Button button_green = findViewById(R.id.button_green);
        button_green.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentState = currentFamily.getStoplightColor();
                String newState = "green";
                currentFamily.setStoplightColor(newState);

                boolean didImprove = didImprove(currentState, newState);
                if (didImprove) {
                    currentFamily.setHasAchievement(true);
                } else {
                    currentFamily.setHasAchievement(false);
                }

                updateViews(currentFamily);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * Updates the views for displaying the selected family
     * @param family the family for which the views are going to be updated
     */
    public void updateViews(Family family) {
        // update view showing selected family
        TextView selectedFamilyView = findViewById(R.id.selected_family);
        selectedFamilyView.setText(family.getFamilyName());

        // update view showing selected family stoplight indicator
        TextView selectedFamilyStatus = findViewById(R.id.selected_family_status);
        selectedFamilyStatus.setText(family.getStoplightColor());

        // update view showing achievement
        TextView selectedFamilyAchievement = findViewById(R.id.selected_family_achievement);
        if (family.getHasAchievement()) {
            selectedFamilyAchievement.setText("Achievement");
        } else {
            selectedFamilyAchievement.setText("None");
        }

        // update the number of achievements earned
        updateNumAchievements();
    }

    /**
     * Returns whether or not a change in indicator is an improvement
     * @param prev indicator status before change
     * @param next indicator status after change
     * @return true if indicator improved, false otherwise
     */
    public boolean didImprove(String prev, String next) {
        if (prev.equals("red")) {
            if (next.equals("yellow") || next.equals("green")) {
                return true;
            } else {
                return false;
            }
        } else if (prev.equals("yellow")) {
            if (next.equals("green")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void updateNumAchievements() {
        int temp = 0;

        for (int i = 0; i < families.length; i++) {
            if (families[i].getHasAchievement()) {
                temp++;
            }
        }

        TextView numAchievements = findViewById(R.id.num_achievements);
        numAchievements.setText(Integer.toString(temp));
    }
}
