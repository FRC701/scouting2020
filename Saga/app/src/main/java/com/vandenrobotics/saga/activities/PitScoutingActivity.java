package com.vandenrobotics.saga.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.vandenrobotics.saga.R;
import com.vandenrobotics.saga.data.model.PitData;
import com.vandenrobotics.saga.data.repo.PitDataRepo;
import com.vandenrobotics.saga.data.repo.TeamsRepo;
import com.vandenrobotics.saga.tools.ExternalStorageTools;

import java.util.ArrayList;
import java.util.Collections;

public class PitScoutingActivity extends AppCompatActivity {

    private EditText intakeAndMech;
    private EditText driveTrain;
    private EditText speed;
    private EditText lang;
    private EditText ballsDuringAuto;
    private RadioButton autoYes;
    private RadioButton autoNo;
    private CheckBox autoInitiationLine;
    private CheckBox autoIntakeBalls;
    private CheckBox autoScoreLower;
    private CheckBox autoScoreOuter;
    private CheckBox autoScoreInner;
    private CheckBox pitScoreBottomPort;
    private CheckBox pitScoreOuterPort;
    private CheckBox pitScoreInnerPort;
    private CheckBox pitPositionControlPanel;
    private CheckBox pitRotateControlPanel;
    private CheckBox pitAssistClimb;
    private CheckBox pitParkRobot;
    private CheckBox pitRobotClimb;
    private RadioButton pitIntakeYes;
    private RadioButton pitIntakeNo;
    private RadioButton pitDefenseYes;
    private RadioButton pitDefenseNo;
    private Button saveButton;
    private ArrayList<Integer> team_numbers;
    private TeamsRepo teamsRepo;
    private PitDataRepo pitDataRepo;
    private Spinner spinnerTeams;
    private ArrayAdapter<Integer> teamAdapter;
    private int mTeamNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_scouting);

        pitDataRepo = new PitDataRepo();

        teamsRepo = new TeamsRepo();
        team_numbers = teamsRepo.getAllTeamNums();
        Collections.sort(team_numbers);
        spinnerTeams = (Spinner) findViewById(R.id.pit_spinnerTeamNum);
        teamAdapter = new ArrayAdapter<>(this, R.layout.spinner_base, team_numbers);
        teamAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinnerTeams.setSelection(teamAdapter.getPosition(mTeamNumber));
        spinnerTeams.setAdapter(teamAdapter);

        spinnerTeams.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long arg3){
                mTeamNumber = Integer.parseInt(spinnerTeams.getItemAtPosition(position).toString());
                ArrayList<Integer> teamsHaveData = pitDataRepo.getTeams();
                if (!teamsHaveData.isEmpty()){
                    boolean teamLoaded = false;
                    for(int i : teamsHaveData){
                        if(i == mTeamNumber) {
                            PitData pitData = pitDataRepo.getTeamData(mTeamNumber);
                            loadData(pitData);
                            teamLoaded = true;
                        }
                    }
                    if (!teamLoaded){
                        PitData pitData = new PitData(mTeamNumber);
                        loadData(pitData);
                    }
                }else{
                    for (int team : teamsRepo.getAllTeamNums()){
                        PitData pitData = new PitData(team);
                        pitDataRepo.insert(pitData);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter){

            }
        });

        intakeAndMech = (EditText)findViewById(R.id.pit_intakeMechanism);
        driveTrain = (EditText)findViewById(R.id.pit_driveTrain);
        speed = (EditText)findViewById(R.id.pit_speed);
        lang = (EditText)findViewById(R.id.pit_programmingLanguage);
        ballsDuringAuto = (EditText)findViewById(R.id.pit_ballsDuringAuto);
        autoYes = (RadioButton)findViewById(R.id.pit_autoYes);
        autoNo = (RadioButton)findViewById(R.id.pit_autoNo);
        autoInitiationLine = (CheckBox)findViewById(R.id.pit_autoInitiationLine);
        autoIntakeBalls = (CheckBox)findViewById(R.id.pit_autoIntakeBalls);
        autoScoreLower = (CheckBox)findViewById(R.id.pit_autoScoreLower);
        autoScoreOuter = (CheckBox)findViewById(R.id.pit_autoScoreOuter);
        autoScoreInner = (CheckBox)findViewById(R.id.pit_autoScoreInner);
        pitScoreBottomPort = (CheckBox)findViewById(R.id.pit_scoreBottomPort);
        pitScoreOuterPort = (CheckBox)findViewById(R.id.pit_scoreOuterPort);
        pitScoreInnerPort = (CheckBox)findViewById(R.id.pit_scoreInnerPort);
        pitPositionControlPanel = (CheckBox)findViewById(R.id.pit_positionControlPanel);
        pitRotateControlPanel = (CheckBox)findViewById(R.id.pit_rotateControlPanel);
        pitAssistClimb = (CheckBox)findViewById(R.id.pit_assistClimb);
        pitParkRobot = (CheckBox)findViewById(R.id.pit_parkRobot);
        pitRobotClimb = (CheckBox)findViewById(R.id.pit_climbRobot);
        pitIntakeYes = (RadioButton)findViewById(R.id.pit_intakePowerCellsYes);
        pitIntakeNo = (RadioButton)findViewById(R.id.pit_intakePowerCellsNo);
        pitDefenseYes = (RadioButton)findViewById(R.id.pit_defenseYes);
        pitDefenseNo = (RadioButton)findViewById(R.id.pit_defenseNo);
    }

   public void save(View view){
       PitData pitdata = new PitData(mTeamNumber);
       pitdata.setIntakeAndMech(intakeAndMech.getText().toString());
       pitdata.setDriveTrain(driveTrain.getText().toString());
       pitdata.setSpeed(speed.getText().toString());
       pitdata.setLang(lang.getText().toString());
       pitdata.setBallsDuringAuto(ballsDuringAuto.getText().toString());

       int aY = (autoYes.isChecked() ? 1:0);
       pitdata.setAutoYes(aY);
       int aN = (autoNo.isChecked() ? 1:0);
       pitdata.setAutoNo(aN);
       int aIL = (autoInitiationLine.isChecked() ? 1:0);
       pitdata.setCrossLinePit(aIL);
       int aIB = (autoIntakeBalls.isChecked() ? 1:0);
       pitdata.setIntakeBallsPit(aIB);
       int aSL = (autoScoreLower.isChecked() ? 1:0);
       pitdata.setScoreLowerPortPit(aSL);
       int aSO = (autoScoreOuter.isChecked() ? 1:0);
       pitdata.setScoreOuterPortPit(aSO);
       int aSI = (autoScoreInner.isChecked() ? 1:0);
       pitdata.setScoreInnerPortPit(aSI);
       int sBP = (pitScoreBottomPort.isChecked() ? 1:0);
       pitdata.setBottomPortScore(sBP);
       int sOP = (pitScoreOuterPort.isChecked() ? 1:0);
       pitdata.setOuterPortScore(sOP);
       int sIP = (pitScoreInnerPort.isChecked() ? 1:0);
       pitdata.setInnerPortScore(sIP);
       int pCP = (pitPositionControlPanel.isChecked() ? 1:0);
       pitdata.setPositionPanel(pCP);
       int rCP = (pitRotateControlPanel.isChecked() ? 1:0);
       pitdata.setRotatePanel(rCP);
       int pAC = (pitAssistClimb.isChecked() ? 1:0);
       pitdata.setAssistClimb(pAC);
       int pPR = (pitParkRobot.isChecked() ? 1:0);
       pitdata.setParkRobot(pPR);
       int pCC = (pitRobotClimb.isChecked() ? 1:0);
       pitdata.setRobotClimb(pCC);
       int iPCY = (pitIntakeYes.isChecked() ? 1:0);
       pitdata.setIntakePowerCellsYes(iPCY);
       int iPCN = (pitIntakeNo.isChecked() ? 1:0);
       pitdata.setIntakePowerCellsNo(iPCN);
       int pDY = (pitDefenseYes.isChecked() ? 1:0);
       pitdata.setRobotDefenseYesPit(pDY);
       int pDN = (pitDefenseNo.isChecked() ? 1:0);
       pitdata.setRobotDefenseNoPit(pDN);

       System.out.println(" autoYes:" + pitdata.getAutoYes()+ " /n autoNo:" + pitdata.getAutoNo()+ " /n autoInitiationLine:" + pitdata.getCrossLinePit()+
               " /n autoIntakeBalls:" + pitdata.getIntakeBallsPit()+ " /n autoScoreLower:" + pitdata.getScoreLowerPortPit()+ " /n autoScoreOuter:" + pitdata.getScoreOuterPortPit()+
               " /n autoScoreInner:" + pitdata.getScoreInnerPortPit()+ " /n pitScoreBottomPort:" + pitdata.getBottomPortScore()+ " /n pitScoreOuterPort:" + pitdata.getOuterPortScore()+
               " /n pitScoreInnerPort:" + pitdata.getInnerPortScore()+ " /n pitPositionControlPanel:" + pitdata.getPositionPanel()+
               " /n pitRotateControlPanel:" + pitdata.getRotatePanel()+ " /n pitAssistClimb:" + pitdata.getAssistClimb()+ " /n pitParkRobot:" + pitdata.getRobotClimb()+
               " /n pitClimbClimb:" + pitdata.getRobotClimb()+ " /n pitIntakeYes:" + pitdata.getIntakePowerCellsYes()+ " /n pitIntakeNo:" + pitdata.getIntakePowerCellsNo()+
               " /n pitDefenseYes:" +  pitdata.getRobotDefenseYesPit()+ " /n pitDefenseNo:" + pitdata.getRobotDefenseNoPit());


        pitDataRepo.insert(pitdata);




       Toast.makeText(this, "Saved Data", Toast.LENGTH_LONG).show();
       ExternalStorageTools.writeDatabaseToES();
   }

   public void loadData(PitData pitData){
        intakeAndMech.setText(pitData.getIntakeAndMech());
        driveTrain.setText(pitData.getDriveTrain());
        speed.setText(pitData.getSpeed());
        lang.setText(pitData.getLang());
        ballsDuringAuto.setText(pitData.getBallsDuringAuto());
        autoYes.setChecked(pitData.getAutoYes() == 1);
        autoNo.setChecked(pitData.getAutoNo() == 1);
        autoInitiationLine.setChecked(pitData.getCrossLinePit() == 1);
        autoIntakeBalls.setChecked(pitData.getIntakeBallsPit() == 1);
        autoScoreLower.setChecked(pitData.getScoreLowerPortPit() == 1);
        autoScoreOuter.setChecked(pitData.getScoreOuterPortPit() == 1);
        autoScoreInner.setChecked(pitData.getScoreInnerPortPit() == 1);
        pitScoreBottomPort.setChecked(pitData.getBottomPortScore() == 1);
        pitScoreOuterPort.setChecked(pitData.getOuterPortScore() == 1);
        pitScoreInnerPort.setChecked(pitData.getInnerPortScore() == 1);
        pitPositionControlPanel.setChecked(pitData.getPositionPanel() == 1);
        pitRotateControlPanel.setChecked(pitData.getRotatePanel() == 1);
        pitAssistClimb.setChecked(pitData.getAssistClimb() == 1);
        pitParkRobot.setChecked(pitData.getParkRobot() == 1);
        pitRobotClimb.setChecked(pitData.getRobotClimb() == 1);
        pitIntakeYes.setChecked(pitData.getIntakePowerCellsYes() == 1);
        pitIntakeNo.setChecked(pitData.getIntakePowerCellsNo() == 1);
        pitDefenseYes.setChecked(pitData.getRobotDefenseYesPit() == 1);
        pitDefenseNo.setChecked(pitData.getRobotDefenseNoPit() == 1);







   }


}
