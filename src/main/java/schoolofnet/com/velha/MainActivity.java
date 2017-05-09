package schoolofnet.com.velha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStartGame;
    private Button btnAboutGame;
    private Button btnExitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExitGame = (Button) findViewById(R.id.btn_exit_game);
        btnAboutGame = (Button) findViewById(R.id.btn_about_game);
        btnStartGame = (Button) findViewById(R.id.btn_start_game);

        btnExitGame.setOnClickListener((view) -> exitGame(view));
        btnAboutGame.setOnClickListener((view) -> aboutGame(view));
        btnStartGame.setOnClickListener((view) -> startGame(view));
    }

    private void exitGame(View view) {
        finish();
        System.exit(0);
    }

    private void aboutGame(View view) {
        Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);

        startActivity(aboutIntent);
    }

    private void startGame(View view) {
        Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);

        startActivity(gameIntent);
    }
}
