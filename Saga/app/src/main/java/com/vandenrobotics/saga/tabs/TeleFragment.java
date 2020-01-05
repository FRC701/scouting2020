package com.vandenrobotics.saga.tabs;

import android.os.Bundle;
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
    private EditText climbStart;

    private String mEvent;
    private int mMatchNum;
    private int mTeamNum;
    private int mMatchPos;
    private String mAlliance;

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

    }
    public void assignViews(View view){
        try {
            disabled_Cb = (CheckBox) view.findViewById(R.id.disabled_Cb);
            foul_Np = (NumberPicker) view.findViewById(R.id.foul_Np);
            techFoul_Np = (NumberPicker) view.findViewById(R.id.techFoul_Np);
            redCard_Cb = (CheckBox) view.findViewById(R.id.redCard_Cb);
            yellowCard_Cb = (CheckBox) view.findViewById(R.id.yellowCard_Cb);


            viewAssigned = true;
       }catch(Exception e){
           e.printStackTrace();
           viewAssigned = false;
       }

    }

}
