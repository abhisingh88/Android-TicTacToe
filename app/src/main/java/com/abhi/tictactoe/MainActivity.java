 package com.abhi.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
    //player representation
    //0 -X
    //1- O
     boolean gameActive= true;
    int activePlayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    //state meaning
    //0-X 1-O 2-blank state
    int [][] winingPositions={{0,1,2},{3,4,5},{6,7,8},
                                {0,3,6}, {1,4,7},{2,5,8},
                                {0,4,8},{2,4,6}};
    public void playerTap(View view ) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive) {
            gameReset(view);
        }
        if (gamestate[tappedImage] == 2) {
            gamestate[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn- Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn- Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
            //check if any player won
            for (int[] winPosition : winingPositions) {
                if (gamestate[winPosition[0]] == gamestate[winPosition[1]]
                        && gamestate[winPosition[1]] == gamestate[winPosition[2]] && gamestate[winPosition[0]] != 2)
                //somebody has won the game
                {
                    String winnerstr;
                    gameActive=false;
                    if (gamestate[winPosition[0]] == 0) {
                        winnerstr = "X has won the game";
                    } else {
                        winnerstr = "O has won the game";
                    }
                    //update the status bar for winner announcement
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerstr);
                }
            }
        }
    }
    public void gameReset(View view){
    gameActive=true;
    activePlayer=0;
    for(int i=0;i<gamestate.length;i++){
        gamestate[i]=2;
    }
    ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
    ((ImageView) findViewById(R.id.imageView10)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's turn- Tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}