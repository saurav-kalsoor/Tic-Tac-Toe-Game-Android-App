package com.example.tic_tac_toeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,reset;
    TextView p1,p2;
    View loginview;
    EditText playername1,playername2;
    String name1="Player1",name2="Player2";


    int p1score=0,p2score=0;
    int chance = 0;
    int ar[] = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginview = LayoutInflater.from(MainActivity.this).inflate(R.layout.login_screen,null);
        playername1 = (EditText) loginview.findViewById(R.id.playerName1);
        playername2 = (EditText) loginview.findViewById(R.id.playerName2);

        AlertDialog.Builder getNames = new AlertDialog.Builder(MainActivity.this);
        getNames.setMessage("Enter Your Names")
                .setCancelable(false)
                .setView(loginview)
                .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        name1 = playername1.getText().toString();
                        name2 = playername2.getText().toString();
                    }
                })
                .setTitle(null);

                getNames.show();


        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        reset = (Button) findViewById(R.id.resetButton);
        p1 = (TextView) findViewById(R.id.player1);
        p2 = (TextView) findViewById(R.id.player2);




    }

    public void setZero()
    {
        for(int i=0;i<9;i++)
        {
            ar[i]=-1;
        }
        chance=0;
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");

        p1.setText(name1 + ": " + p1score);
        p2.setText(name2 + ": " + p2score);
    }

    public void check()
    {
        int flag=-2;
        if(ar[0]==1 && ar[1]==1 && ar[2]==1)
        {
            flag=1;
        }
        else if(ar[3]==1 && ar[4]==1 && ar[5]==1)
        {
            flag=1;
        }
        else if(ar[6]==1 && ar[7]==1 && ar[8]==1)
        {
            flag=1;
        }
        else if(ar[0]==1 && ar[3]==1 && ar[6]==1)
        {
            flag=1;
        }
        else if(ar[1]==1 && ar[4]==1 && ar[7]==1)
        {
            flag=1;
        }
        else if(ar[2]==1 && ar[5]==1 && ar[8]==1)
        {
            flag=1;
        }
        else if(ar[0]==1 && ar[4]==1 && ar[8]==1)
        {
            flag=1;
        }
        else if(ar[2]==1 && ar[4]==1 && ar[6]==1)
        {
            flag=1;
        }

        else if(ar[0]==0 && ar[1]==0 && ar[2]==0)
        {
            flag=0;
        }
        else if(ar[3]==0 && ar[4]==0 && ar[5]==0)
        {
            flag=0;
        }
        else if(ar[6]==0 && ar[7]==0 && ar[8]==0)
        {
            flag=0;
        }
        else if(ar[0]==0 && ar[3]==0 && ar[6]==0)
        {
            flag=0;
        }
        else if(ar[1]==0 && ar[4]==0 && ar[7]==0)
        {
            flag=0;
        }
        else if(ar[2]==0 && ar[5]==0 && ar[8]==0)
        {
            flag=0;
        }
        else if(ar[0]==0 && ar[4]==0 && ar[8]==0)
        {
            flag=0;
        }
        else if(ar[2]==0 && ar[4]==0 && ar[6]==0)
        {
            flag=0;
        }
        else
        {
            flag=-1;

        }

        if(flag==1)
        {

            AlertDialog.Builder adbuilder = new AlertDialog.Builder(MainActivity.this);

            adbuilder.setMessage( name1+ " Won!")
                    .setCancelable(false)
                    .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            p1score+=1;
                            setZero();


                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setTitle("Game Over");

            adbuilder.show();



        }
        else if(flag==0)
        {

            AlertDialog.Builder adbuilder = new AlertDialog.Builder(MainActivity.this);

            adbuilder.setMessage(name2+ " Won!")
                    .setCancelable(false)
                    .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            p2score+=1;
                            setZero();


                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setTitle("Game Over");

            adbuilder.show();

        }
        else
        {
            if(ar[0]==-1 || ar[1]==-1 || ar[2]==-1 || ar[3]==-1 || ar[4]==-1 || ar[5]==-1 || ar[6]==-1 || ar[7]==-1 || ar[8]==-1)
            {

            }
            else
            {
                AlertDialog.Builder adbuilder = new AlertDialog.Builder(MainActivity.this);

                adbuilder.setMessage("Match Draw!")
                        .setCancelable(false)
                        .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                setZero();
                            }
                        })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setTitle("Game Over");

                adbuilder.show();
            }

        }

    }


    public void resetButtonClicked(View v)
    {
       p1score = 0;
       p2score = 0;
       setZero();
    }

    public void oneClicked(View v)
    {
        if(b1.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b1.setText("X");
                ar[0]=1;
            }
            else
            {
                b1.setText("O");
                ar[0]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void twoClicked(View v)
    {
        if(b2.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b2.setText("X");
                ar[1]=1;
            }
            else
            {
                b2.setText("O");
                ar[1]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void threeClicked(View v)
    {
        if(b3.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b3.setText("X");
                ar[2]=1;
            }
            else
            {
                b3.setText("O");
                ar[2]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void fourClicked(View v)
    {
        if(b4.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b4.setText("X");
                ar[3]=1;
            }
            else
            {
                b4.setText("O");
                ar[3]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void fiveClicked(View v)
    {
        if(b5.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b5.setText("X");
                ar[4]=1;
            }
            else
            {
                b5.setText("O");
                ar[4]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void sixClicked(View v)
    {
        if(b6.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b6.setText("X");
                ar[5]=1;
            }
            else
            {
                b6.setText("O");
                ar[5]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void sevenClicked(View v)
    {
        if(b7.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b7.setText("X");
                ar[6]=1;
            }
            else
            {
                b7.setText("O");
                ar[6]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void eightClicked(View v)
    {
        if(b8.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b8.setText("X");
                ar[7]=1;
            }
            else
            {
                b8.setText("O");
                ar[7]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }
    public void nineClicked(View v)
    {
        if(b9.getText().toString().equals(""))
        {
            if(chance%2==0)
            {
                b9.setText("X");
                ar[8]=1;
            }
            else
            {
                b9.setText("O");
                ar[8]=0;
            }
            chance++;
            check();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Space Already Filled!!",Toast.LENGTH_SHORT).show();
        }
    }



}
