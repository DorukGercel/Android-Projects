package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    int mStoryIndex;
    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
            setView();
            Log.d("Destini", "Old View Set");
        }
        else{
            mStoryIndex = 1;
            Log.d("Destini", "First View Set");
        }


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPath(true);
                setView();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPath(false);
                setView();
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndex", mStoryIndex);
        Log.d("Destini", "Saved the View");
    }

    private void findPath(boolean topButtonPressed){
        if(topButtonPressed){
            if(mStoryIndex == 1){
                mStoryIndex = 3;
            }
            else if(mStoryIndex == 2){
                mStoryIndex = 3;
            }
            else if(mStoryIndex == 3){
                mStoryIndex = 6;
            }
        }
        else{
            if(mStoryIndex == 1){
                mStoryIndex = 2;
            }
            else if(mStoryIndex == 2){
                mStoryIndex = 4;
            }
            else if(mStoryIndex == 3){
                mStoryIndex = 5;
            }
        }
    }

    private void setView(){
        if(mStoryIndex == 1){
            mStoryTextView.setText(R.string.T1_Story);
            mTopButton.setText(R.string.T1_Ans1);
            mBottomButton.setText(R.string.T1_Ans2);
        }
        else if(mStoryIndex == 2){
            mStoryTextView.setText(R.string.T2_Story);
            mTopButton.setText(R.string.T2_Ans1);
            mBottomButton.setText(R.string.T2_Ans2);
        }
        else if(mStoryIndex == 3){
            mStoryTextView.setText(R.string.T3_Story);
            mTopButton.setText(R.string.T3_Ans1);
            mBottomButton.setText(R.string.T3_Ans2);
        }
        else if(mStoryIndex == 4){
            mStoryTextView.setText(R.string.T4_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
        else if(mStoryIndex == 5){
            mStoryTextView.setText(R.string.T5_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
        else if(mStoryIndex == 6){
            mStoryTextView.setText(R.string.T6_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
    }
}
