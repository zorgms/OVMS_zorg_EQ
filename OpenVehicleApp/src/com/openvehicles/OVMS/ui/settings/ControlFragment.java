package com.openvehicles.OVMS.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.openvehicles.OVMS.R;
import com.openvehicles.OVMS.ui.BaseFragment;
import com.openvehicles.OVMS.ui.BaseFragmentActivity;
import com.openvehicles.OVMS.ui.utils.Ui;

public class ControlFragment extends BaseFragment implements OnClickListener {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SherlockFragmentActivity activity = getSherlockActivity(); 
		
		activity.getSupportActionBar().setIcon(R.drawable.ic_action_control);
		activity.setTitle(R.string.Control);
		
		View pRootView = getView();
		Ui.setOnClick(pRootView, R.id.btn_features, this);
		Ui.setOnClick(pRootView, R.id.btn_parameters, this);
		Ui.setOnClick(pRootView, R.id.btn_mmi_ussd_code, this);
		Ui.setOnClick(pRootView, R.id.btn_cellular_usage, this);
		Ui.setOnClick(pRootView, R.id.btn_reset_ovms_module, this);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_control, null);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_mmi_ussd_code:
			Ui.showPinDialog(v.getContext(), R.string.msg_mmi_ssd_code, R.string.Send, false, 
					new Ui.OnChangeListener<String>() {
				@Override
				public void onAction(String pData) {
//						sendCommand(resId, cmd);						
				}
			});
			break;
		case R.id.btn_features:
			BaseFragmentActivity activity = (BaseFragmentActivity) getActivity();
			activity.setNextFragment(FeaturesFragment.class);
			break;
		}
	}
}
