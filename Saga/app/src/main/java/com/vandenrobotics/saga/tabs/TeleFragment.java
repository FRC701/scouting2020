package com.vandenrobotics.saga.tabs;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.vandenrobotics.saga.R;
import com.vandenrobotics.saga.activities.MatchActivity;
import com.vandenrobotics.saga.data.model.Stats;
import com.vandenrobotics.saga.data.repo.StatsRepo;
import com.vandenrobotics.saga.views.NumberPicker;

public class TeleFragment extends Fragment {

    private MatchActivity mActivity;
    private boolean viewAssigned = false;

    private ConstraintLayout teleField;

    private CheckBox disabled_Cb;
    private NumberPicker foul_Np;
    private NumberPicker techFoul_Np;
    private CheckBox redCard_Cb;
    private CheckBox yellowCard_Cb;
    private EditText teleComments;
    private RadioButton climbSpeedFast;
    private RadioButton climbSpeedMedium;
    private RadioButton climbSpeedSlow;
    private RadioButton climbSpeedNo;
    private Button teleTopPC_btn;
    private Button teleBottomPC_btn;
    private CheckBox teleRemovePC;
    private CheckBox teleRotation;
    private CheckBox telePosition;
    private RadioButton teleHangSuccess;
    private RadioButton teleHangAttempt;
    private RadioButton teleHangNA;
    private CheckBox teleAssist;
    private CheckBox teleAssisted;
    private RadioButton teleDefenseNone;
    private RadioButton teleDefenseSome;
    private RadioButton teleDefenseAll;
    private RadioButton teleDefenseGood;
    private RadioButton teleDefenseBad;
    private RadioButton teleDefenseOk;
    private RadioButton teleDefenseNA;

    private OnClickPC onClickPC;
    private String mEvent;
    private int mMatchNum;
    private int mTeamNum;
    private int mMatchPos;
    private String mAlliance;
    private int topPCT;
    private int bottomPCT;

