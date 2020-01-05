package com.vandenrobotics.saga.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.vandenrobotics.saga.R;
import com.vandenrobotics.saga.activities.MatchActivity;
import com.vandenrobotics.saga.data.model.Stats;
import com.vandenrobotics.saga.data.repo.StatsRepo;
import com.vandenrobotics.saga.dialogs.NoShowDialogFragment;

//import com.vandenrobotics.saga2018.model.;

public class AutoFragment extends Fragment {

    private MatchActivity mActivity;

    private boolean viewAssigned = false;
    private CheckBox noShow;
    private EditText ssComments_Et;

    private StatsRepo statsRepo;

    private String mEvent;
    private int mMatchNum;
    private int mTeamNum;
    private int mMatchPos;

    private int noShowValue;


    public NoShowDialogFragment noShowDF;


    private boolean viewsAssigned = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_auto, container, false);
        mActivity = (MatchActivity) getActivity();
        mEvent = mActivity.mEvent;
        mMatchNum = mActivity.mMatchNumber;
        mTeamNum = mActivity.mTeamNumber;
        mMatchPos =mActivity.mDeviceNumber;
        statsRepo = new StatsRepo();

        noShowDF = new NoShowDialogFragment();

        if(!viewAssigned) assignViews(rootView);
        if (viewAssigned)loadData();

        return rootView;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        assignViews(view);
        if(viewsAssigned) loadData();
    }

@Override
    public void onPause(){
        super.onPause();
        Stats stats = saveData();
        statsRepo.setPreStats(stats);
    }

    public Stats saveData(){
        Stats stat = new Stats();
        stat.setCompId(mEvent);
        stat.setMatchNum(mMatchNum);
        stat.setTeamNum(mTeamNum);
        int nS = (noShow.isChecked() ? 1 : 0);
        stat.setHadAuto(nS);
        String sS = (ssComments_Et.getText().toString());
        stat.setSscomments(sS);
        return stat;
    }

    @Override
    public void onResume(){
        super.onResume();
        assignViews(getView());
        if(viewAssigned) loadData();
    }

    private void loadData() {
        Stats stats = statsRepo.getPreStats(mEvent, mMatchNum, mMatchPos);
        noShow.setChecked(stats.getNoShow() == 1);
        ssComments_Et.setText(stats.getSsComments());
    }
    private void assignViews(View view){
        try{
            noShow = (CheckBox) view.findViewById(R.id.noShow_Cb);


            viewsAssigned = true;
        } catch (Exception e){
            e.printStackTrace();
            viewsAssigned = false;
        }
    }

    public void command_noShow(View view) {
        if (noShow.isChecked()) {
            noShowDF.show(getChildFragmentManager(), "NoShowDialogFragment");
        }
    }


    public void setNoShow(boolean b){
        noShow.setChecked(b);
    }
}
