package com.vandenrobotics.saga.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private Button topPCellAuto;
    private Button bottomPCellAuto;
    private CheckBox removeballsAuto;
    private CheckBox crossLineAuto;
    private CheckBox doesntMoveAuto;
    private CheckBox intakeAuto;
    private CheckBox noShowAuto;
    private Button teleopAuto;
    private EditText ssComments_Et;

    private StatsRepo statsRepo;

    private OnClickPCA onClickPCA;
    private String mEvent;
    private int mMatchNum;
    private int mTeamNum;
    private int mMatchPos;
    private int bottomPCA;
    private int topPCA;

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
        statsRepo.setAuto(stats);
    }

    public Stats saveData(){
        Stats stat = new Stats();
        stat.setCompId(mEvent);
        stat.setMatchNum(mMatchNum);
        stat.setTeamNum(mTeamNum);
        int nS = (noShowAuto.isChecked() ? 1 : 0);
        stat.setHadAuto(nS);
        stat.setTopPCellAuto(topPCA);
        stat.setBottomPCellAuto(bottomPCA);
        int CLA = (crossLineAuto.isChecked() ? 1:  0);
        stat.setCrossLineAuto(CLA);
        int DMA = (doesntMoveAuto.isChecked() ? 1: 0);
        stat.setDoesntMoveAuto(DMA);
        int IA = (intakeAuto.isChecked() ? 1: 0);
        stat.setIntakeAuto(IA);
        int NSA = (noShowAuto.isChecked() ? 1:0 );
        stat.setNoShowAuto(NSA);

        return stat;
    }

    @Override
    public void onResume(){
        super.onResume();
        assignViews(getView());
        if(viewAssigned) loadData();
    }

    private void loadData() {
        Stats stats = statsRepo.getAuto(mEvent, mMatchNum, mMatchPos);
        crossLineAuto.setChecked(stats.getCrossLineAuto() == 1);
        doesntMoveAuto.setChecked(stats.getDoesntMoveAuto() == 1);
        intakeAuto.setChecked(stats.getIntakeAuto() == 1);
        noShowAuto.setChecked(stats.getNoShowAuto() == 1);
        topPCellAuto.setText(stats.getTopPCellAuto());
        topPCA = stats.getTopPCellAuto();
        bottomPCellAuto.setText(stats.getBottomPCellAuto());
        bottomPCA = stats.getBottomPCellAuto();
    }
    private void assignViews(View view) {
        try {
            topPCellAuto = (Button) view.findViewById(R.id.topPCellAuto);
            bottomPCellAuto = (Button) view.findViewById(R.id.bottomPCellAuto);
            removeballsAuto = (CheckBox) view.findViewById(R.id.removeBallsAuto);
            crossLineAuto = (CheckBox) view.findViewById(R.id.crossLineAuto);
            doesntMoveAuto = (CheckBox) view.findViewById(R.id.doesntMoveAuto);
            intakeAuto = (CheckBox) view.findViewById(R.id.intakeAuto);
            noShowAuto = (CheckBox) view.findViewById(R.id.noShowAuto);
            teleopAuto = (Button) view.findViewById(R.id.teleopAuto);

            topPCellAuto.setOnClickListener(onClickPCA);

            viewsAssigned = true;
        } catch (Exception e) {
            e.printStackTrace();
            viewsAssigned = false;
        }
    }
     public class OnClickPCA implements Button.OnClickListener{
            @Override
            public void onClick (View view){
                switch (view.getId()){
                    case R.id.topPCellAuto:
                        if(removeballsAuto.isChecked()&& topPCA >0){
                            topPCA--;
                        }
                        else {
                            topPCA++;
                        }
                        topPCellAuto.setText(topPCA);
                        break;
                    case R.id. bottomPCellAuto:
                        if(removeballsAuto.isChecked()&& bottomPCA >0){
                            bottomPCA--;
                        }
                        else {
                            bottomPCA++;
                        }
                        bottomPCellAuto.setTag(bottomPCA);
                        break;
                }
            }

    }
}