    private StatsRepo statsRepo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_tele, container, false);
        mActivity = (MatchActivity)getActivity();
        mEvent = mActivity.mEvent;
        mMatchNum = mActivity.mMatchNumber;
        mTeamNum = mActivity.mTeamNumber;
        mMatchPos =mActivity.mDeviceNumber;
        mAlliance = mActivity.mAllianceColor;

        statsRepo = new StatsRepo();

        if(!viewAssigned) assignViews(rootView);
        if(viewAssigned)loadData();

        return rootView;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        assignViews(view);
        if (viewAssigned)loadData();
    }

    @Override
    public void onPause(){
        //gets data from teleTab when clicked out/ paused
        super.onPause();
        Stats stats = saveData();
        statsRepo.setTele(stats);
    }
    public Stats saveData(){
        Stats stats = new Stats();
        stats.setCompId(mEvent);
        stats.setMatchNum(mMatchNum);
        stats.setTeamNum(mTeamNum);
        stats.setTeleTopPC(topPCT);
        stats.setTeleComments(teleComments.getText().toString());
        stats.setTeleBottomPC(bottomPCT);
        int cTF = (climbSpeedFast.isChecked() ? 1 : 0);
        stats.setClimbSpeedFast(cTF);
        int cTM = (climbSpeedMedium.isChecked() ? 1: 0);
        stats.setClimbSpeedMedium(cTM);
        int cTS = (climbSpeedSlow.isChecked() ? 1 : 0);
        stats.setClimbSpeedSlow(cTS);
        int cTN = (climbSpeedNo.isChecked() ? 1 : 0);
        stats.setClimbSpeedNo(cTN);
        int disabled = (disabled_Cb.isChecked() ? 1 : 0);
        stats.setDisabled(disabled);
        int rC = (redCard_Cb.isChecked() ? 1 : 0);
        stats.setRedCard(rC);
        int yC = (yellowCard_Cb.isChecked() ? 1 : 0);
        stats.setYellowCard(yC);
        int foul = (foul_Np.getValue());
        stats.setFoul(foul);
        int techFoul = (techFoul_Np.getValue());
        stats.setTechFoul(techFoul);
        int tR = (teleRotation.isChecked() ? 1:0);
        stats.setTeleRotation(tR);
        int tP = (telePosition.isChecked() ? 1:0);
        stats.setTelePosition(tP);
        int tHS = (teleHangSuccess.isChecked() ? 1:0);
        stats.setTeleHangSuccess(tHS);
        int tHA = (teleHangAttempt.isChecked() ? 1:0);
        stats.setTeleHangAttempt(tHA);
        int tHNA = (teleHangNA.isChecked() ? 1:0);
        stats.setTeleHangNA(tHNA);
        int tA = (teleAssist.isChecked() ? 1:0);
        stats.setTeleHangAssist(tA);
        int tAed = (teleAssisted.isChecked() ? 1:0);
        stats.setTeleHangAssisted(tAed);
        int tDN = (teleDefenseNone.isChecked() ? 1:0);
        stats.setTeleDefenseNone(tDN);
        int tDS = (teleDefenseSome.isChecked() ? 1:0);
        stats.setTeleDefenseSome(tDS);
        int tDA = (teleDefenseAll.isChecked() ? 1:0);
        stats.setTeleDefenseAll(tDA);
        int tDG = (teleDefenseGood.isChecked() ? 1:0);
        stats.setTeleDefenseGood(tDG);
        int tDB = (teleDefenseBad.isChecked() ? 1:0);
        stats.setTeleDefenseBad(tDB);
        int tDO = (teleDefenseOk.isChecked() ? 1:0);
        stats.setTeleDefenseOk(tDO);
        int tDNA = (teleDefenseNA.isChecked() ? 1:0);
        stats.setTeleDefenseNA(tDNA);

        System.out.println(" telePosition:" +stats.getTelePosition() + " /n teleAssist:" +stats.getTeleHangAssist());

        Log.d("TeleFrag saveData", "team id " + stats.getTeamNum());
        return stats;
    }
    @Override
    public void onResume() {
        //when resumed, loads data onto the tab
        super.onResume();
        assignViews(getView());
        if (viewAssigned) loadData();
    }
    private void loadData() {
        Stats stats = statsRepo.getTeleStats(mEvent, mMatchNum, mMatchPos);
        disabled_Cb.setChecked(stats.getDisabled() == 1);
        redCard_Cb.setChecked(stats.getRedCard() == 1);
        yellowCard_Cb.setChecked(stats.getYellowCard() == 1);
        foul_Np.setValue(stats.getFoul());
        techFoul_Np.setValue(stats.getTechFoul());
        topPCT = stats.getTeleTopPC();

        bottomPCT = stats.getTeleBottomPC();
        climbSpeedFast.setChecked(stats.getClimbSpeedFast() == 1);
        climbSpeedMedium.setChecked(stats.getClimbSpeedMedium() == 1);
        climbSpeedSlow.setChecked(stats.getClimbSpeedSlow() == 1);
        climbSpeedNo.setChecked(stats.getClimbSpeedNo() == 1);
        teleRotation.setChecked(stats.getTeleRotation() == 1);
        telePosition.setChecked(stats.getTelePosition() == 1);
        teleHangSuccess.setChecked(stats.getTeleHangSuccess() == 1);
        teleHangAttempt.setChecked(stats.getTeleHangAttempt() == 1);
        teleHangNA.setChecked(stats.getTeleHangNA() == 1);
        teleAssist.setChecked(stats.getTeleHangAssist() == 1);
        teleAssisted.setChecked(stats.getTeleHangAssisted() == 1);
        teleDefenseNone.setChecked(stats.getTeleDefenseNone() == 1);
        teleDefenseSome.setChecked(stats.getTeleDefenseSome() == 1);
        teleDefenseAll.setChecked(stats.getTeleDefenseAll() == 1);
        teleDefenseGood.setChecked(stats.getTeleDefenseGood() == 1);
        teleDefenseBad.setChecked(stats.getTeleDefenseBad() == 1);
        teleDefenseOk.setChecked(stats.getTeleDefenseOk() == 1);
        teleDefenseNA.setChecked(stats.getTeleDefenseNA() == 1);
        teleComments.setText(stats.getTeleComments());

    }
    public void assignViews(View view){
        try {
            climbSpeedFast = (RadioButton) view.findViewById(R.id.climbTimeFast);
            climbSpeedMedium = (RadioButton) view.findViewById(R.id.climbTimeMedium);
            climbSpeedSlow = (RadioButton) view.findViewById(R.id.climbTimeLow);
            climbSpeedNo = (RadioButton) view.findViewById(R.id.climbTimeNo);
            disabled_Cb = (CheckBox) view.findViewById(R.id.disabled_Cb);
            foul_Np = (NumberPicker) view.findViewById(R.id.foul_Np);
            techFoul_Np = (NumberPicker) view.findViewById(R.id.techFoul_Np);
            redCard_Cb = (CheckBox) view.findViewById(R.id.redCard_Cb);
            yellowCard_Cb = (CheckBox) view.findViewById(R.id.yellowCard_Cb);
            teleComments = (EditText) view.findViewById(R.id.teleComments);
            teleTopPC_btn = (Button) view.findViewById(R.id.teleTopPC);
            teleBottomPC_btn = (Button) view.findViewById(R.id.teleBottomPC);
            teleRemovePC = (CheckBox) view.findViewById(R.id.teleRemovePC);
            teleRotation = (CheckBox) view.findViewById(R.id.teleRotation);
            telePosition = (CheckBox) view.findViewById(R.id.telePosition);
            teleHangSuccess = (RadioButton) view.findViewById(R.id.teleHangSuccess);
            teleHangAttempt = (RadioButton) view.findViewById(R.id.teleHangAttempt);
            teleHangNA = (RadioButton) view.findViewById(R.id.teleHangNA);
            teleAssist = (CheckBox) view.findViewById(R.id.teleHangAssist);
            teleAssisted = (CheckBox) view.findViewById(R.id.teleHangAssisted);
            teleDefenseNone = (RadioButton) view.findViewById(R.id.teleDefenseNone);
            teleDefenseSome = (RadioButton) view.findViewById(R.id.teleDefenseSome);
            teleDefenseAll = (RadioButton) view.findViewById(R.id.teleDefenseAll);
            teleDefenseGood = (RadioButton) view.findViewById(R.id.teleDefenseGood);
            teleDefenseBad = (RadioButton) view.findViewById(R.id.teleDefenseBad);
            teleDefenseOk = (RadioButton) view.findViewById(R.id.teleDefenseOk);
            teleDefenseNA = (RadioButton) view.findViewById(R.id.teleDefenseNa);

            onClickPC = new TeleFragment.OnClickPC();
            teleTopPC_btn.setOnClickListener(onClickPC);
            teleBottomPC_btn.setOnClickListener(onClickPC);

            //setting data
            if (topPCT > 0){
                teleTopPC_btn.setText(topPCT + "");
            }
            if(bottomPCT > 0){
                teleBottomPC_btn.setText(bottomPCT + "");
            }

            viewAssigned = true;
       }catch(Exception e){
           e.printStackTrace();
           viewAssigned = false;
       }

    }
    public class OnClickPC implements Button.OnClickListener{
        @Override
        public void onClick (View view){
            System.out.println("button clicked");
            switch (view.getId()){
                case R.id.teleTopPC:
                    if(teleRemovePC.isChecked()&& topPCT > 0){
                        topPCT--;
                    }
                    else{
                        topPCT++;
                    }
                    teleTopPC_btn.setText( topPCT+"");
                    System.out.println("top pct :" + topPCT);
                    break;
                case R.id.teleBottomPC:
                    if(teleRemovePC.isChecked()&& bottomPCT > 0){
                        bottomPCT--;
                    }
                    else{
                        bottomPCT++;
                    }
                    teleBottomPC_btn.setText( bottomPCT +"");
                    System.out.println("bottom pct :" +bottomPCT);
                    break;
            }
        }

    }

}
