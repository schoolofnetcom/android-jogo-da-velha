package schoolofnet.com.velha;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    private Button btnGame1;
    private Button btnGame2;
    private Button btnGame3;
    private Button btnGame4;
    private Button btnGame5;
    private Button btnGame6;
    private Button btnGame7;
    private Button btnGame8;
    private Button btnGame9;
    private Button btnGame;
    private TextView txtGame;

    private Boolean movementX;
    private int[][] gameBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        movementX = true;
        gameBoard = new int[3][3];

        btnGame1 = (Button) findViewById(R.id.btn_game_1);
        btnGame2 = (Button) findViewById(R.id.btn_game_2);
        btnGame3 = (Button) findViewById(R.id.btn_game_3);
        btnGame4 = (Button) findViewById(R.id.btn_game_4);
        btnGame5 = (Button) findViewById(R.id.btn_game_5);
        btnGame6 = (Button) findViewById(R.id.btn_game_6);
        btnGame7 = (Button) findViewById(R.id.btn_game_7);
        btnGame8 = (Button) findViewById(R.id.btn_game_8);
        btnGame9 = (Button) findViewById(R.id.btn_game_9);
        txtGame = (TextView) findViewById(R.id.txt_layout_game);

        btnGame1.setOnClickListener((view) -> movement(view));
        btnGame2.setOnClickListener((view) -> movement(view));
        btnGame3.setOnClickListener((view) -> movement(view));
        btnGame4.setOnClickListener((view) -> movement(view));
        btnGame5.setOnClickListener((view) -> movement(view));
        btnGame6.setOnClickListener((view) -> movement(view));
        btnGame7.setOnClickListener((view) -> movement(view));
        btnGame8.setOnClickListener((view) -> movement(view));
        btnGame9.setOnClickListener((view) -> movement(view));
    }

    private void movement(View view) {
        Integer btnId = view.getId();
        int aux1 = 0;
        int aux2 = 0;
        btnGame = (Button) findViewById(btnId);

        switch(btnId) {
            case R.id.btn_game_1:
            break;
            case R.id.btn_game_2:
                aux1 = 0;
                aux2 = 1;
            break;
            case R.id.btn_game_3:
                aux1 = 0;
                aux2 = 2;
            break;
            case R.id.btn_game_4:
                aux1 = 1;
                aux2 = 0;
            break;
            case R.id.btn_game_5:
                aux1 = 1;
                aux2 = 1;
            break;
            case R.id.btn_game_6:
                aux1 = 1;
                aux2 = 2;
            break;
            case R.id.btn_game_7:
                aux1 = 2;
                aux2 = 0;
            break;
            case R.id.btn_game_8:
                aux1 = 2;
                aux2 = 1;
            break;
            case R.id.btn_game_9:
                aux1 = 2;
                aux2 = 2;
            break;
        }

        if(!btnGame.getText().toString().isEmpty()) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);

            dialog.setTitle("WARNING");
            dialog.setMessage("Already in use | not Empty");
            dialog.setCancelable(true);

            dialog.create().show();

            return;
        }

        if (movementX) {
            btnGame.setText("X");
            gameBoard[aux1][aux2] = 2;
            txtGame.setText("O movement");
            movementX = false;
        } else {
            btnGame.setText("O");
            gameBoard[aux1][aux2] = 1;
            txtGame.setText("X movement");
            movementX = true;
        }

        // check results
        Boolean allEmpty = false;
        Boolean winX = false;
        Boolean winO = false;

        for(int i = 0; i != 3; i++) {
            for (int j = 0; j != 3; j++) {
                if (gameBoard[i][j] == 0) {
                    allEmpty = true;
                    break;
                }
            }
        }

        if (!allEmpty) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);

            dialog.setTitle("ALERT");
            dialog.setMessage("Draw game");
            dialog.setCancelable(true);

            dialog.create().show();
        }


        for (int i = 0; i != 3; i++) {
            //horizontal
            if (gameBoard[i][0] == 1 && gameBoard[i][1] == 1 && gameBoard[i][2] == 1) {
                winO = true;
            }

            if (gameBoard[i][0] == 2 && gameBoard[i][1] == 2 && gameBoard[i][2] == 2) {
                winX = true;
            }

            //vertical
            if (gameBoard[0][i] == 1 && gameBoard[1][i] == 1 && gameBoard[2][i] == 1) {
                winO = true;
            }

            if (gameBoard[0][i] == 2 && gameBoard[1][i] == 2 && gameBoard[2][i] == 2) {
                winX = true;
            }
        }

        if (gameBoard[0][0] == 1 && gameBoard[1][1] == 1 && gameBoard[2][2] == 1) {
            winO = true;
        }

        if (gameBoard[0][0] == 2 && gameBoard[1][1] == 2 && gameBoard[2][2] == 2) {
            winX = true;
        }

        if (gameBoard[0][2] == 1 && gameBoard[1][1] == 1 && gameBoard[2][0] == 1) {
            winO = true;
        }

        if (gameBoard[0][2] == 2 && gameBoard[1][1] == 2 && gameBoard[2][0] == 2) {
            winX = true;
        }


        if (winO) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);

            dialog.setTitle("ALERT");
            dialog.setMessage("Player O Win");
            dialog.setCancelable(true);

            dialog.create().show();
        } else if(winX) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);

            dialog.setTitle("ALERT");
            dialog.setMessage("Player X Win");
            dialog.setCancelable(true);

            dialog.create().show();
        }
    }
}
